package cl.tbd.entrega2.services;

import cl.tbd.entrega2.models.Emergencia;
import cl.tbd.entrega2.repositories.EmergenciaRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class EmergenciaService {
	private final EmergenciaRepository emergenciaRepository;
	EmergenciaService(EmergenciaRepository emergenciaRepository){
		this.emergenciaRepository = emergenciaRepository;
	}

    @GetMapping("/emergencias/count")
    public int countEmergencias(){
        return emergenciaRepository.countEmergencias();
    }

    @GetMapping("/emergencias")
    public List<Emergencia> getAllEmrgs() {
        return emergenciaRepository.getAllEmrgs();
    }

    @GetMapping(value = "/emergencias/{id}")
    public Emergencia getEmrg(@PathVariable int id){
        Emergencia result = emergenciaRepository.getEmrg(id);
        return result;
    }

    @PostMapping("/emergencias")
    @ResponseBody
    public Emergencia createEmrgs(@RequestBody Emergencia emrg){
        Emergencia emergencia = emergenciaRepository.createEmrg(emrg);
        return emergencia;
    }
    
}