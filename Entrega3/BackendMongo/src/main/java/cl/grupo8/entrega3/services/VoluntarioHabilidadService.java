package cl.grupo8.entrega3.services;

import cl.grupo8.entrega3.models.VoluntarioHabilidadModel;
import cl.grupo8.entrega3.repositories.VoluntarioHabilidadRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class VoluntarioHabilidadService {

    @Autowired
    VoluntarioHabilidadRepository voluntarioHabilidadRepository;

    public List<VoluntarioHabilidadModel> getAllVolH(){
        return voluntarioHabilidadRepository.findAll();
    }

    public VoluntarioHabilidadModel saveVolH(VoluntarioHabilidadModel volhabilidad){
        return voluntarioHabilidadRepository.save(volhabilidad);
    }

    public VoluntarioHabilidadModel getVolH(String id){
        return voluntarioHabilidadRepository.findById(id).get();
    }

    public void deleteVolH(String id){
        voluntarioHabilidadRepository.deleteById(id);
    }


}
