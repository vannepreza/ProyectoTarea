package sv.edu.ues.fia.eisi.proyectotarea.modelos;

public class Horario {
    private int idHorario;
    private int horaInicio;
    private int horaFin;

    public Horario() {
    }

    public Horario(int idHorario, int horaInicio, int horaFin) {
        this.idHorario = idHorario;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }
}
