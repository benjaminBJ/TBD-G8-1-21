package cl.tbd.entrega3.services;

import cl.tbd.entrega3.models.Voluntario;
import cl.tbd.entrega3.repositories.VoluntarioRepository;
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
public class VoluntarioService {

	private final VoluntarioRepository voluntarioRepository;
	VoluntarioService(VoluntarioRepository voluntarioRepository){
		this.voluntarioRepository = voluntarioRepository;
	}

	@GetMapping("/voluntario")
	public List<Voluntario> getAllVoluntarios() {
		return voluntarioRepository.getAllVoluntarios();
	}

	@GetMapping("/voluntario/count")
    public int countVoluntarios(){
        int total = voluntarioRepository.countVoluntarios();
        return total;
    }

	@GetMapping(value = "/voluntario/{id}")
	public Voluntario getVoluntario(@PathVariable int id){
		Voluntario result = voluntarioRepository.getVoluntario(id);
		return result;
	}

	@GetMapping(value = "/voluntario/get")
	@ResponseBody
	public Voluntario getVoluntarioNombre(@RequestBody String nombre){
		Voluntario result = voluntarioRepository.getVoluntarioNombre(nombre);
		return result;
	}

	@GetMapping(value = "/voluntario/habilidades")
	@ResponseBody
	public String habilidadesVoluntario(@RequestBody String nombre){
		String result = voluntarioRepository.habilidadesVoluntario(nombre);
		return result;
	}

	@PostMapping("/voluntario/create")
	@ResponseBody
	public Voluntario createVoluntario(@RequestBody Voluntario voluntario){
		Voluntario result = voluntarioRepository.createVoluntario(voluntario);
		return result;
	}

	@PutMapping ("/voluntario/up")
	@ResponseBody
	public Voluntario upVoluntario(@RequestBody Voluntario voluntario){
		Voluntario result = voluntarioRepository.upVoluntario(voluntario);
		return result;
	}

	@DeleteMapping(value = "/voluntario/delete/{id}")
	@ResponseBody
	public void deleteVoluntario(@PathVariable int id){
		voluntarioRepository.deleteVoluntario(id);
	}

	

}