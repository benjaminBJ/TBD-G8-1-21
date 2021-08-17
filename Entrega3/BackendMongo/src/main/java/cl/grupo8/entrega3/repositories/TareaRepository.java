package cl.grupo8.entrega3.repositories;

import cl.grupo8.entrega3.models.TareaModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends MongoRepository<TareaModel,String> {

}
