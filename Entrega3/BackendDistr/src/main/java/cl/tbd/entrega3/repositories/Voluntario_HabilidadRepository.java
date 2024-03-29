package cl.tbd.entrega3.repositories;

import cl.tbd.entrega3.models.Voluntario_Habilidad;

import java.util.List;

public interface Voluntario_HabilidadRepository {

    public List<Voluntario_Habilidad> getAllVoluntario_Habilidad();
    public Voluntario_Habilidad getVoluntario_Habilidad(int id);
    public void createVoluntario_Habilidad(int id_voluntario, String tabla_voluntario);
    public Voluntario_Habilidad upVoluntario_Habilidad(Voluntario_Habilidad voluntario_habilidad);
    public void deleteVoluntario_Habilidad(int id);

}
