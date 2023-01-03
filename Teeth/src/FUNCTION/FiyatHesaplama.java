package FUNCTION;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import DATABASE.Database;
import GUI.FiyatEkrani;

public class FiyatHesaplama {
	static DefaultTableModel modelim = new DefaultTableModel();
	static Object[] kolonlar= {"TEDAVİ","FİYAT"};
	static Object[] satirlar = new Object[2];
	
	
	public static void fiyatListele() {
		Database.baglan();
		String listeleSql = "select * from TedaviFiyatlari";
		ResultSet rs = Database.listele(listeleSql);
		
		modelim.setColumnCount(0);
		modelim.setRowCount(0);
		
		modelim.setColumnIdentifiers(kolonlar);
		
		try {
			while(rs.next()) {
				satirlar[0] = rs.getString("tedavi");
				satirlar[1] = rs.getString("fiyat");
				modelim.addRow(satirlar);
			}
			FiyatEkrani.fiyat_table.setModel(modelim);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int fiyatHesapla() {
		
		int kanal_adet = Integer.parseInt(FiyatEkrani.kanal_comboBox.getSelectedItem().toString());
		int tel_adet = Integer.parseInt(FiyatEkrani.tel_comboBox.getSelectedItem().toString());
		int pro_adet = Integer.parseInt(FiyatEkrani.pro_comboBox.getSelectedItem().toString());
		int radyo_adet = Integer.parseInt(FiyatEkrani.radyo_comboBox.getSelectedItem().toString());
		int pembe_adet = Integer.parseInt(FiyatEkrani.pembe_comboBox.getSelectedItem().toString());
		int cekim_adet = Integer.parseInt(FiyatEkrani.cekim_comboBox.getSelectedItem().toString());
		int tasarim_adet = Integer.parseInt(FiyatEkrani.tasarim_comboBox.getSelectedItem().toString());
		int dolgu_adet = Integer.parseInt(FiyatEkrani.dolgu_comboBox.getSelectedItem().toString());
		int implant_adet = Integer.parseInt(FiyatEkrani.implant_comboBox.getSelectedItem().toString());
		
		int kanal_fiyat = Integer.parseInt(FiyatEkrani.fiyat_table.getValueAt(0,1).toString());
		int tel_fiyat = Integer.parseInt(FiyatEkrani.fiyat_table.getValueAt(3,1).toString());
		int pro_fiyat = Integer.parseInt(FiyatEkrani.fiyat_table.getValueAt(7,1).toString());
		int radyo_fiyat = Integer.parseInt(FiyatEkrani.fiyat_table.getValueAt(8,1).toString());
		int pembe_fiyat = Integer.parseInt(FiyatEkrani.fiyat_table.getValueAt(2,1).toString());
		int cekim_fiyat = Integer.parseInt(FiyatEkrani.fiyat_table.getValueAt(5,1).toString());
		int tasarim_fiyat = Integer.parseInt(FiyatEkrani.fiyat_table.getValueAt(6,1).toString());
		int dolgu_fiyat = Integer.parseInt(FiyatEkrani.fiyat_table.getValueAt(4,1).toString());
		int implant_fiyat = Integer.parseInt(FiyatEkrani.fiyat_table.getValueAt(1,1).toString());
		
		
		int toplamTutar = (kanal_adet*kanal_fiyat) + (tel_adet*tel_fiyat) +(pro_adet*pro_fiyat) +
				(radyo_adet*radyo_fiyat) +(pembe_adet*pembe_fiyat) +(cekim_adet*cekim_fiyat) +
				(tasarim_adet*tasarim_fiyat) +(dolgu_adet*dolgu_fiyat) +(implant_adet*implant_fiyat);
		
		return toplamTutar;
		
	}
	
	
	
	

	

}