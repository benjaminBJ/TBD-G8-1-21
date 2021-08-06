package cl.grupo8.entrega3.controllers;

import cl.grupo8.entrega3.models.Dog;
import cl.grupo8.entrega3.services.DogService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prueba")
@AllArgsConstructor
public class DogController {

    private final DogService dogService;

    @GetMapping
    public List<Dog> fetchAllDogs(){
        return dogService.getAllDogs();
    }


}
