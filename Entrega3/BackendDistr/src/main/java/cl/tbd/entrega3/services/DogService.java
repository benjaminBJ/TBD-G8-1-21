package cl.tbd.entrega3.services;

import cl.tbd.entrega3.models.Dog;
import cl.tbd.entrega3.repositories.DogRepository;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class DogService {

    private final DogRepository dogRepository;
    DogService(DogRepository dogRepository){
        this.dogRepository = dogRepository;
    }

    @GetMapping("/dogs")
    public List<Dog> getAllDogs() {
        //System.out.println("getAllDogs()");
        try {
            List<Dog> dogs = dogRepository.getAllDogs();
            return dogs;
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
            return null;
        }

    }

    @GetMapping("/dogs/count")
    public String countDogs(){
        int total = dogRepository.countDogs();
        return String.format("Tienes %d perros!!", total);
    }

    @GetMapping(value = "/dogs/{id}")
    public Dog getDog(@PathVariable int id){
        Dog result = dogRepository.getDog(id);
        return result;
    }

    @PostMapping("/dogs/create")
    @ResponseBody
    public Dog createDog(@RequestBody Dog dog){
        Dog result = dogRepository.createDog(dog);
        return result;
    }

    @DeleteMapping(value = "/dogs/delete/{id}")
    @ResponseBody
    public void deleteDog(@PathVariable int id){
       dogRepository.deleteDog(id);
    }

    @PutMapping ("/dogs/up")
    @ResponseBody
    public Dog upDog(@RequestBody Dog dog){
        Dog result = dogRepository.upDog(dog);
        return result;
    }
}
