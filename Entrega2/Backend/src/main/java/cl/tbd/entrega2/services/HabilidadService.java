package cl.tbd.entrega2.services;

import cl.tbd.entrega2.models.Habilidad;
import cl.tbd.entrega2.models.HabilidadCount;
import cl.tbd.entrega2.repositories.HabilidadRepository;

import org.springframework.web.bind.annotation.*;
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
	public Habilidad createHabilidad(@RequestBody Habilidad habilidad){
		Habilidad result = habilidadRepository.createHabilidad(habilidad);
		return result;
	}

	@PutMapping ("/habilidades/up")
	@ResponseBody
	public Habilidad upHabilidad(@RequestBody Habilidad habilidad){
		Habilidad result = habilidadRepository.upHabilidad(habilidad);
		return result;
	}

	@DeleteMapping(value = "/habilidades/delete/{id}")
	@ResponseBody
	public void deleteHabilidad(@PathVariable int id){
		habilidadRepository.deleteHabilidad(id);
	}



	@GetMapping("/habilidades/{id}/{n}")
	@ResponseBody
	//Entrada id de Emergencia x N de habilidades mas requeridas para esta emergencia
	public List<HabilidadCount> countHabilidadEmergencia(@PathVariable int id, @PathVariable int n){
		return habilidadRepository.countHabilidadEmergencia(id,n);
	}

}