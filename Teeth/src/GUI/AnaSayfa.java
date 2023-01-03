package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnaSayfa extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnaSayfa frame = new AnaSayfa();
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
	public AnaSayfa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton giris_btn = new JButton("GİRİŞ");
		giris_btn.setBackground(SystemColor.inactiveCaptionBorder);
		giris_btn.setFont(new Font("Tahoma", Font.BOLD, 15));
		giris_btn.setBounds(110, 241, 160, 47);
		contentPane.add(giris_btn);
		
		giris_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Login l=new Login();
				l.setVisible(true);
				dispose();
				
				
				
			}
			
			
			
			
			
			
			
			
			
			
		});
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(getClass().getResource("AnaSayfa.png")));
		
		lblNewLabel.setBounds(89, 11, 200, 200);
		contentPane.add(lblNewLabel);
		
		
		
		
		
		
		
	}

}
	
	
	



