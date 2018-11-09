package com.germiyanoglu;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

//http://localhost:1001/004_RESTful_Form/rest/uye
@Path("/uye")
public class KullaniciController {

	//http://localhost:1001/004_RESTful_Form/rest/uye/login
	@POST // Formdan geldiði için POST la aldýk
	@Path("/login")
	@Produces("text/html; charset=UTF-8")
	public Response girisYap(
			@FormParam("kullaniciAdi") String username,
			@FormParam("kullaniciParola") String password) {
		
		String yazi = "<hr> Girilen Bilgiler : <font face='verdana' size='3' ><hr> <u>" + username  + "</u> <hr> <u>" + password  + "</u>   </font>";
		return Response.status(200).entity(yazi).build();  
		
	}
	
	//http://localhost:1001/004_RESTful_Form/rest/uye/login
	@POST // Formdan geldiði için POST la aldýk
	@Path("/ekle")
	@Produces("text/html; charset=UTF-8")
	public Response ekle(
			@FormParam("personelAdi") String personelName,
			@FormParam("personelUlke") String personelCountry) {
		
		String yazi = "<hr> Eklenen Bilgiler : <font face='verdana' size='3' ><hr> <u>" + personelName  + "</u> <hr> <u>" + personelCountry  + "</u>   </font>";
		return Response.status(200).entity(yazi).build();  
		
	}
	
}
