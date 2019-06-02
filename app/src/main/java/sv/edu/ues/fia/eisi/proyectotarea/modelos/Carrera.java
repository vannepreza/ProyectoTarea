package sv.edu.ues.fia.eisi.proyectotarea.modelos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Carrera {
    private String id_carrera;
    private String nombre_carrera;
    private String id_escuela;
    public Carrera() {
    }

    public Carrera(String id_carrera,String nombre_carrera, String id_escuela) {
        this.id_carrera = id_carrera;
        this.nombre_carrera = nombre_carrera;
        this.id_escuela = id_escuela;
    }


    public String getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(String id_carrera) {
        this.id_carrera = id_carrera;
    }

    public String getNombre_carrera() {
        return nombre_carrera;
    }

    public void setNombre_carrera(String nombre_carrera) {
        this.nombre_carrera = nombre_carrera;
    }

    public String getId_escuela() {
        return id_escuela;
    }

    public void setId_escuela(String id_escuela) {
        this.id_escuela = id_escuela;
    }


}
