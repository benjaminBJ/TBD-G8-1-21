package cl.grupo8.entrega3.services;

import cl.grupo8.entrega3.models.Dog;
import cl.grupo8.entrega3.repositories.DogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class DogService {

    private final DogRepository dogRepository;

    public List<Dog> getAllDogs(){
        return dogRepository.findAll();
    }
}
