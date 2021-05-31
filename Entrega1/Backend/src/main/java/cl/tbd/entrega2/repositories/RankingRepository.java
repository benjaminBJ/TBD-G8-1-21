package cl.tbd.entrega2.repositories;
import java.util.List;
import cl.tbd.entrega2.models.Ranking;

public interface RankingRepository {
    public List<Ranking> getAllRanking();
    public Ranking getRanking(int id);    
    public Ranking createRanking(Ranking ranking);
    public Ranking upRanking(Ranking ranking);
    public void deleteRanking(int id);
}
