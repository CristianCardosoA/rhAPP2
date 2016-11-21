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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by itexico on 23/06/16.
 */
public class SettingsFragment extends Fragment {



    private static final String TAG = SettingsFragment.class.getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.log_out_fragment, container, false);
        setHasOptionsMenu(true);
        final RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);


        final Uri endPoint = Uri.parse(getString(R.string.api_puestos));

        NetworkConnection.with(getActivity()).withListener(new NetworkConnection.ResponseListener() {
            @Override
            public void onSuccessfullyResponse(final String response) {

                ArrayList<Perfil> perfiles = new ArrayList<>();
                Log.e("perfil", perfiles.toString());
                perfiles = JSONUtils.with(getActivity()).getPuestos(response);
                ActivitiesAdapter adapter = new ActivitiesAdapter(perfiles,getContext());
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onErrorResponse(String error, String message, int code) {

            }
        }).doRequest(Connection.REQUEST.GET, endPoint,null,null, null);

        //Log out process
        return v;
    }

    /**
     *
     * @return LogOutframent instance.
     */
    public static SettingsFragment newInstance() {
        return new SettingsFragment();
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
