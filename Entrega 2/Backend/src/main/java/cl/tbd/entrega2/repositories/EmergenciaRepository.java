package cl.tbd.entrega2.repositories;
import java.util.List;
import cl.tbd.entrega2.models.Emergencia;

public interface EmergenciaRepository {
    public int countEmergencias();
    public List<Emergencia> getAllEmrgs();
    public Emergencia getEmrg(int id);
    public Emergencia createEmrg(Emergencia emg);
    public Emergencia upEmrg(Emergencia dog);
    public void deleteEmrg(int id);
}
