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
            String sql = "SELECT COUNT(*)" +
                         "FROM habilidad";            
            total = conn.createQuery(sql).executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Habilidad> getAllHab() {
        try(Connection conn = sql2o.open()){
            String sql = "SELECT * " + 
                         "FROM habilidad";
            return conn.createQuery(sql)
                    .executeAndFetch(Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Habilidad createHab(Habilidad est) {
        try(Connection conn = sql2o.open()){
            String sql = 
            "INSERT INTO habilidad (descripcion)" +
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
