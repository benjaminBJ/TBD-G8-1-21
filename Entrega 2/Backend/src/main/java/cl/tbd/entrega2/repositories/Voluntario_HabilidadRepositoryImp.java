package cl.tbd.entrega2.repositories;

import cl.tbd.entrega2.models.Institucion;
import cl.tbd.entrega2.models.Voluntario_Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class Voluntario_HabilidadRepositoryImp implements Voluntario_HabilidadRepository{

    @Autowired
    private Sql2o sql2o;


    @Override
    public List<Voluntario_Habilidad> getAllVoluntario_Habilidad() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from vol_habilidad")
                    .executeAndFetch(Voluntario_Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Voluntario_Habilidad getVoluntario_Habilidad(int id) {
        try(Connection conn = sql2o.open()){

            String sql = "select * from vol_habilidad WHERE id = :id";

            Voluntario_Habilidad vol_habilidad = conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Voluntario_Habilidad.class);
            return vol_habilidad;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Voluntario_Habilidad createVoluntario_Habilidad(Voluntario_Habilidad voluntario_habilidad) {
        try(Connection conn = sql2o.open()){
            String sql =
                    "INSERT INTO vol_habilidad (id_voluntario,id_habilidad) values (:id_voluntario,:id_habilidad)";

            int insertedId = (int) conn.createQuery(sql, true)
                    .addParameter("id_voluntario", voluntario_habilidad.getId_voluntario())
                    .addParameter("id_habilidad", voluntario_habilidad.getId_habilidad())
                    .executeUpdate().getKey();

            voluntario_habilidad.setId(insertedId);
            return voluntario_habilidad;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Voluntario_Habilidad upVoluntario_Habilidad(Voluntario_Habilidad voluntario_habilidad) {
        try(Connection conn = sql2o.open()){

            String sql =
                    "UPDATE vol_habilidad SET id_voluntario = :id_voluntario, id_habilidad = :id_habilidad " +
                            "WHERE id = :id";

            conn.createQuery(sql, true)
                    .addParameter("id_voluntario", voluntario_habilidad.getId_voluntario())
                    .addParameter("id_habilidad", voluntario_habilidad.getId_habilidad())
                    .addParameter("id", voluntario_habilidad.getId())
                    .executeUpdate();

            return voluntario_habilidad;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteVoluntario_Habilidad(int id) {

        try(Connection conn = sql2o.open()){

            String sql = "DELETE FROM vol_habilidad WHERE id = :id";
            conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
