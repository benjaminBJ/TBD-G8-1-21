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
            total = conn.createQuery("SELECT COUNT(*) FROM voluntario_tarea").executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Voluntario_Tarea> getAllVolTareas() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from voluntario_tarea")
                    .executeAndFetch(Voluntario_Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Voluntario_Tarea createVol(Voluntario_Tarea volTarea) {
        try(Connection conn = sql2o.open()){
            int insertedId = (int) conn.createQuery("INSERT INTO voluntario_tarea (nombre) values (:volTareaName)", true)
                    .addParameter("volTareaName", volTarea.getNombre())
                    .executeUpdate().getKey();
            volTarea.setId(insertedId);
            return volTarea;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
