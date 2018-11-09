package com.germiyanoglu.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.germiyanoglu.modal.Personel;

@XmlRootElement(name = "personeller")
public class PersonelList implements Serializable{
	
	private List<Personel> personeller = new ArrayList<Personel>();

	public List<Personel> getPersoneller() {
		return personeller;
	}

	public void setPersoneller(List<Personel> personeller) {
		this.personeller = personeller;
	}
	
	

}
