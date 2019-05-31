package sv.edu.ues.fia.eisi.proyectotarea;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.ues.fia.eisi.proyectotarea.baseDatos.ControlDBProyecto;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Local;

public class LocalConsultarActivity extends Activity {
    ControlDBProyecto helper;
    EditText editIdLocal;
    EditText editUbicacion;
    EditText editCapacidad;
    EditText editNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_consultar);

        helper = new ControlDBProyecto(this);
        editIdLocal = (EditText) findViewById(R.id.editIdLocal);
        editUbicacion = (EditText) findViewById(R.id.editUbicacion);
        editCapacidad = (EditText) findViewById(R.id.editCapacidad);
        editNombre = (EditText) findViewById(R.id.editNombre);
    }

    public void consultarLocal(View v) {
        helper.abrir();
        Local local = helper.consultarLocal(editIdLocal.getText().toString());
        helper.cerrar();
        if(local == null)
            Toast.makeText(this, "Local con IdLocal " + editIdLocal.getText().toString() +  " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editUbicacion.setText(local.getUbicacion());
            editCapacidad.setText(local.getCapacidad());
            editNombre.setText(local.getNombre());
        }
    }

    public void limpiarTexto(View v) {
        editIdLocal.setText("");
        editUbicacion.setText("");
        editCapacidad.setText("");
        editNombre.setText("");
    }
}
