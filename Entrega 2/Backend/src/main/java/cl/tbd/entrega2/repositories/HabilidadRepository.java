package cl.tbd.entrega2.repositories;
import java.util.List;
import cl.tbd.entrega2.models.Habilidad;

public interface HabilidadRepository {
    public int countHabilidades();
    public List<Habilidad> getAllEst();
    public Habilidad createVol(Habilidad hab);
}
