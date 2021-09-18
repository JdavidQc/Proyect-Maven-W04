package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import gestion.GestionarProducto;
import modelo.Producto;

import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegistroProducto extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtcodigo;
	private JTextField txtPrecio;
	private JTextField txtStock;
	private JTable tblProducto;
	private JLabel lblNewLabel_1;
	private JPanel panel;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTextArea txtDescripcion;
	private JLabel lblDescripcion;
	private JLabel lblNewLabel;
	private JLabel lblStock;
	private JLabel lblPrecio;
	private JLabel lblCategoria;
	private JButton btnAgregar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroProducto frame = new RegistroProducto();
					frame.setLocationRelativeTo(null);
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
	DefaultTableModel model = new DefaultTableModel();
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnConsultar;
	private JComboBox<String> cboCategoria;

	public RegistroProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBounds(10, 76, 307, 337);
		contentPane.add(panel);
		panel.setLayout(null);

		txtcodigo = new JTextField();
		txtcodigo.setEditable(false);
		txtcodigo.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtcodigo.setBounds(85, 11, 146, 30);
		panel.add(txtcodigo);
		txtcodigo.setColumns(10);

		lblNewLabel = new JLabel("CODIGO:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 12, 71, 27);
		panel.add(lblNewLabel);

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(this);
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.setForeground(new Color(230, 230, 250));
		btnAgregar.setBackground(new Color(65, 105, 225));
		btnAgregar.setBounds(26, 214, 114, 47);
		panel.add(btnAgregar);

		lblDescripcion = new JLabel("DESCRIPCION:");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescripcion.setBounds(10, 135, 104, 27);
		panel.add(lblDescripcion);

		lblStock = new JLabel("STOCK:");
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStock.setBounds(166, 52, 65, 27);
		panel.add(lblStock);

		lblPrecio = new JLabel("PRECIO:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrecio.setBounds(10, 50, 65, 30);
		panel.add(lblPrecio);

		lblCategoria = new JLabel("CATEGORIA:");
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCategoria.setBounds(10, 91, 90, 33);
		panel.add(lblCategoria);

		txtPrecio = new JTextField();
		txtPrecio.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(85, 52, 71, 30);
		panel.add(txtPrecio);

		txtStock = new JTextField();
		txtStock.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtStock.setColumns(10);
		txtStock.setBounds(225, 51, 71, 30);
		panel.add(txtStock);

		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setForeground(new Color(230, 230, 250));
		btnEliminar.setBackground(new Color(255, 102, 102));
		btnEliminar.setBounds(26, 279, 114, 47);
		panel.add(btnEliminar);

		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificar.setForeground(new Color(230, 230, 250));
		btnModificar.setBackground(new Color(255, 255, 102));
		btnModificar.setBounds(166, 279, 114, 47);
		panel.add(btnModificar);

		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(this);
		btnConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultar.setForeground(new Color(230, 230, 250));
		btnConsultar.setBackground(new Color(105, 105, 105));
		btnConsultar.setBounds(166, 214, 114, 47);
		panel.add(btnConsultar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(110, 135, 186, 64);
		panel.add(scrollPane);

		txtDescripcion = new JTextArea();
		txtDescripcion.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setViewportView(txtDescripcion);

		cboCategoria = new JComboBox<String>();
		cboCategoria.setModel(new DefaultComboBoxModel<String>(new String[] { "Seleccione","1", "2", "3" ,"4","5"}));
		cboCategoria.setBounds(110, 97, 186, 30);
		panel.add(cboCategoria);
		
		btnLimipiar = new JButton("New button");
		btnLimipiar.addActionListener(this);
		btnLimipiar.setBounds(241, 15, 44, 23);
		panel.add(btnLimipiar);

		lblNewLabel_1 = new JLabel("Registro Producto");
		lblNewLabel_1.setForeground(new Color(230, 230, 250));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(112, 128, 144));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 740, 54);
		contentPane.add(lblNewLabel_1);

		panel_1 = new JPanel();
		panel_1.setBounds(327, 77, 423, 336);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 408, 314);
		panel_1.add(scrollPane_1);

		tblProducto = new JTable();
		scrollPane_1.setViewportView(tblProducto);

		model.addColumn("ID CODIGO");
		model.addColumn("DESCRIPCION");
		model.addColumn("STOCK");
		model.addColumn("PRECIO");
		model.addColumn("CATEGORIA");
		tblProducto.setModel(model);
		

		listaProducto();
		limpiar();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLimipiar) {
			actionPerformedBtnLimipiar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
	}

	GestionarProducto gP = new GestionarProducto();
	private JButton btnLimipiar;
private void limpiar() {
	txtcodigo.setText(gP.getCodigoCorrolativo());
	txtDescripcion.setText(null);
	txtPrecio.setText(null);
	txtStock.setText(null);
	cboCategoria.setSelectedIndex(0);
	
}
	private void listaProducto() {
		model.setRowCount(0);
		for (Producto p : gP.listarProducto()) {
			Object fila[] = { p.getIdProducto(), p.getDescripcion(), p.getStock(), p.getPrecio(), p.getIdCategoria() };
			model.addRow(fila);
		}
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int res = JOptionPane.showConfirmDialog(null, "Eliminar el producto?");
		if (res == JOptionPane.YES_OPTION) {
			if (gP.EliminarProducto(txtcodigo.getText())) {
				JOptionPane.showMessageDialog(null, "Elimino Correctamente");
				limpiar();
				listaProducto();
			}else {

				JOptionPane.showMessageDialog(null,"Error al eliminar");
			}
			
		}

	}

	protected void actionPerformedBtnConsultar(ActionEvent e) {
		String codigo = JOptionPane.showInputDialog("Ingrese Codigo");
		Producto p = gP.consultarProducto(codigo);
		if (!(p == null)) {
			txtcodigo.setText(p.getIdProducto());
			txtPrecio.setText(String.valueOf(p.getPrecio()));
			txtStock.setText(String.valueOf(p.getStock()));
			txtDescripcion.setText(String.valueOf(p.getDescripcion()));
			cboCategoria.setSelectedIndex(p.getIdCategoria());
		}else {
			JOptionPane.showMessageDialog(null,"El Codigo "+txtcodigo.getText().trim()+" no existe");
		}
	}

	protected void actionPerformedBtnAgregar(ActionEvent e) {
		if (gP.AgregarProducto(new Producto(txtcodigo.getText().trim(), txtDescripcion.getText().trim(),
				Integer.parseInt(txtStock.getText().trim()), Double.parseDouble(txtPrecio.getText().trim()),
				Integer.parseInt(cboCategoria.getSelectedItem().toString()),1))) {
			JOptionPane.showMessageDialog(null, "Se Agrego Correctamente");
			limpiar();
			listaProducto();
		}else {

			
		}	

	}

	protected void actionPerformedBtnModificar(ActionEvent e) {
		if (gP.ModificarProducto(new Producto(txtcodigo.getText().trim(), txtDescripcion.getText().trim(),
				Integer.parseInt(txtStock.getText().trim()), Double.parseDouble(txtPrecio.getText().trim()),
				Integer.parseInt(cboCategoria.getSelectedItem().toString()),1))) {
			JOptionPane.showMessageDialog(null, "Se Modifico Correctamente");
			limpiar();
			listaProducto();
		}else {

			JOptionPane.showMessageDialog(null,"Error al Modifico");
		}

	}
	protected void actionPerformedBtnLimipiar(ActionEvent e) {
		limpiar();
	}
}
