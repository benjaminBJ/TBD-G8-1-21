package cl.grupo8.entrega3.services;

import cl.grupo8.entrega3.models.EmergenciaModel;
import cl.grupo8.entrega3.repositories.EmergenciaRepository;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.AllArgsConstructor;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Service
public class EmergenciaService {

    @Autowired
    EmergenciaRepository emergenciaRepository;

    // Para consultas Custom
    @Autowired
    MongoDatabase database;

    //Metodos de crud basico, findall save findbyId y deleteByid
    public List<EmergenciaModel> getAllEmergencias(){
        return emergenciaRepository.findAll();
    }

    public EmergenciaModel saveEmergencia(EmergenciaModel emergencia){
        return emergenciaRepository.save(emergencia);
    }

    public EmergenciaModel getEmergencia(String id){
        return emergenciaRepository.findById(id).get();
    }

    public void deleteEmergencia(String id){
        emergenciaRepository.deleteById(id);
    }

    //Consulta Custom desde mongo compass
    //FindIterable<Document> -> AggregateIterable<Document>
    public ArrayList<Document> tareasXEmergencia() {
        MongoCollection<Document> collection = database.getCollection("emergencias");

        AggregateIterable<Document> r = collection.aggregate(Arrays.asList(new Document("$lookup",
                        new Document("from", "tareas")
                                .append("localField", "nombre")
                                .append("foreignField", "emergencia")
                                .append("as", "tareas")),
                new Document("$unwind",
                        new Document("path", "$tareas")),
                new Document("$group",
                        new Document("_id",
                                new Document("nombre", "$nombre"))
                                .append("tareas_emergencia",
                                        new Document("$addToSet", "$tareas")))));
        /*

        for (Document dbObject : result)
        {
            System.out.println(dbObject);
        }
        */
        ArrayList<Document> result = new ArrayList<>(100);
        for (Document document : r){
            result.add(document);
            //Si se pudo
        }
        return  result;
    }




}
