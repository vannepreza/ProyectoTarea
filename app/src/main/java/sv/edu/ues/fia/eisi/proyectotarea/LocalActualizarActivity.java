package sv.edu.ues.fia.eisi.proyectotarea;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.ues.fia.eisi.proyectotarea.baseDatos.ControlDBProyecto;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Local;

public class LocalActualizarActivity extends Activity {

    ControlDBProyecto helper;
    EditText editIdLocal;
    EditText editUbicacion;
    EditText editCapacidad;
    EditText editNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_actualizar);
        helper = new ControlDBProyecto(this);
        editIdLocal = (EditText) findViewById(R.id.editIdLocal);
        editUbicacion = (EditText) findViewById(R.id.editUbicacion);
        editCapacidad = (EditText) findViewById(R.id.editCapacidad);
        editNombre = (EditText) findViewById(R.id.editNombre);
    }

    public void actualizarLocal(View v) {
        Local local = new Local();
        local.setIdLocal(Integer.parseInt(editIdLocal.getText().toString()));
        local.setUbicacion(editUbicacion.getText().toString());
        local.setCapacidad(Integer.parseInt(editCapacidad.getText().toString()));
        local.setNombre(editNombre.getText().toString());

        helper.abrir();
        String estado = helper.actualizar(local);
        helper.cerrar();

        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editIdLocal.setText("");
        editUbicacion.setText("");
        editCapacidad.setText("");
        editNombre.setText("");
    }
}
