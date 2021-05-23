package cl.tbd.entrega2.repositories;

import java.util.List;

import cl.tbd.entrega2.models.Tarea_Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


@Repository
public class TareaHabilidadRepositoryImp implements TareaHabilidadRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countTareaHabilidad() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery("SELECT COUNT(*) FROM tarea_habilidad").executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Tarea_Habilidad> getAllTareaHab() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from tarea_habilidad")
                    .executeAndFetch(Tarea_Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Tarea_Habilidad createTareaHab(Tarea_Habilidad est) {
        try(Connection conn = sql2o.open()){
            int insertedId = (int) conn.createQuery("INSERT INTO tarea_habilidad (id) values (:primaryKey)", true)
                    .addParameter("primaryKey", est.getId())
                    .executeUpdate().getKey();
            est.setId(insertedId);
            return est;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
