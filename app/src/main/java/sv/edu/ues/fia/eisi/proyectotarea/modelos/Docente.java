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

    public Docente(String IdDocente, String Nombre, String Apellido, String Dui,  String Genero, String Email){

        this.idDocente = IdDocente;
        this.nombre = Nombre;
        this.apellido = Apellido;
        this.dui = Dui;
        this.genero = Genero;
        this.email = Email;
    }

    public String getIdDocente(){ return idDocente; }
    public void setIdDocente(String IdDocente){ this.idDocente = IdDocente; }

    public String getNombre(){ return nombre; }
    public void setNombre(String Nombre){ this.nombre = Nombre; }

    public String getApellido(){ return apellido; }
    public void setApellido(String Apellido){ this.apellido = Apellido; }

    public String getDui(){ return dui; }
    public void setDui(String Dui){ this.dui = Dui; }



    public String getGenero(){ return genero; }
    public void setGenero(String Genero){ this.genero= Genero; }

    public String getEmail(){ return email; }
    public void setEmail(String Email){ this.email = Email; }
}
