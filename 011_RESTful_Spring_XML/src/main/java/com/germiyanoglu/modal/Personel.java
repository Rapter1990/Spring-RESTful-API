package com.germiyanoglu.modal;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "personel")
@XmlAccessorType(XmlAccessType.NONE)
public class Personel implements Serializable{
	
	@XmlAttribute
	private int id;
	
	@XmlElement
	private String ad;
	
	@XmlElement
	private String soyad;
	
	@XmlElement
	private String email;
	
	public Personel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Personel(int id,String ad, String soyad, String email) {
		super();
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
		this.email = email;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}
	
	
	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
