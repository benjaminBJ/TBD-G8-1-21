package cl.tbd.entrega2.repositories;

import java.util.List;

import cl.tbd.entrega2.models.Habilidad;
import cl.tbd.entrega2.models.HabilidadCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


@Repository
public class HabilidadRepositoryImp implements HabilidadRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countHabilidads() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            String sql = "SELECT COUNT(*)" +
                         "FROM habilidad";            
            total = conn.createQuery(sql).executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Habilidad> getAllHabilidads() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from habilidad")
                    .executeAndFetch(Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Habilidad getHabilidad(int id) {
        try(Connection conn = sql2o.open()){

            String sql = "select * from habilidad WHERE id = :id";

            Habilidad habilidad = conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Habilidad.class);
            return habilidad;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Habilidad createHabilidad(Habilidad habilidad) {
        try(Connection conn = sql2o.open()){
            String sql =
                    "INSERT INTO habilidad (descrip) values (:descrip)";

            int insertedId = (int) conn.createQuery(sql, true)
                    .addParameter("descrip", habilidad.getDescrip())
                    .executeUpdate().getKey();

            habilidad.setId(insertedId);
            return habilidad;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Habilidad upHabilidad(Habilidad habilidad) {
        try(Connection conn = sql2o.open()){

            String sql =
                    "UPDATE habilidad SET descrip = :descrip " +
                            "WHERE id = :id";

            conn.createQuery(sql, true)
                    .addParameter("descrip", habilidad.getDescrip())
                    .addParameter("id", habilidad.getId())
                    .executeUpdate();

            return habilidad;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteHabilidad(int id) {

        try(Connection conn = sql2o.open()){
            String sql = "DELETE FROM habilidad WHERE id = :id";
            conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<HabilidadCount> countHabilidadEmergencia(int id, int n){

        try(Connection conn = sql2o.open()){
            String sql = "SELECT h.id, h.descrip, COUNT(h.id) AS cant_tareas"+
                        " FROM habilidad AS h, tarea AS t, tarea_habilidad AS th"+
                        " WHERE t.id_emergencia = :id AND t.id = th.id_tarea AND h.id = th.id_habilidad"+
                        " GROUP BY h.id"+
                        " ORDER BY cant_tareas DESC"+
                        " LIMIT :n";
            List<HabilidadCount> result = conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .addParameter("n", n)
                    .executeAndFetch(HabilidadCount.class);
            return result;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }


}
