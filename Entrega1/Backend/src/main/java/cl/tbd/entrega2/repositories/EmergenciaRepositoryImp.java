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
    public List<Emergencia> getAllEmergencias() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from emergencia")
                    .executeAndFetch(Emergencia.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Emergencia getEmergencia(int id) {
        try(Connection conn = sql2o.open()){

            String sql = "select * from emergencia WHERE id = :id";

            Emergencia emergencia = conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Emergencia.class);
            return emergencia;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Emergencia createEmergencia(Emergencia emergencia) {
        try(Connection conn = sql2o.open()){
            String sql =
                    "INSERT INTO emergencia (nombre,descrip,finicio,ffin,id_institucion) " +
                            "values (:nombre,:descrip,:finicio,:ffin,:id_institucion)";

            int insertedId = (int) conn.createQuery(sql, true)
                    .addParameter("nombre", emergencia.getNombre())
                    .addParameter("descrip", emergencia.getDescrip())
                    .addParameter("finicio", emergencia.getFinicio())
                    .addParameter("ffin", emergencia.getFfin())
                    .addParameter("id_institucion", emergencia.getId_institucion())
                    .executeUpdate().getKey();

            emergencia.setId(insertedId);
            return emergencia;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Emergencia upEmergencia(Emergencia emergencia) {
        try(Connection conn = sql2o.open()){

            String sql =
                    "UPDATE emergencia SET nombre = :nombre, descrip = :descrip, finicio = :finicio, " +
                            "ffin =:ffin, id_institucion =:id_institucion WHERE id = :id";

            conn.createQuery(sql, true)
                    .addParameter("nombre", emergencia.getNombre())
                    .addParameter("descrip", emergencia.getDescrip())
                    .addParameter("finicio", emergencia.getFinicio())
                    .addParameter("ffin", emergencia.getFfin())
                    .addParameter("id_institucion", emergencia.getId_institucion())
                    .addParameter("id", emergencia.getId())
                    .executeUpdate();

            return emergencia;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteEmergencia(int id) {
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