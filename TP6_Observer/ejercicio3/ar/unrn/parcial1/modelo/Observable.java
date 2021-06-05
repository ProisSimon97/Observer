package ar.unrn.parcial1.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {

	private List<Observer> observadores;
	
	public Observable() {
		observadores = new ArrayList<>();
	}
	
	public void agregarObservador(Observer obs) {
		this.observadores.add(obs);
	}
	
	protected void notificar(Venta venta) {
		
		for (Observer observer : observadores) {
			observer.actualizar(venta);
		}
	}
}
