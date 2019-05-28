package sv.edu.ues.fia.eisi.proyectotarea;

import java.util.Date;

public class HorarioNo {

    private String ciclo;
    private String fecha;

    public HorarioNo(){

    }

    public HorarioNo(String ciclo, String fecha){
        this.ciclo = ciclo;
        this.fecha = fecha;
    }
    public String getCiclo(){
        return ciclo;
    }
    public void setCiclo(String ciclo){
        this.ciclo = ciclo;
    }

    public String getFecha(){
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}

