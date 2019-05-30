package sv.edu.ues.fia.eisi.proyectotarea.modelos;

public class Cargo {

    private int idCargo;
    private String tipoDocente;
    private String actividadDescribir;

    public Cargo(){ }

    public Cargo(int idCargo, String tipoDocente, String actividadDescribir){
        this.idCargo= idCargo;
        this.tipoDocente= tipoDocente;
        this.actividadDescribir= actividadDescribir;
    }

    public int getIdCargo(){return idCargo;}
    public void setIdCargo(int idCargo){this.idCargo= idCargo;}

    public String getTipoDocente(){return tipoDocente;}
    public void setTipoDocente(String tipoDocente) { this.tipoDocente=tipoDocente;}

    public String getActividadDescribir(){ return actividadDescribir;}
    public void setActividadDescribir(String actividadDescribir){this.actividadDescribir= actividadDescribir;}
}
