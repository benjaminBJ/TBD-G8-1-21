package cl.tbd.entrega2.services;

import cl.tbd.entrega2.models.Emergencia;
import cl.tbd.entrega2.repositories.EmergenciaRepository;
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
public class EmergenciaService {

    private final EmergenciaRepository emergenciaRepository;
    EmergenciaService(EmergenciaRepository emergenciaRepository){
        this.emergenciaRepository = emergenciaRepository;
    }

    @GetMapping("/emergencias")
    public List<Emergencia> getAllEmergencias() {
        /*
        try {
            List<Emergencia> emergencias = emergenciaRepository.getAllEmergencias();
            return emergencias;
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
            return null;
        }*/
        return emergenciaRepository.getAllEmergencias();
    }


    @GetMapping("/emergencias/count")
    public int countDogs(){
        int total = emergenciaRepository.countEmergencia();
        //return String.format("Tienes %d perros!!", total);
        return total;
    }


    @GetMapping(value = "/emergencias/{id}")
    public Emergencia getEmergencia(@PathVariable int id){
        Emergencia result = emergenciaRepository.getEmergencia(id);
        return result;
    }

    @PostMapping("/emergencias/create")
    @ResponseBody
    public Emergencia createEmergencia(@RequestBody Emergencia emergencia){
        Emergencia result = emergenciaRepository.createEmergencia(emergencia);
        return result;
    }

    @PutMapping ("/emergencias/up")
    @ResponseBody
    public Emergencia upEmergencia(@RequestBody Emergencia emergencia){
        Emergencia result = emergenciaRepository.upEmergencia(emergencia);
        return result;
    }

    @DeleteMapping(value = "/emergencias/delete/{id}")
    @ResponseBody
    public void deleteEmergencia(@PathVariable int id){
        emergenciaRepository.deleteEmergencia(id);
    }
}