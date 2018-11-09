package com.germiyanoglu.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.germiyanoglu.dao.impl.MusteriDAOImpl;
import com.germiyanoglu.modal.pojo.entity.bean.Musteri;

//http://localhost:8085/017_RESTful_Multiple_Output_Format_JDBC_CRUD/rest/musteri

@Path("/musteri")
public class MusteriRESTfulService {

	//http://localhost:8085/017_RESTful_Multiple_Output_Format_JDBC_CRUD/rest/musteri/herkes
	@GET
	@Path("/herkes")
//	@Produces ("application/xml,  application/json ; charset=utf-8")
	@Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON + ";charset=utf-8"})	
	public List<Musteri> musterileriGetir() {
		
		/*List<Musteri> musteriler = new ArrayList<Musteri>();
		Musteri musteri = null;
		
		for (int i = 1; i < 10; i++) {
			
			musteri = new Musteri(i, i*i, "musteriAdi"+i, "musteriSoyadi"+i);
			
			musteri = new Musteri();
			musteri.setMusteriId(i);
			musteri.setMusteriNo(i*i);
			musteri.setMusteriAd("musteriAdi"+i);
			musteri.setMusteriSoyad("musteriSoyadi"+i);
			
			musteriler.add(musteri);
		}
	
	
		return musteriler;*/
		
		
		MusteriDAOImpl nesne = new MusteriDAOImpl();
		return nesne.veriOku();
		
	}
	
	
	//  http://localhost:8085/017_RESTful_Multiple_Output_Format_JDBC_CRUD/rest/musteri/2	
	@GET
	@Path("/{musteriId}")
	//	@Produces ("application/xml,  application/json ; charset=utf-8")
	@Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON + ";charset=utf-8"})	
	public Musteri musteriGetirById( @PathParam ("musteriId") int musteriId) {
	
		
		 /*Musteri musteri = new Musteri();
				musteri.setMusteriId(musteriId);
				musteri.setMusteriNo(musteriId*musteriId);
				musteri.setMusteriAd("musteriAdi"+musteriId);
				musteri.setMusteriSoyad("musteriSoyadi"+musteriId);
			
		return musteri;*/
		
		MusteriDAOImpl nesne = new MusteriDAOImpl();
		return nesne.veriOku(musteriId);
		
		
		/*  XML
		 *  <musteri>
			    <musteriAd>Gizem</musteriAd>
			    <musteriNo>1001</musteriNo>
			    <musteriSoyad>Kýlýç</musteriSoyad>
			</musteri>
		
			JSON
			{  
			      "musteriNo":123,
			      "musteriAd":"Hasan",
			      "musteriSoyad":"Kýmýkçý"
			}
		
		
		 */
		
	}  	
	
	
	//  http://localhost:8085/017_RESTful_Multiple_Output_Format_JDBC_CRUD/rest/musteri
	@POST
	@Path("/")
	@Consumes ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON + ";charset=utf-8"}) 
	public Response musteriEkle(Musteri musteri ) {
		
		//return Response.status(201).build();
		
		MusteriDAOImpl nesne = new MusteriDAOImpl();
		boolean eklemeDurumu = nesne.veriEkle(musteri);
		
		if(eklemeDurumu == false)
			return Response.status(201).build();
		else
			return Response.status(204).build();
		
	}  	
	
	
	//  http://localhost:8085/017_RESTful_Multiple_Output_Format_JDBC_CRUD/rest/musteri/4
	@PUT
	@Path("/{musteriId}")
	@Produces ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON + ";charset=utf-8"})	
	@Consumes ({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON + ";charset=utf-8"}) 
	public Musteri musteriDuzenle( @PathParam ("musteriId") int musteriId, Musteri musteri) {
		
		
		//return Response.status(200).build();
		
		MusteriDAOImpl nesne = new MusteriDAOImpl();
		boolean duzenlemeDurumu = nesne.veriDuzenle(musteri, musteriId);
		
		if(duzenlemeDurumu == true)
			return musteri;
		else
			return null;
		
		
		/*
		  XML
			  <musteri>
			    <musteriAd>Banu</musteriAd>
			    <musteriNo>111</musteriNo>
			    <musteriSoyad>Oðuzcan</musteriSoyad>
			  </musteri>
		
		  JSON
		  
		  {  
		      "musteriNo":81,
		      "musteriAd":"Yaðmur",
		      "musteriSoyad":"Aslý"
		  }
		

		*/
		
		
		
	}  
	
	//  http://localhost:8085/017_RESTful_Multiple_Output_Format_JDBC_CRUD/rest/musteri/
	@DELETE
	@Path("/{musteriId}")
	public Response musteriSil(@PathParam ("musteriId") int musteriId ) {
		
		//return Response.status(200).build();
		
		MusteriDAOImpl nesne = new MusteriDAOImpl();
		boolean silmeDurumu = nesne.veriSilme(musteriId);
		
		if(silmeDurumu == false)
			return Response.status(200).build();
		else
			return Response.status(204).build();

	}  	
	
}
