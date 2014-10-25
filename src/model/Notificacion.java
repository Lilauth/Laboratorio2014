package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class Notificacion implements Serializable{	
	
	public static final long serialVersionUID = 1L;
	private int idNotificacion;
	private String texto;
	private Date fechaHoraEnvio;
	private Date fechaHoraRecepcion;
	private ArrayList<Etiqueta> etiquetas;
	private Emisor emisor;
	
	public Notificacion(){
		Etiqueta et = new Etiqueta();
		et.setIdEtiqueta(1);
		et.setDescripcion("Recibido");
		this.etiquetas = new ArrayList<Etiqueta>();
		this.etiquetas.add(et);
	}
	
	public int getIdNotificacion(){
		return this.idNotificacion;
	}
	
	public void setIdNotificacion(int id){
		this.idNotificacion = id;
	}
	
	public void setEmisor(Emisor em){
		this.emisor = em;
	}
	
	public Emisor getEmisor(){
		return this.emisor;
	}
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getFechaHoraEnvio() {
		return fechaHoraEnvio;
	}
	public void setFechaHoraEnvio(Date fechaHoraEnvio) {
		this.fechaHoraEnvio = fechaHoraEnvio;
	}
	public Date getFechaHoraRecepcion() {
		return fechaHoraRecepcion;
	}
	public void setFechaHoraRecepcion(Date fechaHoraRecepcion) {
		this.fechaHoraRecepcion = fechaHoraRecepcion;
	}
	public ArrayList<Etiqueta> getEtiquetas() {
		return etiquetas;
	}
	public void setEtiquetas(ArrayList<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}

}
