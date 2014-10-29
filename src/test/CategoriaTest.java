package test;

import java.util.ArrayList;
import model.Categoria;

public class CategoriaTest {
		private ArrayList<Categoria> lista;
		
		public CategoriaTest(){
			lista = new ArrayList<Categoria>();			
		}
		
		private Categoria creaCategoria(int id, String desc){
			Categoria cat = new Categoria();
			cat.setIdCategoria(id);
			cat.setDescripcion(desc);
			return cat;
		}
		
		public void crearCategorias(){
			//genera algunas categorias por default. Después, van a depender del emisor	
			Categoria cat1 = this.creaCategoria(1, "Alimentacion");
			lista.add(cat1);
			Categoria cat2 = this.creaCategoria(2, "Sentimiento");
			lista.add(cat2);
			Categoria cat3 = this.creaCategoria(3, "Dolencias");
			lista.add(cat3);
			Categoria cat4 = this.creaCategoria(2, "Paseos y actividades");
			lista.add(cat4);		
		}
		
		public ArrayList<Categoria> retCategorias(){
			return this.lista;
		}
}
