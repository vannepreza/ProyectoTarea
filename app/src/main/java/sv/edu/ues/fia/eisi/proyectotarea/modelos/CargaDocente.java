package sv.edu.ues.fia.eisi.proyectotarea.modelos;

public class CargaDocente {

    private String idCargaDocente;
    private String nombreCarga;
    private int idCiclo;
    private int idSolicitud;
    private int idDocente;
    private int idAsignaturaPesum;
    private int idDisponibilidadCiclo;

    public CargaDocente(){

    }

    public CargaDocente(String idCargaDocente, String nombreCarga, int ciclo, int idSolicitud, int idDocente, int idAsignaturaPesum, int idDispCiclo){
        this.idCargaDocente = idCargaDocente;
        this.nombreCarga = nombreCarga;
        this.idCiclo = ciclo;
        this.idSolicitud = idSolicitud;
        this.idDocente= idDocente;
        this.idAsignaturaPesum= idAsignaturaPesum;
        this.idDisponibilidadCiclo = idDispCiclo;
    }

    public String getIdCargaDocente(){return idCargaDocente;}
    public void setIdCargaDocente(String idCargaDocente){ this.idCargaDocente = idCargaDocente;}

    public String getNombreCarga(){return  nombreCarga;}
    public void setNombreCarga(String nomCar){this.nombreCarga = nomCar;}


    public int getIdSolicitud(){return idSolicitud;}
    public void setIdSolicitud(int idSolicitud){ this.idSolicitud = idSolicitud;}

    public int getIdDocente(){return idDocente;}
    public void setIdDocente(int idDocente){this.idDocente = idDocente;}

    public int getIdAsignaturaPesum(){return idAsignaturaPesum;}
    public void setIdAsignaturaPesum(int idAsignaturaPesum){this.idAsignaturaPesum = idAsignaturaPesum;}

    public int getIdDisponibilidadCiclo() { return idDisponibilidadCiclo; }
    public void setIdDisponibilidadCiclo(int idDisponibilidadCiclo) { this.idDisponibilidadCiclo = idDisponibilidadCiclo; }


    public int getIdCiclo() { return idCiclo; }
    public void setIdCiclo(int idCiclo) { this.idCiclo = idCiclo; }
}
