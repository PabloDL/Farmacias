package util;

public class ObjetoConsulta2 {
//{ "_id" : { "sucursal" : 1.0, "cliente" : { "obraSocial" : { "nombre" : "OSde" } } }, "Total venta" : 200.0 }
	private _idConsulta2 _id;
	private int Total_venta;
	
	public _idConsulta2 get_id() {
		return _id;
	}
	public void set_id(_idConsulta2 _id) {
		this._id = _id;
	}
	public int getTotal_venta() {
		return Total_venta;
	}
	public void setTotal_venta(int total_venta) {
		Total_venta = total_venta;
	}
	@Override
	public String toString() {
		return  _id.toString() + " | Total Venta: " + Total_venta ;
	}
	
	
}
