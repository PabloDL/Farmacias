package modelo;

public class Cliente {
	
	private int dni;
	private String nombre;
	private String apelido;
	private Domicilio domicilio;
	private ObraSocial obraSocial;
	
	public Cliente() {
		this.dni = 0;
		this.nombre = null;
		this.apelido = null;
		this.domicilio = null;
		this.obraSocial = null;
	}
	
	public Cliente(int dni, String nombre, String apelido, Domicilio domicilio, ObraSocial obraSocial) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apelido = apelido;
		this.domicilio = domicilio;
		this.obraSocial = obraSocial;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apelido=" + apelido + ", domicilio=" + domicilio
				+ ", obraSocial=" + obraSocial + "]";
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public ObraSocial getObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(ObraSocial obraSocial) {
		this.obraSocial = obraSocial;
	}
	
	
	
	
	

}
