package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Modelo {
	/*esta clase levanta todas las clases del modelo que haya */
	private Etiquetas etiquetas;
	private Categorias categorias;
	private Notificaciones notificaciones;
	
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
	
	/*levanta el modelo desde el archivo de texto*/
	public boolean iniciar(){
		String csvFile = "/home/lilauth/Modelo.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
			    //use comma as separator
				String[] linea = line.split(cvsSplitBy);
				/*por como está organizado el csv idNotificacion, texto, fechaHoraEnvio, fechaHoraRecepcion,
				 * idCategoria, Categoria, idEtiqueta, etiqueta, idEmisor, Emisor*/
				/*el indice arranca de cero*/
				/*System.out.println("Country [code= " + country[4] 
	                                 + " , name=" + country[5] + "]");*/
	 
			}
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
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
