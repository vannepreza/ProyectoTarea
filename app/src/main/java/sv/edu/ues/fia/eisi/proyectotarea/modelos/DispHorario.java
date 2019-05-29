package sv.edu.ues.fia.eisi.proyectotarea.modelos;

public class DispHorario {
    private int idDispHorario;
    private int horaInicio;
    private int idHorario;

    public DispHorario() {
    }

    public DispHorario(int idDispHorario, int horaInicio, int idHorario) {
        this.idDispHorario = idDispHorario;
        this.horaInicio = horaInicio;
        this.idHorario = idHorario;
    }

    public int getIdDispHorario() {
        return idDispHorario;
    }

    public void setIdDispHorario(int idDispHorario) {
        this.idDispHorario = idDispHorario;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }
}
