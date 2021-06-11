package cl.tbd.entrega2.repositories;
import java.util.List;
import cl.tbd.entrega2.models.Emergencia;


public interface EmergenciaRepository {
    public List<Emergencia> getAllEmergencias();
    public Emergencia getEmergencia(int id);
    public Emergencia createEmergencia(Emergencia emergencia);
    public Emergencia upEmergencia(Emergencia emergencia);
    public void deleteEmergencia(int id);
    public String getJson();
}
