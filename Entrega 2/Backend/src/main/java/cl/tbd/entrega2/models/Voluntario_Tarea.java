package cl.tbd.entrega2.models;

public class Voluntario_Tarea {
    private Integer id;
    private String nombre;
    private String rut;
    //private Integer id_voluntario;
    //private Integer id_tarea;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
