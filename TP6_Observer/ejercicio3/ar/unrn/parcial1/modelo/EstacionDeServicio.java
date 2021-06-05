package ar.unrn.parcial1.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EstacionDeServicio extends Observable {

	private static final String SUPER = "SUPER";
	private static final String COMUN = "C";

	RegistroDeVentas registro;

	public EstacionDeServicio(RegistroDeVentas registro, List<Observer> observadores) {

		this.registro = registro;

		for (Observer observer : observadores) {
			this.agregarObservador(observer);
		}
	}

	public double calcular(String nafta, Integer litros, LocalDateTime fecha) throws ValidacionException {

		Nafta combustible = null;

		if (esSuper(nafta))
			combustible = new Super();

		if (esComun(nafta))
			combustible = new Comun();

		return combustible.aplicarDescuento(litros, combustible.precio(), fecha);
	}

	public boolean existe(Venta venta) throws Exception {

		List<Venta> ventas = registro.recuperarVentas();

		return ventas.contains(venta);
	}

	public List<Venta> recuperarVentas(LocalDateTime inicio, LocalDateTime fin) throws Exception {

		List<Venta> ventas = registro.recuperarVentas();

		List<Venta> ventas2 = new ArrayList<Venta>();

		for (Venta venta : ventas) {

			if (venta.fechaDeVenta().isBefore(fin) && venta.fechaDeVenta().isAfter(inicio))
				ventas2.add(venta);
		}

		return ventas2;
	}

	public List<Venta> ventas() throws Exception {

		return registro.recuperarVentas();
	}

	public void guardarVenta(String tipoDeVenta, Integer litros, LocalDateTime fecha, String email) throws Exception {

		double precio = this.calcular(tipoDeVenta, litros, fecha);

		Venta venta = new Venta(fecha, precio, litros, email);

		registro.guardarCargaDeNafta(venta);

		this.notificar(venta);
	}

	public boolean esSuper(String nafta) {

		if (nafta.contentEquals(SUPER))
			return true;

		return false;
	}

	public boolean esComun(String nafta) {

		if (nafta.contentEquals(COMUN))
			return true;

		return false;
	}
}