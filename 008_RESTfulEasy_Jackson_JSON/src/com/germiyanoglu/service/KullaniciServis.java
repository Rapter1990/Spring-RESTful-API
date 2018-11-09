package com.germiyanoglu.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.germiyanoglu.modal.Kullanici;

//http://localhost:8085/008_RESTfulEasy_Jackson_JSON/rest/kullanici
@Path("/kullanici")
public class KullaniciServis {

	//http://localhost:8085/008_RESTfulEasy_Jackson_JSON/kullanici/bilgi/1
	@GET
	@Path("/bilgi/{id}")
	//@Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
	//@Produces("application/json"+";charset=UTF-8")
	public Response getBilgiGoster(@PathParam("id") int id) {
		
		Kullanici kullanici = new Kullanici();
		kullanici.setId(id);
		kullanici.setAd("Melis");
		kullanici.setSoyad("Türk");
		
		return Response.status(200).entity(kullanici).build();  
	}
}
