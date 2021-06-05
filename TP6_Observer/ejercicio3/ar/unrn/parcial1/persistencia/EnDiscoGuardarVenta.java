package ar.unrn.parcial1.persistencia;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import ar.unrn.parcial1.modelo.RegistroDeVentas;

import ar.unrn.parcial1.modelo.Venta;

public class EnDiscoGuardarVenta implements RegistroDeVentas {

	private String path;

	public EnDiscoGuardarVenta(String path) {

		this.path = path;
	}

	@Override
	public void guardarCargaDeNafta(Venta venta) throws Exception {
		// TODO Auto-generated method stub
		DateTimeFormatter largo = DateTimeFormatter.ofPattern("dd-MM-YYYY").withLocale(new Locale("es", "ES"));
		String fechaDeVenta = largo.format(venta.fechaDeVenta());

		String carga = fechaDeVenta + "," + venta.precioDeNaftaActual() + ","
				+ venta.litrosCargadosEnLaVenta().toString() + "," + venta.emailDeCliente() + "\n";

		try {
			Files.write(Paths.get(this.path), carga.getBytes(), StandardOpenOption.APPEND);
			
		} catch (IOException ex) {
			throw new Exception("No se pudo persistir", ex);
		}
	}

	@Override
	public List<Venta> recuperarVentas() throws Exception {

		List<Venta> ventas = new ArrayList<Venta>();

		try {

			List<String> lineas = Files.readAllLines(Paths.get(this.path));

			for (String venta : lineas) {

				Venta a;
				try {
					String[] split = venta.split(",");
					String fecha = split[0];
					String[] splitFecha = fecha.split("-");

					LocalDateTime fechaPrincipal = LocalDateTime.of(Integer.parseInt(splitFecha[2]),
							Integer.parseInt(splitFecha[1]), Integer.parseInt(splitFecha[0]), 0, 0);

					a = new Venta(fechaPrincipal, Double.valueOf(split[1]), Integer.valueOf(split[2]),
							String.valueOf(split[3]));
					ventas.add(a);

				} catch (Exception e1) {
					throw new Exception("No se pudo recuperar la lista", e1);
				}
			}

		} catch (IOException ex) {
			throw new Exception("No se pudo Abrir", ex);
		}

		return ventas;
	}
}