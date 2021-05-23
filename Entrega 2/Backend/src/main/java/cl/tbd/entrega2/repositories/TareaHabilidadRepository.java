package cl.tbd.entrega2.repositories;
import java.util.List;
import cl.tbd.entrega2.models.Tarea_Habilidad;

public interface TareaHabilidadRepository {
    public int countTareaHabilidad();
    public List<Tarea_Habilidad> getAllTareaHab();
    public Tarea_Habilidad createTareaHab(Tarea_Habilidad th);
}
