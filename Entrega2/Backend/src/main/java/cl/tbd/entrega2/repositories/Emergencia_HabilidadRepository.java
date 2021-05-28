package cl.tbd.entrega2.repositories;

import cl.tbd.entrega2.models.Emergencia_Habilidad;

import java.util.List;

public interface Emergencia_HabilidadRepository {

    public List<Emergencia_Habilidad> getAlleme_habilidad();
    public Emergencia_Habilidad getEmergencia_Habilidad(int id);
    public Emergencia_Habilidad createEmergencia_Habilidad(Emergencia_Habilidad emergencia_habilidad);
    public Emergencia_Habilidad upEmergencia_Habilidad(Emergencia_Habilidad emergencia_habilidad);
    public void deleteEmergencia_Habilidad(int id);
}
