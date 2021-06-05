package ar.unrn.tp6.main;

import java.util.List;

import ar.unrn.tp6.observadores.ObservadorEnConsola;
import ar.unrn.tp6.observadores.ObservadorEnDisco;
import ar.unrn.tp6.observadores.RegistroDeTemperaturas;

public class Main {

	public static void main(String[] args) {
		
		RegistroDeTemperaturas registro = new RegistroDeTemperaturas(List.of(
				new ObservadorEnDisco(
						"C:\\Users\\Simón\\Downloads\\UNRN\\Materias 3ro\\OO2\\Trabajos\\TP6\\archivo_ejercicio1.txt"),
				new ObservadorEnConsola()));
		
		registro.informarTemperatura();
	}
}
