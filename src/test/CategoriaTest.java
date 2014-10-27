package test;

import java.util.ArrayList;
import model.Categoria;

public class CategoriaTest {
		private ArrayList<Categoria> lista;
		
		public CategoriaTest(){
			lista = new ArrayList<Categoria>();			
		}
		
		public void crearCategorias(){
			//genera algunas categorias por default. Después, van a depender del emisor
			Categoria cat = new Categoria();
			cat.setIdCategoria(1);
			cat.setDescripcion("Alimentacion");
			
			lista.add(cat);
			
			cat.setIdCategoria(2);
			cat.setDescripcion("Sentimiento");
			
			lista.add(cat);			
		}
		
		public ArrayList<Categoria> retCategorias(){
			return this.lista;
		}
}
