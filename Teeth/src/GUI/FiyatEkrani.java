package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import FUNCTION.FiyatHesaplama;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class FiyatEkrani extends JFrame {

	private JPanel contentPane;
	public static JTable fiyat_table;
	public static JComboBox kanal_comboBox;
	public static JComboBox radyo_comboBox;
	public static JComboBox tel_comboBox;
	public static JComboBox pembe_comboBox;
	public static JComboBox cekim_comboBox;
	public static JComboBox tasarim_comboBox;
	public static JComboBox dolgu_comboBox;
	public static JComboBox pro_comboBox;
	public static JComboBox implant_comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FiyatEkrani frame = new FiyatEkrani();
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
	public FiyatEkrani() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kanal Tedavisi");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(37, 21, 150, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("İmplant");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(37, 58, 121, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Pembe Tedavi");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(37, 99, 150, 19);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Diş Teli");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(37, 140, 121, 19);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Dolgu");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(37, 182, 121, 19);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Diş Çekimi");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(37, 220, 142, 19);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Gülüş Tasarımı");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(37, 257, 121, 19);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Protetik Diş Tedavisi");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(37, 299, 171, 19);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Oral Diagnoz ve Radyoloji");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBounds(28, 341, 234, 20);
		contentPane.add(lblNewLabel_8);
		
		radyo_comboBox = new JComboBox();
		radyo_comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5"}));
		radyo_comboBox.setBounds(301, 343, 45, 21);
		contentPane.add(radyo_comboBox);
		
		pro_comboBox = new JComboBox();
		pro_comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5"}));
		pro_comboBox.setBounds(301, 300, 45, 21);
		contentPane.add(pro_comboBox);
		
		tasarim_comboBox = new JComboBox();
		tasarim_comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5"}));
		tasarim_comboBox.setBounds(301, 258, 45, 21);
		contentPane.add(tasarim_comboBox);
		
		cekim_comboBox = new JComboBox();
		cekim_comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5"}));
		cekim_comboBox.setBounds(301, 221, 45, 21);
		contentPane.add(cekim_comboBox);
		
		dolgu_comboBox = new JComboBox();
		dolgu_comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5"}));
		dolgu_comboBox.setBounds(301, 183, 45, 21);
		contentPane.add(dolgu_comboBox);
		
		tel_comboBox = new JComboBox();
		tel_comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5"}));
		tel_comboBox.setBounds(301, 141, 45, 21);
		contentPane.add(tel_comboBox);
		
		pembe_comboBox = new JComboBox();
		pembe_comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5"}));
		pembe_comboBox.setBounds(301, 100, 45, 21);
		contentPane.add(pembe_comboBox);
		
		implant_comboBox = new JComboBox();
		implant_comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5"}));
		implant_comboBox.setBounds(301, 59, 45, 21);
		contentPane.add(implant_comboBox);
		
		kanal_comboBox = new JComboBox();
		kanal_comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5"}));
		kanal_comboBox.setBounds(301, 22, 45, 21);
		contentPane.add(kanal_comboBox);
		
		JButton btnNewButton = new JButton("HESAPLA");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(422, 334, 124, 38);
		contentPane.add(btnNewButton);
		
		JLabel fiyat_lbl = new JLabel("");
		fiyat_lbl.setBounds(422, 295, 97, 31);
		contentPane.add(fiyat_lbl);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(372, 25, 174, 165);
		contentPane.add(scrollPane);
		
		fiyat_table = new JTable();
		scrollPane.setViewportView(fiyat_table);
		
		JButton geri1 = new JButton("<-GERİ");
		
		geri1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				YonlendirmeEkrani ye=new YonlendirmeEkrani();
				ye.setVisible(true);
				dispose();
				
			}
			
			
			
			
			
		});
		
		
		
		
		
		
		
		geri1.setFont(new Font("Tahoma", Font.BOLD, 15));
		geri1.setBounds(38, 379, 97, 31);
		contentPane.add(geri1);
		
		
		
		
		JLabel lblNewLabel_9 = new JLabel(new ImageIcon(getClass().getResource("picture.jpg")));
		
		lblNewLabel_9.setBounds(0, 0, 562, 541);
		contentPane.add(lblNewLabel_9);
		
		FiyatHesaplama.fiyatListele();
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fiyat_lbl.setText("TUTAR : " + FiyatHesaplama.fiyatHesapla());
			}
		});
		
		
	}
}