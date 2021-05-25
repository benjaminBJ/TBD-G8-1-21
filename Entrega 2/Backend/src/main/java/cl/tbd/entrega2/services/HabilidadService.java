package cl.tbd.entrega2.services;

import cl.tbd.entrega2.models.Habilidad;
import cl.tbd.entrega2.repositories.HabilidadRepository;

import cl.tbd.entrega2.repositories.InstitucionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class HabilidadService {

	private final HabilidadRepository habilidadRepository;
	HabilidadService(HabilidadRepository habilidadRepository){
		this.habilidadRepository = habilidadRepository;
	}


	@GetMapping("/habilidades")
	public List<Habilidad> getAllHabilidads() {
		return habilidadRepository.getAllHabilidads();
	}


	@GetMapping(value = "/habilidades/{id}")
	public Habilidad getHabilidad(@PathVariable int id){
		Habilidad result = habilidadRepository.getHabilidad(id);
		return result;
	}

	@PostMapping("/habilidades/create")
	@ResponseBody
	public Habilidad createHabilidad(@RequestBody Habilidad institucion){
		Habilidad result = habilidadRepository.createHabilidad(institucion);
		return result;
	}

	@PutMapping ("/habilidades/up")
	@ResponseBody
	public Habilidad upHabilidad(@RequestBody Habilidad institucion){
		Habilidad result = habilidadRepository.upHabilidad(institucion);
		return result;
	}

	@DeleteMapping(value = "/habilidades/delete/{id}")
	@ResponseBody
	public void deleteHabilidad(@PathVariable int id){
		habilidadRepository.deleteHabilidad(id);
	}
}