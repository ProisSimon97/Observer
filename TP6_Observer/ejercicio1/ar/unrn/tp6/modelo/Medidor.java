package ar.unrn.tp6.modelo;

import java.util.List;

public class Medidor extends Observable {// SujetoConcreto?

	private String temperatura;
	private ClimaOnline clima;

	public Medidor(ClimaOnline clima, List<Observer> observadores) {

		this.clima = clima;

		for (Observer observer : observadores) {
			this.agregarObservador(observer);
		}
	}

	public String leerTemperatura() {
		// leo la temperatura del servicio web

		this.temperatura = this.clima.temperatura();

		this.notificar(this.temperatura);

		String temp = this.temperatura;

		return temp;
	}
}
