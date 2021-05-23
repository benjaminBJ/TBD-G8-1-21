package cl.tbd.entrega2.services;

import cl.tbd.entrega2.models.Habilidad;
import cl.tbd.entrega2.repositories.HabilidadRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class HabilidadService {
	private final HabilidadRepository habilidadRepository;
	HabilidadService(HabilidadRepository habilidadRepository){
		this.habilidadRepository = habilidadRepository;
	}

	@GetMapping("/Habilidades")
	public List<Habilidad> getAllHab(){
		return habilidadRepository.getAllHab();
	}

	@GetMapping("/Habilidades/count")
	public int countHabilidades(){
		return habilidadRepository.countHabilidades();
	}

	@PostMapping("/Habilidades")
	@ResponseBody
	public Habilidad createHab(@RequestBody Habilidad hab){
		Habilidad habilidad = habilidadRepository.createHab(hab);
		return habilidad;
	}
}