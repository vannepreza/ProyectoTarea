package sv.edu.ues.fia.eisi.proyectotarea;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.ues.fia.eisi.proyectotarea.baseDatos.ControlDBProyecto;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Asignatura;

public class AsignaturaConsultarActivity extends Activity {

    ControlDBProyecto helper;
    EditText editId_Asignatura;
    EditText editNombre_Asignatura;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignatura_consultar);
        helper = new ControlDBProyecto (this);

        editId_Asignatura = (EditText) findViewById(R.id.editId_Asignatura);
        editNombre_Asignatura = (EditText) findViewById(R.id.editNombre_Asignatura);

    }

    public void  consultarAsignatura(View v)
    {
        helper.abrir();
        Asignatura asignatura = helper.ConsultarAsignatura(editId_Asignatura.getText().toString());
        helper.cerrar();
        if(asignatura == null)
            Toast.makeText(this, "Asignatura con ID " + editId_Asignatura.getText().toString() +
                    " no encontrada", Toast.LENGTH_LONG).show();
        else{

            editId_Asignatura.setText(asignatura.getId_asignatura());
            editNombre_Asignatura.setText(asignatura.getNombre_asignatura());


        }
    }
    public void limpiarTexto(View v){

        editId_Asignatura.setText("");
        editNombre_Asignatura.setText("");


    }
}