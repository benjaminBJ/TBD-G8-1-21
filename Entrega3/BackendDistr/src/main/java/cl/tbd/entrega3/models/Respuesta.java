package cl.tbd.entrega3.models;

public class Respuesta {
            
    private String descrip;
    private String tabla_habilidad;

    public String getName() {
        return tabla_habilidad;
    }

    public void setName(String tabla_habilidad) {
        this.tabla_habilidad = tabla_habilidad;
    }

    public String getDescrip() { return descrip; }

    public void setDescrip(String descrip) { this.descrip = descrip; }
}
