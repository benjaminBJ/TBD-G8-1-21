package cl.tbd.entrega2.services;

import cl.tbd.entrega2.models.Emergencia;
import cl.tbd.entrega2.repositories.EmergenciaRepository;

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
    public List<Emergencia> getAllEmrgs() {
        return emergenciaRepository.getAllEmrgs();
    }

    @GetMapping("/emergencias/count")
    public int countEmergencias(){
        return emergenciaRepository.countEmergencias();
    }

    @PostMapping("/emergencias")
    @ResponseBody
    public Emergencia createEmrgs(@RequestBody Emergencia emrg){
        Emergencia emergencia = emergenciaRepository.createEmrgs(emrg);
        return emergencia;
    }
}