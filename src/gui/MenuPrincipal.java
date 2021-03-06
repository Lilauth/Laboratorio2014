package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import model.Modelo;
import model.Etiquetas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal {
	private JFrame frmAdministracinDeNotificaciones;
	private static boolean cargaDeArchivo = false;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Modelo md;
				md = new Modelo();
				try {
					if(cargaDeArchivo){
						md.iniciar();
					}
					else{
						md.recuperarDatosGuardados();
					}
					MenuPrincipal window = new MenuPrincipal(md);
					window.frmAdministracinDeNotificaciones.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPrincipal(Modelo md) {
		initialize(md);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Modelo md) {
		frmAdministracinDeNotificaciones = new JFrame();
		frmAdministracinDeNotificaciones.setTitle("Administraci\u00F3n de Notificaciones");
		frmAdministracinDeNotificaciones.setBounds(100, 100, 644, 318);
		frmAdministracinDeNotificaciones.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmAdministracinDeNotificaciones.setJMenuBar(menuBar);
		
		JMenu mnAdmin = new JMenu("Administraci\u00F3n ");
		menuBar.add(mnAdmin);
		
		JMenuItem miEtiquetasABM = new JMenuItem("ABM de Etiquetas");
		//Administración de etiquetas
		miEtiquetasABM.addActionListener(new ListadoEtiquetas(md.getEtiquetas()));
		mnAdmin.add(miEtiquetasABM);
		
		JMenuItem miCategoriasABM = new JMenuItem("ABM de Categor\u00EDas");
		mnAdmin.add(miCategoriasABM);
		
		JMenuItem miNotificaciones = new JMenuItem("Listado de Notificaciones");
		miNotificaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//este es el action del menu
			}
		});
		mnAdmin.add(miNotificaciones);
		
		JMenu mnAcercaDe = new JMenu("Acerca de...");
		menuBar.add(mnAcercaDe);
		
		JMenuItem miAcercaDe = new JMenuItem("Esta aplicaci\u00F3n");
		mnAcercaDe.add(miAcercaDe);
	}
	
	/*clase internas que puedo llegar a necesitar*/
	public class ListadoEtiquetas implements ActionListener{
		Etiquetas listaEtiquetas;
		public ListadoEtiquetas(Etiquetas e) {
			listaEtiquetas = e;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {			
			//Listado de Etiquetas
			EtiquetasAdm vEtiquetas = new EtiquetasAdm();
			vEtiquetas.setVisible(true);
			vEtiquetas.setEtiquetas(listaEtiquetas);
			vEtiquetas.setAlwaysOnTop(true);
		}
		
	}

}
