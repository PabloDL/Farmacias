package util;

public class detalleObraSocial {
	//{ "nombre" : "OSde" }
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Obra social: " + nombre;
	}
}
