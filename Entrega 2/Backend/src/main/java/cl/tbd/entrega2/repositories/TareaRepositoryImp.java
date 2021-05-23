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
    public int countTareas() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            String sql = "SELECT COUNT(*) " + 
                         "FROM tarea";             
            total = conn.createQuery(sql).executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Tarea> getAllTareas() {
        try(Connection conn = sql2o.open()){
            String sql = "SELECT * " + 
                         "FROM tarea";             
            return conn.createQuery(sql)
                    .executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Tarea createTarea(Tarea tarea) {
        try(Connection conn = sql2o.open()){
            String sql = 
            "INSERT INTO tarea (nombre, descripcion, vol_requeridos, finicio, ffin, id_emergencia, id_estado)" + 
            "values (:nombre, :descripcion, :vol_requeridos, :finicio, :ffin, :id_emergencia, :id_estado)";           
            int insertedId = (int) conn.createQuery(sql, true)
                    .addParameter("nombre", tarea.getNombre())
                    .addParameter("descripcion", tarea.getNombre())
                    .addParameter("vol_requeridos", tarea.getNombre())
                    .addParameter("finicio", tarea.getNombre())
                    .addParameter("ffin", tarea.getNombre())
                    .addParameter("id_emergencia", tarea.getNombre())
                    .addParameter("id_estado", tarea.getNombre())
                    .executeUpdate().getKey();
            tarea.setId(insertedId);
            return tarea;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
