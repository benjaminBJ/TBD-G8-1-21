package cl.tbd.entrega3.repositories;
import java.util.List;
import cl.tbd.entrega3.models.Voluntario;

public interface VoluntarioRepository {
    public int countVoluntarios();
    public List<Voluntario> getAllVoluntarios();
    public Voluntario getVoluntario(int id);
    public Voluntario getVoluntarioNombre(String nombre);
    public Voluntario createVoluntario(Voluntario voluntario);
    public Voluntario upVoluntario(Voluntario voluntario);
    public void deleteVoluntario(int id);
    public String habilidadesVoluntario(String nombre);
    public String getJson();
}
