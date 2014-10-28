package gui;

import gui.TableDemo.MyTableModel;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.Categoria;
import model.Categorias;
import model.Etiqueta;
import model.Etiquetas;
import model.Modelo;

public class MainWindow {
	private JFrame frame;
	private JTable table;
	private boolean DEBUG = false;
	class MyTableModel extends AbstractTableModel {
        private String[] columnNames = {"First Name",
                                        "Last Name",
                                        "Sport",
                                        "# of Years",
                                        "Vegetarian"};
        private Object[][] data = {
	    {"Kathy", "Smith",
	     "Snowboarding", new Integer(5), new Boolean(false)},
	    {"John", "Doe",
	     "Rowing", new Integer(3), new Boolean(true)},
	    {"Sue", "Black",
	     "Knitting", new Integer(2), new Boolean(false)},
	    {"Jane", "White",
	     "Speed reading", new Integer(20), new Boolean(true)},
	    {"Joe", "Brown",
	     "Pool", new Integer(10), new Boolean(false)}
        };

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if (col < 2) {
                return false;
            } else {
                return true;
            }
        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col) {
            if (DEBUG) {
                System.out.println("Setting value at " + row + "," + col
                                   + " to " + value
                                   + " (an instance of "
                                   + value.getClass() + ")");
            }

            data[row][col] = value;
            fireTableCellUpdated(row, col);

            if (DEBUG) {
                System.out.println("New value of data:");
                printDebugData();
            }
        }

        private void printDebugData() {
            int numRows = getRowCount();
            int numCols = getColumnCount();

            for (int i=0; i < numRows; i++) {
                System.out.print("    row " + i + ":");
                for (int j=0; j < numCols; j++) {
                    System.out.print("  " + data[i][j]);
                }
                System.out.println();
            }
            System.out.println("--------------------------");
        }
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}
	
	private Modelo iniciarModelo(){
		Modelo md = new Modelo();
		md.iniciar();
		return md;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		Modelo m = this.iniciarModelo();
		Categorias cats = m.getCategorias();
		Etiquetas ets = m.getEtiquetas();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 554, 357);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 537, 41);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(10, 11, 107, 23);
		panel.add(btnActualizar);
		//vamos por el jCombobox
		JComboBox comboBox = new JComboBox();
		//agrego los items que van a ser listados
		/*mientras no se termine la lista de Categorias agrego un item*/
		comboBox.addItem("Todos");
		for(Categoria c: cats.getCategorias()){
			comboBox.addItem(c);
		}		
		comboBox.setBounds(127, 12, 164, 20);
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 43, 537, 251);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		/*JTable table = new JTable(new MyTableModel());
	    table.setPreferredScrollableViewportSize(new Dimension(500, 70));
	    table.setFillsViewportHeight(true);*/
	    
		JTable table = new JTable(new MyTableModel());
		table.setBounds(133, 0, 404, 251);
		panel_1.add(table);
		//lista de etiquetas+		
		DefaultListModel listModel = new DefaultListModel();
		for (Etiqueta et: ets.getEtiquetas()){
			listModel.addElement(et);
		}
        
		JList list = new JList(listModel);
		//JList list = new JList();		
		list.setBounds(0, -1, 129, 84);
		list.setLayoutOrientation(JList.VERTICAL);						
		panel_1.add(list);
	}
}
