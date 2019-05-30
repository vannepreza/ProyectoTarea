package sv.edu.ues.fia.eisi.proyectotarea.modelos;

public class Docente {



    private String idDocente;
    private String nombre;
    private String apellido;
    private String dui;
    private String genero;
    private String email;

    public Docente(){

    }

    public Docente(String idDoc, String nom, String apell, String du, String gen, String ema){
        this.idDocente = idDoc;
        this.nombre = nom;
        this.apellido = apell;
        this.dui= du;
        this.genero = gen;
        this.email = ema;

    }

    public String getIdDocente() {
        return idDocente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDui() {
        return dui;
    }

    public String getGenero() {
        return genero;
    }

    public String getEmail() {
        return email;
    }

    public void setIdDocente(String idDocente) {
        this.idDocente = idDocente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
