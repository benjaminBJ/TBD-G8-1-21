package cl.tbd.entrega2.services;

import cl.tbd.entrega2.models.Estado_Tarea;
import cl.tbd.entrega2.repositories.EstadoTareaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class EstadoTareaService {

    private final EstadoTareaRepository estadoTareaRepository;
    EstadoTareaService(EstadoTareaRepository estadoTareaRepository){
        this.estadoTareaRepository = estadoTareaRepository;
    }

    @GetMapping("/estado_tareas")
    public List<Estado_Tarea> getAllEstado_Tarea() {
        return estadoTareaRepository.getAllEstado_Tarea();
    }


    @GetMapping(value = "/estado_tareas/{id}")
    public Estado_Tarea getEstado_Tarea(@PathVariable int id){
        Estado_Tarea result = estadoTareaRepository.getEstado_Tarea(id);
        return result;
    }

    @PostMapping("/estado_tareas/create")
    @ResponseBody
    public Estado_Tarea createEstado_Tarea(@RequestBody Estado_Tarea emergencia){
        Estado_Tarea result = estadoTareaRepository.createEstado_Tarea(emergencia);
        return result;
    }

    @PutMapping ("/estado_tareas/up")
    @ResponseBody
    public Estado_Tarea upEstado_Tarea(@RequestBody Estado_Tarea emergencia){
        Estado_Tarea result = estadoTareaRepository.upEstado_Tarea(emergencia);
        return result;
    }

    @DeleteMapping(value = "/estado_tareas/delete/{id}")
    @ResponseBody
    public void deleteEstado_Tarea(@PathVariable int id){
        estadoTareaRepository.deleteEstado_Tarea(id);
    }
}
