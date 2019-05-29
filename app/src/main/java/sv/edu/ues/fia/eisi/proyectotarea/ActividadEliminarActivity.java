package sv.edu.ues.fia.eisi.proyectotarea;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.ues.fia.eisi.proyectotarea.baseDatos.ControlDBProyecto;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Actividad;

public class ActividadEliminarActivity extends Activity {

    EditText editCiclo;
    ControlDBProyecto controlhelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_eliminar);
        controlhelper=new ControlDBProyecto (this);
        editCiclo=(EditText)findViewById(R.id.editCiclo);
    }

    public void eliminarActividad(View v){
        String regEliminadas;
        Actividad actividad=new Actividad();
        actividad.setCiclo(editCiclo.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(actividad);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }

}

