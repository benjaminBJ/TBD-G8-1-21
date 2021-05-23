package cl.tbd.entrega2.repositories;
import java.util.List;
import cl.tbd.entrega2.models.Tarea;

public interface TareaRepository {
    public int countTareas();
    public List<Tarea> getAllTareas();
    public Tarea createTarea(Tarea tarea);
}
