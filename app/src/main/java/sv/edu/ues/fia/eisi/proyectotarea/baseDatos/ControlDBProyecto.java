package sv.edu.ues.fia.eisi.proyectotarea.baseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import sv.edu.ues.fia.eisi.proyectotarea.modelos.Actividad;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Ciclo;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.HorarioNo;


public class ControlDBProyecto {
    private static final String[] camposActividad = new String[]{"ciclo", "detalle", "actividad"};
    private static final String[] camposCiclo = new String[]{"ciclo", "detalle"};
    private static final String[] camposHorarioNo = new String[]{"ciclo", "fecha"};
    private static final String[] camposDocente = new String[]{"idDocente", "nombre", "apellido", "dui", "genero", "email"};
    private static final String[] camposCargo = new String[]{"idCargo", "tipoDocente", "actividadDescribir"};
    private static final String[] camposSolicitud = new String[]{"idSolicitud", "descripcion", "capacidad", "fecha"};
    private static final String[] camposCargaDocente = new String[]{"idCargaDocente", "nombreCarga", "idAsignaturaPesum", "idCiclo", "idSolcicitud", "idDispoCiclo"};


    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;
    //private int[] VMciclo;

    public ControlDBProyecto(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        private static final String BASE_DATOS = "grupo08.s3db";
        private static final int VERSION = 1;

        public DatabaseHelper(Context context) {
            super(context, BASE_DATOS, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL("CREATE TABLE actividad(ciclo VARCHAR(7) NOT NULL PRIMARY KEY,detalle VARCHAR(30),actividad VARCHAR(30));");
                db.execSQL("CREATE TABLE ciclo(ciclo VARCHAR(6) NOT NULL PRIMARY KEY,detalle VARCHAR(30));");
                db.execSQL("CREATE TABLE horarioNo(ciclo VARCHAR(7) NOT NULL ,fecha DATE,PRIMARY KEY(ciclo));");
                db.execSQL("CREATE TABLE docente(idDocente VARCHAR(4) NOT NULL PRIMARY KEY, nombre VARCHAR(30) NOT NULL, apellido VARCHAR(30)NOT NULL, dui VARCHAR(10), genero VARCHAR(30), email VARCHAR(30));");
                db.execSQL("CREATE TABLE cargo(idCargo VARCHAR(4) NOT NULL PRIMARY KEY, tipoDocente VARCHAR(25), actividadDescribir VARCHAR(30));");
                db.execSQL("CREATE TABLE solicitud(idSolicitud VARCHAR(4) NOT NULL PRIMARY KEY, descripcion VARCHAR(30), capacidad VARCHAR(4), fecha DATE);");
                db.execSQL("CREATE TABLE cargaDocente(idCargaDocente VARCHAR(4) NOT NULL PRIMARY KEY,  nombreCarga VARCHAR(20), idAsignaturaPesum VARCHAR(4), idCiclo VARCHAR(6), idSolcicitud VARCHAR(4), idDispoCiclo VARCHAR(4));");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// TODO Auto-generated method stub
        }
    }

    public void abrir() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return;
    }

    public void cerrar() {
        DBHelper.close();
    }


// Inicio de insertar Actividad

