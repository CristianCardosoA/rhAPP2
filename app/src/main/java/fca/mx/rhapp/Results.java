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
public class Results extends Fragment {



    private static final String TAG = Results.class.getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_results, container, false);
        setHasOptionsMenu(true);
        final RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView
                .getRecycledViewPool()
                .setMaxRecycledViews(RecyclerView.INVALID_TYPE, 100);

        Map<String, String> params = new HashMap<>();
        params.put("nombre", getArguments().getString("nombre").trim());
        final Uri endPoint = Uri.parse(getString(R.string.api_puesto));

        NetworkConnection.with(getActivity()).withListener(new NetworkConnection.ResponseListener() {
            @Override
            public void onSuccessfullyResponse(final String response) {

                Log.e("perfil", response.toString());
                ArrayList<Perfil> perfiles = new ArrayList<>();
                Log.e("perfil", perfiles.toString());
                perfiles = JSONUtils.with(getActivity()).getPuestos(response);
                ActivitiesAdapter adapter = new ActivitiesAdapter(perfiles,getContext());
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onErrorResponse(String error, String message, int code) {

            }
        }).doRequest(Connection.REQUEST.POST,endPoint,params,null, null);

        //Log out process*/
        return v;
    }

    /**
     *
     * @return LogOutframent instance.
     */
    public static Results newInstance(String nombre) {
        Fragment fragment =  new Results();
        Bundle bundle = new Bundle();
        bundle.putString("nombre", nombre);
        fragment.setArguments(bundle);
        return (Results) fragment;
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
