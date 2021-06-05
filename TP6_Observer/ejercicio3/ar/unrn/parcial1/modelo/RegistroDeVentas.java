package ar.unrn.parcial1.modelo;

import java.util.List;

public interface RegistroDeVentas {

	public void guardarCargaDeNafta(Venta venta) throws Exception;

	public List<Venta> recuperarVentas() throws Exception;

}
