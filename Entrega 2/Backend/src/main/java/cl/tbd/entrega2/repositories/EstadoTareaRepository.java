package cl.tbd.entrega2.repositories;
import java.util.List;
import cl.tbd.entrega2.models.Estado_Tarea;

public interface EstadoTareaRepository {
    public int countEstado_Tareas();
    public List<Estado_Tarea> getAllEst();
    public Estado_Tarea createVol(Estado_Tarea est);
}
