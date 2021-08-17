package cl.grupo8.entrega3.repositories;

import cl.grupo8.entrega3.models.VoluntarioHabilidadModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VoluntarioHabilidadRepository extends MongoRepository<VoluntarioHabilidadModel,String> {
}
