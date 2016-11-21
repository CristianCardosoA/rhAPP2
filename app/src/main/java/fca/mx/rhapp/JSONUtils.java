package fca.mx.rhapp;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONUtils {

    private static JSONUtils INSTANCE = null;
    private Context context;

    public JSONUtils(){}

    private static synchronized JSONUtils createInstance(){
        if (INSTANCE == null){
            INSTANCE = new JSONUtils();
        }
        return INSTANCE;
    }

    private static JSONUtils getInstance(){
        if (INSTANCE == null){ createInstance();}
        return INSTANCE;
    }

    public static JSONUtils with(Context c){
        getInstance().setContext(c);
        return getInstance();
    }

    private Context getContext() {
        return context;
    }

    private void setContext(Context context) {
        this.context = context;
    }

    public boolean login(String reponse){
        boolean respuesta = false;
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(reponse);
            if (jsonObject.getInt("sucess") == 1){
                respuesta = true;
            }

        } catch (JSONException e){
            e.printStackTrace();
        }
        return respuesta;
    }

    public ArrayList<Perfil> getPuestos(String reponse){
        boolean respuesta = false;
        ArrayList <Perfil> arrayList = new ArrayList();
        JSONArray jsonArray;
        Perfil perfil = null;
        try {
            jsonArray = new JSONArray(reponse);
            for (int ePos = 0; ePos < jsonArray.length(); ePos++){
                JSONObject jsonObject = jsonArray.getJSONObject(ePos);
                String nombre = jsonObject.getString("Nombre");
                String fecha = jsonObject.getString("FechaActualizacion");
                String Id  = jsonObject.getString("Id");
                String Status  = jsonObject.getString("Status");
                String FechaActualizacion  = jsonObject.getString("FechaActualizacion");
                String Sueldo = jsonObject.getString("Sueldo");
                String HorarioLab  = jsonObject.getString("HorarioLab");
                String Ubicacion  = jsonObject.getString("Ubicacion");
                String NombreDep  = jsonObject.getString("NombreDep");
                String Objetivo  = jsonObject.getString("Objetivo");
                String Habilidades  = jsonObject.getString("Habilidades");
                String Experiencia  = jsonObject.getString("Experiencia");
                String Edad  = jsonObject.getString("Edad");
                String Genero  = jsonObject.getString("Genero");
                String NivelEstudios  = jsonObject.getString("NivelEstudios");
                perfil = new Perfil( nombre,  fecha,  Id,  Status,  FechaActualizacion,
                         Sueldo,  HorarioLab,  Ubicacion,  NombreDep,  Objetivo,
                         Habilidades,  Experiencia,  Edad,  Genero,  NivelEstudios);
                arrayList.add(perfil);
            }


        } catch (JSONException e){
            e.printStackTrace();
        }
        return arrayList;
    }

}
