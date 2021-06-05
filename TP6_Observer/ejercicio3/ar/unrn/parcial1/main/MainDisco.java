package ar.unrn.parcial1.main;

import java.util.List;

import ar.unrn.parcial1.email.ServicioMail;
import ar.unrn.parcial1.modelo.EnvioEmail;
import ar.unrn.parcial1.modelo.EstacionDeServicio;
import ar.unrn.parcial1.persistencia.EnDiscoGuardarVenta;
import ar.unrn.parcial1.ui.MenuPrincipal;

public class MainDisco {

	public static void main(String[] args) {

		MenuPrincipal menu = new MenuPrincipal(new EstacionDeServicio(new EnDiscoGuardarVenta(
				"C:\\Users\\Simón\\Downloads\\UNRN\\Materias 3ro\\OO2\\Parciales\\Parcial1\\archivo_examen.txt"),
				List.of(new EnvioEmail(new ServicioMail()))));

		menu.setVisible(true);
	}
}
