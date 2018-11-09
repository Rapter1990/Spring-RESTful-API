package com.germiyanoglu.modal.pojo.entity.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name ="musteri")
public class Musteri implements Serializable{
	
	private int musteriId;
	private int musteriNo;
	private String musteriAd;
	private String musteriSoyad;
	
	public Musteri() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Musteri(int musteriId, int musteriNo, String musteriAd, String musteriSoyad) {
		super();
		this.musteriId = musteriId;
		this.musteriNo = musteriNo;
		this.musteriAd = musteriAd;
		this.musteriSoyad = musteriSoyad;
	}
	
	//@XmlAttribute
	@XmlElement
	public int getMusteriId() {
		return musteriId;
	}

	public void setMusteriId(int musteriId) {
		this.musteriId = musteriId;
	}

	@XmlElement
	public int getMusteriNo() {
		return musteriNo;
	}

	public void setMusteriNo(int musteriNo) {
		this.musteriNo = musteriNo;
	}

	@XmlElement
	public String getMusteriAd() {
		return musteriAd;
	}

	public void setMusteriAd(String musteriAd) {
		this.musteriAd = musteriAd;
	}

	@XmlElement
	public String getMusteriSoyad() {
		return musteriSoyad;
	}

	public void setMusteriSoyad(String musteriSoyad) {
		this.musteriSoyad = musteriSoyad;
	}

	@Override
	public String toString() {
		return "Musteri [musteriId=" + musteriId + ", musteriNo=" + musteriNo + ", musteriAd=" + musteriAd
				+ ", musteriSoyad=" + musteriSoyad + "]";
	}
	
	
	
	
}
