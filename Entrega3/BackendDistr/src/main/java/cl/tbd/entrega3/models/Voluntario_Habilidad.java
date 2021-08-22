package cl.tbd.entrega3.models;

public class Voluntario_Habilidad {
	private Integer id;
	private Integer id_voluntario;
	private Integer id_habilidad;
	private String tabla;
	private String tabla_voluntario;


	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public Integer getId_voluntario() { return id_voluntario; }

	public void setId_voluntario(Integer id_voluntario) { this.id_voluntario = id_voluntario; }

	public Integer getId_habilidad() { return id_habilidad; }

	public void setId_habilidad(Integer id_habilidad) { this.id_habilidad = id_habilidad; }

	public String getTabla() {
		return tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public String getTabla_voluntario() {
		return tabla_voluntario;
	}

	public void setTabla_voluntario(String tabla_voluntario) {
		this.tabla_voluntario = tabla_voluntario;
	}
}