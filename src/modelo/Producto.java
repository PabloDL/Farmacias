package modelo;

public class Producto {
	
	private int codigo;
	private String tipo;
	private String descripcion;
	private String laboratorio;
	private int precio;
		
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Producto(int codigo, String tipo, String descripcion, String laboratorio, int precio) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.laboratorio = laboratorio;
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", tipo=" + tipo + ", descripcion=" + descripcion + ", laboratorio="
				+ laboratorio + ", precio=" + precio + "]";
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
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
	public String getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
		
}
