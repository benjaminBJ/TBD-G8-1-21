package cl.grupo8.entrega3.controllers;

import cl.grupo8.entrega3.models.DogModel;
import cl.grupo8.entrega3.services.DogService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prueba")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class DogController {

    @Autowired
    DogService dogService;

    @GetMapping
    public List<DogModel> getAllDogs(){
        return dogService.getAllDogs();
    }

    @PostMapping()
    public DogModel saveDog(@RequestBody DogModel dog){
        return  this.dogService.saveDog(dog);
    }


}
