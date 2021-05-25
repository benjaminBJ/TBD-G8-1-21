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
    public Emergencia getEmrg(int id){
        try(Connection conn = sql2o.open()){

            String sql = "select * from emergencia WHERE id = :id";

            Emergencia emg = conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Emergencia.class);
            System.out.println(emg);
            return emg;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Emergencia createEmrg(Emergencia emg) {
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

    @Override
    public Emergencia upEmrg(Emergencia emg){
        try(Connection conn = sql2o.open()){

            String sql = "UPDATE emergencia SET" + 
                         "nombre = :nombre " +
                         "descripcion = :descripcion" +
                         "fecha_inicio = :fecha_inicio" +
                         "fecha_fin = :fecha_fin" +
                         "id_institucion= :id_institucion" +
                         "WHERE id = :id";

            conn.createQuery(sql, true)
                    .addParameter("nombre", emg.getNombre())
                    .addParameter("id", emg.getId())
                    .executeUpdate();

            return emg;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteEmrg(int id) {
        try(Connection conn = sql2o.open()){
            String sql = "DELETE FROM emergencia WHERE id = :id";
            conn.createQuery(sql, true)
                   .addParameter("id", id)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}