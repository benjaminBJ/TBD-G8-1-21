package cl.tbd.entrega2.repositories;

import cl.tbd.entrega2.models.Emergencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmergenciaRepositoryImp implements EmergenciaRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countEmergencias() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            String sql = "SELECT COUNT(*)" +
                         "FROM emergencia";
            total = conn.createQuery(sql).executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Emergencia> getAllEmrgs() {
        try(Connection conn = sql2o.open()){
            String sql = "SELECT * " + 
                         "FROM emergencia";
            return conn.createQuery(sql)
                    .executeAndFetch(Emergencia.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Emergencia createEmrgs(Emergencia emg) {
        try(Connection conn = sql2o.open()){
            String sql = 
            "INSERT INTO emergencia (nombre, descripcion, fecha_inicio, fecha_fin, id_institucion) "+
            "values (:nombre, :descripcion, :fecha_inicio, :fecha_fin, :id_institucion )";
            int insertedId = (int) conn.createQuery(sql, true)
                    .addParameter("nombre", emg.getNombre())
                    .addParameter("descripcion", emg.getDescripcion())
                    .addParameter("fecha_inicio", emg.getFecha_fin())
                    .addParameter("fecha_fin", emg.getFecha_fin())
                    .addParameter("id_institucion", emg.getId_institucion())
                    .executeUpdate().getKey();
            emg.setId(insertedId);
            return emg;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}