package util;

public class ObjetoConsulta3 {
//	{ "_id" : { "sucursal" : 1.0, "formaDePago" : { "descripcion" : "Credito" } }, "Total_cobranza" : 1200.0 }
	private _IdConsulta3 _id;
	private int Total_cobranza;
	
	public _IdConsulta3 get_id() {
		return _id;
	}
	public void set_id(_IdConsulta3 _id) {
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
		return _id.toString()  + " >> Total cobranza=" + this.Total_cobranza;
	}
	
}
