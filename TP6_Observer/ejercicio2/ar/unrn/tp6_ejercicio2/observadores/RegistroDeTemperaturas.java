package ar.unrn.tp6_ejercicio2.observadores;

import java.util.List;

import ar.unrn.tp6_ejercicio2.modelo.Medidor;
import ar.unrn.tp6_ejercicio2.modelo.MedidorBase;
import ar.unrn.tp6_ejercicio2.modelo.MedidorDecorator;
import ar.unrn.tp6_ejercicio2.modelo.Observer;
import ar.unrn.tp6_ejercicio2.modelo.WeatherChannelService;

public class RegistroDeTemperaturas {

	private List<Observer> observadores;

	public RegistroDeTemperaturas(List<Observer> obs) {
		
		this.observadores = obs;
	}
	
	public void informarTemperatura() {
		
		Medidor medidor = new MedidorDecorator(this.observadores, new MedidorBase(new WeatherChannelService()));
		
		medidor.leerTemperatura();
	}
}
