package model;

import java.io.Serializable;

public class Categoria implements Serializable{
	public static final long serialVersionUID = 1L;
	private int idCategoria;
	private String descripcion;
	
	public Categoria(){
		
	}
	
	public Categoria(int id, String descripcion){
		this.setDescripcion(descripcion);
		this.setIdCategoria(id);
	}
	
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {		
		this.idCategoria = idCategoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
