package cl.tbd.entrega2.repositories;

import cl.tbd.entrega2.models.Institucion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class InstitucionRepositoryImp implements InstitucionRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countInstitucions() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery("SELECT COUNT(*) FROM institucion").executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Institucion> getAllInstitucions() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from institucion")
                    .executeAndFetch(Institucion.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public Institucion getInstitucion(int id) {
        try(Connection conn = sql2o.open()){

            String sql = "select * from institucion WHERE id = :id";

            Institucion institucion = conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Institucion.class);
            return institucion;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Institucion createInstitucion(Institucion institucion) {
        try(Connection conn = sql2o.open()){
            String sql =
                    "INSERT INTO institucion (nombre,descrip) values (:nombre,:descrip)";

            int insertedId = (int) conn.createQuery(sql, true)
                    .addParameter("nombre", institucion.getNombre())
                    .addParameter("descrip", institucion.getDescrip())
                    .executeUpdate().getKey();
            institucion.setId(insertedId);
            return institucion;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Institucion upInstitucion(Institucion institucion) {
        try(Connection conn = sql2o.open()){

            String sql =
                    "UPDATE institucion SET nombre = :nombre, descrip = :descrip " +
                    "WHERE id = :id";

            conn.createQuery(sql, true)
                    .addParameter("nombre", institucion.getNombre())
                    .addParameter("descrip", institucion.getDescrip())
                    .addParameter("id", institucion.getId())
                    .executeUpdate();

            return institucion;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteInstitucion(int id) {
        try(Connection conn = sql2o.open()){
            String sql = "DELETE FROM institucion WHERE id = :id";
            conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

}
