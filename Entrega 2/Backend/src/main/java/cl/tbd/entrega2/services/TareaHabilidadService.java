package cl.tbd.entrega2.services;

import cl.tbd.entrega2.models.Tarea_Habilidad;
import cl.tbd.entrega2.repositories.TareaHabilidadRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class TareaHabilidadService {
	private final TareaHabilidadRepository tareaHabilidadRepository;
	TareaHabilidadService(TareaHabilidadRepository tareaHabilidadRepository){
		this.tareaHabilidadRepository = tareaHabilidadRepository;
	}

	@GetMapping("/Tarea_habilidad")
	public List<Tarea_Habilidad> getAllTareaHab(){
		return tareaHabilidadRepository.getAllTareaHab();
	}

	@GetMapping("/Tarea_habilidad/count")
	public int countTareaHabilidad(){
		return tareaHabilidadRepository.countTareaHabilidad();
	}

	@PostMapping("/Tarea_habilidad")
	@ResponseBody
	public Tarea_Habilidad createTareaHab(@RequestBody Tarea_Habilidad th){
		Tarea_Habilidad tareaHabilidad = tareaHabilidadRepository.createTareaHab(th);
		return tareaHabilidad;
	}
}