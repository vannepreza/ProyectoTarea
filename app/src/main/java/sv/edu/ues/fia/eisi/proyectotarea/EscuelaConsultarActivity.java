package sv.edu.ues.fia.eisi.proyectotarea;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.ues.fia.eisi.proyectotarea.baseDatos.ControlDBProyecto;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Escuela;


public class EscuelaConsultarActivity extends Activity {

    ControlDBProyecto helper;
    EditText editId_Escuela;
    EditText editNombre_Escuela;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_escuela_consultar);
        helper = new ControlDBProyecto(this);

        editId_Escuela = (EditText) findViewById(R.id.editId_Escuela);
        editNombre_Escuela = (EditText) findViewById(R.id.editNombre_Escuela);

    }

    public void  ConsultarEscuela(View v)
    {
        helper.abrir();
        Escuela escuela = helper.ConsultarEscuela(editId_Escuela.getText().toString());
        helper.cerrar();
        if(escuela == null)
            Toast.makeText(this, "Escuela con ID " + editId_Escuela.getText().toString() +
                    " no encontrada", Toast.LENGTH_LONG).show();
        else{

            editId_Escuela.setText(escuela.getId_escuela());
            editNombre_Escuela.setText(escuela.getNombre_escuela());


        }
    }
    public void limpiarTexto(View v){
        editId_Escuela.setText("");
        editNombre_Escuela.setText("");


    }
}