    public String insertar(Actividad actividad) {

        String regInsertados = "Registro Insertado Nº= ";
        long contador = 0;
        ContentValues act = new ContentValues();
        act.put("ciclo", actividad.getCiclo());
        act.put("detalle", actividad.getDetalle());
        act.put("actividad", actividad.getActividad());

        contador = db.insert("actividad", null, act);

        if (contador == -1 || contador == 0) {
            regInsertados = "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        } else {
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }

    // Fin de insertar Actividad

    // Inicio de insertar Ciclo

    public String insertar(Ciclo ciclo) {
        String regInsertados = "Registro Insertado Nº= ";
        long contador = 0;
        if (verificarIntegridad(ciclo, 1)) {
            ContentValues ciclos = new ContentValues();
            ciclos.put("detalle", ciclo.getDetalle());
            contador = db.insert("ciclo", null, ciclos);
        }
        if (contador == -1 || contador == 0) {
            regInsertados = "Error al insertar el registro, Registro Duplicado. Verificaar la inserción";
        } else {
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }

    // Fin de insertar Ciclo

    // Inicio de insertar Horario No habil

    public String insertar(HorarioNo horarioNo) {
        return null;
    }

    // Fin de insertar  Horario no Habil


    // Inicio de Actualizar Actividad

    public String actualizar(Actividad actividad) {

        if (verificarIntegridad(actividad, 4)) {
            String[] id = {actividad.getCiclo()};
            ContentValues cv = new ContentValues();
            cv.put("detalle", actividad.getDetalle());
            cv.put("actividad", actividad.getActividad());
            db.update("actividad", cv, "ciclo = ?", id);
            return "Registro actualizado correctamente";
        } else {

            return "Registro con ciclo " + actividad.getCiclo() + " no existe";
        }

    }

    // Fin de Actualizar Actividad

    // Inicio de Actualiar Ciclo

    public String actualizar(Ciclo ciclo) {
        return null;
    }

    // Fin de Actualizar Ciclo

    // Incio de Actualizar Horario No Habil

    public String actualizar(HorarioNo horarioNo) {
        return null;
    }

    // Fin de Actualizar Horario No Habil


    // Inicio de Eliminar Actividad

    public String eliminar(Actividad actividad) {

        String regAfectados = "filas afectadas= ";
        int contador = 0;
        if (verificarIntegridad(actividad, 3)) {
            contador += db.delete("horario", "ciclo='" + actividad.getCiclo() + "'", null);
        }
        contador += db.delete("actividad", "ciclo='" + actividad.getCiclo() + "'", null);
        regAfectados += contador;
        return regAfectados;

    }

    //Fin de Eliminar Actividad

    // Inicio de Eliminar Ciclo

    public String eliminar(Ciclo ciclo) {
        return null;
    }

    // Fin de Eliminar Ciclo

    //Inicio de Eliminar Horario No Habil

    public String eliminar(HorarioNo horarioNo) {
        return null;
    }

    // Fin sw Eliminar Horario No Habil


    // Inicio de Consultar Actividad

    public Actividad consultarActividad(String ciclo) {
        String[] id = {ciclo};
        Cursor cursor = db.query("actividad", camposActividad, "ciclo = ?", id, null, null, null);

        if (cursor.moveToFirst()) {
            Actividad actividad = new Actividad();
            actividad.setCiclo(cursor.getString(0));
            actividad.setDetalle(cursor.getString(1));
            actividad.setActividad(cursor.getString(2));

            return actividad;
        } else {
            return null;
        }
    }

    // Fin de Consultar Actividad

    // Inicio de Consultar Ciclo

    public Ciclo consultarCiclo(String ciclo, String detalle) {

        return null;
    }

    // Fin de Consultar Ciclo

    // Inicio de Consultar Horario No Habil

    public HorarioNo consultarHorarioNo(String ciclo) {
        return null;
    }

    // Fin de Consultar Horario No Habil


    //Verificacion de la integridad de los datos

    private boolean verificarIntegridad(Object dato, int relacion) throws SQLException {
        switch (relacion) {
            case 1: {

                HorarioNo horarioNo = (HorarioNo) dato;
                String[] id1 = {horarioNo.getCiclo()};
//                String[] id2 = {horarioNo.getFecha()};
//abrir();
                Cursor cursor1 = db.query("actividad", null, "ciclo = ?", id1, null,
                        null, null);
                //   Cursor cursor2 = db.query("horarioNo", null, "ciclo = ?", id2, null, null, null);
                // if(cursor1.moveToFirst() && cursor2.moveToFirst()){
                if (cursor1.moveToFirst()) {
//Se encontraron datos
                    return true;
                }
                return false;
            }
            case 2: {

                HorarioNo horarioNo1 = (HorarioNo) dato;
                String[] ids = {horarioNo1.getCiclo(), horarioNo1.getCiclo(),
                        horarioNo1.getCiclo()};
                abrir();
                Cursor c = db.query("horarioNo", null, "ciclo = ? AND actividad = ?", ids, null, null, null);
                if (c.moveToFirst()) {
//Se encontraron datos
                    return true;
                }
                return false;
            }
            case 3: {
                Actividad actividad = (Actividad) dato;
                Cursor c = db.query(true, "horarioNo", new String[]{
                                "ciclo"}, "ciclo='" + actividad.getCiclo() + "'", null,
                        null, null, null, null);
                if (c.moveToFirst())
                    return true;
                else
                    return false;
            }
            case 4: {
                Ciclo ciclo = (Ciclo) dato;
                Cursor cciclo = db.query(true, "nota", new String[]{"detalle"}, "detalle ='" + ciclo.getCiclo() + "'", null, null, null, null, null);
                if (cciclo.moveToFirst())
                    return true;
                else
                    return false;
            }

            case 5: {
//verificar que exista actividad
                Actividad actividad2 = (Actividad) dato;
                String[] id = {actividad2.getCiclo()};
                abrir();
                Cursor c2 = db.query("actividad", null, "ciclo = ?", id, null, null,
                        null);
                if (c2.moveToFirst()) {
//Se encontro Actividad
                    return true;
                }
                return false;
            }

            default:
                return false;
        }
    }


    public String llenarBDProyecto() {

        final String[] VAciclo = {"12017", "22017"};
        final String[] VAdetalle = {"actividad 1", "actividad 2"};
        final String[] VAactividad = {"parcial intro", "parcial repe"};

        final String[] VCciclo = {"12017", "22017"};
        final String[] VAdetallec = {"12017", "22017"};

        final String[] VHciclo = {"12017", "22107"};
        final String[] VHfecha = {"2/03", "3/08"};

        abrir();
        db.execSQL("DELETE FROM actividad");
        db.execSQL("DELETE FROM ciclo");
        db.execSQL("DELETE FROM horarioNo");

        Actividad actividad = new Actividad();
        for (int i = 0; i < 3; i++) {
            actividad.setCiclo(VAciclo[i]);
            actividad.setDetalle(VAdetalle[i]);
            actividad.setActividad(VAactividad[i]);
            insertar(actividad);
        }

        Ciclo ciclo = new Ciclo();
        for (int i = 0; i < 2; i++) {
            ciclo.setCiclo(VAciclo[i]);
            ciclo.setDetalle(VAdetalle[i]);

            insertar(ciclo);
        }

        HorarioNo horarioNo = new HorarioNo();
        for (int i = 0; i < 2; i++) {

            horarioNo.setCiclo(VHciclo[i]);
            horarioNo.setFecha(VHfecha[i]);
            insertar(horarioNo);
        }
        cerrar();
        return "Guardado Correctamente";

    }

}