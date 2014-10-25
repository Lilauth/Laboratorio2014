package model;

import java.io.Serializable;

public class Emisor implements Serializable{
	public static final long serialVersionUID = 1L;
	private int idEmisor;
	private String nombre;
	
	public Emisor(){}
	
	public int getIdEmisor() {
		return idEmisor;
	}
	public void setIdEmisor(int idEmisor) {
		this.idEmisor = idEmisor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
