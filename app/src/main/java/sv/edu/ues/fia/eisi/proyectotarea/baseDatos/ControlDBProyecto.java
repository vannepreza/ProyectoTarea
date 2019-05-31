package sv.edu.ues.fia.eisi.proyectotarea.baseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import sv.edu.ues.fia.eisi.proyectotarea.modelos.Actividad;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.CargaDocente;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Cargo;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Ciclo;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Docente;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.HorarioNo;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Solicitud;

import sv.edu.ues.fia.eisi.proyectotarea.modelos.Local;

public class ControlDBProyecto {
    private static final String[] camposActividad = new String[]{"ciclo", "detalle", "actividad"};
    private static final String[] camposCiclo = new String[]{"ciclo", "detalle"};
    private static final String[] camposHorarioNo = new String[]{"ciclo", "fecha"};
    private static final String[] camposDocente = new String[]{"idDocente", "nombre", "apellido", "dui", "genero", "email"};
    private static final String[] camposCargo = new String[]{"idCargo", "tipoDocente", "actividadDescribir"};
    private static final String[] camposSolicitud = new String[]{"idSolicitud", "descripcion", "capacidad", "fecha"};
    private static final String[] camposCargaDocente = new String[]{"idCargaDocente", "nombreCarga", "idAsignaturaPesum", "idCiclo", "idSolcicitud", "idDispoCiclo"};


    private static final String[] camposHorario = new String []{"idHoraio","horaInicio","horaFin"};
    private static final String[] camposDispHorario = new String []{"idDispHoraio","horaInicio","idHorario","idLocal"};
    private static final String[] camposLocal = new String []{"idLocal","ubicacion","capacidad","nombre"};

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

    private static class DatabaseHelper extends SQLiteOpenHelper{
        private static final String BASE_DATOS ="grupo08.s3db";
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

