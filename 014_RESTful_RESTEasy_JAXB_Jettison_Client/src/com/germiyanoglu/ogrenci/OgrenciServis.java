package com.germiyanoglu.ogrenci;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

//  http://localhost:8085/014_RESTful_RESTEasy_JAXB_Jettison_Client/rest/ogrenci

@Path ("/ogrenci")
public class OgrenciServis {
	
	
//  http://localhost:8085/014_RESTful_RESTEasy_JAXB_Jettison_Client/rest/ogrenci/oku/4/Mustafa/Açan/25
	
	@GET     
	@Path ("/oku/{id}/{adi}/{soyadi}/{yasi}")
	@Produces ("application/json;charset=utF-8") 
	public Ogrenci ogrenciBilgi(
		@PathParam("id") int id,
		@PathParam("adi") String adi,
		@PathParam("soyadi") String soyadi,
		@PathParam("yasi") int yasi
			) {
		
		Ogrenci ogrenci = new Ogrenci(id, adi, soyadi, yasi);
		
		return ogrenci;
	}
	
//  http://localhost:8085/014_RESTful_RESTEasy_JAXB_Jettison_Client/rest/ogrenci/gonder
	
	@POST    
	@Path ("/gonder")
	@Consumes ("application/json;charset=utF-8")
	public Response ogrenciBilgiGonder(Ogrenci ogrenci) {
		return Response.status(200).entity(ogrenci.toString()).build();
	}
		
	
}
