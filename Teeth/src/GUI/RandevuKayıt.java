package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.toedter.calendar.JDateChooser;

import DATABASE.Database;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class RandevuKayıt extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel modelim = new DefaultTableModel();
	Object[] kolonlar = {"AD-SOYAD","YAŞ","TC KİMLİK","CİNSİYET","TELEFON","TEDAVİ","ALERJİLER","TARİH","SAAT"};
	Object[] satirlar = new Object[9];
	private JTextField tel_txt;
	private JTextField adsoyad_txt;
	private JTextField tckimlik_txt;
	private JTextField cinsiyet_txt;
	private JTextField tedavi_txt;
	private JTextField alerji_txt;
	private JTextField yas_txt;
	private JDateChooser dateChooser;
	private JComboBox saat_comboBox;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RandevuKayıt frame = new RandevuKayıt();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RandevuKayıt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 179, 621, 215);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(modelim);
		scrollPane.setViewportView(table);
		
		JLabel telefon_lbl = new JLabel("TELEFON");
		telefon_lbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		telefon_lbl.setBounds(573, 11, 71, 14);
		contentPane.add(telefon_lbl);
		
		tel_txt = new JTextField();
		tel_txt.setBounds(570, 26, 87, 20);
		contentPane.add(tel_txt);
		tel_txt.setColumns(10);
		
		JLabel adsoyad_lbl = new JLabel("AD SOYAD");
		adsoyad_lbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		adsoyad_lbl.setBounds(43, 11, 79, 14);
		contentPane.add(adsoyad_lbl);
		
		adsoyad_txt = new JTextField();
		adsoyad_txt.setBounds(43, 26, 96, 20);
		adsoyad_txt.setColumns(10);
		contentPane.add(adsoyad_txt);
		
		JLabel lblTcKimlik = new JLabel("TC K\u0130ML\u0130K");
		lblTcKimlik.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTcKimlik.setBounds(291, 11, 81, 14);
		contentPane.add(lblTcKimlik);
		
		tckimlik_txt = new JTextField();
		tckimlik_txt.setBounds(292, 26, 96, 20);
		tckimlik_txt.setColumns(10);
		contentPane.add(tckimlik_txt);
		
		JLabel cinsiyet_lbl = new JLabel("C\u0130NS\u0130YET");
		cinsiyet_lbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cinsiyet_lbl.setBounds(437, 11, 87, 14);
		contentPane.add(cinsiyet_lbl);
		
		cinsiyet_txt = new JTextField();
		cinsiyet_txt.setBounds(437, 26, 96, 20);
		cinsiyet_txt.setColumns(10);
		contentPane.add(cinsiyet_txt);
		
		JButton btnNewButton = new JButton("KAYDET");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(43, 119, 128, 49);
		contentPane.add(btnNewButton);
		
		JLabel tedavi_lbl = new JLabel("TEDAVİ");
		tedavi_lbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tedavi_lbl.setBounds(189, 57, 114, 14);
		contentPane.add(tedavi_lbl);
		
		JLabel alerji_lbl = new JLabel("ALERJ\u0130LER");
		alerji_lbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		alerji_lbl.setBounds(43, 57, 96, 14);
		contentPane.add(alerji_lbl);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(328, 82, 168, 21);
		dateChooser.setDateFormatString("yyyy-MM-dd");
		contentPane.add(dateChooser);
		
		saat_comboBox = new JComboBox();
		saat_comboBox.setBounds(549, 82, 58, 21);
		saat_comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "10.00", "10.30", "11.00", "11.30", "12.00", "13.30", "14.00", "14.30", "15.00", "15.30", "16.00", "16.30"}));
		contentPane.add(saat_comboBox);
		
		tedavi_txt = new JTextField();
		tedavi_txt.setBounds(189, 82, 96, 20);
		contentPane.add(tedavi_txt);
		tedavi_txt.setColumns(10);
		
		alerji_txt = new JTextField();
		alerji_txt.setBounds(43, 82, 96, 20);
		contentPane.add(alerji_txt);
		alerji_txt.setColumns(10);
		
		JButton duzenle_btn = new JButton("D\u00DCZENLE");
		duzenle_btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		duzenle_btn.setForeground(Color.BLACK);
		duzenle_btn.setBounds(282, 119, 128, 49);
		duzenle_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf =new SimpleDateFormat("dd-MM-yyyy");
				
				
				String adSoyad,yas,tc,cinsiyet,telefon,tedavi,alerjiler,tarih,saat;
				adSoyad = adsoyad_txt.getText();
				yas = yas_txt.getText();
				tc = tckimlik_txt.getText();
				cinsiyet = cinsiyet_txt.getText();
				telefon = tel_txt.getText();
				tedavi = tedavi_txt.getText();
				alerjiler = alerji_txt.getText();
				tarih = sdf.format(dateChooser.getDate());
				saat = saat_comboBox.getSelectedItem().toString();
				
				String updateSQL = "UPDATE HastaBilgileri SET Ad_soyad='"+adSoyad+"',"+
						"Yas='"+yas+"',TC='"+tc+
						"',Cinsiyet='"+cinsiyet+"',Telefon_No='"+telefon+"',Tedavi_Yontemi='"+tedavi+
						"',Alerjiler='"+alerjiler+"',Tarih='"+tarih+"',Saat='"+saat+"' WHERE TC="+tc;
				
				Database.duzenle(updateSQL);
				dateChooser.setCalendar(null);
				baglanListele();
				
			}
		});
		contentPane.add(duzenle_btn);
		
		JButton sil_btn = new JButton("S\u0130L");
		sil_btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sil_btn.setBounds(530, 118, 127, 50);
		
		sil_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tc,sql_sorgu;
				
				tc = tckimlik_txt.getText();
				
				sql_sorgu = "DELETE FROM HastaBilgileri WHERE TC="+tc;
				
				Database.sil(sql_sorgu);
				baglanListele();
				temizle();
				
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				adsoyad_txt.setText(modelim.getValueAt(table.getSelectedRow(), 0).toString());
				yas_txt.setText(modelim.getValueAt(table.getSelectedRow(), 1).toString());
				tckimlik_txt.setText(modelim.getValueAt(table.getSelectedRow(), 2).toString());
				cinsiyet_txt.setText(modelim.getValueAt(table.getSelectedRow(), 3).toString());
				tel_txt.setText(modelim.getValueAt(table.getSelectedRow(), 4).toString());
				tedavi_txt.setText(modelim.getValueAt(table.getSelectedRow(), 5).toString());
				alerji_txt.setText(modelim.getValueAt(table.getSelectedRow(), 6).toString());
				saat_comboBox.setSelectedItem(modelim.getValueAt(table.getSelectedRow(), 8).toString());
				
			}
		});
		contentPane.add(sil_btn);
		
		JLabel yas_lbl = new JLabel("YA\u015E");
		yas_lbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		yas_lbl.setBounds(157, 11, 49, 14);
		contentPane.add(yas_lbl);
		
		yas_txt = new JTextField();
		yas_txt.setBounds(157, 26, 96, 20);
		contentPane.add(yas_txt);
		yas_txt.setColumns(10);
		
		JButton geri_btn = new JButton("<-GERİ");
		geri_btn.setBounds(26, 405, 134, 49);
		geri_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				YonlendirmeEkrani yon=new YonlendirmeEkrani();
				yon.setVisible(true);
				dispose();
				
			}
		});
		
		geri_btn.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(geri_btn);
		
		JLabel lblNewLabel_1 = new JLabel("TARİH");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(328, 57, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("SAAT");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(549, 57, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(getClass().getResource("picture.jpg")));
		
		lblNewLabel.setBounds(0, 0, 677, 556);
		contentPane.add(lblNewLabel);
		
		
		
		
		
		
		
		baglanListele();
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf =new SimpleDateFormat("dd-MM-yyyy");
				
				
				String adSoyad,yas,tc,cinsiyet,telefon,tedavi,alerjiler,tarih,saat;
				adSoyad = adsoyad_txt.getText();
				yas = yas_txt.getText();
				tc = tckimlik_txt.getText();
				cinsiyet = cinsiyet_txt.getText();
				telefon = tel_txt.getText();
				tedavi = tedavi_txt.getText();
				alerjiler = alerji_txt.getText();
				tarih = sdf.format(dateChooser.getDate());
				saat = saat_comboBox.getSelectedItem().toString();
				
				
				String kaydetSQL = "INSERT INTO HastaBilgileri (Ad_soyad, Yas, TC, Cinsiyet, Telefon_No, Tedavi_Yontemi, Alerjiler, Tarih, Saat)"+
						" VALUES ('"+adSoyad+"', '"+yas+"', '"+tc+"', '"+cinsiyet+"', '"+telefon+"', '"+tedavi+"', '"+alerjiler+"', '"+tarih+"', '"+saat+"')";
				
				
				Database.kaydet(kaydetSQL);
				baglanListele();
				temizle();
			}
		});
		
	}
	void baglanListele() {
		Database.baglan();
		String listeleSql = "select * from HastaBilgileri";
		ResultSet rs = Database.listele(listeleSql);
		
		modelim.setColumnCount(0);
		modelim.setRowCount(0);
		
		modelim.setColumnIdentifiers(kolonlar);
		
		try {
			while(rs.next()) {
				satirlar[0] = rs.getString("Ad_soyad");
				satirlar[1] = rs.getString("Yas");
				satirlar[2] = rs.getString("TC");
				satirlar[3] = rs.getString("Cinsiyet");
				satirlar[4] = rs.getString("Telefon_No");
				satirlar[5] = rs.getString("Tedavi_Yontemi");
				satirlar[6] = rs.getString("Alerjiler");
				satirlar[7] = rs.getString("Tarih");
				satirlar[8] = rs.getString("Saat");
				modelim.addRow(satirlar);
			}
			table.setModel(modelim);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void temizle() {
		adsoyad_txt.setText("");
		tckimlik_txt.setText("");
		yas_txt.setText("");
		tel_txt.setText("");
		cinsiyet_txt.setText("");
		tedavi_txt.setText("");
		alerji_txt.setText("");
		dateChooser.setCalendar(null);
		saat_comboBox.setSelectedItem(null);
		
	}
}