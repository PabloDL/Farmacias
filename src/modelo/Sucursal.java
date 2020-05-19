package modelo;

import modelo.Domicilio;
import modelo.Empleado;

public class Sucursal {
	private int idSucursal;
	private int ptoVenta;
	private Domicilio domicilio;
	private Empleado encargado;

	public Sucursal(int idSucursal, int ptoVenta, Domicilio domicilio, Empleado encargado) {
		super();
		this.idSucursal = idSucursal;
		this.ptoVenta = ptoVenta;
		this.domicilio = domicilio;
		this.encargado = encargado;
	}

	public int getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public int getPtoVenta() {
		return ptoVenta;
	}

	public void setPtoVenta(int ptoVenta) {
		this.ptoVenta = ptoVenta;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public Empleado getEncargado() {
		return encargado;
	}

	public void setEncargado(Empleado encargado) {
		this.encargado = encargado;
	}

}
