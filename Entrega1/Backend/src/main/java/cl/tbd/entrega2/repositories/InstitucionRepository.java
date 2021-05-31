package cl.tbd.entrega2.repositories;

import cl.tbd.entrega2.models.Institucion;
import java.util.List;

public interface InstitucionRepository {
    public int countInstitucions();
    public List<Institucion> getAllInstitucions();
    public Institucion getInstitucion(int id);
    public Institucion createInstitucion(Institucion institucion);
    public Institucion upInstitucion(Institucion institucion);
    public void deleteInstitucion(int id);
}
