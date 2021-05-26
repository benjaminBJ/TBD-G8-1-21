package cl.tbd.entrega2.repositories;


import cl.tbd.entrega2.models.Emergencia_Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class Emergencia_HabilidadRepositoryImp implements Emergencia_HabilidadRepository {


    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Emergencia_Habilidad> getAlleme_habilidad() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from eme_habilidad")
                    .executeAndFetch(Emergencia_Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Emergencia_Habilidad getEmergencia_Habilidad(int id) {
        try(Connection conn = sql2o.open()){

            String sql = "select * from eme_habilidad WHERE id = :id";

            Emergencia_Habilidad eme_habilidad = conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Emergencia_Habilidad.class);
            return eme_habilidad;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Emergencia_Habilidad createEmergencia_Habilidad(Emergencia_Habilidad emergencia_habilidad) {
        try(Connection conn = sql2o.open()){
            String sql =
                    "INSERT INTO eme_habilidad (id_emergencia,id_habilidad) values (:id_emergencia,:id_habilidad)";

            int insertedId = (int) conn.createQuery(sql, true)
                    .addParameter("id_emergencia", emergencia_habilidad.getId_emergencia())
                    .addParameter("id_habilidad", emergencia_habilidad.getId_habilidad())
                    .executeUpdate().getKey();

            emergencia_habilidad.setId(insertedId);
            return emergencia_habilidad;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Emergencia_Habilidad upEmergencia_Habilidad(Emergencia_Habilidad emergencia_habilidad) {
        try(Connection conn = sql2o.open()){

            String sql =
                    "UPDATE eme_habilidad SET id_emergencia = :id_emergencia, id_habilidad = :id_habilidad " +
                            "WHERE id = :id";

            conn.createQuery(sql, true)
                    .addParameter("id_emergencia", emergencia_habilidad.getId_emergencia())
                    .addParameter("id_habilidad", emergencia_habilidad.getId_habilidad())
                    .addParameter("id", emergencia_habilidad.getId())
                    .executeUpdate();

            return emergencia_habilidad;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteEmergencia_Habilidad(int id) {
        try(Connection conn = sql2o.open()){

            String sql = "DELETE FROM eme_habilidad WHERE id = :id";
            conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
