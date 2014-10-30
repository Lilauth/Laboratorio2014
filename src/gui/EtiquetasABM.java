package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Etiqueta;
import model.Etiquetas;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EtiquetasABM extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField edDescripcion;
	private JTextField edCodigo;
	
	Etiquetas listaEtiquetas;

	private void initComponents(){
		setTitle("ABM de Etiquetas");
		setBounds(100, 100, 452, 185);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo:");
		lblNewLabel.setBounds(21, 28, 46, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Descripci\u00F3n:");
		lblNewLabel_1.setBounds(21, 74, 81, 14);
		contentPanel.add(lblNewLabel_1);
		
		edDescripcion = new JTextField();
		edDescripcion.setBounds(97, 71, 297, 20);
		contentPanel.add(edDescripcion);
		edDescripcion.setColumns(10);
		
		edCodigo = new JTextField();
		edCodigo.setEnabled(false);
		edCodigo.setBounds(97, 25, 60, 20);
		contentPanel.add(edCodigo);
		edCodigo.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//guarda los cambios
						Etiqueta et = new Etiqueta();						
						et.setIdEtiqueta(Integer.valueOf(edCodigo.getText()));
						et.setDescripcion(edDescripcion.getText());
						listaEtiquetas.agregarEtiqueta(et);
						listaEtiquetas.persistir();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}	
	}
	
	public EtiquetasABM(java.awt.Frame parent, boolean modal, Etiquetas listaEtiquetas) {		
		super(parent, modal);		
		initComponents();
		
		this.listaEtiquetas = listaEtiquetas;
		int nextID = listaEtiquetas.nextID();
		edCodigo.setText(String.valueOf(nextID));
	}
}
