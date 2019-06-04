package sv.edu.ues.fia.eisi.proyectotarea.baseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import sv.edu.ues.fia.eisi.proyectotarea.modelos.Actividad;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Asignatura;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.CargaDocente;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Cargo;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Carrera;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Ciclo;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Docente;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Escuela;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.HorarioNo;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Local;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Pensum;
import sv.edu.ues.fia.eisi.proyectotarea.modelos.Solicitud;


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


    private static final String[]camposCarrera = new String [] {"id_carrera","nombre_carrera","id_escuela"};
    private static final String[] camposEscuela= new String [] {"id_escuela","nombre_escuela"};
    private static final String[]camposPensum = new String [] {"id_pensum","nombre_materia","id_carrera"};
    private static final String[]camposAsignatura = new String [] {"id_asignatura","nombre_asignatura"};





    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;
    //private int[] VMciclo;

    public ControlDBProyecto(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }


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


                //CARRERA, PENSUM, ESCUELA,ASIGNATURA
                db.execSQL("CREATE TABLE Carrera(id_carrera VARCHAR(8) NOT NULL PRIMARY KEY,nombre_carrera VARCHAR(40),id_escuela VARCHAR(8));");
                db.execSQL("CREATE TABLE Pensum(id_pensum VARCHAR(8) NOT NULL PRIMARY KEY,nombre_materia VARCHAR(40),id_carrera VARCHAR(8));");
                db.execSQL("CREATE TABLE Escuela(id_escuela VARCHAR(8) NOT NULL PRIMARY KEY,nombre_escuela VARCHAR(40));");
                db.execSQL("CREATE TABLE Asignatura(id_asignatura VARCHAR(8) NOT NULL PRIMARY KEY, nombre_asignatura VARCHAR(40));");




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


    //*******************************MATENIMIENTO KARLA***************************************************
    //*******************MANTENIMIENTO TABLA CARRERA************************//



    public boolean verifIntExistaCarrera(Carrera carrera){
        String[] id = {carrera.getId_carrera() + ""};
        Cursor c = db.query("Carrera", null, "id_carrera= ?", id, null, null, null);
        if (c.moveToFirst()){
            return true;
        }
        return false;
    }

    public String insertar(Carrera carrera)
    {
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues carrera1 = new ContentValues();
        carrera1.put("id_carrera", carrera.getId_carrera());
        carrera1.put("nombre_carrera", carrera.getNombre_carrera());
        carrera1.put("id_escuela",carrera.getId_escuela());


        contador=db.insert("Carrera", null, carrera1);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }


    public Carrera ConsultarCarrera(String id_carrera)

    {
        String[] id = {id_carrera};
        Cursor cursor = db.query("Carrera", camposCarrera, "id_carrera = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            Carrera carrera = new Carrera();
            carrera.setId_carrera(cursor.getString(0));
            carrera.setNombre_carrera(cursor.getString(1));
            carrera.setId_escuela(cursor.getString(2));
            return carrera;
        }else{ return null;
        }
    }


    public String actualizarCarrera(Carrera carrera)
    {

        if (verifIntExistaCarrera(carrera)){
            String[] id = {carrera.getId_carrera() + ""};
            ContentValues valores = new ContentValues();
            valores.put("nombre_carrera", carrera.getNombre_carrera());
            db.update("Carrera", valores, "id_carrera = ? ", id);
            return "Registro actualizado correctamente";
        } else{
            return "Registro no existe";
        }
    }

    public String eliminarCarrera(Carrera carrera){
        String regAfectados="filas afectadas= ";
        int contador=0;
        contador+=db.delete("Carrera", "id_carrera=" + carrera.getId_carrera(), null);
        regAfectados+=contador;
        return regAfectados;
    }


    //****************************MANTENIMIENTO ESCUELA******************************//



    public boolean verifIntExistaEscuela(Escuela escuela){
        String[] id = {escuela.getId_escuela() + ""};
        Cursor c = db.query("Escuela", null, "id_escuela= ?", id, null, null, null);
        if (c.moveToFirst()){
            return true;
        }
        return false;
    }

    public String insertar(Escuela escuela)
    {
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues escuela1 = new ContentValues();
        escuela1.put("id_escuela",escuela.getId_escuela());
        escuela1.put("nombre_escuela",escuela.getNombre_escuela());

        contador=db.insert("Escuela", null, escuela1);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }


    public Escuela ConsultarEscuela(String id_escuela)

    {
        String[] id = {id_escuela};
        Cursor cursor = db.query("Escuela", camposEscuela, "id_escuela = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            Escuela escuela= new Escuela();
            escuela.setId_escuela(cursor.getString(0));
            escuela.setNombre_escuela(cursor.getString(1));
            return escuela;
        }else{ return null;
        }
    }

    public String actualizarEscuela(Escuela escuela)
    {

        if (verifIntExistaEscuela(escuela)){
            String[] id = {escuela.getId_escuela() + ""};
            ContentValues valores = new ContentValues();
            valores.put("nombre_escuela", escuela.getNombre_escuela());
            db.update("Escuela", valores, "id_escuela = ? ", id);
            return "Registro actualizado correctamente";
        } else{
            return "Registro no existe";
        }
    }



