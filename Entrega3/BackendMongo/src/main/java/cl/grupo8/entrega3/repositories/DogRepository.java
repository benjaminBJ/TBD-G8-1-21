package cl.grupo8.entrega3.repositories;

import cl.grupo8.entrega3.models.DogModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends MongoRepository<DogModel,String> {

}
