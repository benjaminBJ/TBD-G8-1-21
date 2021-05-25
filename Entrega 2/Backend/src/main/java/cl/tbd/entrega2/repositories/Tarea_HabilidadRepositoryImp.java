package cl.tbd.entrega2.repositories;

import cl.tbd.entrega2.models.Institucion;
import cl.tbd.entrega2.models.Tarea_Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class Tarea_HabilidadRepositoryImp implements Tarea_HabilidadRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Tarea_Habilidad> getAllTarea_Habilidad() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from tarea_habilidad")
                    .executeAndFetch(Tarea_Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Tarea_Habilidad getTarea_Habilidad(int id) {
        try(Connection conn = sql2o.open()){

            String sql = "select * from tarea_habilidad WHERE id = :id";

            Tarea_Habilidad tarea_habilidad = conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Tarea_Habilidad.class);
            return tarea_habilidad;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Tarea_Habilidad createTarea_Habilidad(Tarea_Habilidad tarea_habilidad) {
        try(Connection conn = sql2o.open()){
            String sql =
                    "INSERT INTO tarea_habilidad (id_tarea,id_habilidad) values (:id_tarea,:id_habilidad)";

            int insertedId = (int) conn.createQuery(sql, true)
                    .addParameter("id_tarea", tarea_habilidad.getId_tarea())
                    .addParameter("id_habilidad", tarea_habilidad.getId_habilidad())
                    .executeUpdate().getKey();

            tarea_habilidad.setId(insertedId);
            return tarea_habilidad;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Tarea_Habilidad upTarea_Habilidad(Tarea_Habilidad tarea_habilidad) {
        try(Connection conn = sql2o.open()){

            String sql =
                    "UPDATE tarea_habilidad SET id_tarea = :id_tarea, id_habilidad = :id_habilidad " +
                            "WHERE id = :id";

            conn.createQuery(sql, true)
                    .addParameter("id_tarea", tarea_habilidad.getId_tarea())
                    .addParameter("id_habilidad", tarea_habilidad.getId_habilidad())
                    .executeUpdate();

            return tarea_habilidad;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteTarea_Habilidad(int id) {

        try(Connection conn = sql2o.open()){

            String sql = "DELETE FROM tarea_habilidad WHERE id = :id";
            conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeUpdate();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
