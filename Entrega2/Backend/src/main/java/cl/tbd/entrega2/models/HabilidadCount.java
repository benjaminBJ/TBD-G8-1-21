package cl.tbd.entrega2.models;

public class HabilidadCount extends Habilidad {
    private int cant_tareas;

    public int getCant_tareas(){
        return this.cant_tareas;
    }

    public void setCant_tareas(int cant_tareas){
        this.cant_tareas = cant_tareas;
    }
}