package cl.tbd.entrega2.services;

import cl.tbd.entrega2.models.Tarea_Habilidad;
import cl.tbd.entrega2.repositories.Tarea_HabilidadRepository;
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
public class Tarea_HabilidadService {

    private final Tarea_HabilidadRepository tarea_habilidadRepository;
    Tarea_HabilidadService(Tarea_HabilidadRepository tarea_habilidadRepository){
        this.tarea_habilidadRepository = tarea_habilidadRepository;
    }


    @GetMapping("/ta_habilidad")
    public List<Tarea_Habilidad> getAllInstitucions() {
        return tarea_habilidadRepository.getAllTarea_Habilidad();
    }


    @GetMapping(value = "/ta_habilidad/{id}")
    public Tarea_Habilidad getInstitucion(@PathVariable int id){
        Tarea_Habilidad result = tarea_habilidadRepository.getTarea_Habilidad(id);
        return result;
    }

    @PostMapping("/ta_habilidad/create")
    @ResponseBody
    public Tarea_Habilidad createInstitucion(@RequestBody Tarea_Habilidad tarea_habilidad){
        Tarea_Habilidad result = tarea_habilidadRepository.createTarea_Habilidad(tarea_habilidad);
        return result;
    }

    @PutMapping ("/ta_habilidad/up")
    @ResponseBody
    public Tarea_Habilidad upInstitucion(@RequestBody Tarea_Habilidad tarea_habilidad){
        Tarea_Habilidad result = tarea_habilidadRepository.upTarea_Habilidad(tarea_habilidad);
        return result;
    }

    @DeleteMapping(value = "/ta_habilidad/delete/{id}")
    @ResponseBody
    public void deleteInstitucion(@PathVariable int id){
        tarea_habilidadRepository.deleteTarea_Habilidad(id);
    }

}
