package sv.edu.ues.fia.eisi.proyectotarea;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.ues.fia.eisi.proyectotarea.baseDatos.ControlDBProyecto;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Pensum;


public class PensumInsertarActivity extends Activity {

    ControlDBProyecto  helper;
    EditText editId_Pensum;
    EditText editNombre_Materia;
    EditText editId_Carrera;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pensum_insertar);
        helper = new ControlDBProyecto (this);
        editId_Pensum = (EditText) findViewById(R.id.editId_Pensum);
        editNombre_Materia= (EditText) findViewById(R.id.editNombre_Materia);
        editId_Carrera = (EditText) findViewById(R.id.editId_Carrera);

    }


    public void insertarPensum(View v) {
        String id_pensum=editId_Pensum.getText().toString();
        String nombre_materia=editNombre_Materia.getText().toString();
        String id_carrera=editId_Carrera.getText().toString();

        String regInsertados;

        Pensum pensum=new Pensum();
        pensum.setId_pensum(id_pensum);
        pensum.setNombre_materia(nombre_materia);
        pensum.setId_carrera(id_carrera);

        helper.abrir();
        regInsertados = helper.insertar(pensum);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editId_Pensum.setText("");
        editNombre_Materia.setText("");
        editId_Carrera.setText("");

    }
}
