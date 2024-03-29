package cl.tbd.entrega2.services;

import cl.tbd.entrega2.models.Voluntario_Tarea;
import cl.tbd.entrega2.repositories.Voluntario_TareaRepository;

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
public class Voluntario_TareaService {

	private final Voluntario_TareaRepository voluntarioTareaRepository;
	Voluntario_TareaService(Voluntario_TareaRepository voluntarioTareaRepository){
		this.voluntarioTareaRepository = voluntarioTareaRepository;
	}

	@GetMapping("/voluntarios_tarea")
	public List<Voluntario_Tarea> getAllVoluntario_Tarea(){
		return voluntarioTareaRepository.getAllVoluntario_Tarea();
	}

	@GetMapping(value = "/voluntarios_tarea/{id}")
	public Voluntario_Tarea getVoluntario_Tarea(@PathVariable int id){
		Voluntario_Tarea result = voluntarioTareaRepository.getVoluntario_Tarea(id);
		return result;
	}
	@GetMapping(value = "/voluntarios_tarea2/{id_voluntario}")
	public List<Voluntario_Tarea> getIdVoluntario_Tarea(@PathVariable int id_voluntario){
		return voluntarioTareaRepository.getIdVoluntario_Tarea(id_voluntario);
	}

	@PostMapping("/voluntarios_tarea")
	@ResponseBody
	public Voluntario_Tarea createVoluntario_Tarea(@RequestBody Voluntario_Tarea vol_tarea){
		Voluntario_Tarea voluntario_tarea = voluntarioTareaRepository.createVoluntario_Tarea(vol_tarea);
		return voluntario_tarea;
	}

	@PutMapping("/voluntarios_tarea/up")
	@ResponseBody
	public Voluntario_Tarea upVoluntario_Tarea(@RequestBody Voluntario_Tarea vol_tarea){
		Voluntario_Tarea result = voluntarioTareaRepository.upVoluntario_Tarea(vol_tarea);
		return result;
	}

	@DeleteMapping(value = "/voluntarios_tarea/delete/{id}")
	@ResponseBody
	public void deleteVoluntario_Tarea(@PathVariable int id){
		voluntarioTareaRepository.deleteVoluntario_Tarea(id);
	}


}