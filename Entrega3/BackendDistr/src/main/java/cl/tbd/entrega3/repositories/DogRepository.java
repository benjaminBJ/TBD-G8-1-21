package cl.tbd.entrega3.repositories;
import java.util.List;
import cl.tbd.entrega3.models.Dog;

public interface DogRepository {
    public int countDogs();
    public List<Dog> getAllDogs();
    public Dog createDog(Dog dog);
    public void deleteDog(int id);
    public Dog getDog(int id);
    public Dog upDog(Dog dog);
    //nueva
    public String getJson();

}
