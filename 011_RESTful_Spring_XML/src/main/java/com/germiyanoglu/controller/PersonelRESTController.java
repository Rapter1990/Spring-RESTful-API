package com.germiyanoglu.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.germiyanoglu.modal.Personel;

@RestController
public class PersonelRESTController {
	
private static Set<Personel> personeller;
	
	static {
		personeller = new HashSet<Personel>();
		
		Personel personel = null;
		
		for(int i=1;i<10;i++) {
			personel = new Personel(i, "ad : " +i ,"soyad :" +i,"email :" +i);
			personeller.add(personel);
		}
	}

	@RequestMapping(value = "/personeller/xml")
	public PersonelList getXml() {
		
		PersonelList list = new PersonelList();
		
		Personel personel = null;
		
		for(int i=1;i<10;i++) {
			personel = new Personel(i, "ad : " +i ,"soyad :" +i,"email :" +i);
			list.getPersoneller().add(personel);
		}
		
		return list;
	}
	
	@RequestMapping(value = "/personeller/json")
	public Set<Personel> getJson() {
		return personeller;
	}
	
	
	@RequestMapping(value = "/personeller/json/{id}", method = RequestMethod.GET, headers ="Accept=application/json", produces= "application/json")
	@ResponseBody
	public Personel getPersonelListesiIdByJson(@PathVariable("id") int id) {
		
		Iterator<Personel> kisi = personeller.iterator();
		
		while (kisi.hasNext()) {
			Personel personelNesnesi = (Personel) kisi.next();
			
			if (personelNesnesi.getId() == id) {
				return personelNesnesi;
			}
			
		} 
		return null;
	}	
	
	
	@RequestMapping(value = "/personeller/xml/{id}", method = RequestMethod.GET, headers ="Accept=application/xml", produces= "application/xml")
	@ResponseBody
	public Personel getPersonelListesiIdByXml(@PathVariable("id") int id) {
		
		Iterator<Personel> kisi = personeller.iterator();
		
		while (kisi.hasNext()) {
			Personel personelNesnesi = (Personel) kisi.next();
			
			if (personelNesnesi.getId() == id) {
				return personelNesnesi;
			}
			
		} 
		return null;
	}	
}
