package com.germiyanoglu;

import java.io.UnsupportedEncodingException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//http:localhost:8085/015_RESTful_RESTEasy_AJAX/rest/uye
@Path("/uye")
public class UyeServis {

	//  http:localhost:8085/015_RESTful_RESTEasy_AJAX/rest/uye/ekle	

	@POST
	@Path("/ekle")
    @Produces(MediaType.TEXT_HTML+";charset=UTF-8")
	public Response uyeEkle(@FormParam("adi") String adi,@FormParam("soyadi") String soyadi) {
		
		//String sonuc = "---Gelen Ýsim :"+adi+"---"+"---Gelen Soyisim:"+soyadi +"---";
		String sonuc = "<font face=verdana size=3 color=red> " + adi + " " + soyadi + "</font>" ;
		return Response.status(200).entity("EKLENEN BÝLGÝ: " + sonuc).build();	
	}
	
	//  http:localhost:8085/015_RESTful_RESTEasy_AJAX/rest/uye/ekle	
	@POST
	@Path("/kontrol") 
	@Produces("text/html; charset=UTF-8")
	public Response uyeKontrol(@QueryParam("adi") String adi,  @QueryParam("soyadi") String soyadi) throws UnsupportedEncodingException {
		
		
		if(adi==null || adi.isEmpty()){
			return Response.ok().entity("adi bos gecilemez!").build();	

		}
		
		if(soyadi==null || soyadi.isEmpty()){
			return Response.ok().entity("soyadi bos gecilemez!").build();	

		}
		
		
		return Response.ok().entity("Sayýn "  + adi + " " + soyadi + " RESTful ile AJAX kontrol edildi.").build();	
	}	
}
