package util;

public class detalleCliente {
//{ "obraSocial" : { "nombre" : "OSde" } 
	private detalleObraSocial obraSocial;
	
	public detalleObraSocial getObraSocial() {
		return obraSocial;
	}
	public void setObraSocial(detalleObraSocial obraSocial) {
		this.obraSocial = obraSocial;
	}
	
	@Override
	public String toString() {
		return  obraSocial.toString();
	}
}
