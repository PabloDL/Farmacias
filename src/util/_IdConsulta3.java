package util;

public class _IdConsulta3 {
	//{ "sucursal" : 1.0, "formaDePago" : { "descripcion" : "Debito" } }
	private int sucursal;
	private detalleFormaDePago formaDePago;
	
	public _IdConsulta3() {
		super();
		this.sucursal = -1;
	}

	public int getSucursal() {
		return sucursal;
	}

	public void setSucursal(int sucursal) {
		this.sucursal = sucursal;
	}

	public detalleFormaDePago getProducto() {
		return formaDePago;
	}

	public void setProducto(detalleFormaDePago formaDePago) {
		this.formaDePago = formaDePago;
	}

	@Override
	public String toString() {
		if (sucursal == -1) {
			return  formaDePago.toString();
		}
		return "Sucursal N° " + sucursal + " | " + formaDePago.toString();
	}
	
}
