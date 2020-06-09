package modelo;

import com.google.gson.Gson;

public class SerializadorTicket {
	
	public void debeDevolverLaRepresentacionJSONDeUnObjeto() {
		final Ticket t = new Ticket(0, null, 0, null, null, null, null, null);
		final Gson gson = new Gson();
		final String representacionJSON = gson.toJson(t);
//		assertEquals("{\"id\":46,\"nombre\":\"Miguel\",\"empresa\":\"Autentia\"}", representacionJSON);
		System.out.print(representacionJSON);
	}

	private void assertEquals(String string, String representacionJSON) {
		// TODO Auto-generated method stub
		
	}
}
