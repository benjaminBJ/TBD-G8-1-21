package cl.grupo8.entrega3.controllers;

import cl.grupo8.entrega3.models.EmergenciaModel;
import cl.grupo8.entrega3.models.VoluntarioHabilidadModel;
import cl.grupo8.entrega3.services.VoluntarioHabilidadService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/volHabilidad")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class VoluntarioHabilidadController {

    @Autowired
    VoluntarioHabilidadService voluntarioHabilidadService;

    @GetMapping
    @ResponseBody
    public List<VoluntarioHabilidadModel> getAllVolH(){
        return voluntarioHabilidadService.getAllVolH();
    }

    @PostMapping()
    @ResponseBody
    public VoluntarioHabilidadModel saveVolH(@RequestBody VoluntarioHabilidadModel volhabilidad){
        return  this.voluntarioHabilidadService.saveVolH(volhabilidad);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public VoluntarioHabilidadModel getVolH(@PathVariable String id){
        VoluntarioHabilidadModel result = this.voluntarioHabilidadService.getVolH(id);
        return result;
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseBody
    public void deleteVolH(@PathVariable String id){
        this.voluntarioHabilidadService.deleteVolH(id);
    }

}
