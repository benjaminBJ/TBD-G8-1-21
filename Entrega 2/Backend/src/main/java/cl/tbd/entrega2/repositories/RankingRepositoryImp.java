package cl.tbd.entrega2.repositories;

import cl.tbd.entrega2.models.Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class RankingRepositoryImp implements RankingRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Ranking> getAllRanking() {
        try(Connection conn = sql2o.open()){
            String sql = "SELECT * " + 
                         "FROM ranking";            
            return conn.createQuery(sql)
                    .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    @Override
    public Ranking getRanking(int id) {
        try(Connection conn = sql2o.open()){

            String sql = "select * from ranking WHERE id = :id";

            Ranking Ranking = conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Ranking.class);
            return Ranking;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }    

    @Override
    public Ranking createRanking(Ranking rnk) {
        try(Connection conn = sql2o.open()){
            String sql =
                    "INSERT INTO ranking (puntaje, flg_participa, flg_invitado, id_voluntario, id_tarea)" +
                        "values (:Puntaje,:flg_participa,:flg_invitado,:id_voluntario,:id_tarea)";            
            int insertedId = (int) conn.createQuery(sql, true)
                    .addParameter("puntaje", rnk.getPuntaje())
                    .addParameter("flg_participa", rnk.getFlg_participa())
                    .addParameter("flg_invitado", rnk.getFlg_invitado())
                    .addParameter("id_voluntario", rnk.getId_voluntario())
                    .addParameter("id_tarea", rnk.getId_tarea())
                    .executeUpdate().getKey();
            rnk.setId(insertedId);
            return rnk;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Ranking upRanking(Ranking Ranking) {
        try(Connection conn = sql2o.open()){

            String sql =
                    "UPDATE ranking SET Puntaje = :puntaje, flg_participa = :flg_participa, flg_invitado = :flg_invitado, " +
                            "id_voluntario = :id_voluntario, id_tarea =: id_tarea WHERE id = :id";

            conn.createQuery(sql, true)
                    .addParameter("Puntaje", Ranking.getPuntaje())
                    .addParameter("flg_participa", Ranking.getFlg_participa())
                    .addParameter("flg_invitado", Ranking.getFlg_invitado())
                    .addParameter("id_voluntario", Ranking.getId_voluntario())
                    .addParameter("id_tarea", Ranking.getId_tarea())
                    .executeUpdate();

            return Ranking;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteRanking(int id) {
        try(Connection conn = sql2o.open()){

            String sql = "DELETE FROM ranking WHERE id = :id";
            conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }    
    
}
