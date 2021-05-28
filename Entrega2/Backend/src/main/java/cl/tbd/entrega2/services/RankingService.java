package cl.tbd.entrega2.services;

import cl.tbd.entrega2.models.Ranking;
import cl.tbd.entrega2.repositories.RankingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RankingService {
	private final RankingRepository rankingRepository;
	RankingService(RankingRepository rankingRepository){
		this.rankingRepository = rankingRepository;
	}

	@GetMapping("/rankings")
	public List<Ranking> getAllRanking(){
		return rankingRepository.getAllRanking();
	}

	@GetMapping(value = "/rankings/{id}")
    public Ranking getRanking(@PathVariable int id){
        Ranking result = rankingRepository.getRanking(id);
        return result;
    }

	@PostMapping("/rankings/create")
	@ResponseBody
	public Ranking createRanking(@RequestBody Ranking ranking){
		Ranking result = rankingRepository.createRanking(ranking);
		return result;
	}

	@PutMapping ("/rankings/up")
    @ResponseBody
    public Ranking upRanking(@RequestBody Ranking ranking){
        Ranking result = rankingRepository.upRanking(ranking);
        return result;
    }

    @DeleteMapping(value = "/rankings/delete/{id}")
    @ResponseBody
    public void deleteRanking(@PathVariable int id){
        rankingRepository.deleteRanking(id);
    }
}