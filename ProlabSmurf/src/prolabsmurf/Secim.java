package prolabsmurf;

import java.awt.*;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import javax.swing.JTextPane;

public class Secim extends JFrame {
	private JPanel contentPane;
	static boolean kontrol;
	Image img = Toolkit.getDefaultToolkit().getImage("ana_ekran.png");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 new Secim();
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Secim() {
		JFrame f = new JFrame();
		f.setTitle("Sirinler");
		f.setSize(864,486);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		
		
		
		JButton uykucu = new JButton("uykucu");
		uykucu.setBounds(138, 55, 239, 333);
		uykucu.setIcon(new ImageIcon("uykucubg.png"));
		
		f.getContentPane().add(uykucu);
		uykucu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kontrol=true;
				new Labirent();
				f.dispose();
			}
		});
		
		
		
		JButton gözlüklü = new JButton("gözlüklü");
		gözlüklü.setBounds(474, 55, 239, 333);
		gözlüklü.setIcon(new ImageIcon("gozluklubg.png"));
		
		f.getContentPane().add(gözlüklü);	
		gözlüklü.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kontrol= false;
				new Labirent();
				f.dispose();
				
			}
		});
		
		JLabel arkaplan = new JLabel("");
		arkaplan.setIcon(new ImageIcon("arkaplan.png"));
		arkaplan.setBounds(0, 0, 850, 449);
		f.getContentPane().add(arkaplan);
		
		JTextPane uykucusirintext = new JTextPane();
		uykucusirintext.setEditable(false);
		uykucusirintext.setToolTipText("");
		uykucusirintext.setBackground(new Color(176, 224, 230));
		uykucusirintext.setForeground(Color.WHITE);
		uykucusirintext.setText("               UYKUCU SIRIN");
		uykucusirintext.setFont(new Font("Stencil", Font.PLAIN, 17));
		uykucusirintext.setBounds(138, 398, 239, 30);
		f.getContentPane().add(uykucusirintext);
		
		JTextPane gozluklusirintext = new JTextPane();
		gozluklusirintext.setEditable(false);
		gozluklusirintext.setBackground(new Color(100, 149, 237));
		gozluklusirintext.setForeground(Color.WHITE);
		gozluklusirintext.setText("               GOZLUKLU SIRIN");
		gozluklusirintext.setFont(new Font("Stencil", Font.PLAIN, 17));
		gozluklusirintext.setBounds(474, 398, 239, 30);
		f.getContentPane().add(gozluklusirintext);
		
	}
}
