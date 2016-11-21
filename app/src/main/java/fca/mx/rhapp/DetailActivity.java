package fca.mx.rhapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {


    TextView txvNombre, txvId, txvStatus, txvFecha, txvSueldo,
            txvHorarioLab, txvUbicacion, txvDepartamento, txvObjetivo,
            txvHabilidades, txvExperiencia, txvEdad, txvGenero, txvNivelEstudios;
    Perfil perfil;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        perfil= (Perfil) getIntent().getExtras().getSerializable("perfil");

        txvNombre = (TextView) findViewById(R.id.txv_nombre);
        txvId = (TextView) findViewById(R.id.txvId);
        txvStatus = (TextView) findViewById(R.id.txvStatus);
        txvFecha = (TextView) findViewById(R.id.txvStatus);
        txvSueldo = (TextView) findViewById(R.id.txvSueldo);
        txvHorarioLab = (TextView) findViewById(R.id.txvHorarioLab);
        txvUbicacion = (TextView) findViewById(R.id.txvUbicacion);
        txvDepartamento = (TextView) findViewById(R.id.txvDepartamento);
        txvObjetivo = (TextView) findViewById(R.id.txvObjetivo);
        txvHabilidades = (TextView) findViewById(R.id.txvHabilidades);
        txvExperiencia = (TextView) findViewById(R.id.txvExperiencia);
        txvEdad = (TextView) findViewById(R.id.txvEdad);
        txvGenero = (TextView) findViewById(R.id.txvGenero);
        txvNivelEstudios = (TextView) findViewById(R.id.txvNivelEstudios);

        txvNombre.setText(perfil.getTitulo());
        txvId.setText("Id: " + perfil.getId());
        if (perfil.getStatus().equals("A")){
            txvStatus.setText("Status: Activo");
        }else{
            txvStatus.setText("Status: Inactivo");
        }
        txvFecha.setText("Fecha: " + perfil.getFecha());
        txvSueldo.setText("Sueldo: " +perfil.getSueldo());
        txvHorarioLab.setText("Horario laboral: " +perfil.getHorarioLab());
        txvUbicacion.setText("Ubicación : " + perfil.getUbicacion());
        txvDepartamento.setText("Departamento : " +perfil.getNombreDep());
        txvObjetivo.setText("Objetivos: " +perfil.getObjetivo());
        txvHabilidades.setText("Habilidades: " +perfil.getHabilidades());
        txvExperiencia.setText("Experencia: " +perfil.getExperiencia());
        txvEdad.setText(perfil.getEdad());
        if (perfil.getGenero().trim().equals("M")){
            txvGenero.setText("Género: " + "Masculino");

        }else if (perfil.getGenero().trim().equals("F")){
            txvGenero.setText("Género: " + "Femenino");


        }else{
            txvGenero.setText("Género: " + "Indistinto");

        }

            txvNivelEstudios.setText(perfil.getNivelEstudios());



    }
}
