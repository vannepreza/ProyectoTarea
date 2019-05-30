package sv.edu.ues.fia.eisi.proyectotarea;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.ues.fia.eisi.proyectotarea.baseDatos.ControlDBProyecto;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Docente;

public class DocenteInsertarActivity extends Activity {
    ControlDBProyecto helper;
    EditText editIdDocente;
    EditText edNombre;
    EditText edApellido;
    EditText edDui;
    EditText edGenero;
    EditText edEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente_insertar);
        helper = new ControlDBProyecto(this);

        editIdDocente =   findViewById(R.id.editidDocente);
        edNombre =   findViewById(R.id.editNombre);
        edApellido =  findViewById(R.id.editApellido);
        edDui =  findViewById(R.id.editDui);
        edGenero =   findViewById(R.id.editGenero);
        edEmail =  findViewById(R.id.editEmail);

    }

    public void insertar(View v){
        String idDoc = editIdDocente.getText().toString();
        String nombre = edNombre.getText().toString();
        String apellido = edApellido.getText().toString();
        String dui = edDui.getText().toString();
        String genero = edGenero.getText().toString();
        String email = edEmail.getText().toString();


        Docente doc = new Docente();
        doc.setIdDocente(idDoc);
        doc.setNombre(nombre);
        doc.setApellido(apellido);
        doc.setDui(dui);
        doc.setGenero(genero);
        doc.setEmail(email);

        ControlDBProyecto db = new ControlDBProyecto(this);
        db.abrir();
        String result = db.insertarDocente(doc);
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        db.cerrar();


    }

    public void limpiarTexto (View v){
        editIdDocente.setText("");
        edNombre.setText("");
        edApellido.setText("");
        edDui.setText("");
        edGenero.setText("");
        edEmail.setText("");
    }
}
