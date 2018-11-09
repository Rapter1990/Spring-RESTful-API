package com.germiyanoglu.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.germiyanoglu.modal.Personel;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/personel")
public class PersonelController {
	
	private static Set<Personel> personeller;
	
	static {
		personeller = new HashSet<Personel>();
		
		Personel personel = new Personel();
		
		for(int i=1;i<10;i++) {
			personel = new Personel(i, "personel " + i);
			personeller.add(personel);
		}
	}
	
	// http://localhost:8085/personel/listele
	
	@RequestMapping(value = "/listele", method = RequestMethod.GET, 
			headers = "Accept=application/json",produces = "application/json;charset=UTF-8")
	@ResponseBody // methoddan geleni -> application/json çevirir.
	public Set<Personel> getPersonelListesi(Model model) {
		
		return personeller;
		
	}
	
	// http://localhost:8085/personel/listele/3
	@RequestMapping(value = "/listele/{id}", method = RequestMethod.GET, 
			headers = "Accept=application/json",produces = "application/json;charset=UTF-8")
	@ResponseBody // methoddan geleni -> application/json çevirir.
	public Personel getPersonelListesiById(@PathVariable("id") int id) {
		
		Iterator<Personel> bilgi = personeller.iterator();
		
		while(bilgi.hasNext()) {
			Personel personel = bilgi.next();
			
			if(personel.getId() == id) {
				return personel;
			}
		}
		
		return null;
		
	}
	
	// http://localhost:8085/personel/listele/html
	@RequestMapping(value = "/listele/html", method = RequestMethod.GET, 
			headers = "Accept=text/html",produces = "text/html;charset=UTF-8")
	@ResponseBody // methoddan geleni -> application/json çevirir.
	public String getPersonelListesiHtml() {
		
		String html = "<html><body><table border=2>";
		
		Iterator<Personel> bilgi = personeller.iterator();
		
		while(bilgi.hasNext()) {
			Personel personel = bilgi.next();
			html += "<tr><td>" + personel.getId() + "</td><td>" + personel.getName() + "</td></tr>";
		}
		
		html += "</table></body></html>";
		
		return html;
		
	}
	
	// http://localhost:8085/personel/sil/3
	@RequestMapping(value = "/listele/{id}", method = RequestMethod.DELETE, 
			headers = "Accept=application/json",produces = "application/json;charset=UTF-8")
	@ResponseBody // methoddan geleni -> application/json çevirir.
	public boolean deletePersonelById(@PathVariable("id") int id) {
		
		System.out.println("Siliniyor ... " + id);
		
		Iterator<Personel> bilgi = personeller.iterator();
		
		while(bilgi.hasNext()) {
			Personel personel = bilgi.next();
			
			if(personel.getId() == id) {
				bilgi.remove();
				System.out.println("Silindi ... " + id);
				return true;
			}
		}
		
		System.out.println("Silinmedi... " + id);
		return false;
		
	}
	
	// http://localhost:8085/personel/listele
	@RequestMapping(value = "/listele", method = RequestMethod.POST, 
			headers ="Accept=application/json", consumes= "application/json;charset=UTF-8")															
	@ResponseBody
	public boolean getPersonelListesiEkleme(@RequestBody Personel personel) {
		
		return personeller.add(personel);
		
	}	
	
	// http:localhost:8085/personel/listele/10
	@RequestMapping(value = "/listele/{id}", method = RequestMethod.PUT, headers ="Accept=application/json", produces= "application/json;charset=UTF-8", consumes= "application/json;charset=UTF-8" )
	@ResponseBody
	public Personel getPersonelListesiDuzenlemeId(@RequestBody Personel personel,@PathVariable("id") int id) {
		
		
		Iterator<Personel> kisi = personeller.iterator();
		
		while (kisi.hasNext()) {
			Personel personelNesnesi = (Personel) kisi.next();
			
			if (personelNesnesi.getId() == id) {
				
				personelNesnesi.setId(personel.getId());
				personelNesnesi.setName(personel.getName());
				
				System.out.println("Düzenlendi..." + id);
				return personelNesnesi;
			}
			
		} 
		
		System.out.println("Düzenlenmedi..." + id);
		return null;
	}	
	
}
