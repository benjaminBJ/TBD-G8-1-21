package cl.tbd.entrega3.models;

public class Voluntario {
    private Integer id;
    private String nombre;
    private String rut;
    private String email;
    private String telefono;
    private String tabla;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }
}
