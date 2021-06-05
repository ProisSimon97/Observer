package ar.unrn.parcial1.persistencia;

import java.util.ArrayList;
import java.util.List;

import ar.unrn.parcial1.modelo.RegistroDeVentas;
import ar.unrn.parcial1.modelo.Venta;

public class EnMemoriaGuardarVenta implements RegistroDeVentas {

	private List<Venta> registroVentas = new ArrayList<Venta>();

	@Override
	public void guardarCargaDeNafta(Venta venta) throws Exception {
		// TODO Auto-generated method stub
		registroVentas.add(venta);
	}

	@Override
	public List<Venta> recuperarVentas() throws Exception {
		// TODO Auto-generated method stub
		List<Venta> ventas = new ArrayList<Venta>();

		for (Venta venta : registroVentas) {

			try {

				ventas.add(venta);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				throw new Exception("No se pudo recuperar la lista", e1);
			}
		}

		return ventas;
	}
}