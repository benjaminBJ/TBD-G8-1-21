package cl.tbd.entrega2.repositories;

import cl.tbd.entrega2.models.Voluntario_Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Voluntario_TareaRepositoryImp implements Voluntario_TareaRepository {

    @Autowired
    private Sql2o sql2o;


    @Override
    public List<Voluntario_Tarea> getAllVoluntario_Tarea() {
        try(Connection conn = sql2o.open()){
            String sql = "SELECT * " +
                    "FROM vol_tarea";
            return conn.createQuery(sql)
                    .executeAndFetch(Voluntario_Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Voluntario_Tarea getVoluntario_Tarea(int id) {
        try(Connection conn = sql2o.open()){

            String sql = "select * from vol_tarea WHERE id = :id";

            Voluntario_Tarea voluntario_tarea = conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Voluntario_Tarea.class);
            return voluntario_tarea;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Prueba 
    @Override
    public List<Voluntario_Tarea> getIdVoluntario_Tarea(int id_voluntario) {
        try(Connection conn = sql2o.open()){

            String sql = "select * from vol_tarea WHERE id_voluntario = :id_voluntario";

             return conn.createQuery(sql, true)
                    .addParameter("id_voluntario", id_voluntario)
                    .executeAndFetch(Voluntario_Tarea.class);


        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Voluntario_Tarea createVoluntario_Tarea(Voluntario_Tarea voluntario_tarea) {
        try(Connection conn = sql2o.open()){
            String sql =
                    "INSERT INTO vol_tarea (flg_participa, id_estado, id_voluntario, id_tarea) " +
                            "values (:flg_participa, :id_estado, :id_voluntario, :id_tarea)";
            int insertedId = (int) conn.createQuery(sql, true)
                    .addParameter("flg_participa", voluntario_tarea.isFlg_participa())
                    .addParameter("id_estado", voluntario_tarea.getId_estado())
                    .addParameter("id_voluntario", voluntario_tarea.getId_voluntario())
                    .addParameter("id_tarea", voluntario_tarea.getId_tarea())
                    .executeUpdate().getKey();

            voluntario_tarea.setId(insertedId);
            return voluntario_tarea;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Voluntario_Tarea upVoluntario_Tarea(Voluntario_Tarea voluntario_tarea) {
        try(Connection conn = sql2o.open()){

            String sql =
                    "UPDATE vol_tarea SET id_voluntario = :id_voluntario, " +
                            "id_tarea = :id_tarea, id_estado = :id_estado, flg_participa =:flg_participa " +
                            "WHERE id = :id";

            conn.createQuery(sql, true)
                    .addParameter("flg_participa", voluntario_tarea.isFlg_participa())
                    .addParameter("id_estado", voluntario_tarea.getId_estado())
                    .addParameter("id_voluntario", voluntario_tarea.getId_voluntario())
                    .addParameter("id_tarea", voluntario_tarea.getId_tarea())
                    .addParameter("id", voluntario_tarea.getId())
                    .executeUpdate();

            return voluntario_tarea;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteVoluntario_Tarea(int id) {

        try(Connection conn = sql2o.open()){
            String sql = "DELETE FROM voluntario_tarea WHERE id = :id";
            conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