//****************************MANTENIMIENTO PENSUM*******************************//



    public boolean verifIntExistaPensum(Pensum pensum){
        String[] id = {pensum.getId_pensum() + ""};
        Cursor c = db.query("Pensum", null, "id_pensum= ?", id, null, null, null);
        if (c.moveToFirst()){
            return true;
        }
        return false;
    }



    public String insertar(Pensum pensum){

        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues pensum1 = new ContentValues();
        pensum1.put("id_pensum",pensum.getId_pensum());
        pensum1.put("nombre_materia",pensum.getNombre_materia());
        pensum1.put("id_carrera",pensum.getId_carrera());

        contador=db.insert("Pensum", null, pensum1);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;


    }


    public Pensum ConsultarPensum(String id_pensum)

    {
        String[] id = {id_pensum};
        Cursor cursor = db.query("Pensum", camposPensum, "id_pensum = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            Pensum pensum = new Pensum();
            pensum.setId_pensum(cursor.getString(0));
            pensum.setNombre_materia(cursor.getString(1));
            pensum.setId_carrera(cursor.getString(2));
            return pensum;
        }else{ return null;
        }
    }



    public String actualizarPensum(Pensum pensum)
    {

        if (verifIntExistaPensum(pensum)){
            String[] id = {pensum.getId_pensum() + ""};
            ContentValues valores = new ContentValues();
            valores.put("nombre_materia", pensum.getNombre_materia());
            db.update("Pensum", valores, "id_pensum = ? ", id);
            return "Registro actualizado correctamente";
        } else{
            return "Registro no existe";
        }
    }

//*****************************MANTENIMIENTO ASIGNATURA*************************************/

    public String insertar(Asignatura asignatura)
    {
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues asignatura1 = new ContentValues();
        asignatura1.put("id_asignatura",asignatura.getId_asignatura());
        asignatura1.put("nombre_asignatura",asignatura.getNombre_asignatura());

        contador=db.insert("Escuela", null, asignatura1);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }



    public Asignatura ConsultarAsignatura (String id_asignatura)

    {
        String[] id = {id_asignatura};
        Cursor cursor = db.query("Asignatura", camposAsignatura, "id_asignatura = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            Asignatura asignatura = new Asignatura();
            asignatura.setId_asignatura(cursor.getString(0));
            asignatura.setNombre_asignatura(cursor.getString(1));

            return asignatura;
        }else{ return null;
        }
    }



  /*  private boolean verificarIntegridad(Object dato, int relacion) throws SQLException{
        switch(relacion){

            case 1:
            {
//verificar que al insertar carrera exista escuela
                Carrera carrera = (Carrera) dato;
                String[] id1 = {carrera.getId_escuela()};

                //abrir();
                Cursor cursor1 = db.query("Escuela", null, "id_escuela = ?", id1, null, null, null);
                if(cursor1.moveToFirst()){
//Se encontraro dato
                    return true;
                }
                return false;
                 }

                case 2:

                {
                    // verificar que al modificar carrera exista escuela
                   Carrera carrera1 = (Carrera) dato;
                    String[] id2 = {carrera1.getId_escuela()};
                    abrir();
                    Cursor c2 = db.query("Carrera", null, "id_carrera = ?", id2, null, null, null);
                    if(c2.moveToFirst()){
//Se encontro dato
                        return true;
                    }
                    return false;
                }
                case 3:
                {
//verificar  que al insertar pensum exista carrera
                   Pensum pensum = (Pensum) dato;
                   String[] id3 = {pensum.getId_carrera()};
                    Cursor cursor3 = db.query("Pensum", null, "id_pensum = ?", id3, null, null, null);
                    if(cursor3.moveToFirst()){
//Se encontraron datos
                        return true;
                    }
                    return false;
                }
            case 4:
            {
//verificar que exista Carrera
                Carrera carrera2 = (Carrera) dato;
                String[] id4 = {
                        carrera2.getId_carrera()
                };
                abrir();
                Cursor cursor4 = db.query("Carrera ", null, "id_carrera = ?", id4, null, null, null);
                if(cursor4.moveToFirst()){
//Se encontro Carrera
                    return true;
                }
                return false;

            }
            case 5:
            {
//verificar que exista Escuela
                Escuela escuela = (Escuela)dato;
                String[] id5 = {escuela.getId_escuela()};
                abrir();
                Cursor cm = db.query("Escuela", null, "id_escuela = ?", id5, null, null, null);
                if(cm.moveToFirst()){
//Se encontro Escuela
                    return true;
                }
                return false;
            }
            default:
                return false;
        }
    }*/






