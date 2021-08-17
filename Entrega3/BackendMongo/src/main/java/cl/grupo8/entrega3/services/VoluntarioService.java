package cl.grupo8.entrega3.services;

import cl.grupo8.entrega3.models.VoluntarioModel;
import cl.grupo8.entrega3.repositories.VoluntarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class VoluntarioService {

    @Autowired
    VoluntarioRepository voluntarioRepository;

    public List<VoluntarioModel> getAllVoluntarios(){
        return voluntarioRepository.findAll();
    }

    public VoluntarioModel saveVoluntario(VoluntarioModel voluntario){
        return voluntarioRepository.save(voluntario);
    }

    public VoluntarioModel getVoluntario(String id){
        return voluntarioRepository.findById(id).get();
    }

    public void deleteVoluntario(String id){
        voluntarioRepository.deleteById(id);
    }


}
