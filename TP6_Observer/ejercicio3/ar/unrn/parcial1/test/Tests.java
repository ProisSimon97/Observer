package ar.unrn.parcial1.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.junit.Test;

import ar.unrn.parcial1.email.ServicioMail;
import ar.unrn.parcial1.modelo.Comun;
import ar.unrn.parcial1.modelo.EnvioEmail;
import ar.unrn.parcial1.modelo.Nafta;
import ar.unrn.parcial1.modelo.Super;
import ar.unrn.parcial1.modelo.ValidacionException;
import ar.unrn.parcial1.modelo.EstacionDeServicio;
import ar.unrn.parcial1.modelo.Venta;
import ar.unrn.parcial1.persistencia.EnMemoriaGuardarVenta;

public class Tests {

	@Test

	public void calcularMontoDeNaftaSuperEnUnDomingoTest() throws ValidacionException {

		EstacionDeServicio v = new EstacionDeServicio(new EnMemoriaGuardarVenta(), List.of(new EnvioEmail(new ServicioMail())));

		LocalDateTime date = LocalDateTime.of(2021, Month.MAY, 8, 22, 20);

		Nafta nafta = new Super();

		Integer litros = 20;

		assertEquals(1584.0, v.calcular(nafta.tipo(), litros, date), 0.1);
	}

	@Test

	public void calcularMontoDeNaftaSuperEnUnSabadoTest() throws ValidacionException {

		EstacionDeServicio v = new EstacionDeServicio(new EnMemoriaGuardarVenta(), List.of(new EnvioEmail(new ServicioMail())));

		LocalDateTime date = LocalDateTime.of(2021, Month.MAY, 9, 22, 20);

		Nafta nafta = new Super();

		Integer litros = 20;

		assertEquals(1620.0, v.calcular(nafta.tipo(), litros, date), 0.1);
	}

	@Test

	public void calcularMontoDeNaftaComunTest() throws ValidacionException {

		EstacionDeServicio v = new EstacionDeServicio(new EnMemoriaGuardarVenta(), List.of(new EnvioEmail(new ServicioMail())));

		LocalDateTime date = LocalDateTime.of(2021, Month.MAY, 9, 9, 9);

		Nafta nafta = new Comun();

		Integer litros = 20;

		assertEquals(1330.0, v.calcular(nafta.tipo(), litros, date), 0.1);
	}

	@Test

	public void calcularMontoDeNaftaComunSinDescuentoTest() throws ValidacionException {

		EstacionDeServicio v = new EstacionDeServicio(new EnMemoriaGuardarVenta(), List.of(new EnvioEmail(new ServicioMail())));

		LocalDateTime date = LocalDateTime.of(2021, Month.MAY, 9, 11, 9);

		Nafta nafta = new Comun();

		Integer litros = 20;

		assertEquals(1400.0, v.calcular(nafta.tipo(), litros, date), 0.1);
	}

	@Test

	public void calcularMontoDeNaftaSuperSinDescuentoTest() throws ValidacionException {

		EstacionDeServicio v = new EstacionDeServicio(new EnMemoriaGuardarVenta(),List.of(new EnvioEmail(new ServicioMail())));

		LocalDateTime date = LocalDateTime.of(2021, Month.MAY, 10, 22, 20);

		Nafta nafta = new Super();

		Integer litros = 20;

		assertEquals(1800, v.calcular(nafta.tipo(), litros, date), 0.1);
	}

	@Test

	public void verificarExistenciaDeVenta() throws Exception {

		EstacionDeServicio v = new EstacionDeServicio(new EnMemoriaGuardarVenta(), List.of(new EnvioEmail(new ServicioMail())));

		v.guardarVenta("SUPER", 20, LocalDateTime.now(), "simonpreuss@gmail.com");
		
		List<Venta> ventas = v.ventas();

		assertTrue(v.existe(ventas.get(0)));
	}

	@Test

	public void verificarExistenciaDeVentaEntreDosFechas() throws Exception {

		EstacionDeServicio v = new EstacionDeServicio(new EnMemoriaGuardarVenta(), List.of(new EnvioEmail(new ServicioMail())));

		Venta venta = new Venta(LocalDateTime.now(), 20, 20, "simonpreuss@gmail.com");

		v.guardarVenta("COMUN", venta.litrosCargadosEnLaVenta(), venta.fechaDeVenta(), venta.emailDeCliente());

		assertFalse(v.recuperarVentas(LocalDateTime.of(2019, Month.MAY, 7, 9, 9),
				LocalDateTime.of(2025, Month.MAY, 20, 9, 9)).isEmpty());
	}
}