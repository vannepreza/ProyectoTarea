package sv.edu.ues.fia.eisi.proyectotarea;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActividadInsertarActivity extends Activity {
    ControlDBProyecto helper;
    EditText editCiclo;
    EditText editDetalle;
    EditText editActividad;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_insertar);
        helper = new ControlDBProyecto(this);
        editCiclo = (EditText) findViewById(R.id.editCiclo);
        editDetalle = (EditText) findViewById(R.id.editDetalle);
        editActividad = (EditText) findViewById(R.id.editActividad);
    }

    public void insertarActividad(View v) {
        String ciclo = editCiclo.getText().toString();
        String detalle = editDetalle.getText().toString();
        String actividad1 = editActividad.getText().toString();

        String regInsertados;
        Actividad actividad = new Actividad();
        actividad.setCiclo(ciclo);
        actividad.setDetalle(detalle);
        actividad.setActividad(actividad1);
        helper.abrir();
        regInsertados = helper.insertar(actividad);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v){

        editCiclo.setText("");
        editDetalle.setText("");

    }
}