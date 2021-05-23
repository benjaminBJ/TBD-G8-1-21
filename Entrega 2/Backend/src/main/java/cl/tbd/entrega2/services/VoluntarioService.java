package cl.tbd.entrega2.services;

import cl.tbd.entrega2.models.Voluntario;
import cl.tbd.entrega2.repositories.VoluntarioRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class VoluntarioService {
	private final VoluntarioRepository voluntarioRepository;
	VoluntarioService(VoluntarioRepository voluntarioRepository){
		this.voluntarioRepository = voluntarioRepository;
	}

	@GetMapping("/voluntarios")
	public List<Voluntario> getAllVols(){
		return voluntarioRepository.getAllVols();
	}

	@GetMapping("/voluntarios/count")
	public int countVoluntarios(){
		return voluntarioRepository.countVoluntarios();
	}

	@PostMapping("/voluntarios")
	@ResponseBody
	public Voluntario createVol(@RequestBody Voluntario vol){
		Voluntario voluntario = voluntarioRepository.createVol(vol);
		return voluntario;
	}
}