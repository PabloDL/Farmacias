package util;

public class ObjetoConsulta1 {
	private int _id;
	private double Total_sucursal;
	
	public ObjetoConsulta1() {
		super();
		this._id = -1;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public double getTotal_sucursal() {
		return Total_sucursal;
	}
	public void setTotal_sucursal(double total_sucursal) {
		Total_sucursal = total_sucursal;
	}
	
	@Override
	public String toString() {
		if ( this._id == -1) {
			return "Total_sucursal=" + Total_sucursal ;	
		}
		return "Sucursal " + _id + "| Total_sucursal=" + Total_sucursal ;
	}
	
}

