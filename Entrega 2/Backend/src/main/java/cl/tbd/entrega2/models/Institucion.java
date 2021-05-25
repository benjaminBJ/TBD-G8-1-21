package cl.tbd.entrega2.models;

public class Institucion {
	private Integer id;
	private String nombre;
	private String descrip;

	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public String getNombre(){
		return nombre;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public String getDescripcion(){
		return descrip;
	}

	public void setDescripcion(String descripcion){
		this.descrip = descripcion;
	}

}