package com.germiyanoglu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//http://localhost:1001/001_RESTfulJersey/rest/selam

@Path(value = "/selam")
public class Merkez {
	
	/*@GET // Alma türü
	@Produces(MediaType.TEXT_PLAIN) // Çýktýsý yazý olacak
	public String method1() {
		System.out.println("method1");
		return "RESTful Merhaba";
	}*/
	
	/*@GET // Alma türü
	@Produces("text/html") // Çýktýsý yazý olacak
	public Response  method2() {
		System.out.println("method2");
		String yazý = "<font face=verdana size=40>Method 2</font>";
		return Response.status(200).entity(yazý).build();
		
	}*/
	
	//http://localhost:1001/001_RESTfulJersey/rest/selam/sorgu1
	@GET // Alma türü
	@Path(value = "/sorgu1")
	@Produces("text/html") // Çýktýsý yazý olacak
	public Response  method3() {
		System.out.println("method3");
		String yazý = "<font face=verdana size=40>Method 3</font>";
		// 200 -> Sayfa baþarýlý olduðunda
		return Response.status(200).entity(yazý).build();
		
	}
	
	//http://localhost:1001/001_RESTfulJersey/rest/selam/sorgu2
	@GET // Alma türü
	@Path(value = "/sorgu2")
	@Produces("text/html") // Çýktýsý yazý olacak
	public Response  method4() {
		System.out.println("method4");
		String yazý = "<font face=verdana size=40>Method 4</font>";
		// 200 -> Sayfa baþarýlý olduðunda
		return Response.status(200).entity(yazý).build();  
		
	}
	
	//http://localhost:1001/001_RESTfulJersey/rest/selam/sorgu3/{parametre}
	@GET // Alma türü
	@Path(value = "/sorgu3/{parametre}")
	@Produces(MediaType.TEXT_XML) // Çýktýsý yazý olacak
	public Response  method5(@PathParam("parametre") String parameter) {
		System.out.println("method5");
		String yazý = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
				+ "<soyle> 404 " + parameter  +" </soyle>";
		// 200 -> Sayfa baþarýlý olduðunda
		return Response.status(200).entity(yazý).build();  
		
	}
	
	//http://localhost:1001/001_RESTfulJersey/rest/selam/sorgu4?parametre=
	@GET // Alma türü
	@Path(value = "/sorgu4")
	@Produces(MediaType.TEXT_HTML) // Çýktýsý yazý olacak
	public Response  method6(@QueryParam("parametre") String parameter) {
		System.out.println("method6");
		String yazý = "SELAM , " + parameter + " ";
		// 200 -> Sayfa baþarýlý olduðunda
		return Response.ok(yazý, MediaType.TEXT_HTML).build();
		
	}
}
