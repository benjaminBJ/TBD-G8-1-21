package cl.grupo8.entrega3.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection= "tareas")
public class TareaModel {

    @Id
    private String id;

    private String nombre;
    private String descrip;
    private Integer vol_requeridos;
    private String finicio;
    private String ffin;
    private String emergencia;

    public TareaModel(String nombre, String descrip, Integer vol_requeridos, String finicio, String ffin, String emergencia) {
        this.nombre = nombre;
        this.descrip = descrip;
        this.vol_requeridos = vol_requeridos;
        this.finicio = finicio;
        this.ffin = ffin;
        this.emergencia = emergencia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public Integer getVol_requeridos() {
        return vol_requeridos;
    }

    public void setVol_requeridos(Integer vol_requeridos) {
        this.vol_requeridos = vol_requeridos;
    }

    public String getFinicio() {
        return finicio;
    }

    public void setFinicio(String finicio) {
        this.finicio = finicio;
    }

    public String getFfin() {
        return ffin;
    }

    public void setFfin(String ffin) {
        this.ffin = ffin;
    }

    public String getEmergencia() {
        return emergencia;
    }

    public void setEmergencia(String emergencia) {
        this.emergencia = emergencia;
    }
}
