package com.germiyanoglu.kurs;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="kurs")
public class Kurs implements Serializable{

	private int egitimYil;
	private String dersinAd;
	private int dersSure;
	private int dersFiyat;
	private String egitmenAd;
	
	public Kurs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Kurs(int egitimYil, String dersinAd, int dersSure, int dersFiyat, String egitmenAd) {
		super();
		this.egitimYil = egitimYil;
		this.dersinAd = dersinAd;
		this.dersSure = dersSure;
		this.dersFiyat = dersFiyat;
		this.egitmenAd = egitmenAd;
	}
	
	//@XmlAttribute
	@XmlElement
	public int getEgitimYil() {
		return egitimYil;
	}

	public void setEgitimYil(int egitimYil) {
		this.egitimYil = egitimYil;
	}
	
	@XmlElement
	public String getDersinAd() {
		return dersinAd;
	}

	public void setDersinAd(String dersinAd) {
		this.dersinAd = dersinAd;
	}
	
	@XmlElement
	public int getDersSure() {
		return dersSure;
	}

	public void setDersSure(int dersSure) {
		this.dersSure = dersSure;
	}
	
	@XmlElement
	public int getDersFiyat() {
		return dersFiyat;
	}

	public void setDersFiyat(int dersFiyat) {
		this.dersFiyat = dersFiyat;
	}
	
	@XmlElement
	public String getEgitmenAd() {
		return egitmenAd;
	}

	public void setEgitmenAd(String egitmenAd) {
		this.egitmenAd = egitmenAd;
	}
	
	
}
