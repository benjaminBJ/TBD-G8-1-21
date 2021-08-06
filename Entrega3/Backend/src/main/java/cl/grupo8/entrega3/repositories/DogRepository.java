package cl.grupo8.entrega3.repositories;

import cl.grupo8.entrega3.models.Dog;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DogRepository extends
        MongoRepository<Dog,String> {

    List<Dog> findByName(String name);

}
