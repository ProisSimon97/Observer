package ar.unrn.parcial1.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ar.unrn.parcial1.modelo.EstacionDeServicio;
import ar.unrn.parcial1.modelo.Venta;

import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDeVentas extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DefaultTableModel modelo;
	private JPanel contentPane;

	public ConsultaDeVentas(EstacionDeServicio validaciones) {

		String[] titulos = { "FECHA", "LITROS", "MONTO" };
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Ventas");

		JTable table = new JTable();
		table.setBounds(1, 30, 250, 0);

		modelo = new DefaultTableModel(new Object[][] {}, titulos);

		table.setModel(modelo);
		contentPane.add(table, BorderLayout.CENTER);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(13, 42, 422, 218);
		getContentPane().add(scrollPane);

		List<Venta> ventas = new ArrayList<Venta>();
		
		try {
			ventas = validaciones.recuperarVentas(LocalDateTime.of(2020, Month.MAY, 7, 9, 9),
					LocalDateTime.of(2022, Month.MAY, 10, 9, 9));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

		for (Venta v : ventas) {

			modelo.addRow(
					new Object[] { v.fechaDeVenta().toString(), v.litrosCargadosEnLaVenta(), v.precioDeNaftaActual() });
		}
	}
}