package cl.tbd.entrega2.models;

public class Voluntario_Tarea {
    private Integer id;

    private boolean flg_participa;
    private Integer id_estado;
    private Integer id_voluntario;
    private Integer id_tarea;

    public Integer getId() {
        return id;
    }
    public Integer getId_estado() {
        return id_estado;
    }
    public void setId_estado(Integer id_estado) {
        this.id_estado = id_estado;
    }
    public boolean isFlg_participa() {
        return flg_participa;
    }
    public void setFlg_participa(boolean flg_participa) {
        this.flg_participa = flg_participa;
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

    
}
