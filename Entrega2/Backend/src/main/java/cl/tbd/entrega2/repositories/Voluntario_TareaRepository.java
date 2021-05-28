package cl.tbd.entrega2.repositories;
import java.util.List;


import cl.tbd.entrega2.models.Voluntario_Tarea;

public interface Voluntario_TareaRepository {
    public List<Voluntario_Tarea> getAllVoluntario_Tarea();
    public Voluntario_Tarea getVoluntario_Tarea(int id);
    public Voluntario_Tarea createVoluntario_Tarea(Voluntario_Tarea voluntario_tarea);
    public Voluntario_Tarea upVoluntario_Tarea(Voluntario_Tarea voluntario_tarea);
    public void deleteVoluntario_Tarea(int id);
}
