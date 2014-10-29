package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Emisores {
	private ArrayList<Emisor> lista;
	
	public Emisores(){
		lista = new ArrayList<Emisor>();
	}
	
	public void setEmisores(ArrayList<Emisor> lista){
		this.lista = lista;
	}
	
	public void listar(){
		//lista todas las categorias cargadaen lista
		for(Emisor c: lista){
			System.out.println(c.getNombre());
		}
	}
	
	public Emisor getEmisor(int id){
		int i = 0;
		Boolean ok = false;
		while((i < lista.size()) && (!ok)){
			if(lista.get(i).getIdEmisor() == id){
				ok = true;
			}
			else{
			i++;
			}
		}	
		if(ok){
			return lista.get(i);
		}
		else{
			return null;
		}
	}
	
	private boolean existeEmisor(Emisor em){
		int i = 0;
		Boolean ok = false;
		while((i < lista.size()) && (!ok)){
			if(lista.get(i).getNombre() == em.getNombre()){
				ok = true;
			}
			else{
				i++;
			}
		}
		return ok;
	}
	
	public ArrayList<Emisor> getEmisores(){
		return this.lista;
	}
	
	public void agregarEmisor(Emisor em){
		//si no existe la etiqueta la agrego. Compara por descripcion
		if (!existeEmisor(em)){
			lista.add(em);
		}
	}
	
	public void eliminarEmisor(Emisor em){
		lista.remove(em);
	}
	
	/*métodos que tienen que ver con manejo de archivos*/
	public void persistir(){		
		ObjectOutputStream salida = null;
		try {
			salida = new ObjectOutputStream(new FileOutputStream("emisores.dat"));
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
	public Emisores recuperar(){			
		lista.clear();		
		ObjectInputStream entrada = null;
		try{
			entrada= new ObjectInputStream(new FileInputStream("emisores.dat"));
			lista =  (ArrayList<Emisor>)entrada.readObject();			
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
