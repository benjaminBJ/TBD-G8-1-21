package cl.tbd.entrega2.repositories;
import java.util.List;
import cl.tbd.entrega2.models.Ranking;

public interface RankingRepository {
    public int countRankings();
    public List<Ranking> getAllRanks();
    public Ranking createVol(Ranking rnk);
}
