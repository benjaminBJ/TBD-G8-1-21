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
            total = conn.createQuery("SELECT COUNT(*) FROM ranking").executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Ranking> getAllRanks() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from ranking")
                    .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Ranking createVol(Ranking rnk) {
        try(Connection conn = sql2o.open()){
            int insertedId = (int) conn.createQuery("INSERT INTO ranking (puntaje) values (:rnkPuntaje)", true)
                    .addParameter("rnkPuntaje", rnk.getPuntaje())
                    .executeUpdate().getKey();
            rnk.setId(insertedId);
            return rnk;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
