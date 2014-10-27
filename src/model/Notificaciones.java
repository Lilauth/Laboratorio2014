package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Notificaciones {
	private ArrayList<Notificacion> lista;
	
	public Notificaciones(){
		lista = new ArrayList<Notificacion>();
	}
	
	public void listar(){
		//lista todas las notificaciones cargadaen lista
		for(Notificacion not: lista){
			System.out.println(not.getTexto());
		}
	}
	
	public void addNotificacion(Notificacion notif){
		this.lista.add(notif);
	}
	
	/*métodos que tienen que ver con la persistencia de las notificaciones*/
	public void persistir(){
		ObjectOutputStream salida = null;
		try {
			salida = new ObjectOutputStream(new FileOutputStream("notificaciones.dat"));
			salida.writeObject(lista);
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	    catch (Exception ex) {
	    	ex.printStackTrace();
		} 
		finally {
			try { 
					if (salida != null) {
						salida.flush(); 
						salida.close();
					}
			} 
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public Notificaciones recuperar(){
		//recupera las categorias persistidas y las guarda en su lista privada				
		lista.clear();
		
		ObjectInputStream entrada = null;
		try{
			entrada= new ObjectInputStream(new FileInputStream("notificaciones.dat"));
			lista = (ArrayList<Notificacion>)entrada.readObject();
			entrada.close();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	    catch (Exception ex) {
	    	ex.printStackTrace();
		}
		finally {
			try { 		
				if (entrada != null) {
					entrada.close();
				}
			} 
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}	
		return this;
	}
}
