package com.germiyanoglu.modal;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "kullanici")
public class Kullanici implements Serializable{

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "kullaniciId")
	int id;
	
	@XmlElement(name = "kullaniciAd")
	String ad;
	
	@XmlElement(name = "kullaniciSoyad")
	String soyad;
	
	public Kullanici() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Kullanici(int id, String ad, String soyad) {
		super();
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
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
	
}
