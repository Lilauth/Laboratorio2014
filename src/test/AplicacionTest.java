package test;

import model.Categorias;
import model.Emisores;
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
		
		EmisoresTest emtest = new EmisoresTest();
		emtest.crearEmisores();
		Emisores listaEmisores = new Emisores();
		listaEmisores.setEmisores(emtest.retEmisores());
		
		listaEtiquetas.persistir();
		listaCat.persistir();
		listaEmisores.persistir();
				
		Modelo md = new Modelo();
		md.iniciar();
	}

}
