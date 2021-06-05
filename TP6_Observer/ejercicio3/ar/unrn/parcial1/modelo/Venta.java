package ar.unrn.parcial1.modelo;

import java.time.LocalDateTime;

public class Venta {

	private PrecioDeNafta precioDeNafta;
	private Fecha fecha;
	private LitrosCargados litros;
	private String email;
	
	public Venta(LocalDateTime fecha, double precio, Integer litros, String email) throws ValidacionException {

		this.fecha = new Fecha(fecha);
		this.precioDeNafta = new PrecioDeNafta(precio);
		this.litros = new LitrosCargados(litros);
		this.email = email;
	}

	public double precioDeNaftaActual() {

		double precio = this.precioDeNafta.precioDeLaNafta();

		return precio;
	}

	public LocalDateTime fechaDeVenta() {

		LocalDateTime fecha = this.fecha.fechaActual();

		return fecha;
	}

	public Integer litrosCargadosEnLaVenta() {

		Integer litros = this.litros.litrosCargados();

		return litros;
	}
	
	public String emailDeCliente() {
		
		String email = this.email;
		
		return email;
	}
}
