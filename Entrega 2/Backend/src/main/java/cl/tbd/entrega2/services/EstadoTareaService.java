package cl.tbd.entrega2.services;

import cl.tbd.entrega2.models.Estado_Tarea;
import cl.tbd.entrega2.repositories.EstadoTareaRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class EstadoTareaService {
	private final EstadoTareaRepository estadoTareaRepository;
	EstadoTareaService(EstadoTareaRepository estadoTareaRepository){
		this.estadoTareaRepository = estadoTareaRepository;
	}

	@GetMapping("/estados_tarea")
	public List<Estado_Tarea> getAllEst(){
		return estadoTareaRepository.getAllEst();
	}

	@GetMapping("/estados_tarea/count")
	public int countEstado_Tareas(){
		return estadoTareaRepository.countEstado_Tareas();
	}

	@PostMapping("/estados_tarea")
	@ResponseBody
	public Estado_Tarea createEst(@RequestBody Estado_Tarea est){
		Estado_Tarea estado_Tarea = estadoTareaRepository.createEst(est);
		return estado_Tarea;
	}
}