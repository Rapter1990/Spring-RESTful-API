package com.germiyanoglu.modal;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class Personel implements Serializable{
	
	private int id;
	private String name;
	
	public Personel() {
		super();
		this.id = 1;
		this.name = "Personel";
	}

	public Personel(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Personel [id=" + id + ", name=" + name + "]";
	}
	
	
}
