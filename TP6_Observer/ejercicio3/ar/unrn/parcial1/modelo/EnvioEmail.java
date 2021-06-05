package ar.unrn.parcial1.modelo;

public class EnvioEmail implements Observer {

	private Servicio servicio;

	public EnvioEmail(Servicio servicio) {

		this.servicio = servicio;
	}

	@Override
	public void actualizar(Venta venta) {
		// TODO Auto-generated method stub
		this.servicio.enviar(
				"Se realizo una venta el dia: " + venta.fechaDeVenta() + " ,con valor de: $"
						+ venta.precioDeNaftaActual() + ", por " + venta.litrosCargadosEnLaVenta() + " litros",
				venta.emailDeCliente());
	}
}
