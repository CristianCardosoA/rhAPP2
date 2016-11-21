package fca.mx.rhapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    boolean login = Preferences.getBoolean(Splash.this, Preferences.SHAREDPREFERENCE_KEY.KEY_LOGIN);

                    if (login){
                        Intent intent;
                        intent = new Intent(Splash.this,HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Intent intent;
                        intent = new Intent(Splash.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                }
            }
        };
        thread.start();

    }
}

