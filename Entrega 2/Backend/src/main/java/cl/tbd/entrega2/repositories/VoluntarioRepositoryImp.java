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
    public int countVoluntarios() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery("SELECT COUNT(*) FROM voluntario").executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Voluntario> getAllVols() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from voluntario")
                    .executeAndFetch(Voluntario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Voluntario createVol(Voluntario vol) {
        try(Connection conn = sql2o.open()){
            int insertedId = (int) conn.createQuery("INSERT INTO voluntario (nombre) values (:voluntarioName)", true)
                    .addParameter("voluntarioName", vol.getNombre())
                    .executeUpdate().getKey();
            vol.setId(insertedId);
            return vol;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
