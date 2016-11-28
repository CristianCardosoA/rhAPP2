package fca.mx.rhapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by itexico on 23/06/16.
 */
public class Search extends Fragment {


    OnSearch listener;

    private static final String TAG = SettingsFragment.class.getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_search, container, false);
        setHasOptionsMenu(true);
        final EditText txvSearch = (EditText) v.findViewById(R.id.edt_username);
        Button button = (Button) v.findViewById(R.id.btn_login);
        listener = (OnSearch) getActivity();
        boolean validated = true;
        txvSearch.setError(null);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!(txvSearch.getText().toString().length() > 0)) { //if username field is empty
                    txvSearch.setError("Este campo es obligatorio");
                    txvSearch.requestFocus();
                }else{
                    listener.onSearch(txvSearch.getText().toString().trim());
                }
            }
        });

        return v;
    }

    /**
     *
     * @return LogOutframent instance.
     */
    public static Search newInstance() {
        return new Search();
    }

    /**
     *
     * @param menu menu
     * @param inflater inflater.
     */

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }
}
