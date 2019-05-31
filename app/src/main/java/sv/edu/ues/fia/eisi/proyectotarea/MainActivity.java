package sv.edu.ues.fia.eisi.proyectotarea;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import sv.edu.ues.fia.eisi.proyectotarea.baseDatos.ControlDBProyecto;

public class MainActivity extends ListActivity {
    String[] menu={"Tabla Actividad","Tabla Ciclo","Tabla Horario No", "Tabla Tipo Actividad","Tabla Local","Tabla Horario","Tabla Disponiblidad Horario","Tabla Disponibiliad Ciclo","Tabla Tipo Local", "LLenar Base de Datos"};
            String[]
    activities={"ActividadMenuActivity","CicloMenuActivity","HorarioNoMenuActivity","TipoAMenuActivity","LocalMenuActivity","HorarioMenuActivity","DispHorarioMenuActivity","DispCicloMenuActivity","TipoLocalMenuActivity"};

    ControlDBProyecto BDhelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, menu));
        BDhelper=new ControlDBProyecto(this);
    }
    @Override
    protected void onListItemClick(ListView l,View v,int position,long id){
        super.onListItemClick(l, v, position, id);
        if(position!=9){
            String nombreValue=activities[position];
            try{
                Class<?>
                        clase=Class.forName("sv.edu.ues.fia.eisi.proyectotarea."+nombreValue);
                Intent inte = new Intent(this,clase);
                this.startActivity(inte);
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }else{

            BDhelper.abrir();
            String tost=BDhelper.llenarBDProyecto();
            BDhelper.cerrar();
            Toast.makeText(this, tost, Toast.LENGTH_SHORT).show();

        }
    }
}