                //LOCAL,HORARIO, DISPHORARIO
                db.execSQL("CREATE TABLE horaio(idHorario INT NOT NULL PRIMARY KEY, horaInicio INT, horarioFin INT);");
                db.execSQL("CREATE TABLE local(idLocal INT NOT NULL PRIMARY KEY, ubicacion VARCHAR(80), capacidad INT, nombre VARCHAR(50));");
                db.execSQL("CREATE TABLE dispHorario(idDispHorario int NOT NULL, horaInicio int, PRIMARY KEY(idDispHorario, idHorario, idLocal));");

            }catch(SQLException e){
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

    //Inicio de insertar Docente
    public String insertar(Docente docente){

        String regInsertados = "Registro Insertado Nº= ";
        long contador = 0;
        ContentValues act = new ContentValues();
        act.put("idDocente", docente.getIdDocente());
        act.put("nombre", docente.getNombre());
        act.put("apellido", docente.getApellido());
        act.put("dui", docente.getDui());
        act.put("genero", docente.getGenero());
        act.put("email", docente.getEmail());



        contador = db.insert("docente", null, act);

        if (contador == -1 || contador == 0) {
            regInsertados = "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        } else {
            regInsertados = regInsertados + contador;
        }
        return regInsertados;

    }
    //fin de insertar docente

    //Inicio de insertar Carga docente
    public String insertar(CargaDocente cargaDocente){return null;}
    //fin de insertar carga docente

    //Inicio de insertar Cargo
    public String insertar(Cargo cargo){return null;}
    //fin de insertar cargo

    //Inicio de insertar Solicitud
    public String insertar(Solicitud solicitud){return null;}
    //fin de insertar solicitud


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

    //inicio de actualizar docente
    public String actualizar(Docente docente){return  null;}
    //fin de actualizar docente

    //inicio de actualizar carga docente
    public String actualizar(CargaDocente cargaDocente){return  null;}
    //fin de actualizar carga docente

    //inicio de actualizar solicitud
    public String actualizar(Solicitud solicitud){return  null;}
    //fin de actualizar solicitud

    //inicio de actualizar cargo
    public String actualizar(Cargo cargo){return  null;}
    //fin de actualizar cargo

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

    //inicio de eliminar docente
    public String eliminar(Docente docente){return null;}
    //fin de eliminar docente

    //inicio de eliminar carga docente
    public String eliminar(CargaDocente cargaDocente){return null;}
    //fin de eliminar carga docente

    //inicio de eliminar solicitud
    public String eliminar(Solicitud solicitud){return null;}
    //fin de eliminar solicitud

    //inicio de eliminar cargo
    public String eliminar(Cargo cargo){return null;}
    //fin de eliminar cargo


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

    //Inicio consultar docente
    public Docente consultarDocente(String docente){return null;}
    //fin de consultar docente

    //Inicio consultar carga docente
    public CargaDocente consultarCargaDocente(String cargadocente){return null;}
    //fin de consultar carga docente

    //Inicio consultar solicitud
    public Solicitud consultarSolicitud(String solicitud){return null;}
    //fin de consultar solicitud

    //Inicio consultar cargo
    public Cargo consultarCargo(String cargo){return null;}
    //fin de consultar cargo
    //INSERTAR LOCAL
    public String insertar(Local local){
        String regInsertados="Registro Insertado N°= ";
        long contador=0;

        ContentValues loc = new ContentValues();
        loc.put("idLocal", local.getIdLocal());
        loc.put("ubicacion", local.getUbicacion());
        loc.put("capacidad", local.getCapacidad());
        loc.put("nombre", local.getNombre());
        contador=db.insert("local", null, loc);
        if(contador==-1 || contador==0) {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        } else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }

    //CONSULTAR LOCAL
    public Local consultarLocal(String idLocal){
        String[] id = {idLocal};
        Cursor cursor = db.query("local", camposLocal, "idLocal = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            Local local = new Local();
            local.setIdLocal(Integer.parseInt(cursor.getString(0)));
            local.setUbicacion(cursor.getString(1));
            local.setCapacidad(Integer.parseInt(cursor.getString(2)));
            local.setNombre(cursor.getString(3));

            return local;
        }else{
            return null;
        }
    }

    //ACTUALIZAR LOCAL
    public String actualizar(Local local){
        if(verificarIntegridad(local, 4)){  //Relacion de 4 por ser local
            String[] id = {String.valueOf(local.getIdLocal())};
            ContentValues cv = new ContentValues();
            cv.put("ubicacion", local.getUbicacion());
            cv.put("capacidad", local.getCapacidad());
            cv.put("nombre", local.getNombre());
            db.update("local", cv, "idLocal = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro con carnet " + local.getIdLocal() + " no existe";
        }
    }

    //ELIMINAR LOCAL
    public String eliminar(Local local){
        String regAfectados="filas afectadas= ";
        int contador=0;
        if (verificarIntegridad(local,3)) {
            contador+=db.delete("dispHorario", "idLocal='"+local.getIdLocal()+"'", null);
        }
        contador+=db.delete("local", "idLocal='"+local.getIdLocal()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }



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
            case 6: {
                //verificar que exista docente
                Docente docente = (Docente) dato;
                String[] id = {docente.getIdDocente()};
                abrir();
                Cursor c = db.query("docente", null, "idDocente = ?", id, null, null, null);
                if (c.moveToFirst()){
                    //se encontro docente
                    return true;
                }
                //No se encontro docente
                return false;
            }
            case 7: {
                //verificar que exista cargo
                Cargo cargo = (Cargo) dato;
                String[] id = {cargo.getIdCargo()};
                abrir();
                Cursor c = db.query("cargo", null, "idCargo = ?", id, null, null, null);
                if (c.moveToFirst()){
                    //se encontro cargo
                    return true;
                }
                //No se encontro cargo
                return false;
            }
            case 8: {
                //verificar que exista solicitud
                Solicitud solicitud = (Solicitud) dato;
                String[] id = {solicitud.getIdSolicitud()};
                abrir();
                Cursor c = db.query("solicitud", null, "idSolicitud = ?", id, null, null, null);
                if (c.moveToFirst()){
                    //se encontro solicitud
                    return true;
                }
                //No se encontro solicitud
                return false;
            }

            case 9: {
                //verificar que exista carga docente
                CargaDocente cargaDocente = (CargaDocente) dato;
                String[] id = {cargaDocente.getIdCargaDocente()};
                abrir();
                Cursor c = db.query("cargaDocente", null, "idCargaDocente = ?", id, null, null, null);
                if (c.moveToFirst()){
                    //se encontro carga docente
                    return true;
                }
                //No se encontro carga docente
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

        //Sofia
        final String[] VDiddocente = {"0001", "0002"};
        final String[] VDnombre = {"docente 1", "docente 2"};
        final String[] VDapellido = {"parcial", "parcial"};
        final String[] VDdui = {"12017", "22017"};
        final String[] VDgenero = {"1", "2"};
        final String[] VDemail = {"parcial@intro", "parcial@repe"};


        abrir();
        db.execSQL("DELETE FROM actividad");
        db.execSQL("DELETE FROM ciclo");
        db.execSQL("DELETE FROM horarioNo");
        db.execSQL("DELETE FROM docente");
        db.execSQL("DELETE FROM solicitud");
        db.execSQL("DELETE FROM cargaDocente");
        db.execSQL("DELETE FROM cargo");


      /*
        //sofia
        db.execSQL("DELETE FROM docente");
        db.execSQL("DELETE FROM cargo");
        db.execSQL("DELETE FROM solicitud");
        */

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

        //Sofia
        Docente docente = new Docente();
        for (int i = 0; i < 6; i++) {
            docente.setIdDocente(VDiddocente[i]);
            docente.setNombre(VDnombre[i]);
            docente.setApellido(VDapellido[i]);
            docente.setDui(VDdui[i]);
            docente.setGenero(VDgenero[i]);
            docente.setEmail(VDemail[i]);
            insertar(docente);
        }

        cerrar();
        return "Guardado Correctamente";

    }

}