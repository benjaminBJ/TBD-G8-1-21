package cl.tbd.entrega2.models;

public class Dog {
    private Integer id;
    private String name;
    private String descrip;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrip() { return descrip; }

    public void setDescrip(String descrip) { this.descrip = descrip; }
}