/***************FIN MANTENIMIENO KARLA*************************************/



    public String llenarBDProyecto()

        {

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


            //Karla

            final String[] VCid_carrera = {"I10515","I10502","I10503","I10504"};
            final String[] VCnombre_carrera = {"Ingenieria de Sistemas","Ingeniera Industrial","Ingenieria Mecanica","Ingenieria Electrica"};
            final String[] VCid_escuela = {"SIS515","IND502","MEC503","ELT504"};
            final String[] VPid_pensum = {"P10515","P10502","P10503","P10504"};
            final String[] VPnombre_materia = {"Sistemas y Procedimientos","Matematica 4","Solidos 1","Sistemas Digitales"};
            final String[] VPid_carrera = {"I10515","I10502","I10503","I10504"};
            final String[] VEid_escuela = {"E10515","E10502","E10503","E10504"};
            final String[] VEnombre_escuela = {"Escuela Ingenieria de Sistemas","Escuela Ingeniera Industrial","Escuela Ingenieria Mecanica","Escuela Ingenieria Electrica"};
            final String[] VAid_asignatura = {"SYS115","HDP115","SDU115","MAT115"};
            final String[] VAnombre_asignatura ={"Sistemas y procedimientos","Herramientas de productividad","Sistemas digitales","Matematicas 1"};



            abrir();
            db.execSQL("DELETE FROM actividad");
            db.execSQL("DELETE FROM ciclo");
            db.execSQL("DELETE FROM horarioNo");
            db.execSQL("DELETE FROM docente");
            db.execSQL("DELETE FROM solicitud");
            db.execSQL("DELETE FROM cargaDocente");
            db.execSQL("DELETE FROM cargo");

            abrir();
            db.execSQL("DELETE FROM carrera");
            db.execSQL("DELETE FROM pensum");
            db.execSQL("DELETE FROM escuela");
            db.execSQL("DELETE FROM asignatura");



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

            Carrera carrera = new Carrera();
            for(int i=0;i<4;i++){
                carrera.setId_carrera(VCid_carrera[i]);
                carrera.setNombre_carrera(VCnombre_carrera[i]);
                carrera.setId_escuela(VCid_escuela[i]);
                insertar(carrera);
            }
            Pensum pensum = new Pensum();
            for(int i=0;i<4;i++){
                pensum.setId_pensum(VPid_pensum[i]);
                pensum.setNombre_materia(VPnombre_materia[i]);
                pensum.setId_carrera(VPid_carrera[i]);
                insertar(pensum);
            }
            Escuela escuela = new Escuela();
            for(int i=0;i<4;i++){
                escuela.setId_escuela(VEid_escuela[i]);
                escuela.setNombre_escuela(VEnombre_escuela[i]);

                insertar(escuela);
            }


            Asignatura asignatura = new Asignatura();
            for(int i=0;i<4;i++)
            {
                asignatura.setId_asignatura(VAid_asignatura[i]);
                asignatura.setNombre_asignatura(VAnombre_asignatura[i]);

                insertar(asignatura);
            }

            cerrar();
            return "Guardo Correctamente";
        }

        }

