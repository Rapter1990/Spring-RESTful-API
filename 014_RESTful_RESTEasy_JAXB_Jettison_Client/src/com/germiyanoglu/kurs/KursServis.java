package com.germiyanoglu.kurs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;

//http://localhost:8085/014_RESTful_RESTEasy_JAXB_Jettison_Client/rest/kurs

@Path ("/kurs")
public class KursServis {

	//http://localhost:8085/014_RESTful_RESTEasy_JAXB_Jettison_Client/rest/kurs/json
	@GET
	//@BadgerFish // Görünüþü $ iþaretine atama olarak yapar. ( id = { "$" : 50 } )
	@Path("/json")
	@Produces ("application/json;charset=utF-8") // XMLAttribute json da @ iþareti kullanýlýr.
	public List<Kurs> alKursBilgisiJSON(){
		
		List<Kurs> kurslar = new ArrayList<Kurs>();
		
		Kurs kurs = null;
		
		for (int i = 0; i < 10; i++) {
			kurs = new Kurs(2018, "Ders"+i, 40 ,30*i, "eðitmen"+i);
			kurslar.add(kurs);
		}

		return kurslar;
	}
	
	//http://localhost:8085/014_RESTful_RESTEasy_JAXB_Jettison_Client/rest/kurs/xml
	@GET
	@Path("/xml")
	@Produces ("application/xml;charset=utF-8") 
	public List<Kurs> alKursBilgisiXML(){
		
		List<Kurs> kurslar = new ArrayList<Kurs>();
		
		Kurs kurs = null;
		
		for (int i = 0; i < 10; i++) {
			kurs = new Kurs(2018, "Ders"+i, 40 ,30*i, "eðitmen"+i);
			kurslar.add(kurs);
		}

		return kurslar;
	}
}
