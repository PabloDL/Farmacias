package util;

public class ObjetoConsulta8 {
	//{ "_id" : { "cliente" : "Stephen", "apellido" : "Strange", "dni" : 6.0 }, "Total_Productos" : 15.0 }
	private _IdConsulta7 _id;
	private int Total_Productos;
	
	public _IdConsulta7 get_id() {
		return _id;
	}
	public void set_id(_IdConsulta7 _id) {
		this._id = _id;
	}
	public int getTotal_Productos() {
		return Total_Productos;
	}
	public void setTotal_Productos(int total_Productos) {
		Total_Productos = total_Productos;
	}
	@Override
	public String toString() {
		return _id.toString()  + " | Total productos=" + this.Total_Productos;
	}
	
}
