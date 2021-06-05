package ar.unrn.tp6_ejercicio2.observadores;

import ar.unrn.tp6_ejercicio2.modelo.Observer;

public class ObservadorEnConsola implements Observer {

	private static final Integer DOCE_GRADOS = 12;
	private static final Integer DIECISIETE_GRADOS = 17;
	
	@Override
	public void actualizar(String estado) {
		// TODO Auto-generated method stub
		
		String[] split = estado.split(" ");
		int temperatura = Integer.parseInt(split[0]);
		
		if(temperaturaEsMenorADoceGrados(temperatura))
			System.out.println("Hace frio, se encenderá la caldera");
		
		if(temperaturaEsMayorADiecisieteGrados(temperatura))
			System.out.println("Hace calor, se encenderá el aire acondicionado");
	}

	public boolean temperaturaEsMenorADoceGrados(int temperatura) {
		
		return temperatura < DOCE_GRADOS;
	}
	
	public boolean temperaturaEsMayorADiecisieteGrados(int temperatura) {
		
		return temperatura > DIECISIETE_GRADOS;
	}
}
