package sv.edu.ues.fia.eisi.proyectotarea.modelos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Pensum {
    private String id_pensum;
    private String nombre_materia;
    private String id_carrera;
    public Pensum() {
    }

    public Pensum(String id_pensum, String nombre_materia, String id_carrera) {
        this.id_pensum = id_pensum;
        this.nombre_materia = nombre_materia;
        this.id_carrera = id_carrera;
    }
    public String getId_pensum() {
        return id_pensum;
    }

    public void setId_pensum(String id_pensum) {
        this.id_pensum = id_pensum;
    }

    public String getNombre_materia() {
        return nombre_materia;
    }

    public void setNombre_materia(String nombre_materia) {
        this.nombre_materia = nombre_materia;
    }

    public String getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(String id_carrera) {
        this.id_carrera = id_carrera;
    }


}