package DATABASE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	static String url = "jdbc:sqlite:C://dental_db/HastaBilgileri.db";
	static Connection conn = null;
	static Statement st;
	public static ResultSet rs;
	
	public static boolean baglan() {
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("Veritabanına bağlanıldı");
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
	}
	
	
	public static ResultSet listele(String sorgu) {

		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sorgu);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	public static void kaydet(String sorgu) {
		
		try {
			st = conn.createStatement();
			st.executeUpdate(sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void sil(String sorgu) {
		
		try {
			st.executeUpdate(sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void duzenle(String sorgu) {
		try {
			st.executeUpdate(sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static ResultSet sorgula(String sorgu) {
		rs = null;
		try {
			rs = st.executeQuery(sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public static ResultSet yap() {
		rs = null;
		
		try {
			conn = DriverManager.getConnection(url);
			st = conn.createStatement();
			rs= st.executeQuery("select * from GirisBilgileri");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	public static ResultSet connect() {
		rs = null;
		
		try {
			conn = DriverManager.getConnection(url);
			st = conn.createStatement();
			rs= st.executeQuery("select * from TedaviFiyatlari");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}

}