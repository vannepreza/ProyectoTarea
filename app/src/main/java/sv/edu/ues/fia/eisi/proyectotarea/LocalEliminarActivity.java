package sv.edu.ues.fia.eisi.proyectotarea;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.ues.fia.eisi.proyectotarea.baseDatos.ControlDBProyecto;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Local;

public class LocalEliminarActivity extends Activity {
    EditText editIdLocal;
    ControlDBProyecto controlhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_eliminar);
        controlhelper=new ControlDBProyecto (this);
        editIdLocal=(EditText)findViewById(R.id.editIdLocal);
    }

    public void eliminarLocal(View v){
        String regEliminadas;
        Local local=new Local();
        local.setIdLocal(Integer.parseInt(editIdLocal.getText().toString()));
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(local);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}
