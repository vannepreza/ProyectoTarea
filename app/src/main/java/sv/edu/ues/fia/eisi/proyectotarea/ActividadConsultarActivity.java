package sv.edu.ues.fia.eisi.proyectotarea;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.ues.fia.eisi.proyectotarea.baseDatos.ControlDBProyecto;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Actividad;

public class ActividadConsultarActivity extends Activity{
    ControlDBProyecto helper;
    EditText editCiclo;
    EditText editDetalle;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_consultar);
        helper = new ControlDBProyecto(this);
        editCiclo = (EditText) findViewById(R.id.editCiclo);
        editDetalle = (EditText) findViewById(R.id.editDetalle);
    }
    public void consultarActividad(View v){
        helper.abrir();
        Actividad actividad = helper.consultarActividad(editCiclo.getText().toString());

        helper.cerrar();
        if (actividad == null)
            Toast.makeText(this,"Actividad con ciclo " + editCiclo.getText().toString() + " no encontrado", Toast.LENGTH_LONG).show();
        else {
            editCiclo.setText(actividad.getCiclo());
            editDetalle.setText(actividad.getDetalle());
        }
    }

    public void limpiarTexto(View v){

        editCiclo.setText("");
        editDetalle.setText("");
    }


}