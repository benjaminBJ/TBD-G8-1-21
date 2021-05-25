package cl.tbd.entrega2.models;

public class Ranking {
    private Integer id;
    private Integer puntaje;
    private Boolean flg_participa;
    private Boolean flg_invitado;
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

    public Boolean getFlg_invitado() {
        return flg_invitado;
    }
    public void setFlg_invitado(Boolean flg_invitado) {
        this.flg_invitado = flg_invitado;
    }

    public Boolean getFlg_participa() {
        return flg_participa;
    }
    public void setFlg_participa(Boolean flg_participa) {
        this.flg_participa = flg_participa;
    }

    public Integer getPuntaje() {
        return puntaje;
    }
    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }
    

    
}