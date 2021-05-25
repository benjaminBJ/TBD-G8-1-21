package cl.tbd.entrega2.repositories;
import java.util.List;
import cl.tbd.entrega2.models.Tarea;

public interface TareaRepository {
    public int countTarea();
    public List<Tarea> getAllTarea();
    public Tarea getTarea(int id);
    public Tarea createTarea(Tarea tarea);
    public Tarea upTarea(Tarea tarea);
    public void deleteTarea(int id);
}
