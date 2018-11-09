package com.germiyanoglu;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "musteri")
public class Musteri implements Serializable{
	
	
	private int musteriId;
	private String musteriAd;
	private String musteriSehir;
	
	public Musteri() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Musteri(String musteriAd, String musteriSehir) {
		super();
		this.musteriAd = musteriAd;
		this.musteriSehir = musteriSehir;
	}

	@XmlAttribute
	public int getMusteriId() {
		return musteriId;
	}

	public void setMusteriId(int musteriId) {
		this.musteriId = musteriId;
	}

	@XmlElement 
	public String getMusteriAd() {
		return musteriAd;
	}

	public void setMusteriAd(String musteriAd) {
		this.musteriAd = musteriAd;
	}

	@XmlElement 
	public String getMusteriSehir() {
		return musteriSehir;
	}

	public void setMusteriSehir(String musteriSehir) {
		this.musteriSehir = musteriSehir;
	}
	
}
