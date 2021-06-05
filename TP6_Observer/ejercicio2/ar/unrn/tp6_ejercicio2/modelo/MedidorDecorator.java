package ar.unrn.tp6_ejercicio2.modelo;

import java.util.List;

public class MedidorDecorator extends Observable implements Medidor {

	private String temperatura;
	private Medidor medidor;
	
	public MedidorDecorator(List<Observer> observadores, Medidor medidor) {
		
		this.medidor = medidor;
		
		for(Observer obs : observadores)
			this.agregarObservador(obs);
	}
	
	@Override
	public String leerTemperatura() {
		// TODO Auto-generated method stub
		this.temperatura = this.medidor.leerTemperatura();
		
		this.notificar(temperatura);
		
		return this.temperatura;
	}
}
