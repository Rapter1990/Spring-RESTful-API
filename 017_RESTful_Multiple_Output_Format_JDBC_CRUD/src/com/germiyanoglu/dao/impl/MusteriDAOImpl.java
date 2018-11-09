package com.germiyanoglu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.germiyanoglu.dao.MusteriDAO;
import com.germiyanoglu.modal.pojo.entity.bean.Musteri;

public class MusteriDAOImpl implements MusteriDAO {

	private static Connection connection = null;

	@Override
	public Connection veritabaninaBaglantiKur() {
		// TODO Auto-generated method stub

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "springDatabase", "123");

			if (!connection.isClosed()) {
				System.out.println("Veritabanýna baðlantý kuruldu.");
			} else {
				System.out.println("VeritabanÄ±na baðlantý kurulmadý.");
			}

		} catch (Exception e) {
			System.out.println("Hata: " + e);
		} finally {
			System.out.println("Aha dayý sor.");
		}

		return connection;
	}

	@Override
	public List<Musteri> veriOku() {
		// TODO Auto-generated method stub
		veritabaninaBaglantiKur();
		List<Musteri> musteriler = new ArrayList<Musteri>();
		Musteri musteri = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM Musteri");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				// System.out.println(resultSet.getInt(1) + " "+ resultSet.getInt(2) + " " +
				// resultSet.getString(3) + " "+ resultSet.getString(4) );

				musteri = new Musteri(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
						resultSet.getString(4));

				musteriler.add(musteri);
			}

		} catch (Exception e) {
			System.out.println("HATA: " + e);
		} finally {

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		for (int i = 0; i < musteriler.size(); i++) {
			Object obj = musteriler.get(i).getMusteriId() + " " + musteriler.get(i).getMusteriNo() + " "
					+ musteriler.get(i).getMusteriAd() + " " + musteriler.get(i).getMusteriSoyad();

			System.out.println(obj);
		}

		return musteriler;
	}

	@Override
	public Musteri veriOku(int musteriId) {
		// TODO Auto-generated method stub
		veritabaninaBaglantiKur();

		Musteri musteri = null;

		try {

			String sorgu = "SELECT * FROM springDatabase.Musteri WHERE musteriId=?";

			PreparedStatement preparedStatement = connection.prepareStatement(sorgu);
			preparedStatement.setInt(1, musteriId);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				musteri = new Musteri(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
						resultSet.getString(4));

			}

		} catch (Exception e) {
			System.out.println("HATA: " + e);
		}

		System.out.println(musteri);
		/*
		 * System.out.println( musteri.getMusteriId() + " " + musteri.getMusteriNo()+
		 * " " + musteri.getMusteriAdi()+ " " + musteri.getMusteriSoyadi());
		 */

		return musteri;
	}

	@Override
	public boolean veriEkle(Musteri musteri) {
		// TODO Auto-generated method stub
		veritabaninaBaglantiKur();
		boolean eklemeDurumu = false;
		String sonuc = "";
		try {

			String sorgu = "INSERT INTO Musteri (musteriNo, musteriAd, musteriSoyad) VALUES (?, ?, ?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sorgu);
			preparedStatement.setInt(1, musteri.getMusteriNo());
			preparedStatement.setString(2, musteri.getMusteriAd());
			preparedStatement.setString(3, musteri.getMusteriSoyad());
			
			// "Returns - true if the first result is a ResultSet object; false if the first result is an update count or there is no result" 
			eklemeDurumu = preparedStatement.execute();
			if (eklemeDurumu == false)
				sonuc = "Ekleme baþarýlý";
			else
				sonuc = "Ekleme baþarýsýz";

		} catch (Exception e) {
			System.out.println("HATA: " + e);
		}

		System.out.println(sonuc);

		return eklemeDurumu;

	}

	@Override
	public boolean veriDuzenle(Musteri musteri, int musteriId) {
		// TODO Auto-generated method stub
		veritabaninaBaglantiKur();
		boolean duzenlemeDurumu = false;
		String mesajSonuc = "";		
				try {
					
				
				String sorgu =	"UPDATE Musteri"
						+ " SET musteriNo = ?, "
							+ " musteriAd = ?, "
							+ " musteriSoyad = ? "
							+ " WHERE musteriId = ?";

					
					PreparedStatement  preparedStatement = connection.prepareStatement(sorgu);
					preparedStatement.setInt(1, musteri.getMusteriNo());
					preparedStatement.setString(2, musteri.getMusteriAd());
					preparedStatement.setString(3, musteri.getMusteriSoyad());
					preparedStatement.setInt(4, musteriId);
					
					int sorguSonucu = preparedStatement.executeUpdate();
					
					if(sorguSonucu == 1){
						mesajSonuc = "Düzenleme baþarýlý";
						duzenlemeDurumu = true;
						}else{
						mesajSonuc = "Düzenleme baþarýlýsýz";
						duzenlemeDurumu = false;}


				} catch (Exception e) {
				System.out.println("HATA: "+e);
				}	
				
				System.out.println(mesajSonuc);
			
				return duzenlemeDurumu;
				
	}

	@Override
	public boolean veriSilme(int musteriId) {
		// TODO Auto-generated method stub
		veritabaninaBaglantiKur();
		boolean silmeDurumu = false;
		String sonuc = "";	
		
		try {
			
			String sorgu = "DELETE FROM Musteri  WHERE musteriId=?";
			
			PreparedStatement  preparedStatement = connection.prepareStatement(sorgu);
			preparedStatement.setInt(1, musteriId);

			silmeDurumu = preparedStatement.execute();
			
			if(silmeDurumu == false)
				sonuc = "Silme baþarrýlý.";
			else
				sonuc = "Silme baþarýsýz.";
			
			

		} catch (Exception e) {
		System.out.println("HATA: "+e);
		}	
		
		System.out.println(sonuc);
		
		return silmeDurumu;
	}

	public static void main(String[] args) {
		MusteriDAOImpl daoImpl = new MusteriDAOImpl();
		
		// daoImpl.veritabaninaBaglantiKur();
		
		// daoImpl.veriOku();
		
		//daoImpl.veriOku(2);
		
		
		/*
		Musteri	musteri = new Musteri();
		musteri.setMusteriNo(2000);
		musteri.setMusteriAd("Melis");
		musteri.setMusteriSoyad("Türk");
		
		daoImpl.veriEkle(musteri);
		*/
		
		// daoImpl.veriSilme(5);
		
		//daoImpl.veriDuzenle(daoImpl.veriOku(8), 2); // 8 'i oku 6 numaraya býrak
		
		
		
		Musteri	musteri = new Musteri();
		musteri.setMusteriNo(1453);
		musteri.setMusteriAd("Ali");
		musteri.setMusteriSoyad("Sak");
		daoImpl.veriDuzenle(musteri, 1); 
		
		
		
	}

}
