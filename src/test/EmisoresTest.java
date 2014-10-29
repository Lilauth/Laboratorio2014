package test;

import java.util.ArrayList;

import model.Emisor;

public class EmisoresTest {
	private ArrayList<Emisor> lista;
	
	public EmisoresTest(){
		lista = new ArrayList<Emisor>();			
	}
	
	private static Emisor creaEmisor(int id, String nombre){
		Emisor em = new Emisor();
		em.setIdEmisor(id);
		em.setNombre(nombre);
		return em;
	}
	
	public void crearEmisores(){
		//genera algunas categorias por default. Después, van a depender del emisor	
		Emisor em1 = creaEmisor(1, "Juan");
		lista.add(em1);
		Emisor em2 = creaEmisor(1, "Pedro");
		lista.add(em2);		
	}
	
	public ArrayList<Emisor> retEmisores(){
		return this.lista;
	}
}
