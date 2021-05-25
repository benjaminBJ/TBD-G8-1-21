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
    public int countRankings() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            String sql = "SELECT COUNT(*) " + 
                         "FROM ranking";            
            total = conn.createQuery(sql).executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Ranking> getAllRanks() {
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
    public Ranking createRanking(Ranking rnk) {
        try(Connection conn = sql2o.open()){
            String sql =
            "INSERT INTO ranking (Puntaje, flg_participa, flg_invitado, id_voluntario, id_tarea)" +
            "values (:Puntaje,:flg_participa,:flg_invitado,:id_voluntario,:id_tarea)";            
            int insertedId = (int) conn.createQuery(sql, true)
                    .addParameter("Puntaje", rnk.getPuntaje())
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
    
}
