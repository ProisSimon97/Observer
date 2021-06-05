package ar.unrn.parcial1.main;

import java.util.List;

import ar.unrn.parcial1.email.ServicioMail;
import ar.unrn.parcial1.modelo.EnvioEmail;
import ar.unrn.parcial1.modelo.EstacionDeServicio;
import ar.unrn.parcial1.persistencia.EnMemoriaGuardarVenta;
import ar.unrn.parcial1.ui.MenuPrincipal;

public class MainMemoria {
	public static void main(String[] args) {

		MenuPrincipal menu = new MenuPrincipal(
				new EstacionDeServicio(new EnMemoriaGuardarVenta(), List.of(new EnvioEmail(new ServicioMail()))));

		menu.setVisible(true);
	}
}
