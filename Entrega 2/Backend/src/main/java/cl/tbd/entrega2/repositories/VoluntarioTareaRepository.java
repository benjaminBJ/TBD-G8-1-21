package cl.tbd.entrega2.repositories;
import java.util.List;
import cl.tbd.entrega2.models.Voluntario_Tarea;

public interface VoluntarioTareaRepository {
    public int countVoluntariosTareas();
    public List<Voluntario_Tarea> getAllVolTareas();
    public Voluntario_Tarea createVolTarea(Voluntario_Tarea volTarea);
}
