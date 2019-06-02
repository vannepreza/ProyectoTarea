package sv.edu.ues.fia.eisi.proyectotarea;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.ues.fia.eisi.proyectotarea.modelos.Carrera;
import sv.edu.ues.fia.eisi.proyectotarea.baseDatos.ControlDBProyecto;

public class CarreraConsultarActivity extends Activity {

    ControlDBProyecto helper;
    EditText editId_Carrera;
    EditText editNombre_Carrera;
    EditText editId_Escuela;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_carrera_consultar);
        helper = new   ControlDBProyecto (this);

        editId_Carrera = (EditText) findViewById(R.id.editId_Carrera);
        editNombre_Carrera = (EditText) findViewById(R.id.editNombre_Carrera);
        editId_Escuela = (EditText) findViewById(R.id.editId_Escuela);
    }

    public void  ConsultarCarrera(View v)
    {
        helper.abrir();
        Carrera carrera = helper.ConsultarCarrera(editId_Carrera.getText().toString());
        helper.cerrar();
        if(carrera == null)
            Toast.makeText(this, "Carrera con ID " + editId_Carrera.getText().toString() +
                    " no encontrada", Toast.LENGTH_LONG).show();
        else{

            editNombre_Carrera.setText(carrera.getNombre_carrera());
            editId_Escuela.setText(carrera.getId_escuela());

        }
    }
    public void limpiarTexto(View v){

        editId_Carrera.setText("");
        editNombre_Carrera.setText("");
        editId_Escuela.setText("");

    }
}
