package cl.tbd.entrega2.models;

import java.sql.Date;

public class TareaDTO extends Tarea {
    private double distancia_km;


    public double getDistancia_km() {
        return this.distancia_km;
    }

    public void setDistancia_km(double distancia_km) {
        this.distancia_km = distancia_km;
    }
         
}