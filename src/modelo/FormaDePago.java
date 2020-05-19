package modelo;

public class FormaDePago {
	private int idFormaDePago;
	private String descripcion;

	public FormaDePago(int idFormaDePago, String descripcion) {
		super();
		this.idFormaDePago = idFormaDePago;
		this.descripcion = descripcion;
	}

	public int getIdFormaDePago() {
		return idFormaDePago;
	}

	protected void setIdFormaDePago(int idFormaDePago) {
		this.idFormaDePago = idFormaDePago;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
