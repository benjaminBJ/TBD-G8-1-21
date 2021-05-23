package cl.tbd.entrega2.repositories;

import cl.tbd.entrega2.models.Voluntario_Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VoluntarioTareaRepositoryImp implements VoluntarioTareaRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countVoluntariosTareas() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            String sql = "SELECT COUNT(*)" +
                         "FROM voluntario_tarea";            
            total = conn.createQuery(sql).executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Voluntario_Tarea> getAllVolTareas() {
        try(Connection conn = sql2o.open()){
            String sql = "SELECT * " + 
                         "FROM voluntario_tarea";            
            return conn.createQuery(sql)
                    .executeAndFetch(Voluntario_Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Voluntario_Tarea createVolTarea(Voluntario_Tarea volTarea) {
        try(Connection conn = sql2o.open()){
            String sql =
            "INSERT INTO voluntario_tarea (nombre, rut, id_voluntario, id_tarea) " +
            "values (:nombre, :rut, :id_voluntario, :id_tarea)";             
            int insertedId = (int) conn.createQuery(sql, true)
                    .addParameter("nombre", volTarea.getNombre())
                    .addParameter("rut", volTarea.getRut())
                    .addParameter("id_voluntario", volTarea.getId_voluntario())
                    .addParameter("id_tarea", volTarea.getId_tarea())
                    .executeUpdate().getKey();
            volTarea.setId(insertedId);
            return volTarea;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
