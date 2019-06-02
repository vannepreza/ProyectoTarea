package sv.edu.ues.fia.eisi.proyectotarea;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.ues.fia.eisi.proyectotarea.baseDatos.ControlDBProyecto;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Pensum;

public class PensumActualizarActivity extends Activity {


    ControlDBProyecto helper;
    private EditText editId_Pensum;
    private EditText  editNombre_Materia;
    private EditText  editId_Carrera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pensum_actualizar);
        helper = new ControlDBProyecto(this);

        editId_Pensum = (EditText) findViewById(R.id.editId_Pensum);
        editNombre_Materia = (EditText) findViewById(R.id.editNombre_Materia);
        editId_Carrera= (EditText) findViewById(R.id.editId_Carrera);


    }

    public void actualizarPensum(View v) {
        Pensum pensum = new Pensum();
        pensum.setId_pensum(editId_Pensum.getText().toString());
        pensum.setNombre_materia(editNombre_Materia.getText().toString());
        pensum.setId_carrera(editId_Carrera.getText().toString());
        helper.abrir();
        String estado = helper.actualizarPensum(pensum);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {

        editId_Pensum.setText("");
        editNombre_Materia.setText("");
        editId_Carrera.setText("");

    }
}

