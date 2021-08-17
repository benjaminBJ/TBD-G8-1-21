package cl.grupo8.entrega3.services;

import cl.grupo8.entrega3.models.TareaModel;
import cl.grupo8.entrega3.repositories.TareaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TareaService {

    @Autowired
    TareaRepository tareaRepository;

    public List<TareaModel> getAllTareas(){
        return tareaRepository.findAll();
    }

    public TareaModel saveTarea(TareaModel tarea){
        return tareaRepository.save(tarea);
    }

    public TareaModel getTarea(String id){
        return tareaRepository.findById(id).get();
    }

    public void deleteTarea(String id){
        tareaRepository.deleteById(id);
    }


}
