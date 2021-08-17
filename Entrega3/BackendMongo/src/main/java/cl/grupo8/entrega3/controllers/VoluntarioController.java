package cl.grupo8.entrega3.controllers;


import cl.grupo8.entrega3.models.VoluntarioModel;
import cl.grupo8.entrega3.services.VoluntarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/voluntario")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class VoluntarioController {

    @Autowired
    VoluntarioService voluntarioService;

    @GetMapping
    @ResponseBody
    public List<VoluntarioModel> getAllVoluntarios(){
        return voluntarioService.getAllVoluntarios();
    }

    @PostMapping()
    @ResponseBody
    public VoluntarioModel saveVoluntario(@RequestBody VoluntarioModel voluntario){
        return  this.voluntarioService.saveVoluntario(voluntario);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public VoluntarioModel getVoluntario(@PathVariable String id){
        VoluntarioModel result = this.voluntarioService.getVoluntario(id);
        return result;
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseBody
    public void deleteVoluntario(@PathVariable String id){
        this.voluntarioService.deleteVoluntario(id);
    }

}
