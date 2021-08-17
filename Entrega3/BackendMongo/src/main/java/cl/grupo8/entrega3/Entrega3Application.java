package cl.grupo8.entrega3;

import cl.grupo8.entrega3.models.DogModel;
import cl.grupo8.entrega3.repositories.DogRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@SpringBootApplication
@RestController
public class Entrega3Application {

	public static void main(String[] args) {
		SpringApplication.run(Entrega3Application.class, args);
	}

	@GetMapping("/")
    public String HelloWorld(){
        return "Hello World";
    }

	@Bean
	//Prueba de faker
	CommandLineRunner runner(DogRepository repository, MongoTemplate mongoTemplate){

		return args ->{
			DogModel dog = new DogModel(
					"pedro",
					2,
					"cafe",
					LocalDateTime.now()
			);

			//Query de Mongo Prueba
			//Query query = new Query();
			//query.addCriteria(Criteria.where("email").is(email));
			//Ocupar el template
			//List<Dog> dogs = mongoTemplate.find(query(),Dog.class);

			/*
			if (dogs.size() >1 ){
				throw new IllegalStateException(
						"found many studens with email " + email);
			}

			if(dogs.isEmpty()){
				System.out.println("Inserting Dog " + dog);
				repository.insert(dog);
			}else{
				System.out.println(dog + "already exist");
			}
			 */

			repository.insert(dog);

		};
	}

}
