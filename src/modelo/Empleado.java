package modelo;

public class Empleado {
	
	private int idEmpleado;
	private String nombre;
	private String apellido;
	private String cuil;
	private ObraSocial obraSocial;
	private Domicilio domicilio;
	
	public Empleado() {
		this.idEmpleado = 0;
		this.nombre = null;
		this.apellido = null;
		this.cuil = null;
		this.obraSocial = null;
		this.domicilio = null;
	}
	
	
	public Empleado(int idEmpleado, String nombre, String apellido, String cuil, ObraSocial obraSocial,
			Domicilio domicilio) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuil = cuil;
		this.obraSocial = obraSocial;
		this.domicilio = domicilio;
	}


	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellido=" + apellido + ", cuil=" + cuil
				+ ", obraSocial=" + obraSocial + ", domicilio=" + domicilio + "]";
	}


	public int getIdEmpleado() {
		return idEmpleado;
	}


	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getCuil() {
		return cuil;
	}


	public void setCuil(String cuil) {
		this.cuil = cuil;
	}


	public ObraSocial getObraSocial() {
		return obraSocial;
	}


	public void setObraSocial(ObraSocial obraSocial) {
		this.obraSocial = obraSocial;
	}


	public Domicilio getDomicilio() {
		return domicilio;
	}


	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	
		

}
