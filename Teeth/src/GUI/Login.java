package GUI;

 import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DATABASE.Database;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username_txt;
	private JPasswordField passwordField;
	static String ad;
	static String sifre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel kullanici_lbl = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		kullanici_lbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		kullanici_lbl.setBounds(146, 132, 219, 70);
		contentPane.add(kullanici_lbl);
		
		username_txt = new JTextField();
		username_txt.setBounds(146, 188, 185, 35);
		contentPane.add(username_txt);
		username_txt.setColumns(10);
		
		JLabel sifre_lbl = new JLabel("\u015E\u0130FRE");
		sifre_lbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		sifre_lbl.setBounds(146, 234, 134, 42);
		contentPane.add(sifre_lbl);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(146, 287, 185, 35);
		contentPane.add(passwordField);
		
		JButton giris_btn = new JButton("G\u0130R\u0130\u015E");
		giris_btn.setFont(new Font("Tahoma", Font.BOLD, 13));
		giris_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ad = username_txt.getText();
				sifre = passwordField.getText();
				
				String sqlSorgu = "select count(user_id) as giris from GirisBilgileri where username='"+ad+
						"' and pass='"+sifre+"'";
				
				ResultSet rs = Database.yap();
				rs = Database.sorgula(sqlSorgu);
				
				try {
					while(rs.next()) {
						if(rs.getInt("giris")==1) {
							YonlendirmeEkrani ye = new YonlendirmeEkrani();
							ye.setVisible(true);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "HATALI KULLANICI GİRİŞİ !");
							username_txt.setText("");
							passwordField.setText("");
						}
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		giris_btn.setBounds(145, 351, 186, 52);
		contentPane.add(giris_btn);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(getClass().getResource("Login.png")));
		
		lblNewLabel.setBounds(0, 0, 483, 414);
		contentPane.add(lblNewLabel);
	}
}
