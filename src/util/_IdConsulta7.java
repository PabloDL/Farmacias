package util;

public class _IdConsulta7 {
// { "cliente" : "Juan", "apellido" : "Gomez", "dni" : 2.0 },}
	private String cliente;
	private String apellido;
	private long dni;
	
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	
	@Override
	public String toString() {
		return "Cliente: " + cliente +" " + apellido + " | dni=" + dni ;
	}
}
