package com.germiyanoglu.kullanici;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//http://localhost:8085/014_RESTful_RESTEasy_JAXB_Jettison_Client/rest/kullanici-yonetim

@XmlAccessorType (XmlAccessType.NONE)
@XmlRootElement (name = "kullanici-yonetim")
@Path ("/kullanici-yonetim")
public class KullaniciServis {

	//http://localhost:8085/014_RESTful_RESTEasy_JAXB_Jettison_Client/rest/kullanici-yonetim/kullanicilar
	@XmlElement (name="kullanicilar")
	private String uri1 = "/kullanici-yonetim/kullanicilar";
	
	//http://localhost:8085/014_RESTful_RESTEasy_JAXB_Jettison_Client/rest/kullanici-yonetim/raporlar
	@XmlElement (name="raporlar")
	private String uri2 = "/kullanici-yonetim/raporlar";

	public String getUri1() {
		return uri1;
	}

	public void setUri1(String uri1) {
		this.uri1 = uri1;
	}

	public String getUri2() {
		return uri2;
	}

	public void setUri2(String uri2) {
		this.uri2 = uri2;
	}
	
	//http://localhost:8085/014_RESTful_RESTEasy_JAXB_Jettison_Client/rest/kullanici-yonetim/xml
	@GET
	@Path("/xml") // ("/{xml : (?i)xml}")  // Büyük harf kucuk harfa duyarliligi iptal eder
	@Produces ("application/xml;charset=utf-8")
	public KullaniciServis servisBilgiXML() {
		return new KullaniciServis();
	}
	
	//http://localhost:8085/014_RESTful_RESTEasy_JAXB_Jettison_Client/rest/kullanici-yonetim/json
	@GET
	@Path("/json") // ("/{xml : (?i)xml}")  // Büyük harf kucuk harfa duyarliligi iptal eder
	@Produces ("application/json;charset=utf-8")
	public KullaniciServis servisBilgiJSON() {
		return new KullaniciServis();
	}
	
	//http://localhost:8085/014_RESTful_RESTEasy_JAXB_Jettison_Client/rest/kullanici-yonetim/kullanicilar/1
	@GET
	@Path("/kullanicilar/{id}")
	@Produces("application/xml;charset=UTF-8")
	public Kullanici getKullaniciById(@PathParam("id") int id, @Context Request request) {

		if (request.getMethod().equals("GET")) {
			//System.out.println(Metot  @GET mi?: " + request.getMethod().equals("POST"));
			
            Response.ResponseBuilder rb = request.evaluatePreconditions(new Date());
            if (rb != null) {
                throw new WebApplicationException(rb.build());
            }
        }
		
		Kullanici kullanici = new Kullanici();
		kullanici.setId(id);
		
		if (id == 1) {
			kullanici.setAd("Ahmet");
			kullanici.setSoyad("Yazgýn");
		} else if (id == 2) {
			kullanici.setAd("Burhan");
			kullanici.setSoyad("Güvenn");
		} else {
			kullanici.setAd("Aha ");
			kullanici.setSoyad("Dayýya Sor");
		}
		
		kullanici.setUri("/kullanici-yonetim/kullanicilar/" + id);
		
		return kullanici;
	}
	
	// http://localhost:8085/014_RESTful_RESTEasy_JAXB_Jettison_Client/rest/kullanici-yonetim/kullanicilar	
		/*	
		<kullanici>
		   <id>3</id>
		   <ad>Nazým</ad>  
		   <soyad>Sevim</soyad>
		</kullanici>
		*/
			
	@POST
	@Path("/kullanicilar")
	@Consumes("application/xml;charset=UTF-8")
	public Response createKullanici(  Kullanici kullanici,     
			@DefaultValue("false") @QueryParam("allow-admin") boolean allowAdmin  )  throws URISyntaxException {
		
		System.out.println(kullanici.getAd());
		System.out.println(kullanici.getSoyad());
		
		return Response.status(201).contentLocation(new URI("/kullanici-yonetim/kullanicilar/3")).build();
	}
	
	@PUT
	// @Path("/kullanicilar/{id: [0-9]*}")  //Sadece sayý girilmesini saglar
	@Path("/kullanicilar/{id}")
	@Consumes("application/xml;charset=UTF-8")
	@Produces("application/xml;charset=UTF-8")
	public Kullanici updateKullanici(@PathParam("id") int id, Kullanici kullanici) throws URISyntaxException {
		kullanici.setId(id);
		kullanici.setAd(kullanici.getAd() + " updated");
		return kullanici;
	}

	@DELETE
	@Path("/kullanicilar/{id}")
	public Response deleteKullanici(@PathParam("id") int id)
			throws URISyntaxException {
		return Response.status(200).build();
	}
	
}
