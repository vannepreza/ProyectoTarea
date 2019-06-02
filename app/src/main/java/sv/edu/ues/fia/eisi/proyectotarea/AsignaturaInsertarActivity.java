package sv.edu.ues.fia.eisi.proyectotarea;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.ues.fia.eisi.proyectotarea.baseDatos.ControlDBProyecto;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Asignatura;
public class AsignaturaInsertarActivity extends Activity {

    ControlDBProyecto helper;
    EditText editId_Asignatura;
    EditText editNombre_Asignatura;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignatura_insertar);
         helper = new  ControlDBProyecto(this);
        editId_Asignatura = (EditText) findViewById(R.id.editId_Asignatura);
        editNombre_Asignatura= (EditText) findViewById(R.id.editNombre_Asignatura);


    }


    public void insertarAsignatura(View v) {
        String id_asignatura=editId_Asignatura.getText().toString();
        String nombre_asignatura=editNombre_Asignatura.getText().toString();


        String regInsertados;

        Asignatura asignatura=new Asignatura();
        asignatura.setId_asignatura(id_asignatura);
        asignatura.setNombre_asignatura(nombre_asignatura);


       helper.abrir();
        regInsertados = helper.insertar(asignatura);
        helper.cerrar();
       Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editId_Asignatura.setText("");
        editNombre_Asignatura.setText("");


    }
}
