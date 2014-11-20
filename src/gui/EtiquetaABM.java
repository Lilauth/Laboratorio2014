package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Etiqueta;
import model.Etiquetas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EtiquetaABM extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField edCodigo;
	private JTextField edDescrip;
	private JButton okButton;
	
	private Etiquetas lista;
	private Etiqueta et;

	/**
	 * Create the dialog.
	 */
	public void configurar(Etiquetas lista, Etiqueta e,  char oper){
		this.lista = lista;
		this.et = e;
		
		if(oper == 'M'){ 
			//abre la ventana para modificacion y carga los controles
			edCodigo.setText(String.valueOf(et.getIdEtiqueta()));
			edDescrip.setText(et.getDescripcion());
			lista.eliminarEtiqueta(e);
		}	
		
	}
	
	public EtiquetaABM() {
		setTitle("ABM de Etiqueta");
		setBounds(100, 100, 448, 196);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(24, 35, 46, 14);
		contentPanel.add(lblCdigo);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(24, 89, 74, 14);
		contentPanel.add(lblDescripcin);
		
		edCodigo = new JTextField();
		edCodigo.setBounds(109, 32, 86, 20);
		contentPanel.add(edCodigo);
		edCodigo.setColumns(10);
		
		edDescrip = new JTextField();
		edDescrip.setBounds(109, 86, 181, 20);
		contentPanel.add(edDescrip);
		edDescrip.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");				
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						et.setDescripcion(edDescrip.getText());
						et.setIdEtiqueta(Integer.valueOf(edCodigo.getText()));
						if(lista.existeEtiqueta(et)){
							JOptionPane.showMessageDialog(contentPanel, "el elemento ya existe", "error de aceptar", JOptionPane.ERROR_MESSAGE);
						}
						else{
							lista.agregarEtiqueta(et);
							lista.persistir();
							dispose();
						}	
					}
				});
				//okButton.addActionListener(new Aceptar(lista, et));				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//si el oper es 'M' vuelve a agregar la etiqueta a la lista
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
}
