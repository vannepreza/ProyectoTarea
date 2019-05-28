package sv.edu.ues.fia.eisi.proyectotarea;

public class Actividad {

    private String ciclo;
    private String detalle;
    private String actividad;

    public Actividad(){

    }

    public Actividad(String ciclo, String detalle, String actividad) {
        this.ciclo = ciclo;
        this.detalle = detalle;
        this.actividad = actividad;
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

    public String getActividad() {
        return actividad;
    }
    public void setActividad(String actividad) {
        this.actividad = actividad;
    }


}
