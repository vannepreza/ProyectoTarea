package sv.edu.ues.fia.eisi.proyectotarea;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.ues.fia.eisi.proyectotarea.baseDatos.ControlDBProyecto;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Carrera;

public class CarreraInsertarActivity extends Activity {

    ControlDBProyecto helper;
    EditText editId_Carrera;
    EditText editNombre_Carrera;
    EditText editId_Escuela;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrera_insertar);
        helper = new  ControlDBProyecto(this);
        editId_Carrera = (EditText) findViewById(R.id.editId_Carrera);
        editNombre_Carrera= (EditText) findViewById(R.id.editNombre_Carrera);
        editId_Escuela = (EditText) findViewById(R.id.editId_Escuela);

    }


    public void insertarCarrera(View v) {
        String id_carrera=editId_Carrera.getText().toString();
        String nombre_carrera=editNombre_Carrera.getText().toString();
        String id_escuela=editId_Escuela.getText().toString();

        String regInsertados;

        Carrera carrera=new Carrera();
        carrera.setId_carrera(id_carrera);
        carrera.setNombre_carrera(nombre_carrera);
        carrera.setId_escuela(id_escuela);

        helper.abrir();
        regInsertados = helper.insertar(carrera);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editId_Carrera.setText("");
        editNombre_Carrera.setText("");
        editId_Escuela.setText("");

    }
}
