package com.controladores;

import com.excepciones.CamposVaciosException;
import com.excepciones.IntegerInvalidoException;
import com.excepciones.ElementoNoSeleccionadoException;
import com.utils.ConexionUtils;
import com.utils.Utils;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ControladorGeneral {

	public void insertarTabla(String nombre, String aniosServicio, String cantidadEmpleados, String cantidadSedes, String servicioOfrecido, String nombreFundador) {
		if (Utils.estaVacio(nombre)
				|| Utils.estaVacio(aniosServicio)
				|| Utils.estaVacio(cantidadEmpleados)
				|| Utils.estaVacio(cantidadSedes)
				|| Utils.estaVacio(servicioOfrecido)
				|| Utils.estaVacio(nombreFundador)) {
			throw new CamposVaciosException();
		}

		if (!Utils.esInt(cantidadEmpleados)
				|| !Utils.esInt(cantidadSedes)
				|| !Utils.esInt(aniosServicio)) {
			throw new IntegerInvalidoException();
		}
		
		if (Integer.parseInt(cantidadEmpleados) < 0
				|| Integer.parseInt(cantidadSedes) < 0
				|| Integer.parseInt(aniosServicio) < 0) {
			throw new IntegerInvalidoException();
		}

		try {
			PreparedStatement ps = ConexionUtils.realizarConexion().prepareStatement("INSERT INTO empresas (nit, nombre, anios_servicio, cantidad_empleados, cantidad_sedes, servicio_ofrecido, nombre_fundador) VALUES (?, ?, ?, ? ,?, ?, ?)");
			ps.setString(1, Utils.generarNit(nombre));
			ps.setString(2, nombre);
			ps.setString(3, aniosServicio);
			ps.setString(4, cantidadEmpleados);
			ps.setString(5, cantidadSedes);
			ps.setString(6, servicioOfrecido);
			ps.setString(7, nombreFundador);
			

			ps.execute();

		} catch (SQLException ex) {
			System.err.print(ex);
		}
	}

	public ResultSet listarTabla() {
		try {
			PreparedStatement ps = ConexionUtils.realizarConexion().prepareStatement("SELECT * FROM empresas");

			return ps.executeQuery();
		} catch (SQLException ex) {
			System.err.print(ex);
		}
		return null;
	}

	public ResultSet buscarCoincidencias(String where) {
		try {
			PreparedStatement ps = ConexionUtils.realizarConexion().prepareStatement("SELECT * FROM empresas WHERE nit LIKE CONCAT('%',?,'%')");
			ps.setString(1, where);

			return ps.executeQuery();
		} catch (SQLException ex) {
			System.err.print(ex);
		}
		return null;
	}

	public ResultSet consultarNit(String nit) {
		try {
			PreparedStatement ps = ConexionUtils.realizarConexion().prepareStatement("SELECT * FROM empresas WHERE nit = ?");
			ps.setString(1, nit);

			return ps.executeQuery();
		} catch (SQLException ex) {
			System.err.print(ex);
		}
		return null;
	}

	public void actualizarTabla(String nit, String nombre, String aniosServicio, String cantidadEmpleados, String cantidadSedes, String servicioOfrecido, String nombreFundador) {
		if (Utils.estaVacio(nit)) {
			throw new ElementoNoSeleccionadoException();
		}

		if (Utils.estaVacio(nombre)
				|| Utils.estaVacio(aniosServicio)
				|| Utils.estaVacio(cantidadEmpleados)
				|| Utils.estaVacio(cantidadSedes)
				|| Utils.estaVacio(servicioOfrecido)
				|| Utils.estaVacio(nombreFundador)) {
			throw new CamposVaciosException();
		}

		if (!Utils.esInt(cantidadEmpleados)
				|| !Utils.esInt(cantidadSedes)
				|| !Utils.esInt(aniosServicio)) {
			throw new IntegerInvalidoException();
		}
		
		if (Integer.parseInt(cantidadEmpleados) < 0
				|| Integer.parseInt(cantidadSedes) < 0
				|| Integer.parseInt(aniosServicio) < 0) {
			throw new IntegerInvalidoException();
		}

		try {
			PreparedStatement ps = ConexionUtils.realizarConexion().prepareStatement("UPDATE empresas SET nombre = ?, anios_servicio = ?, cantidad_empleados = ?, cantidad_sedes = ?, servicio_ofrecido = ?, nombre_fundador = ? WHERE nit = ?");
			ps.setString(1, nombre);
			ps.setString(2, aniosServicio);
			ps.setString(3, cantidadEmpleados);
			ps.setString(4, cantidadSedes);
			ps.setString(5, servicioOfrecido);
			ps.setString(6, nombreFundador);
			ps.setString(7, nit);

			ps.execute();

		} catch (SQLException ex) {
			System.err.print(ex);
		}
	}

	public void eliminarTabla(String nit) {
		if (Utils.estaVacio(nit)) {
			throw new ElementoNoSeleccionadoException();
		}

		try {
			PreparedStatement ps = ConexionUtils.realizarConexion().prepareStatement("DELETE FROM empresas WHERE nit = ?");
			ps.setString(1, nit);

			ps.execute();

		} catch (SQLException ex) {
			System.err.print(ex);
		}
	}
}
