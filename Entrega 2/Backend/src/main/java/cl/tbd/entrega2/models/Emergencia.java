package cl.tbd.entrega2.models;

import java.sql.Date;

public class Emergencia {
    private Integer id;
    private String nombre;
    private String decrip;
    private Date finicio;
    private Date ffin;
    private Integer id_institucion;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }
    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDecrip() { return decrip; }

    public void setDecrip(String decrip) { this.decrip = decrip; }

    public Date getFinicio() { return finicio; }

    public void setFinicio(Date finicio) { this.finicio = finicio; }

    public Date getFfin() { return ffin; }

    public void setFfin(Date ffin) { this.ffin = ffin; }

    public Integer getId_institucion() { return id_institucion; }

    public void setId_institucion(Integer id_institucion) { this.id_institucion = id_institucion; }
}
