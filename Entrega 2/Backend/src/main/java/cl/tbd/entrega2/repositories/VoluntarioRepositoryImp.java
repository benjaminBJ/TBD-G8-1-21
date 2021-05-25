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
            String sql = "SELECT * " +
                    "FROM voluntario";
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

            String sql = "select * from voluntario WHERE id = :id";

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
                    "INSERT INTO voluntario (nombre, rut, email, telefono)" +
                            "values (:nombre, :rut, :email, :telefono)";
            int insertedId = (int) conn.createQuery(sql, true)
                    .addParameter("nombre", voluntario.getNombre())
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
                    "UPDATE voluntario SET nombre = :nombre, nombre = :nombre , rut = :rut , email = :email , " +
                            "telefono =:telefono WHERE id = :id";

            conn.createQuery(sql, true)
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("rut", voluntario.getRut())
                    .addParameter("email", voluntario.getEmail())
                    .addParameter("telefono", voluntario.getTelefono())
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
}
