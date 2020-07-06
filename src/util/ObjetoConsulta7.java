package util;

public class ObjetoConsulta7 {
//	{ "_id" : { "cliente" : "Juan", "apellido" : "Gomez", "dni" : 2.0 }, "Total_cobranza" : 1900.0 }
	private _IdConsulta7 _id;
	private int Total_cobranza;
	
	public _IdConsulta7 get_id() {
		return _id;
	}
	public void set_id(_IdConsulta7 _id) {
		this._id = _id;
	}
	public int getTotal_cobranza() {
		return Total_cobranza;
	}
	public void setTotal_cobranza(int total_cobranza) {
		Total_cobranza = total_cobranza;
	}
	
	@Override
	public String toString() {
		return _id.toString()  + " | Total cobranza=" + this.Total_cobranza;
	}
	
}
