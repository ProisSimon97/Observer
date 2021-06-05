package ar.unrn.parcial1.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ar.unrn.parcial1.modelo.ValidacionException;
import ar.unrn.parcial1.modelo.EstacionDeServicio;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;

public class CargaDeNafta extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField LitrosTextField;
	private JTextField montoTextField;
	private JTextField emailTextField;

	public CargaDeNafta(EstacionDeServicio validaciones) {
		getContentPane().setLayout(null);

		setTitle("Carga de Nafta");
		setBounds(100, 100, 275, 316);

		JLabel lblNewLabel = new JLabel("Litros Cargados:");
		lblNewLabel.setBounds(10, 30, 126, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tipo de Nafta: ");
		lblNewLabel_1.setBounds(10, 84, 126, 18);
		getContentPane().add(lblNewLabel_1);

		LitrosTextField = new JTextField();
		LitrosTextField.setBounds(146, 27, 43, 20);
		getContentPane().add(LitrosTextField);
		LitrosTextField.setColumns(10);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(146, 80, 75, 22);
		getContentPane().add(comboBox);

		comboBox.addItem("SUPER");
		comboBox.addItem("COMUN");

		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					validaciones.guardarVenta(comboBox.getSelectedItem().toString(),
							Integer.parseInt(LitrosTextField.getText()), LocalDateTime.now(), emailTextField.getText());

				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}

				JOptionPane.showMessageDialog(null, "Se guardo con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);

				setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 243, 89, 23);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(146, 243, 89, 23);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Consultar Monto");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					montoTextField.setText(String.valueOf(validaciones.calcular(comboBox.getSelectedItem().toString(),
							Integer.parseInt(LitrosTextField.getText()), LocalDateTime.now())));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (ValidacionException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2.setBounds(11, 138, 128, 23);
		getContentPane().add(btnNewButton_2);

		montoTextField = new JTextField();
		montoTextField.setBounds(165, 139, 43, 20);
		getContentPane().add(montoTextField);
		montoTextField.setColumns(10);
		
		JLabel emailLabel = new JLabel("Email: ");
		emailLabel.setBounds(10, 196, 54, 14);
		getContentPane().add(emailLabel);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(74, 193, 147, 20);
		getContentPane().add(emailTextField);
		emailTextField.setColumns(10);
	}
}