package sv.edu.ues.fia.eisi.proyectotarea.modelos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
public class Escuela {
    private String id_escuela;
    private String nombre_escuela;

    public Escuela() {
    }

    public Escuela(String id_escuela,String nombre_escuela) {
        this.id_escuela = id_escuela;
        this.nombre_escuela = nombre_escuela;
    }


    public String getId_escuela()
    {
        return id_escuela;
    }

    public void setId_escuela(String id_escuela) {
        this.id_escuela = id_escuela;
    }

    public String getNombre_escuela() {
        return nombre_escuela;
    }

    public void setNombre_escuela(String nombre_escuela)
    {
        this.nombre_escuela = nombre_escuela;
    }
}



