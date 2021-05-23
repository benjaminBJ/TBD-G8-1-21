package cl.tbd.entrega2.services;

import cl.tbd.entrega2.models.Ranking;
import cl.tbd.entrega2.repositories.RankingRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class RankingService {
	private final RankingRepository rankingRepository;
	RankingService(RankingRepository rankingRepository){
		this.rankingRepository = rankingRepository;
	}

	@GetMapping("/rankings")
	public List<Ranking> getAllRanks(){
		return rankingRepository.getAllRanks();
	}

	@GetMapping("/rankings/count")
	public int countRankings(){
		return rankingRepository.countRankings();
	}

	@PostMapping("/rankings")
	@ResponseBody
	public Ranking createRanking(@RequestBody Ranking rank){
		Ranking ranking = rankingRepository.createRanking(rank);
		return ranking;
	}
}