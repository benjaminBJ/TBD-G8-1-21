package cl.tbd.entrega2.repositories;

import cl.tbd.entrega2.models.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

@Repository
public class DogRepositoryImp implements DogRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countDogs() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            total = conn.createQuery("SELECT COUNT(*) FROM dog").executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Dog> getAllDogs() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from dog")
                    .executeAndFetch(Dog.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Dog getDog(int id){
        try(Connection conn = sql2o.open()){
            String sql = "select * from dog WHERE id = :id";
            Dog dog = conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Dog.class);
            return dog;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public Dog createDog(Dog dog) {
        try(Connection conn = sql2o.open()){
            int insertedId = (int) conn.createQuery("INSERT INTO dog (name,descrip) values (:dogName,:descrip)", true)
                    .addParameter("dogName", dog.getName())
                    .addParameter("descrip", dog.getDescrip())
                    .executeUpdate().getKey();
            dog.setId(insertedId);
            return dog;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteDog(int id) {
        try(Connection conn = sql2o.open()){
            String sql = "DELETE FROM dog WHERE id = :id";
            conn.createQuery(sql, true)
                   .addParameter("id", id)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Dog upDog(Dog dog){
        try(Connection conn = sql2o.open()){

            String sql = "UPDATE dog SET name = :nombre " +
                         "WHERE id = :id";

            conn.createQuery(sql, true)
                    .addParameter("nombre", dog.getName())
                    .addParameter("id", dog.getId())
                    .executeUpdate();

            return dog;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }


}
