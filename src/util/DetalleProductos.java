package util;

public class DetalleProductos {
//"tipo" : "Farmacia", "descripcion" : "Ibuprofeno" }
	private String tipo;
	private String descripcion;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Producto: " + descripcion +  " Tipo" + tipo ;
	}
	
}
