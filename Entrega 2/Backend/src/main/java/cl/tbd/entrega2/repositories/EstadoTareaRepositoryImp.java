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
    public int countEstado_Tareas() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            String sql = "SELECT COUNT(*)" +
                         "FROM estado_tarea";
            total = conn.createQuery(sql).executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Estado_Tarea> getAllEst() {
        try(Connection conn = sql2o.open()){
            String sql = "SELECT * " + 
                         "FROM estado_tarea";            
            return conn.createQuery(sql)
                    .executeAndFetch(Estado_Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Estado_Tarea createEst(Estado_Tarea est) {
        try(Connection conn = sql2o.open()){
            String sql =
            "INSERT INTO estado_tarea (descripcion) "+
            "values (:descripcion)";
            int insertedId = (int) conn.createQuery(sql, true)
                    .addParameter("descripcion", est.getDescripcion())
                    .executeUpdate().getKey();
            est.setId(insertedId);
            return est;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
