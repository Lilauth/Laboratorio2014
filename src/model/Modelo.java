package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Modelo {
	/*esta clase levanta todas las clases del modelo que haya */
	private Etiquetas etiquetas;
	private Categorias categorias;
	private Notificaciones notificaciones;
	
	public Modelo(){
		etiquetas = new Etiquetas();
		categorias = new Categorias();
		notificaciones = new Notificaciones();
	}
	
	/*getters y setters*/
	public Etiquetas getEtiquetas() {
		return etiquetas;
	}
	public void setEtiquetas(Etiquetas etiquetas) {
		this.etiquetas = etiquetas;
	}
	public Categorias getCategorias() {
		return categorias;
	}
	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}
	public Notificaciones getNotificaciones() {
		return notificaciones;
	}
	public void setNotificaciones(Notificaciones notificaciones) {
		this.notificaciones = notificaciones;
	}
	
	private void recuperarCategorias(){
		//recupera las categorias 		
		categorias.recuperar();
	}
	
	private void recuperarEtiquetas(){
		etiquetas.recuperar();
	}
	
	/*levanta el modelo desde el archivo de texto*/
	public boolean iniciar(){
		int id;
		String descripcion;
		Etiqueta et;
		Categoria cat;
		Emisor em;
		Notificacion notif;
		String fechaHoraEnvio;
		String fechaHoraRecepcion;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		//String csvFile = "/home/lilauth/Modelo.csv";
		String csvFile = "C:\\Users\\Lilauth\\workspace\\Comunicador\\Modelo.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		//recupero categorías y etiquetas ya cargadas
		this.recuperarCategorias();
		this.recuperarEtiquetas();
		
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
			    //use comma as separator
				String[] linea = line.split(cvsSplitBy);				
				//entonces no es el título
				id = Integer.parseInt(linea[6]);
				descripcion = linea[7];
				et = new Etiqueta(id, descripcion);
				//me fijo si está en las etiquetas que ya existen
				if(this.etiquetas.getEtiqueta(id) != null){ 
					et = this.etiquetas.getEtiqueta(id);
				}
				else{
					this.etiquetas.agregarEtiqueta(et);
				}
				//me fijo si la categoria existe
				id = Integer.parseInt(linea[4]);
				descripcion = linea[5];
				cat = new Categoria(id, descripcion);
				if(this.categorias.getCategoria(id) != null){
					cat = this.categorias.getCategoria(id);
				}
				else{
					this.categorias.agregarCategoria(cat);
				}
				//hago un emisor
				em = new Emisor();
				em.setIdEmisor(Integer.parseInt(linea[8]));
				em.setNombre(linea[9]);
				//finalmente hago la notificacion
				fechaHoraEnvio = linea[2];
				fechaHoraRecepcion = linea[3];					
					
				notif = new Notificacion();
				notif.setEmisor(em);
				notif.addEtiqueta(et);
				notif.setIdNotificacion(Integer.parseInt(linea[0]));
				notif.setTexto(linea[1]);
				//notif.setFechaHoraEnvio((Date)df.parse(fechaHoraEnvio));
				//if(fechaHoraRecepcion != "null"){
				//	notif.setFechaHoraRecepcion((Date)df.parse(fechaHoraRecepcion));
				//}
				this.notificaciones.addNotificacion(notif);
				}			
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}/* catch(ParseException e){
			e.printStackTrace();
		}*/finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return true;
	}
	
	
	
}
