package com.germiyanoglu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//http://localhost:8085/009_RESTful_Jersey_JSON/kayit
@Path("/kayit")
public class MusteriServis {

	//http://localhost:8085/009_RESTful_Jersey_JSON/kayit/bilgi/1
	@GET
	@Path("/bilgi/{id}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
	//@Produces("application/json"+";charset=UTF-8")
	public Musteri bilgiGoster(@PathParam("id") int id) {
		
		Musteri musteri = new Musteri();
		musteri.setMusteriId(id);
		musteri.setMusteriAd("Noyan Germiyanoðlu");
		musteri.setMusteriSehir("Ankara");
		return musteri;
		
	}
	
	
}
