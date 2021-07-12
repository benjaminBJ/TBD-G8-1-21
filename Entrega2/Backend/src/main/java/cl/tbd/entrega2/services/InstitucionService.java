package cl.tbd.entrega2.services;

import cl.tbd.entrega2.models.Institucion;
import cl.tbd.entrega2.repositories.InstitucionRepository;
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
public class InstitucionService {

    private final InstitucionRepository institucionRepository;
    InstitucionService(InstitucionRepository institucionRepository){
        this.institucionRepository = institucionRepository;
    }

    @GetMapping("/institucions/count")
    public String countInstitucions(){
        int total = institucionRepository.countInstitucions();
        return String.format("Tienes %d instituciones!!", total);
    }

    @GetMapping("/institucions")
    public List<Institucion> getAllInstitucions() {
        return institucionRepository.getAllInstitucions();
    }


    @GetMapping(value = "/institucions/{id}")
    public Institucion getInstitucion(@PathVariable int id){
        Institucion result = institucionRepository.getInstitucion(id);
        return result;
    }

    @PostMapping("/institucions/create")
    @ResponseBody
    public Institucion createInstitucion(@RequestBody Institucion institucion){
        Institucion result = institucionRepository.createInstitucion(institucion);
        return result;
    }

    @PutMapping ("/institucions/up")
    @ResponseBody
    public Institucion upInstitucion(@RequestBody Institucion institucion){
        Institucion result = institucionRepository.upInstitucion(institucion);
        return result;
    }

    @DeleteMapping(value = "/institucions/delete/{id}")
    @ResponseBody
    public void deleteInstitucion(@PathVariable int id){
        institucionRepository.deleteInstitucion(id);
    }


}
