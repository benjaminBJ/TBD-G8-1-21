package cl.tbd.entrega2.repositories;

import java.util.List;

import cl.tbd.entrega2.models.Estado_Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


@Repository
public class EstadoTareaRepositoryImp implements EstadoTareaRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Estado_Tarea> getAllEstado_Tarea() {
        try(Connection conn = sql2o.open()){            
            return conn.createQuery("SELECT * FROM estado_tarea")
                    .executeAndFetch(Estado_Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Estado_Tarea getEstado_Tarea(int id) {
        try(Connection conn = sql2o.open()){

            String sql = "select * from estado_tarea WHERE id = :id";

            Estado_Tarea estado_tarea = conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Estado_Tarea.class);
            return estado_tarea;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Estado_Tarea createEstado_Tarea(Estado_Tarea estado_Tarea) {
        try(Connection conn = sql2o.open()){
            String sql =
            "INSERT INTO estado_tarea (descripcion) "+
                "values (:descripcion)";
            int insertedId = (int) conn.createQuery(sql, true)
                    .addParameter("descripcion", estado_Tarea.getDescripcion())
                    .executeUpdate().getKey();
            estado_Tarea.setId(insertedId);
            return estado_Tarea;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Estado_Tarea upEstado_Tarea(Estado_Tarea estado_Tarea) {
        try(Connection conn = sql2o.open()){

            String sql =
                    "UPDATE estado_Tarea SET descripcion = :descripcion" +
                            "WHERE id = :id";

            conn.createQuery(sql, true)
                    .addParameter("descripcion", estado_Tarea.getDescripcion())
                    .executeUpdate();

            return estado_Tarea;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteEstado_Tarea(int id) {
        try(Connection conn = sql2o.open()){

            String sql = "DELETE FROM estado_Tarea WHERE id = :id";
            conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
