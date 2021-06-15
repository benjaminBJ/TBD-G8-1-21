package cl.tbd.entrega2.repositories;

import cl.tbd.entrega2.models.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TareaRepositoryImp implements TareaRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countTarea() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            String sql = "SELECT COUNT(*) " + 
                         "FROM tarea";             
            total = conn.createQuery(sql).executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Tarea> getAllTarea() {
        try(Connection conn = sql2o.open()){

            final String query = "SELECT id, nombre,descrip,vol_requeridos,finicio,ffin,id_emergencia,id_estado" +
                    ", st_x(st_astext( location)) AS longitude, st_y(st_astext(location)) AS latitude" +
                    " FROM tarea;";

            return conn.createQuery(query)
                    .executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Tarea getTarea(int id) {
        try(Connection conn = sql2o.open()){

            String sql = "SELECT id, nombre,descrip,vol_requeridos,finicio,ffin,id_emergencia,id_estado" +
                    ", st_x(st_astext( location)) AS longitude, st_y(st_astext(location)) AS latitude" +
                    " FROM tarea WHERE id=:id";

            Tarea tarea = conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Tarea.class);
            return tarea;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Tarea createTarea(Tarea tarea) {
        try(Connection conn = sql2o.open()){
            String sql = 
                    "INSERT INTO tarea (nombre, descrip, vol_requeridos, finicio, ffin, id_emergencia, id_estado,location)" +
                        "values (:nombre, :descrip, :vol_requeridos, :finicio, :ffin, :id_emergencia, :id_estado, ST_GeomFromText(:point, 4326))";

            String point = "POINT("+tarea.getLongitude()+" "+tarea.getLatitude()+")";
            System.out.println("point: "+point);

            int insertedId = (int) conn.createQuery(sql, true)
                    .addParameter("nombre", tarea.getNombre())
                    .addParameter("point", point)
                    .addParameter("descrip", tarea.getDescrip())
                    .addParameter("vol_requeridos", tarea.getVol_requeridos())
                    .addParameter("finicio", tarea.getFinicio())
                    .addParameter("ffin", tarea.getFfin())
                    .addParameter("id_emergencia", tarea.getId_emergencia())
                    .addParameter("id_estado", tarea.getId_estado())
                    .executeUpdate().getKey();
            tarea.setId(insertedId);
            return tarea;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Tarea upTarea(Tarea tarea) {
        try(Connection conn = sql2o.open()){

            String sql =
                    "UPDATE tarea SET nombre = :nombre, descrip = :descrip, vol_requeridos = :vol_requeridos, " +
                        "finicio = :finicio, ffin = :ffin, id_emergencia = :id_emergencia, id_estado = :id_estado" +
                            ", location = ST_GeomFromText(:point, 4326) WHERE id = :id";

            String point = "POINT("+tarea.getLongitude()+" "+tarea.getLatitude()+")";
            System.out.println("point: "+point);

            conn.createQuery(sql, true)
                    .addParameter("id", tarea.getId())
                    .addParameter("point", point)
                    .addParameter("nombre", tarea.getNombre())
                    .addParameter("descrip", tarea.getDescrip())
                    .addParameter("vol_requeridos", tarea.getVol_requeridos())
                    .addParameter("finicio", tarea.getFinicio())
                    .addParameter("ffin", tarea.getFfin())
                    .addParameter("id_emergencia", tarea.getId_emergencia())
                    .addParameter("id_estado", tarea.getId_estado())
                    .executeUpdate();

            return tarea;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteTarea(int id) {

        try(Connection conn = sql2o.open()){
            String sql = "DELETE FROM tarea WHERE id = :id";
            conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void procedure1(int idt, int idv) {

        try(Connection conn = sql2o.open()){

            String sql2 = "CALL public.cerrar_tarea("+idt+","+idv+" )";
            conn.createQuery(sql2, true)
                    .executeUpdate();

           // System.out.println("Ejecuta procedimiento");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getJson() {
        // TODO Auto-generated method stub
        final String query = "SELECT json_build_object("+
                "'type', 'FeatureCollection',"+
                "'features', json_agg(ST_AsGeoJSON(t.geom)::json)"+
                ")"+
                "FROM division_regional_4326 AS t WHERE t.gid = 5;";
        return null;
    }


}
