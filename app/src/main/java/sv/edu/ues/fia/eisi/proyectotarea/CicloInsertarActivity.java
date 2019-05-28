package sv.edu.ues.fia.eisi.proyectotarea;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CicloInsertarActivity extends Activity {
    ControlDBProyecto helper;
    EditText editCiclo;
    EditText editDetalle;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclo_insertar);
        helper = new ControlDBProyecto(this);
        editCiclo = (EditText) findViewById(R.id.editCiclo);
        editDetalle = (EditText) findViewById(R.id.editDetalle);
    }
    public void insertarCiclo(View v) {
        String regInsertados;
        String ciclo = editCiclo.getText().toString();
        String detalle = editDetalle.getText().toString();

        Ciclo ciclo1 = new Ciclo();
        ciclo1.setCiclo(ciclo);
        ciclo1.setDetalle(detalle);
        helper.abrir();
        regInsertados = helper.insertar(ciclo1);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editCiclo.setText("");
        editDetalle.setText("");
    }
}

