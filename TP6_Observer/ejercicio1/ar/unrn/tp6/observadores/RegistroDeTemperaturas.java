package ar.unrn.tp6.observadores;

import java.util.List;

import ar.unrn.tp6.modelo.Medidor;
import ar.unrn.tp6.modelo.Observer;
import ar.unrn.tp6.modelo.WeatherChannelService;

public class RegistroDeTemperaturas {

	private List<Observer> observadores;

	public RegistroDeTemperaturas(List<Observer> obs) {
		
		this.observadores = obs;
	}
	
	public void informarTemperatura() {
		
		Medidor medidor = new Medidor(new WeatherChannelService(), this.observadores);
		
		medidor.leerTemperatura();
	}
}
