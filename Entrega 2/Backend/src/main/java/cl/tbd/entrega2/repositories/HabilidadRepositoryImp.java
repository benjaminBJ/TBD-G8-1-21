package cl.tbd.entrega2.repositories;

import java.util.List;

import cl.tbd.entrega2.models.Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


@Repository
public class HabilidadRepositoryImp implements HabilidadRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countHabilidades() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery("SELECT COUNT(*) FROM habilidad").executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Habilidad> getAllEst() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from habilidad")
                    .executeAndFetch(Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Habilidad createVol(Habilidad est) {
        try(Connection conn = sql2o.open()){
            int insertedId = (int) conn.createQuery("INSERT INTO habilidad (descripcion) values (:estadoDesc)", true)
                    .addParameter("estadoDesc", est.getDescripcion())
                    .executeUpdate().getKey();
            est.setId(insertedId);
            return est;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
