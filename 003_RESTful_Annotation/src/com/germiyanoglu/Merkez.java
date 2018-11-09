package com.germiyanoglu;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;

//http://localhost:1001/003_RESTful_Annotation/rest/kullanici
@Path(value = "/kullanici")
public class Merkez {

	//http://localhost:1001/003_RESTful_Annotation/rest/kullanici
	/*@GET // Bilgi Okuma
	public Response selamVer1() {
		String yazi = "selamVer1 çalýþýyor";
		return Response.status(200).entity(yazi).build();  
	}*/
	
	//http://localhost:1001/003_RESTful_Annotation/rest/kullanici/selamla
	@GET // Bilgi Okuma
	@Path("/selamla")
	public Response selamVer2() {
		String yazi = "selamVer2 çalýþýyor";
		return Response.status(200).entity(yazi).build();  
	}
	
	//http://localhost:1001/003_RESTful_Annotation/rest/kullanici/selamla/Noyan
	@GET // Bilgi Okuma
	@Path("/selamla/{parametre}")
	public Response selamVer3(@PathParam("parametre") String parametre ) {
		String yazi = "SELAMLAR " + parametre;
		return Response.status(200).entity(yazi).build();  
	}
	
	//http://localhost:1001/003_RESTful_Annotation/rest/kullanici/06/Ankara
	@GET // Bilgi Okuma
	@Path("/{plakaNo}/{sehirNo}")
	@Produces("text/html")
	public Response selamVer4(@PathParam("plakaNo") String plakaNo, @PathParam("sehirNo") String sehirNo ) {
		String yazi = "Bilgi :  " + plakaNo + " - " + sehirNo + " üiðþçöýþ";
		return Response.status(200).entity(yazi).build();  
	}
	
	//http://localhost:1001/003_RESTful_Annotation/rest/kullanici/regex/
	@GET // Bilgi Okuma
	@Path("/regex/{adi :[a-zA-Z][a-zA-Z_0-9]+ }")  // _ -> ve olarak kullanýlýr.
	public Response selamVer5(@PathParam("adi") String adi) {
		String yazi = "SELAMLAR " + adi + " - regex";
		return Response.status(200).entity(yazi).build();  
	}
	
	//http://localhost:1001/003_RESTful_Annotation/rest/kullanici/1/Noyan
	@GET // Bilgi Okuma
	@Path("/1/{adi}")  // _ -> ve olarak kullanýlýr.
	@Produces("text/html; charset=UTF-8")
	public Response selamVer6(@PathParam("adi") String adi) {
		String yazi = "SELAMLAR " + adi;
		return Response.status(200).entity(yazi).build();  
	}
	
	//http://localhost:1001/003_RESTful_Annotation/rest/kullanici/2/Noyan/28
	@GET // Bilgi Okuma
	@Path("/2/{ad}/{yas}")
	public Response selamVer7(@PathParam("ad") String ad,@PathParam("yas") int yas) {
		String yazi = "SELAMLAR " + ad + " " + yas;
		return Response.status(200).entity(yazi).build();  
	}
	
	//http://localhost:1001/003_RESTful_Annotation/rest/kullanici;ad=Noyan;ulke=Türkiye
	@GET // Bilgi Okuma
	@Produces("text/html; charset=UTF-8")
	public Response selamVer8(@MatrixParam("ad") String ad,   
			@MatrixParam("ulke") String ulke ) {
		String yazi = "SELAMLAR Ad: " + ad + " Ülke : " + ulke + " üiðþçöýþ";
		return Response.status(200).entity(yazi).build();  
	}
	
	//http://localhost:1001/003_RESTful_Annotation/rest/kullanici/3/personel/detay;adi=Nazým;meslek=Yazýlýmcý;tecrube=7
	@GET
	@Path("/3/personel/{detay}")
	@Produces("text/html; charset=UTF-8")
	public Response getPersonelBilgi(@PathParam("detay") PathSegment detay) {
		String personel = "Personel : ";
	
		MultivaluedMap<String, String> matrix = detay.getMatrixParameters(); // Sýnýrý bilmediðimizde kullanýrýz
		for (String key : matrix.keySet()) {
			personel +=  key + matrix.get(key) + " "; 
		}
		
		personel += " "; 
		
		return Response.status(200).entity(personel).build();
		
	}	
	
	
}
