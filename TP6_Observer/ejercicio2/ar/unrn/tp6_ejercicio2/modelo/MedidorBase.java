package ar.unrn.tp6_ejercicio2.modelo;

public class MedidorBase implements Medidor {

	private String temperatura;
	private ClimaOnline clima;

	public MedidorBase(ClimaOnline clima) {

		this.clima = clima;
	}

	public String leerTemperatura() {
		// leo la temperatura del servicio web

		this.temperatura = this.clima.temperatura();

		String temp = this.temperatura;

		return temp;
	}
}
