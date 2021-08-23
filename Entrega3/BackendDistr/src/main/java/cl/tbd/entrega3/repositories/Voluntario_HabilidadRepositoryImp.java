package cl.tbd.entrega3.repositories;

import cl.tbd.entrega3.models.Voluntario_Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;
import java.util.Random;

@Repository
public class Voluntario_HabilidadRepositoryImp implements Voluntario_HabilidadRepository{

    @Autowired
    private Sql2o sql2o;

    //Funcion hash que en este caso lo realizara por id de voluntario
    private Integer hashFunction(Integer id){
        return id % 3;
    }

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
    public void createVoluntario_Habilidad(int id_voluntario, String tabla_voluntario) {
        try(Connection conn = sql2o.open()){

            Voluntario_Habilidad voluntario_habilidad = new Voluntario_Habilidad();
            Integer index = hashFunction(id_voluntario);
            String tabla = "vol_habilidad"+index;

            String sql =
                    "INSERT INTO "+tabla +" (id_voluntario,tabla_voluntario,id_habilidad,tabla) values (:id_voluntario,:tabla_voluntario,:id_habilidad,:tabla)";

            String sql2 = "SELECT COUNT(*) FROM habilidad ";

            Integer habilidades = conn.createQuery(sql2, true).executeScalar(Integer.class);

            Random rand = new Random();
            int indexh = rand.nextInt(habilidades+1);
            int insertedId = (int) conn.createQuery(sql, true)

                    .addParameter("id_voluntario", id_voluntario)
                    .addParameter("tabla_voluntario", tabla_voluntario)
                    .addParameter("id_habilidad", indexh)
                    .addParameter("tabla",tabla)
                    .executeUpdate().getKey();

            voluntario_habilidad.setId(insertedId);

        }catch(Exception e){
            System.out.println(e.getMessage());
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
