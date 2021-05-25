package cl.tbd.entrega2.services;

import cl.tbd.entrega2.models.Voluntario_Tarea;
import cl.tbd.entrega2.repositories.Voluntario_TareaRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class VoluntarioTareaService {
	private final Voluntario_TareaRepository voluntarioTareaRepository;
	VoluntarioTareaService(Voluntario_TareaRepository voluntarioTareaRepository){
		this.voluntarioTareaRepository = voluntarioTareaRepository;
	}

	@GetMapping("/voluntarios_tarea")
	public List<Voluntario_Tarea> getAllVolTareas(){
		return voluntarioTareaRepository.getAllVolTareas();
	}

	@GetMapping("/voluntarios_tarea/count")
	public int countVoluntariosTareas(){
		return voluntarioTareaRepository.countVoluntariosTareas();
	}

	@PostMapping("/voluntarios_tarea")
	@ResponseBody
	public Voluntario_Tarea createVolTarea(@RequestBody Voluntario_Tarea vol_tarea){
		Voluntario_Tarea voluntario_tarea = voluntarioTareaRepository.createVolTarea(vol_tarea);
		return voluntario_tarea;
	}
}