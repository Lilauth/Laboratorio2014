package test;

import java.util.ArrayList;

import model.Etiqueta;

public class EtiquetasTest {
	private ArrayList<Etiqueta> lista;
	
	public EtiquetasTest(){
		lista = new ArrayList<Etiqueta>();
	}
	
	public void crearEtiquetas(){
		//crea las etiquetas por default
		Etiqueta e;
		
		e = new Etiqueta();
		e.setIdEtiqueta(1);
		e.setDescripcion("Favorito");
		
		lista.add(e);
		
		e = new Etiqueta();
		e.setIdEtiqueta(2);
		e.setDescripcion("Importante");
		
		lista.add(e);
		
		e = new Etiqueta();
		e.setIdEtiqueta(3);
		e.setDescripcion("Urgente");
		
		lista.add(e);
		
	}
	
	public ArrayList<Etiqueta> retEtiquetas(){
		return this.lista;
	}
		
}
