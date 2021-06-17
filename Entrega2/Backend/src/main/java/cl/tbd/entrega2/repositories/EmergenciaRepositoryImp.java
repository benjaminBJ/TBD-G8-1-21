package cl.tbd.entrega2.repositories;

import cl.tbd.entrega2.models.Emergencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmergenciaRepositoryImp implements EmergenciaRepository{

    @Autowired
    private Sql2o sql2o;


    @Override
    public int countEmergencia() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery("SELECT COUNT(*) FROM emergencia").executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Emergencia> getAllEmergencias() {
        try(Connection conn = sql2o.open()){

            final String query = "SELECT id, nombre,descrip,finicio,ffin,id_institucion" +
                    ", st_x(st_astext( location)) AS longitude, st_y(st_astext(location)) AS latitude" +
                    " FROM emergencia;";
            return conn.createQuery(query)
                    .executeAndFetch(Emergencia.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Emergencia getEmergencia(int id) {
        try(Connection conn = sql2o.open()){

            String sql = "select id, nombre,descrip,finicio,ffin,id_institucion" +
                    ", st_x(st_astext( location)) AS longitude, st_y(st_astext(location)) AS latitude" +
                    " FROM emergencia WHERE id = :id";

            Emergencia emergencia = conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Emergencia.class);
            return emergencia;
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("No existe emergencia con id : "+id);
            return null;
        }
    }

    @Override
    public Emergencia createEmergencia(Emergencia emergencia) {
        try(Connection conn = sql2o.open()){

            String sql =
                    "INSERT INTO emergencia (nombre,descrip,finicio,ffin,id_institucion,location) " +
                            "values (:nombre,:descrip,:finicio,:ffin,:id_institucion, ST_GeomFromText(:point, 4326))";

            String point = "POINT("+emergencia.getLongitude()+" "+emergencia.getLatitude()+")";
            System.out.println("point: "+point);

            int insertedId = (int) conn.createQuery(sql, true)
                    .addParameter("nombre", emergencia.getNombre())
                    .addParameter("point", point)
                    //Ocultar mientras se arregla los otros parametros
                    .addParameter("descrip", emergencia.getDescrip())
                    .addParameter("finicio", emergencia.getFinicio())
                    .addParameter("ffin", emergencia.getFfin())
                    .addParameter("id_institucion", emergencia.getId_institucion())
                    .executeUpdate().getKey();

            emergencia.setId(insertedId);
            return emergencia;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Emergencia upEmergencia(Emergencia emergencia) {
        try(Connection conn = sql2o.open()){

            String sql =
                    "UPDATE emergencia SET nombre = :nombre, descrip = :descrip, finicio = :finicio, " +
                            "ffin =:ffin, id_institucion =:id_institucion, location = ST_GeomFromText(:point, 4326)" +
                            " WHERE id = :id";

            String point = "POINT("+emergencia.getLongitude()+" "+emergencia.getLatitude()+")";
            System.out.println("point: "+point);

            conn.createQuery(sql, true)
                    .addParameter("nombre", emergencia.getNombre())
                    .addParameter("point", point)
                    //Ocultar mientras se arregla los otros parametros
                    .addParameter("descrip", emergencia.getDescrip())
                    .addParameter("finicio", emergencia.getFinicio())
                    .addParameter("ffin", emergencia.getFfin())
                    .addParameter("id_institucion", emergencia.getId_institucion())
                    .addParameter("id", emergencia.getId())
                    .executeUpdate();

            return emergencia;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteEmergencia(int id) {
        try(Connection conn = sql2o.open()){
            String sql = "DELETE FROM emergencia WHERE id = :id";
            conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeUpdate();
            System.out.println("Eliminado emergencia con id : "+id);
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