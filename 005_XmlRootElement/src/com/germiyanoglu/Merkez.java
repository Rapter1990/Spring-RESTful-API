package com.germiyanoglu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//http://localhost:8085/005_XmlRootElement/rest/kayit
@Path("/kayit")
public class Merkez {

	//http://localhost:8085/005_XmlRootElement/rest/kayit/bilgi/1
	@GET
	@Path("/bilgi/{id}")
	@Produces(MediaType.APPLICATION_XML + ";charset=UTF-8")
	public Musteri bilgiGoster(@PathParam("id") int id) {
		
		Musteri musteri = new Musteri();
		musteri.setMusteriId(id);
		musteri.setMusteriAd("Noyan");
		musteri.setMusteriSehir("Ankara");
		return musteri;
		
	}
	
	
}
