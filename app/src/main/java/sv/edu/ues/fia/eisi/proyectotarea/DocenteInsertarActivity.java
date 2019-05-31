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
    EditText idDoc;
    EditText nom;
    EditText ape;
    EditText dui;
    EditText gen;
    EditText ema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente_insertar);

        helper = new ControlDBProyecto(this);
        idDoc = (EditText) findViewById(R.id.editidDocente);
        nom = (EditText) findViewById(R.id.editNombre);
        ape = (EditText) findViewById(R.id.editApellido);
        dui = (EditText) findViewById(R.id.editDui);
        gen = (EditText) findViewById(R.id.editGenero);
        ema = (EditText) findViewById(R.id.editEmail);
    }

    public void insertDoc(View v){
        String idDocente = idDoc.getText().toString();
        String nombre = nom.getText().toString();
        String apellido = ape.getText().toString();
        String dui = ape.getText().toString();
        String genero = gen.getText().toString();
        String email = ema.getText().toString();

        String regInsert;
        Docente docente = new Docente();
        docente.setIdDocente(idDocente);
        docente.setNombre(nombre);
        docente.setApellido(apellido);
        docente.setDui(dui);
        docente.setGenero(genero);
        docente.setEmail(email);

        helper.abrir();
        regInsert = helper.insertar(docente);
        helper.cerrar();
        Toast.makeText(this, regInsert, Toast.LENGTH_SHORT).show();
    }

    public void limpiar (View v){
        idDoc.setText("");
        nom.setText("");
        ape.setText("");
        dui.setText("");
        gen.setText("");
        ema.setText("");
    }
}
