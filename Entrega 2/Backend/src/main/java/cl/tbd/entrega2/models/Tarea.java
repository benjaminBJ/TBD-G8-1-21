package cl.tbd.entrega2.models;

import java.sql.Date;

public class Tarea {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer vol_requeridos;
    private Date finicio;
    private Date ffin;
    //private Integer id_emergencia;
    //private Integer id_estado;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Date getFfin() {
        return ffin;
    }
    public void setFfin(Date ffin) {
        this.ffin = ffin;
    }

    public Date getFinicio() {
        return finicio;
    }
    public void setFinicio(Date finicio) {
        this.finicio = finicio;
    }

    public Integer getVol_requeridos() {
        return vol_requeridos;
    }
    public void setVol_requeridos(Integer vol_requeridos) {
        this.vol_requeridos = vol_requeridos;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
