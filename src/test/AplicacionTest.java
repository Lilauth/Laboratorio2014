package test;

import model.Categorias;
import model.Etiquetas;
import model.Modelo;

public class AplicacionTest {

	public static void main(String[] args) {
		EtiquetasTest etest = new EtiquetasTest();
		etest.crearEtiquetas();
		
		Etiquetas listaEtiquetas = new Etiquetas();
		listaEtiquetas.setEtiquetas(etest.retEtiquetas());
		
		CategoriaTest ctest = new CategoriaTest();
		ctest.crearCategorias();
		
		Categorias listaCat = new Categorias();
		listaCat.setCategorias(ctest.retCategorias());			
		
		listaEtiquetas.persistir();
		listaCat.persistir();
		
		Modelo md = new Modelo();
		md.iniciar();
	}

}
