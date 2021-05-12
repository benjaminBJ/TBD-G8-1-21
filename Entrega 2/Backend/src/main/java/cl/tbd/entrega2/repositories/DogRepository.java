package cl.tbd.entrega2.repositories;
import java.util.List;
import cl.tbd.entrega2.models.Dog;

public interface DogRepository {
    public int countDogs();
    public List<Dog> getAllDogs();
    public Dog createDog(Dog dog);
}
