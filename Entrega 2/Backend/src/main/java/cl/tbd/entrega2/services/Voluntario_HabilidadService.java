package cl.tbd.entrega2.services;

import cl.tbd.entrega2.models.Voluntario_Habilidad;
import cl.tbd.entrega2.repositories.Voluntario_HabilidadRepository;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@CrossOrigin
@RestController
public class Voluntario_HabilidadService {

    private final Voluntario_HabilidadRepository voluntario_habilidadRepository;
    Voluntario_HabilidadService(Voluntario_HabilidadRepository voluntario_habilidadRepository){
        this.voluntario_habilidadRepository = voluntario_habilidadRepository;
    }


    @GetMapping("/vol_habilidad")
    public List<Voluntario_Habilidad> getAllVoluntario_Habilidad() {
        return voluntario_habilidadRepository.getAllVoluntario_Habilidad();
    }


    @GetMapping(value = "/vol_habilidad/{id}")
    public Voluntario_Habilidad getVoluntario_Habilidad(@PathVariable int id){
        Voluntario_Habilidad result = voluntario_habilidadRepository.getVoluntario_Habilidad(id);
        return result;
    }

    @PostMapping("/vol_habilidad/create")
    @ResponseBody
    public Voluntario_Habilidad createVoluntario_Habilidad(@RequestBody Voluntario_Habilidad voluntario_habilidad){
        Voluntario_Habilidad result = voluntario_habilidadRepository.createVoluntario_Habilidad(voluntario_habilidad);
        return result;
    }

    @PutMapping ("/vol_habilidad/up")
    @ResponseBody
    public Voluntario_Habilidad upVoluntario_Habilidadn(@RequestBody Voluntario_Habilidad voluntario_habilidad){
        Voluntario_Habilidad result = voluntario_habilidadRepository.upVoluntario_Habilidadn(voluntario_habilidad);
        return result;
    }

    @DeleteMapping(value = "/vol_habilidad/delete/{id}")
    @ResponseBody
    public void deleteVoluntario_Habilidad(@PathVariable int id){
        voluntario_habilidadRepository.deleteVoluntario_Habilidad(id);
    }

}
