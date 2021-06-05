package ar.unrn.tp6_ejercicio2.observadores;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

import ar.unrn.tp6_ejercicio2.modelo.Observer;

public class ObservadorEnDisco implements Observer {

	private String path;

	public ObservadorEnDisco(String path) {

		this.path = path;
	}

	@Override
	public void actualizar(String estado) {
		// TODO Auto-generated method stub

		String texto = estado + "," + LocalDate.now() + "\n";

		try {
			Files.write(Paths.get(this.path), texto.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No se pudo persistir" + e.getMessage());
		}
	}
}