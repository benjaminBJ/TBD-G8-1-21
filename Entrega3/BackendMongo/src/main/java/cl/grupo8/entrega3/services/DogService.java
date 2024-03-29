package cl.grupo8.entrega3.services;

import cl.grupo8.entrega3.models.DogModel;
import cl.grupo8.entrega3.repositories.DogRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@AllArgsConstructor
@Service
public class DogService {

    @Autowired
    DogRepository dogRepository;

    public List<DogModel> getAllDogs(){
        return dogRepository.findAll();
    }

    public DogModel saveDog(DogModel dog){
        return dogRepository.save(dog);
    }

    public DogModel getDog(String id){
        return dogRepository.findById(id).get();
    }

    public void deleteDog(String id){
        dogRepository.deleteById(id);
    }
}
