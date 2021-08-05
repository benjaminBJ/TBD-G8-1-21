package cl.grupo8.entrega3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


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

	

}
