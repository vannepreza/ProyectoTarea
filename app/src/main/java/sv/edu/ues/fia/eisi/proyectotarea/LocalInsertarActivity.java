package sv.edu.ues.fia.eisi.proyectotarea;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.ues.fia.eisi.proyectotarea.baseDatos.ControlDBProyecto;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Local;

public class LocalInsertarActivity extends Activity {

    ControlDBProyecto helper;
    EditText editIdLocal;
    EditText editUbicacion;
    EditText editCapacidad;
    EditText editNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_insertar);
        helper = new ControlDBProyecto(this);
        editIdLocal = (EditText) findViewById(R.id.editIdLocal);
        editUbicacion = (EditText) findViewById(R.id.editUbicacion);
        editCapacidad = (EditText) findViewById(R.id.editCapacidad);
        editNombre = (EditText) findViewById(R.id.editNombre);
    }

    public void insertarLocal(View v) {
        String idLocal=editIdLocal.getText().toString();
        String ubicacion=editUbicacion.getText().toString();
        String capacidad=editCapacidad.getText().toString();
        String nombre=editNombre.getText().toString();
        String regInsertados;
        Local local=new Local();
        local.setIdLocal(Integer.parseInt(idLocal));
        local.setUbicacion(ubicacion);
        local.setCapacidad(Integer.parseInt(capacidad));
        local.setNombre(nombre);

        helper.abrir();
        regInsertados=helper.insertar(local);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editIdLocal.setText("");
        editUbicacion.setText("");
        editCapacidad.setText("");
        editNombre.setText(""); }
}
