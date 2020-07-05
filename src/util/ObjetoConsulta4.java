package util;

import java.util.Date;
import java.util.List;

public class ObjetoConsulta4 {
//{ "_id" : { "sucursal" : 1.0, "productos" : { "producto" : { "tipo" : "Farmacia", "descripcion" : "Ibuprofeno" } } }, "Total venta" : 300.0, "Cantidad vendida" : 3.0 }
	private _Id _id;
	private int Total_venta;
	private int Cantidad_vendida; //Total producto por sucursal o cadena segun filtr
		
	public _Id get_id() {
		return _id;
	}

	public void set_id(_Id _id) {
		this._id = _id;
	}

	public int getTotal_venta() {
		return Total_venta;
	}

	public void setTotal_venta(int total_venta) {
		Total_venta = total_venta;
	}

	public int getCantidad_vendida() {
		return Cantidad_vendida;
	}

	public void setCantidad_vendida(int cantidad_vendida) {
		Cantidad_vendida = cantidad_vendida;
	}

	@Override
	public String toString() {
		return _id.toString()  + " >> cantidad=" + this.Cantidad_vendida
				+ ">> TotalVenta=" + Total_venta;
	}
	
}
