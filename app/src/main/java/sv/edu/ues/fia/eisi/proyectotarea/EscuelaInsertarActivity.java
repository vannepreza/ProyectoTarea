package sv.edu.ues.fia.eisi.proyectotarea;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.ues.fia.eisi.proyectotarea.baseDatos.ControlDBProyecto;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Escuela;

public class EscuelaInsertarActivity extends Activity {

    ControlDBProyecto helper;
    EditText editId_Escuela;
    EditText editNombre_Escuela;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escuela_insertar);
        helper = new ControlDBProyecto (this);
        editId_Escuela = (EditText) findViewById(R.id.editId_Escuela);
        editNombre_Escuela= (EditText) findViewById(R.id.editNombre_Escuela);

    }


    public void insertarEscuela(View v) {
        String id_escuela=editId_Escuela.getText().toString();
        String nombre_escuela=editNombre_Escuela.getText().toString();

        String regInsertados;

        Escuela escuela=new Escuela();
        escuela.setId_escuela(id_escuela);
        escuela.setNombre_escuela(nombre_escuela);


        helper.abrir();
        regInsertados = helper.insertar(escuela);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editId_Escuela.setText("");
        editNombre_Escuela.setText("");


    }
}
