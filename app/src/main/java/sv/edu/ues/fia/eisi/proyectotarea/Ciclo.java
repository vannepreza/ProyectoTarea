package sv.edu.ues.fia.eisi.proyectotarea;

public class Ciclo {

    private String ciclo;
    private  String detalle;

    public Ciclo(){
    }
    public Ciclo(String ciclo, String detalle) {
        this.ciclo = ciclo;
        this.detalle = detalle;
    }

    public String getCiclo() {
        return ciclo;
    }
    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getDetalle() {
        return detalle;
    }
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

}

