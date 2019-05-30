package sv.edu.ues.fia.eisi.proyectotarea.modelos;

public class Solicitud {

    private String idSolicitud;
    private String descripcion;
    private String capacidad;
    private String  fecha;

    public Solicitud(){

    }

    public Solicitud(String idSolicitud,String Descripcion, String capacidad, String fecha){
        this.idSolicitud= idSolicitud;
        this.descripcion = Descripcion;
        this.capacidad = capacidad;
        this.fecha = fecha;
    }

    public String getIdSolicitud(){return idSolicitud;}
    public void setIdSolicitud(String idSolicitud){this.idSolicitud= idSolicitud;}

    public String getDescripcion(){return descripcion; }
    public void setDescripcion(String descripcion){this.descripcion=descripcion;}

    public String getCapacidad(){return capacidad; }
    public void setCapacidad(String capacidad){this.capacidad=capacidad;}

    public String getFecha(){return fecha; }
    public void setFecha (String fecha){this.fecha = fecha;}

}
