package cl.tbd.entrega2.models;

public class Voluntario_Tarea {
    private Integer id;
    private String nombre;
    private String rut;
    private Integer id_voluntario;
    private Integer id_tarea;

    public Integer getId() {
        return id;
    }
    public Integer getId_voluntario() {
        return id_voluntario;
    }
    public void setId_voluntario(Integer id_voluntario) {
        this.id_voluntario = id_voluntario;
    }
    public Integer getId_tarea() {
        return id_tarea;
    }
    public void setId_tarea(Integer id_tarea) {
        this.id_tarea = id_tarea;
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
