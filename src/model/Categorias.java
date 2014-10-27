package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Categorias {
	private ArrayList<Categoria> lista;
	
	public Categorias(){
		lista = new ArrayList<Categoria>();
	}
	
	public void setCategorias(ArrayList<Categoria> lista){
		this.lista = lista;
	}
	
	public void listar(){
		//lista todas las categorias cargadaen lista
		for(Categoria c: lista){
			System.out.println(c.getDescripcion());
		}
	}
	
	public Categoria getCategoria(int id){
		int i = 0;
		Boolean ok = false;
		while((i < lista.size()) && (!ok)){
			if(lista.get(i).getIdCategoria() == id){
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
	
	private boolean existeCategoria(Categoria cat){
		int i = 0;
		Boolean ok = false;
		while((i < lista.size()) && (!ok)){
			if(lista.get(i).getDescripcion() == cat.getDescripcion()){
				ok = true;
			}
			else{
				i++;
			}
		}
		return ok;
	}
	
	public void agregarCategoria(Categoria cat){
		//si no existe la etiqueta la agrego. Compara por descripcion
		if (!existeCategoria(cat)){
			lista.add(cat);
		}
	}
	
	public void eliminarCategoria(Categoria cat){
		lista.remove(cat);
	}
	
	/*métodos que tienen que ver con manejo de archivos*/
	public void persistir(){		
		ObjectOutputStream salida = null;
		try {
			salida = new ObjectOutputStream(new FileOutputStream("categorias.dat"));
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
	public Categorias recuperar(){	
		lista.clear();		
		ObjectInputStream entrada = null;
		try{
			entrada= new ObjectInputStream(new FileInputStream("categorias.dat"));
			lista =  (ArrayList<Categoria>)entrada.readObject();			
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
