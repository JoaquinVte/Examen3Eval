package swing;

import listas.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MiVentana extends JFrame {

	private JPanel contentPane;
	private ListaDoblementeEnlazada listaCoches = new ListaDoblementeEnlazada();
	private JComboBox comboBox;
	private JSpinner spinner;
	private JRadioButton rdbtnTurismo;
	private JRadioButton rdbtnIndustrial;
	private JTextField txtFiledPropietario;
	private JTextField txtFieldMatricula;
	private JTextField txtFieldModelo;
	private Nodo nodoAux;
	private JButton btnAnterior;
	private JButton btnAnyadir;
	private JButton btnSiguiente;
	private JButton btnNuevo;
	private JButton btnTostring;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiVentana frame = new MiVentana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MiVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 365);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mItemCargar = new JMenuItem("Cargar");
		mItemCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser file = new JFileChooser();
				int accionUsuario = file.showOpenDialog(MiVentana.this);
			      if (accionUsuario == JFileChooser.APPROVE_OPTION) {
			        listaCoches.setFile(file.getSelectedFile());			        
			        try{
			        listaCoches.cargar();
			        JOptionPane.showMessageDialog(null, "Lista cargada correctamente");
			        nodoAux=listaCoches.getCabeza();
			        if(nodoAux!=null){
			        	mostrarCoche((Coche)nodoAux.getInfo());
			        	hDContenPane(false);
			        	btnAnterior.setEnabled(false);
			        	if (nodoAux==listaCoches.getCola()) btnSiguiente.setEnabled(false);
			        	else btnSiguiente.setEnabled(true);
			        }
			        }catch (Exception excep){
			        	System.out.println(excep);
			        }
			      }	
			}
		});
		mnFile.add(mItemCargar);
		
		JMenuItem mItemGuardar = new JMenuItem("Guardar");
		mItemGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
				int accionUsuario = file.showOpenDialog(MiVentana.this);
			      if (accionUsuario == JFileChooser.APPROVE_OPTION) {
			        listaCoches.setFile(file.getSelectedFile());
			        try{
			        listaCoches.guardar();
			        JOptionPane.showMessageDialog(null, "Lista guardada correctamente");
			        }catch (Exception excep){
			        	System.out.println(excep);
			        }
			      }				
			}
		});
		mnFile.add(mItemGuardar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblMatricula = new JLabel("Matricula");
		
		JLabel lblModelo = new JLabel("Modelo");
		
		JLabel lblMarca = new JLabel("Marca");
		
		JLabel lblCaballos = new JLabel("Caballos");
		
		JLabel lblPropietario = new JLabel("Propietario");
		
		txtFieldMatricula = new JTextField();
		txtFieldMatricula.setEnabled(false);
		txtFieldMatricula.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Audi", "Mercedes", "Opel", "Renault", "Seat", "VolksWagen"}));
		
		txtFieldModelo = new JTextField();
		txtFieldModelo.setEnabled(false);
		txtFieldModelo.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		
		spinner = new JSpinner();
		spinner.setEnabled(false);
		spinner.setModel(new SpinnerNumberModel(70, 70, 200, 5));
		
		rdbtnTurismo = new JRadioButton("Turismo");
		rdbtnTurismo.setEnabled(false);
		rdbtnTurismo.setSelected(true);
		
		rdbtnIndustrial = new JRadioButton("Industrial");
		rdbtnIndustrial.setEnabled(false);
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnTurismo);
		btnGroup.add(rdbtnIndustrial);
		
		txtFiledPropietario = new JTextField();
		txtFiledPropietario.setEnabled(false);
		txtFiledPropietario.setColumns(10);
		
		btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSiguiente.setEnabled(true);
				nodoAux=nodoAux.getAnterior();
				if (nodoAux==listaCoches.getCabeza()) btnAnterior.setEnabled(false);
				mostrarCoche((Coche)nodoAux.getInfo());
			}
		});
		btnAnterior.setEnabled(false);
		
		btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAnterior.setEnabled(true);
				nodoAux=nodoAux.getSiguiente();
				if (nodoAux==listaCoches.getCola()) btnSiguiente.setEnabled(false);
				mostrarCoche((Coche)nodoAux.getInfo());
			}
		});
		btnSiguiente.setEnabled(false);
		
		btnAnyadir = new JButton("Añadir");
		btnAnyadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnNuevo.setEnabled(true);
				String tipo="Turismo";
				if(rdbtnIndustrial.isSelected()) tipo="Industrial";
				Coche coche=new Coche(comboBox.getSelectedItem().toString(),txtFieldModelo.getText(),(Integer)spinner.getValue(),txtFieldMatricula.getText(),tipo,txtFiledPropietario.getText());
				nodoAux=new Nodo(coche);
				listaCoches.insertarCola(nodoAux);
				JOptionPane.showMessageDialog(null, "Coche añadido.");
				hDContenPane(false);
				btnAnyadir.setEnabled(false);
				if (listaCoches.getCabeza()!=nodoAux) btnAnterior.setEnabled(true);
				btnSiguiente.setEnabled(false);
			}
		});
		btnAnyadir.setEnabled(false);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarCampos();
				hDContenPane(true);
				btnAnyadir.setEnabled(true);
				btnNuevo.setEnabled(false);
				btnSiguiente.setEnabled(false);
				btnAnterior.setEnabled(false);
			}
		});
		
		btnTostring = new JButton("toString");
		btnTostring.setVisible(false);
		btnTostring.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(listaCoches.toString());
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPropietario)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMatricula)
								.addComponent(lblMarca)
								.addComponent(lblModelo)
								.addComponent(lblCaballos)
								.addComponent(lblTipo))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(rdbtnTurismo)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(rdbtnIndustrial))
								.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtFieldModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txtFieldMatricula))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnTostring))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAnterior)
							.addGap(18)
							.addComponent(btnAnyadir)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNuevo)
							.addGap(18)
							.addComponent(btnSiguiente))
						.addComponent(txtFiledPropietario, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMatricula)
						.addComponent(txtFieldMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTostring))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMarca)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblModelo)
						.addComponent(txtFieldModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCaballos)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipo)
						.addComponent(rdbtnTurismo)
						.addComponent(rdbtnIndustrial))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblPropietario)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtFiledPropietario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAnterior)
						.addComponent(btnAnyadir)
						.addComponent(btnNuevo)
						.addComponent(btnSiguiente))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	private void hDContenPane(boolean b){
		comboBox.setEnabled(b);
		spinner.setEnabled(b);
		rdbtnTurismo.setEnabled(b);
		rdbtnIndustrial.setEnabled(b);
		txtFiledPropietario.setEnabled(b);
		txtFieldMatricula.setEnabled(b);
		txtFieldModelo.setEnabled(b);
	}
	private void mostrarCoche(Coche c){
		comboBox.setSelectedItem(c.getMarca());
		spinner.setValue(c.getCaballos());
		if (c.getTipo().compareTo("Turismo")==0) rdbtnTurismo.setSelected(true);
		else rdbtnIndustrial.setSelected(true);		
		txtFiledPropietario.setText(c.getPropietario());;
		txtFieldMatricula.setText(c.getMatricula());
		txtFieldModelo.setText(c.getModelo());
	}
	private void limpiarCampos(){
		comboBox.setSelectedItem("Audi");
		spinner.setValue(70);
		rdbtnTurismo.setSelected(true);	
		txtFiledPropietario.setText("");;
		txtFieldMatricula.setText("");
		txtFieldModelo.setText("");
	}
}
