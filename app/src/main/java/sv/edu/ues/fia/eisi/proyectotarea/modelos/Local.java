package sv.edu.ues.fia.eisi.proyectotarea.modelos;

public class Local {
    private int IdLocal;
    private  String Ubicacion;
    private int Capacidad;
    private String Nombre;

    public Local() {
    }

    public Local(int idLocal, String ubicacion, int capacidad, String nombre) {
        IdLocal = idLocal;
        Ubicacion = ubicacion;
        Capacidad = capacidad;
        Nombre = nombre;
    }

    public int getIdLocal() {
        return IdLocal;
    }

    public void setIdLocal(int idLocal) {
        IdLocal = idLocal;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    public int getCapacidad() {
        return Capacidad;
    }

    public void setCapacidad(int capacidad) {
        Capacidad = capacidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
