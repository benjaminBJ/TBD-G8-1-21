package cl.tbd.entrega2.repositories;
import java.util.List;
import cl.tbd.entrega2.models.Voluntario;

public interface VoluntarioRepository {
    public int countVoluntarios();
    public List<Voluntario> getAllVols();
    public Voluntario createVol(Voluntario vol);
}
