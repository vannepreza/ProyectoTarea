package sv.edu.ues.fia.eisi.proyectotarea;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.ues.fia.eisi.proyectotarea.modelos.Escuela;
import sv.edu.ues.fia.eisi.proyectotarea.baseDatos.ControlDBProyecto;



public class EscuelaActualizarActivity extends Activity {
    ControlDBProyecto helper;
    private EditText editId_Escuela;
    private EditText  editNombre_Escuela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escuela_actualizar);
        helper = new  ControlDBProyecto(this);
        editId_Escuela= (EditText) findViewById(R.id.editId_Escuela);
        editNombre_Escuela = (EditText) findViewById(R.id.editNombre_Escuela);
    }

    public void actualizarEscuela(View v) {
        Escuela escuela = new Escuela();
        escuela.setId_escuela(editId_Escuela.getText().toString());
        escuela.setNombre_escuela(editNombre_Escuela.getText().toString());
        helper.abrir();
        String estado = helper.actualizarEscuela(escuela);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editId_Escuela.setText("");
        editNombre_Escuela.setText("");


    }
}
