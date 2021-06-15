package cl.tbd.entrega2.models;

import java.sql.Date;

public class Tarea {
    private Integer id;
    private String nombre;
    private String descrip;
    private Integer vol_requeridos;
    private Date finicio;
    private Date ffin;
    private Integer id_emergencia;
    private Integer id_estado;
    private double longitude;
    private double latitude;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
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
    public Date getFinicio() {
        return finicio;
    }
    public void setFinicio(Date finicio) {
        this.finicio = finicio;
    }
    public Date getFfin() {
        return ffin;
    }
    public void setFfin(Date ffin) {
        this.ffin = ffin;
    }
    public Integer getId_emergencia() {
        return id_emergencia;
    }
    public void setId_emergencia(Integer id_emergencia) {
        this.id_emergencia = id_emergencia;
    }
    public Integer getId_estado() {
        return id_estado;
    }
    public void setId_estado(Integer id_estado) {
        this.id_estado = id_estado;
    }

          
}
