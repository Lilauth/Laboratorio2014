package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

import java.awt.Panel;
import java.awt.Button;
import model.Etiquetas;

public class EtiquetasAdm extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tEtiquetas;
	
	private Etiquetas listadoEtiquetas;

	public void setEtiquetas(Etiquetas lista){
		this.listadoEtiquetas = lista;
	}
	
	public Etiquetas getEtiquetas() {
		return listadoEtiquetas;
	}
	
	public EtiquetasAdm() {
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
		bAgregar.setBounds(10, 16, 70, 22);
		pAcciones.add(bAgregar);
		
		Button bModificar = new Button("Modificar");
		bModificar.setBounds(99, 16, 70, 22);
		pAcciones.add(bModificar);
		
		Button bEliminar = new Button("Eliminar");
		bEliminar.setBounds(189, 16, 70, 22);
		pAcciones.add(bEliminar);
		
		Panel panel = new Panel();
		panel.setBounds(0, 54, 434, 208);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 208);
		panel.add(scrollPane);
		
		tEtiquetas = new JTable();
		tEtiquetas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {"Código", "Descripción"
			}
		));
		scrollPane.setViewportView(tEtiquetas);
		DefaultTableModel tm = (DefaultTableModel) tEtiquetas.getModel();
		tm.addRow(new Object[]{"v1", "v2"});
	}	
}
