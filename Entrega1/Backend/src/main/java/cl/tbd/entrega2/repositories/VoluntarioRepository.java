package cl.tbd.entrega2.repositories;
import java.util.List;
import cl.tbd.entrega2.models.Voluntario;

public interface VoluntarioRepository {
    public List<Voluntario> getAllVoluntarios();
    public Voluntario getVoluntario(int id);
    public Voluntario createVoluntario(Voluntario voluntario);
    public Voluntario upVoluntario(Voluntario voluntario);
    public void deleteVoluntario(int id);
}
