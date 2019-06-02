package sv.edu.ues.fia.eisi.proyectotarea;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.ues.fia.eisi.proyectotarea.baseDatos.ControlDBProyecto;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Pensum;

public class PensumConsultarActivity extends Activity {

    ControlDBProyecto helper;
    EditText editId_Pensum;
    EditText editNombre_Materia;
    EditText editId_Carrera;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_pensum_consultar);
        helper = new ControlDBProyecto (this);

        editId_Pensum = (EditText) findViewById(R.id.editId_Pensum);
        editNombre_Materia = (EditText) findViewById(R.id.editNombre_Materia);
        editId_Carrera = (EditText) findViewById(R.id.editId_Carrera);
    }

    public void  ConsultarPensum(View v)
    {
        helper.abrir();
        Pensum pensum = helper.ConsultarPensum(editId_Pensum.getText().toString());
        helper.cerrar();
        if(pensum == null)
            Toast.makeText(this, "Pensum con ID " + editId_Carrera.getText().toString() +
                    " no encontrada", Toast.LENGTH_LONG).show();
        else{

            editNombre_Materia.setText(pensum.getNombre_materia());
            editId_Carrera.setText(pensum.getId_carrera());

        }
    }
    public void limpiarTexto(View v){

        editId_Pensum.setText("");
        editNombre_Materia.setText("");
        editId_Carrera.setText("");

    }
}
