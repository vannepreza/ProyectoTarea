package sv.edu.ues.fia.eisi.proyectotarea;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.ues.fia.eisi.proyectotarea.baseDatos.ControlDBProyecto;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Carrera;

public class CarreraActualizarActivity extends Activity {
    ControlDBProyecto helper;
    private EditText  editId_Carrera;
    private EditText  editNombre_Carrera;
    private EditText  editId_Escuela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrera_actualizar);
        helper = new   ControlDBProyecto (this);
        editId_Carrera= (EditText) findViewById(R.id.editId_Carrera);
        editNombre_Carrera = (EditText) findViewById(R.id.editNombre_Carrera);
        editId_Escuela = (EditText) findViewById(R.id.editId_Escuela);

    }

    public void actualizarCarrera(View v) {
        Carrera carrera = new Carrera();
        carrera.setId_carrera(editId_Carrera.getText().toString());
        carrera.setNombre_carrera(editNombre_Carrera.getText().toString());
        carrera.setId_escuela(editId_Escuela.getText().toString());
        helper.abrir();
        String estado = helper.actualizarCarrera(carrera);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editId_Carrera.setText("");
        editNombre_Carrera.setText("");
        editId_Escuela.setText("");

    }
}
