package cl.grupo8.entrega3.models;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection= "vol_habilidad")
public class VoluntarioHabilidadModel {

    @Id
    private String id;
    private String voluntario;
    private String habilidad;

    public VoluntarioHabilidadModel(String voluntario, String habilidad) {
        this.voluntario = voluntario;
        this.habilidad = habilidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVoluntario() {
        return voluntario;
    }

    public void setVoluntario(String voluntario) {
        this.voluntario = voluntario;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }
}
