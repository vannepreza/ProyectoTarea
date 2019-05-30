package sv.edu.ues.fia.eisi.proyectotarea.modelos;

public class DispCiclo {
    private int idDisponibilidad;
    private int disponibilidad;
    private int idCargaDocente;

    public DispCiclo() {
    }

    public DispCiclo(int idDisponibilidad, int disponibilidad, int idCargaDocente) {
        this.idDisponibilidad = idDisponibilidad;
        this.disponibilidad = disponibilidad;
        this.idCargaDocente = idCargaDocente;
    }

    public int getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public void setIdDisponibilidad(int idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getIdCargaDocente() {
        return idCargaDocente;
    }

    public void setIdCargaDocente(int idCargaDocente) {
        this.idCargaDocente = idCargaDocente;
    }
}
