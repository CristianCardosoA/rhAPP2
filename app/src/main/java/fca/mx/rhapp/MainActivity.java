package fca.mx.rhapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements NetworkConnection.ResponseListener {

    EditText edt_username;
    EditText edt_pasword;
    Button btn_login;
    private ProgressBar progressBarDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_username = (EditText) findViewById(R.id.edt_username);
        edt_pasword = (EditText) findViewById(R.id.edt_password);
        btn_login = (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLogin();
            }
        });

        progressBarDialog  = (ProgressBar) findViewById(R.id.progressBarDialog);
        progressBarDialog.setVisibility(View.INVISIBLE);

    }

    public boolean getLogin() {

        if (fieldsValidated()){
            //Call Login API..
            progressBarDialog.setVisibility(View.VISIBLE);
            String user = edt_username.getText().toString().trim();
            String pass= edt_pasword.getText().toString().trim();
            Map<String, String> params = new HashMap<>();
            params.put("usuario", user);
            params.put("password", pass);

            Uri endPoint = Uri.parse(getString(R.string.api_login));
            NetworkConnection.with(this).withListener(this).doRequest(Connection.REQUEST.POST, endPoint, params, null, null);
        }

        boolean respuesta = false;
        return respuesta;
    }

    public boolean fieldsValidated(){
        boolean validated = true;
        edt_username.setError(null);
        edt_pasword.setError(null);
        if (!(edt_username.getText().toString().length() > 0)) { //if username field is empty
            edt_username.setError("Este campo es obligatorio");
            edt_username.requestFocus();
            validated = false;
        }
        if (!(edt_pasword.getText().toString().length() > 0)) { //if password field is empty
            edt_pasword.setError("Este campo es obligatorio");
            edt_pasword.requestFocus();
            validated = false;
        }
        if ((edt_pasword.getText().toString().length() > 0) && (edt_pasword.getText().length() < 5)){
            edt_pasword.setError("Deben de ser cinco caracteres");
            edt_pasword.requestFocus();
            validated = false;
        }
        return validated;
    }

    @Override
    public void onSuccessfullyResponse(String response) {
        progressBarDialog.setVisibility(View.INVISIBLE);
        boolean respuesta = JSONUtils.with(this).login(response);
        if (respuesta){
            Toast.makeText(getApplicationContext(),"Bienvenido",Toast.LENGTH_LONG).show();
            Preferences.setBoolean(this,Preferences.SHAREDPREFERENCE_KEY.KEY_LOGIN,true);
            Preferences.setString(this,Preferences.SHAREDPREFERENCE_KEY.KEY_USERNAME, edt_username.getText().toString());
            Intent i = new Intent(this, HomeActivity.class);
            i.putExtra("nombreUsuario", edt_username.getText().toString());
            startActivity(i);
            finish();
        }else{
            Toast.makeText(getApplicationContext(),"Error usuario y/o password incorrectos",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onErrorResponse(String error, String message, int code) {
        progressBarDialog.setVisibility(View.INVISIBLE);
        Toast.makeText(getApplicationContext(),"Error usuario y/o password incorrectos",Toast.LENGTH_LONG).show();
    }
}
