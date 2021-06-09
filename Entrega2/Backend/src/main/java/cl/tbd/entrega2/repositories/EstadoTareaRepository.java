package cl.tbd.entrega2.repositories;
import java.util.List;
import cl.tbd.entrega2.models.Estado_Tarea;

public interface EstadoTareaRepository {
    public List<Estado_Tarea> getAllEstado_Tarea();
    public Estado_Tarea createEstado_Tarea(Estado_Tarea estado_Tarea);
    public Estado_Tarea getEstado_Tarea(int id);
    public Estado_Tarea upEstado_Tarea(Estado_Tarea estado_Tarea);
    public void deleteEstado_Tarea(int id);

}
