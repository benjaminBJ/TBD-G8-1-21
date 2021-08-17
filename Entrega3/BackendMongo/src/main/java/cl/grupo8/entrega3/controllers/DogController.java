package cl.grupo8.entrega3.controllers;

import cl.grupo8.entrega3.models.DogModel;
import cl.grupo8.entrega3.services.DogService;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.AllArgsConstructor;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/prueba")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class DogController {

    @Autowired
    DogService dogService;

    @GetMapping
    @ResponseBody
    public List<DogModel> getAllDogs(){
        return dogService.getAllDogs();
    }

    @PostMapping()
    @ResponseBody
    public DogModel saveDog(@RequestBody DogModel dog){
        return  this.dogService.saveDog(dog);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public DogModel getDog(@PathVariable String id){
        DogModel result = this.dogService.getDog(id);
        return result;
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseBody
    public void deleteDog(@PathVariable String id){
        this.dogService.deleteDog(id);
    }


}
