package cl.grupo8.entrega3.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection= "dogs")
public class DogModel {
    //ID
    @Id
    private String id;
    //Atributos
    private String name;
    private int age;
    private String color;
    private LocalDateTime created;

    //Constructor
    public DogModel(String name, int age, String color, LocalDateTime created) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.created = created;
    }

    //Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}