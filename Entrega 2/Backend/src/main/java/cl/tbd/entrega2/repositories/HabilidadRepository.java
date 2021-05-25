package cl.tbd.entrega2.repositories;
import java.util.List;
import cl.tbd.entrega2.models.Habilidad;

public interface HabilidadRepository {
    public int countHabilidads();
    public List<Habilidad> getAllHabilidads();
    public Habilidad getHabilidad(int id);
    public Habilidad createHabilidad(Habilidad habilidad);
    public Habilidad upHabilidad(Habilidad habilidad);
    public void deleteHabilidad(int id);
}
