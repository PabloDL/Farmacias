package util;

public class detalleFormaDePago {
	// { "descripcion" : "Debito" }
		private String descripcion;

		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		@Override
		public String toString() {
			return "Forma de pago: " + descripcion ;
		}
		
}
