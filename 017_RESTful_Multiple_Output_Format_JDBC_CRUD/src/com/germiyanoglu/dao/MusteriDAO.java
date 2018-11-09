package com.germiyanoglu.dao;

import java.sql.Connection;
import java.util.List;

import com.germiyanoglu.modal.pojo.entity.bean.Musteri;

public interface MusteriDAO {

	public Connection veritabaninaBaglantiKur(); 
	public List<Musteri> veriOku();
	public Musteri veriOku(int musteriId);
	public boolean veriEkle(Musteri musteri);
	public boolean veriDuzenle(Musteri musteri, int musteriId);
	public boolean veriSilme(int musteriId);
}
