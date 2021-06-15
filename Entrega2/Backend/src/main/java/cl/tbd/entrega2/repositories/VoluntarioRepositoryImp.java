package cl.tbd.entrega2.repositories;

import cl.tbd.entrega2.models.Voluntario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository{
    
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Voluntario> getAllVoluntarios() {
        try(Connection conn = sql2o.open()){
            String sql = "SELECT id, nombre, rut, email, telefono" +
                    ", st_x(st_astext( location)) AS longitude, st_y(st_astext(location)) AS latitude" +
                    " FROM voluntario";
            return conn.createQuery(sql)
                    .executeAndFetch(Voluntario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Voluntario getVoluntario(int id) {
        try(Connection conn = sql2o.open()){

            String sql = "SELECT id, nombre, rut, email, telefono" +
                    ", st_x(st_astext( location)) AS longitude, st_y(st_astext(location)) AS latitude" +
                    " FROM voluntario WHERE id = :id";

            Voluntario voluntario = conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Voluntario.class);
            return voluntario;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Voluntario createVoluntario(Voluntario voluntario) {
        try(Connection conn = sql2o.open()){
            String sql =
                    "INSERT INTO voluntario (nombre, rut, email, telefono,location)" +
                            "values (:nombre, :rut, :email, :telefono, ST_GeomFromText(:point, 4326))";

            String point = "POINT("+voluntario.getLongitude()+" "+voluntario.getLatitude()+")";
            System.out.println("point: "+point);

            int insertedId = (int) conn.createQuery(sql, true)
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("point", point)
                    .addParameter("rut", voluntario.getRut())
                    .addParameter("email", voluntario.getEmail())
                    .addParameter("telefono", voluntario.getTelefono())
                    .executeUpdate().getKey();

            voluntario.setId(insertedId);
            return voluntario;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Voluntario upVoluntario(Voluntario voluntario) {
        try(Connection conn = sql2o.open()){

            String sql =
                    "UPDATE voluntario SET nombre = :nombre, rut = :rut , email = :email , " +
                            "telefono =:telefono, location = ST_GeomFromText(:point, 4326) WHERE id = :id";

            String point = "POINT("+voluntario.getLongitude()+" "+voluntario.getLatitude()+")";
            System.out.println("point: "+point);

            conn.createQuery(sql, true)
                    .addParameter("id", voluntario.getId())
                    .addParameter("point", point)
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("rut", voluntario.getRut())
                    .addParameter("email", voluntario.getEmail())
                    .addParameter("telefono", voluntario.getTelefono())
                    .addParameter("id", voluntario.getId())
                    .executeUpdate();

            return voluntario;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteVoluntario(int id) {
        try(Connection conn = sql2o.open()){
            String sql = "DELETE FROM voluntario WHERE id = :id";
            conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeUpdate();
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
