package util;

public class _Id {
	//{ "_id" : { "sucursal" : 1.0, "productos" : { "producto" : { "tipo" : "Farmacia", "descripcion" : "Ibuprofeno" } } }, "Total venta" : 300.0, "Cantidad vendida" : 3.0 }
	private int sucursal;
	private DetalleProductos producto;
	
	public _Id() {
		super();
		this.sucursal = -1;
	}
	public int getSucursal() {
		return sucursal;
	}
	public void setSucursal(int sucursal) {
		this.sucursal = sucursal;
	}
	public DetalleProductos getProducto() {
		return producto;
	}
	public void setProducto(DetalleProductos producto) {
		this.producto = producto;
	}
	
	@Override
	public String toString() {
		if (sucursal == -1) {
			return  producto.toString();
		}
		return "Sucursal N° " + sucursal + " | " + producto.toString();
	}
	
}
