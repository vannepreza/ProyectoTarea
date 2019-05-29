package sv.edu.ues.fia.eisi.proyectotarea;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.ues.fia.eisi.proyectotarea.baseDatos.ControlDBProyecto;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Actividad;

public class ActividadActualizarActivity extends Activity {
    ControlDBProyecto helper;
    EditText editCiclo;
    EditText editDetalle;
    EditText editActividad;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_actualizar);
        helper = new ControlDBProyecto(this);
        editCiclo = (EditText) findViewById(R.id.editCiclo);
        editDetalle = (EditText) findViewById(R.id.editDetalle);
        editActividad = (EditText) findViewById(R.id.editActividad);
    }

    public void actualizarActividad(View v) {
        Actividad actividad = new Actividad();
        actividad.setCiclo(editCiclo.getText().toString());
        actividad.setDetalle(editDetalle.getText().toString());


        helper.abrir();
        String estado = helper.actualizar(actividad);
        helper.cerrar();

        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editCiclo.setText("");
        editDetalle.setText("");
    }
}

