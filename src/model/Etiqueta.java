package model;

import java.io.Serializable;

public class Etiqueta implements Serializable{
	public static final long serialVersionUID = 1L;
	private int idEtiqueta;
	private String descripcion;
	
	public Etiqueta(){}
	
	public Etiqueta(int id, String descripcion){
		this.setIdEtiqueta(id);
		this.setDescripcion(descripcion);		
	}
	
	public int getIdEtiqueta() {
		return idEtiqueta;
	}
	public void setIdEtiqueta(int idEtiqueta) {
		this.idEtiqueta = idEtiqueta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
