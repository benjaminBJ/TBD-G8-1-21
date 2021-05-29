package cl.tbd.entrega2.services;

import cl.tbd.entrega2.models.Tarea;
import cl.tbd.entrega2.repositories.TareaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TareaService {

    private final TareaRepository tareaRepository;
    TareaService(TareaRepository tareaRepository){
        this.tareaRepository = tareaRepository;
    }

	@GetMapping("/tareas")
	public List<Tarea> getAllTarea(){
		return tareaRepository.getAllTarea();
	}

	@GetMapping(value = "/tareas/{id}")
    public Tarea getTarea(@PathVariable int id){
        Tarea result = tareaRepository.getTarea(id);
        return result;
    }

	@PostMapping("/tareas/create")
	@ResponseBody
	public Tarea createTarea(@RequestBody Tarea Tarea){
		Tarea result = tareaRepository.createTarea(Tarea);
		return result;
	}

	@PutMapping ("/tareas/up")
    @ResponseBody
    public Tarea upTarea(@RequestBody Tarea Tarea){
        Tarea result = tareaRepository.upTarea(Tarea);
        return result;
    }

    @DeleteMapping(value = "/tareas/delete/{id}")
    @ResponseBody
    public void deleteTarea(@PathVariable int id){
        tareaRepository.deleteTarea(id);
    }

    @PutMapping("/tareas/cerrar_tarea/{idt}/{idv}")
    @ResponseBody
    public void procedure1(@PathVariable int idt,@PathVariable int idv){
        tareaRepository.procedure1(idt,idv);
    }

}