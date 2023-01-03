package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class YonlendirmeEkrani extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YonlendirmeEkrani frame = new YonlendirmeEkrani();
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
	public YonlendirmeEkrani() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton randevu_btn = new JButton("RANDEVU OLUŞTUR");
		randevu_btn.setFont(new Font("Tahoma", Font.BOLD, 15));
		randevu_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RandevuKayıt rka = new RandevuKayıt();
				rka.setVisible(true);
				dispose();
			}
		});
		randevu_btn.setBounds(128, 71, 183, 51);
		contentPane.add(randevu_btn);
		
		JButton fiyat_btn = new JButton("FİYAT HESAPLA");
		fiyat_btn.setFont(new Font("Tahoma", Font.BOLD, 15));
		fiyat_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FiyatEkrani fe = new FiyatEkrani();
				fe.setVisible(true);
				dispose();
			}
		});
		fiyat_btn.setBounds(128, 133, 183, 51);
		contentPane.add(fiyat_btn);
		
		JButton btn23 = new JButton("ÇIKIŞ");
		btn23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn23.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn23.setBounds(152, 376, 130, 35);
		contentPane.add(btn23);
		
		
		
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(getClass().getResource("yonlendirme.jpg")));
		
		lblNewLabel.setBounds(0, 0, 436, 411);
		contentPane.add(lblNewLabel);
	}
}