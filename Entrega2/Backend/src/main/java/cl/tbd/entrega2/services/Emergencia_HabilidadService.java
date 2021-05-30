package cl.tbd.entrega2.services;

import cl.tbd.entrega2.models.Emergencia_Habilidad;

import cl.tbd.entrega2.repositories.Emergencia_HabilidadRepository;
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
public class Emergencia_HabilidadService {

    private final Emergencia_HabilidadRepository emergencia_habilidadRepository;
    Emergencia_HabilidadService(Emergencia_HabilidadRepository emergencia_habilidadRepository){
        this.emergencia_habilidadRepository = emergencia_habilidadRepository;
    }

    @GetMapping("/eme_habilidad")
    public List<Emergencia_Habilidad> getAlleme_habilidad() {
        return emergencia_habilidadRepository.getAlleme_habilidad();
    }


    @GetMapping(value = "/eme_habilidad/{id}")
    public Emergencia_Habilidad getEmergencia_Habilidad(@PathVariable int id){
        Emergencia_Habilidad result = emergencia_habilidadRepository.getEmergencia_Habilidad(id);
        return result;
    }

    @PostMapping("/eme_habilidad/create")
    @ResponseBody
    public Emergencia_Habilidad createEmergencia_Habilidad(@RequestBody Emergencia_Habilidad emergencia_habilidad){
        Emergencia_Habilidad result = emergencia_habilidadRepository.createEmergencia_Habilidad(emergencia_habilidad);
        return result;
    }

    @PutMapping ("/eme_habilidad/up")
    @ResponseBody
    public Emergencia_Habilidad upEmergencia_Habilidad(@RequestBody Emergencia_Habilidad emergencia_habilidad){
        Emergencia_Habilidad result = emergencia_habilidadRepository.upEmergencia_Habilidad(emergencia_habilidad);
        return result;
    }

    @DeleteMapping(value = "/eme_habilidad/delete/{id}")
    @ResponseBody
    public void deleteEmergencia_Habilidad(@PathVariable int id){
        emergencia_habilidadRepository.deleteEmergencia_Habilidad(id);
    }


}



