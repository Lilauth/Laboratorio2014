package gui;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.Panel;
import java.awt.Button;

import model.Etiqueta;
import model.Etiquetas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JList;

public class EtiquetasAdm extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;	
	private Etiquetas listadoEtiquetas;
	private JList<Etiqueta> list;

	public void setEtiquetas(Etiquetas lista){
		this.listadoEtiquetas = lista;
		this.recargarLista(list);
	}
	
	public Etiquetas getEtiquetas() {
		return listadoEtiquetas;
	}
	
	public EtiquetasAdm() {
		listadoEtiquetas = new Etiquetas();
		
		setTitle("Etiquetas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel pAcciones = new Panel();
		pAcciones.setBounds(0, 0, 434, 48);
		contentPane.add(pAcciones);
		pAcciones.setLayout(null);
		
		Button bAgregar = new Button("Agregar");
		bAgregar.addActionListener(new EtiquetaABMListener(listadoEtiquetas, (new Etiqueta()), 'A'));
		bAgregar.setBounds(10, 16, 70, 22);
		pAcciones.add(bAgregar);
		
		Button bModificar = new Button("Modificar");
		bModificar.addActionListener(new EtiquetaABMListener(listadoEtiquetas, (new Etiqueta()), 'M'));
		bModificar.setBounds(99, 16, 70, 22);
		pAcciones.add(bModificar);
		
		Button bEliminar = new Button("Eliminar");
		bEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//elimina la etiqueta seleccionada
			}
		});
		bEliminar.setBounds(189, 16, 70, 22);
		pAcciones.add(bEliminar);
		
		Button bCerrar = new Button("Cerrar");
		bCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		bCerrar.setBounds(354, 16, 70, 22);
		pAcciones.add(bCerrar);
		
		Panel panel = new Panel();
		panel.setBounds(0, 54, 434, 208);
		contentPane.add(panel);
		panel.setLayout(null);
		
		list = new JList<Etiqueta>();
		list.setBounds(0, 0, 434, 208);
		panel.add(list);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 208);
		panel.add(scrollPane);
	}	
	//funciones que modifican la vista
	private void recargarLista(JList<Etiqueta> listado){
		DefaultListModel<Etiqueta> modelo = new DefaultListModel<Etiqueta>();
		listado.setModel(modelo);
		ArrayList<Etiqueta> lista = listadoEtiquetas.getEtiquetas();
		for(Etiqueta e: lista){
			modelo.addElement(e);
		}
	}
	
	/*clase internas que puedo llegar a necesitar*/
	public class EtiquetaABMListener implements ActionListener{
		Etiquetas listaEtiquetas;
		Etiqueta e;
		char oper;
		
		public EtiquetaABMListener(Etiquetas lista, Etiqueta e,  char oper) {
			listaEtiquetas = lista;
			this.oper = oper;
			this.e = e;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {			
			//ABM de etiquetas
			EtiquetaABM abmEtiquetas = new EtiquetaABM();
			abmEtiquetas.configurar(listaEtiquetas, e, oper);
			abmEtiquetas.setVisible(true);
			abmEtiquetas.setAlwaysOnTop(true);				
		}
		
	}
}
