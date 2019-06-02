package sv.edu.ues.fia.eisi.proyectotarea;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.ues.fia.eisi.proyectotarea.modelos.Carrera;
import sv.edu.ues.fia.eisi.proyectotarea.baseDatos.ControlDBProyecto;

public class CarreraEliminarActivity extends Activity {
    EditText editId_Carrera;
    ControlDBProyecto  controlhelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrera_eliminar);
        controlhelper=new ControlDBProyecto (this);
        editId_Carrera=(EditText)findViewById(R.id.editId_Carrera);
    }
    public void eliminarCarrera(View v){
        String regEliminadas;
        Carrera carrera=new Carrera();
        carrera.setId_carrera(editId_Carrera.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminarCarrera(carrera);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}
