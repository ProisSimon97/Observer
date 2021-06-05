package ar.unrn.parcial1.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ar.unrn.parcial1.modelo.RegistroDeVentas;
import ar.unrn.parcial1.modelo.Venta;

public class PersistenciaDeVenta implements RegistroDeVentas {

	@Override
	public void guardarCargaDeNafta(Venta venta) throws Exception {
		// TODO Auto-generated method stub
		String sqlUpdate = "Insert ventas SET fecha = ? ,monto = ? ,litros = ? ,emailCliente = ?";

		try {

			Connection conexion = (Connection) Conexion.conexion();
			PreparedStatement ps = (PreparedStatement) ((java.sql.Connection) conexion).prepareStatement(sqlUpdate);

			ps.setTimestamp(1, Timestamp.valueOf(venta.fechaDeVenta()));
			ps.setDouble(2, venta.precioDeNaftaActual());
			ps.setInt(3, venta.litrosCargadosEnLaVenta());
			ps.setString(4, venta.emailDeCliente());
			
			ps.executeUpdate();
			ps.close();
			conexion.close();

		} catch (SQLException e) {
			throw new Exception("Error" + e);
		}
	}

	@Override
	public List<Venta> recuperarVentas() throws Exception {
		// TODO Auto-generated method stub

		List<Venta> ventas = new ArrayList<Venta>();

		try {

			Connection conexion = Conexion.conexion();
			Statement sent = conexion.createStatement();

			ResultSet resul = sent.executeQuery("select * from ventas");

			while (resul.next()) {

				LocalDateTime fechaPrincipal = resul.getTimestamp("fecha").toLocalDateTime();

				ventas.add(new Venta(fechaPrincipal, resul.getDouble("monto"), resul.getInt("litros"), resul.getString("emailCliente")));
			}

		} catch (SQLException e) {
			throw new Exception("Error", e);
		}

		return ventas;
	}
}