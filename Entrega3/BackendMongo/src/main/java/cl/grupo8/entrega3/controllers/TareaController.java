package cl.grupo8.entrega3.controllers;


import cl.grupo8.entrega3.models.TareaModel;
import cl.grupo8.entrega3.services.TareaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarea")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class TareaController {

    @Autowired
    TareaService tareaService;

    @GetMapping
    @ResponseBody
    public List<TareaModel> getAllTareas(){
        return tareaService.getAllTareas();
    }

    @PostMapping()
    @ResponseBody
    public TareaModel saveTarea(@RequestBody TareaModel tarea){
        return  this.tareaService.saveTarea(tarea);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public TareaModel getTarea(@PathVariable String id){
        TareaModel result = this.tareaService.getTarea(id);
        return result;
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseBody
    public void deleteTarea(@PathVariable String id){
        this.tareaService.deleteTarea(id);
    }



}
