package cl.tbd.entrega2.services;

import cl.tbd.entrega2.models.Tarea;
import cl.tbd.entrega2.repositories.TareaRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class TareaService {
	private final TareaRepository tareaRepository;
	TareaService(TareaRepository tareaRepository){
		this.tareaRepository = tareaRepository;
	}

	@GetMapping("/tareas")
	public List<Tarea> getAllTareas(){
		return tareaRepository.getAllTareas();
	}

	@GetMapping("/tareas/count")
	public int countTareas(){
		return tareaRepository.countTareas();
	}

	@PostMapping("/tareas")
	@ResponseBody
	public Tarea createTarea(@RequestBody Tarea t){
		Tarea tarea = tareaRepository.createTarea(t);
		return tarea;
	}

}