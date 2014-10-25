package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Etiquetas {
	/*esta clase administra la lista de etiquetas*/
	private ArrayList<Etiqueta> lista;
	
	public Etiquetas(){
		lista = new ArrayList<Etiqueta>();
	}
	
	public void listar(){
		//lista todas las categorias cargadaen lista
		for(Etiqueta e: lista){
			System.out.println(e.getDescripcion());
		}
	}
	
	private boolean existeEtiqueta(Etiqueta et){
		int i = 0;
		Boolean ok = false;
		while((i < lista.size()) && (!ok)){
			if(lista.get(i).getDescripcion() == et.getDescripcion()){
				ok = true;
			}
			i++;
		}
		return ok;
	}
	
	public void agregarEtiqueta(Etiqueta et){
		//si no existe la etiqueta la agrego. Compara por descripcion
		if (!existeEtiqueta(et)){
			lista.add(et);
		}
	}
	
	public void eliminarEtiqueta(Etiqueta et){
		lista.remove(et);
	}
	
	public Etiqueta getEtiqueta(int id){
		int i = 0;
		Boolean ok = false;
		while((i < lista.size()) && (!ok)){
			if(lista.get(i).getIdEtiqueta() == id){
				ok = true;
			}
			i++;
		}	
		if(ok){
			return lista.get(i);
		}
		else{
			return null;
		}
	}
	
	/*métodos que tienen que ver con manejo de archivos*/
	public void persistir(){		
		ObjectOutputStream salida = null;
		try {
			salida = new ObjectOutputStream(new FileOutputStream("etiquetas.dat"));			
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
	public Etiquetas recuperar(){
		//recupera las categorias persistidas y las guarda en su lista privada				
		this.lista.clear();
		
		ObjectInputStream entrada = null;
		try{		
			entrada= new ObjectInputStream(new FileInputStream("notificaciones.dat"));
			lista = (ArrayList<Etiqueta>)entrada.readObject();
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
