package com.germiyanoglu.kullanici;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType (XmlAccessType.NONE)
@XmlRootElement (name="kullanici")
public class Kullanici implements Serializable{

	@XmlAttribute (name ="id")
	private int id;
	
	@XmlAttribute (name ="uri")
	private String uri;
	
	@XmlElement(name ="ad")
	private String ad;
	
	@XmlElement(name ="soyad")
	private String soyad;

	public Kullanici() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Kullanici(int id, String uri, String ad, String soyad) {
		super();
		this.id = id;
		this.uri = uri;
		this.ad = ad;
		this.soyad = soyad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
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
