package cl.tbd.entrega2.repositories;

import cl.tbd.entrega2.models.Tarea_Habilidad;
import java.util.List;

public interface Tarea_HabilidadRepository {

    public List<Tarea_Habilidad> getAllTarea_Habilidad();
    public Tarea_Habilidad getTarea_Habilidad(int id);
    public Tarea_Habilidad createTarea_Habilidad(Tarea_Habilidad tarea_habilidad);
    public Tarea_Habilidad upTarea_Habilidad(Tarea_Habilidad tarea_habilidad);
    public void deleteTarea_Habilidad(int id);
}
