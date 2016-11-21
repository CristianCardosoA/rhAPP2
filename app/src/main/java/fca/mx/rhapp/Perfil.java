package fca.mx.rhapp;

import java.io.Serializable;

/**
 * Created by macbook on 20/11/16.
 */

public class Perfil implements Serializable{

    String titulo;
    String fecha;
    String Id;
    String Status;
    String FechaActualizacion;
    String Sueldo;
    String HorarioLab;
    String Ubicacion;
    String NombreDep;
    String Objetivo;
    String Habilidades;
    String Experiencia;
    String Edad;
    String Genero;
    String NivelEstudios;

    public Perfil(String titulo, String fecha, String id, String status, String fechaActualizacion,
                  String sueldo, String horarioLab, String ubicacion, String nombreDep, String objetivo,
                  String habilidades, String experiencia, String edad, String genero, String nivelEstudios) {
        this.titulo = titulo;
        this.fecha = fecha;
        Id = id;
        Status = status;
        FechaActualizacion = fechaActualizacion;
        Sueldo = sueldo;
        HorarioLab = horarioLab;
        Ubicacion = ubicacion;
        NombreDep = nombreDep;
        Objetivo = objetivo;
        Habilidades = habilidades;
        Experiencia = experiencia;
        Edad = edad;
        Genero = genero;
        NivelEstudios = nivelEstudios;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getFechaActualizacion() {
        return FechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        FechaActualizacion = fechaActualizacion;
    }

    public String getSueldo() {
        return Sueldo;
    }

    public void setSueldo(String sueldo) {
        Sueldo = sueldo;
    }

    public String getHorarioLab() {
        return HorarioLab;
    }

    public void setHorarioLab(String horarioLab) {
        HorarioLab = horarioLab;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    public String getNombreDep() {
        return NombreDep;
    }

    public void setNombreDep(String nombreDep) {
        NombreDep = nombreDep;
    }

    public String getObjetivo() {
        return Objetivo;
    }

    public void setObjetivo(String objetivo) {
        Objetivo = objetivo;
    }

    public String getHabilidades() {
        return Habilidades;
    }

    public void setHabilidades(String habilidades) {
        Habilidades = habilidades;
    }

    public String getExperiencia() {
        return Experiencia;
    }

    public void setExperiencia(String experiencia) {
        Experiencia = experiencia;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getNivelEstudios() {
        return NivelEstudios;
    }

    public void setNivelEstudios(String nivelEstudios) {
        NivelEstudios = nivelEstudios;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "titulo='" + titulo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", Id='" + Id + '\'' +
                ", Status='" + Status + '\'' +
                ", FechaActualizacion='" + FechaActualizacion + '\'' +
                ", Sueldo='" + Sueldo + '\'' +
                ", HorarioLab='" + HorarioLab + '\'' +
                ", Ubicacion='" + Ubicacion + '\'' +
                ", NombreDep='" + NombreDep + '\'' +
                ", Objetivo='" + Objetivo + '\'' +
                ", Habilidades='" + Habilidades + '\'' +
                ", Experiencia='" + Experiencia + '\'' +
                ", Edad='" + Edad + '\'' +
                ", Genero='" + Genero + '\'' +
                ", NivelEstudios='" + NivelEstudios + '\'' +
                '}';
    }
}
