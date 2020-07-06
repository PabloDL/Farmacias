package util;

public class _idConsulta2 {
// { "sucursal" : 1.0, "cliente" : { "obraSocial" : { "nombre" : "OSde" } }
	private int sucursal;
	private detalleCliente cliente;
	
	public _idConsulta2() {
		super();
		this.sucursal = -1;
	}
	public int getSucursal() {
		return sucursal;
	}
	public void setSucursal(int sucursal) {
		this.sucursal = sucursal;
	}
	public detalleCliente getcliente() {
		return cliente;
	}
	public void setObraSocial(detalleCliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public String toString() {
		if (sucursal == -1)
			return "| " + cliente.toString();
		else 
			return "Sucursal: " + sucursal + "| " + cliente.toString();
	}
	
}
