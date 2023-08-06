package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Helper.helper;

import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;

public class AnaMenuGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnaMenuGUI frame = new AnaMenuGUI();
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
	
	public AnaMenuGUI() {
		setTitle("Ana Menu");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Eren Konak\\Desktop\\Bilgin-Yachts.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Stok Kart yönetimi");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockManGUI sto=new StockManGUI();
				sto.setVisible(true);
				dispose();
			}
		});
		
		
		JButton btnNewButton = new JButton("Depo Yönetimi");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepoGUI dep=new DepoGUI();
				dep.setVisible(true);
				dispose();
				}
			});
		btnNewButton.setBounds(10, 32, 185, 28);
		contentPane.add(btnNewButton);
		btnNewButton_1.setBounds(10, 71, 185, 28);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 11, 670, 410);
		Image image=new ImageIcon(this.getClass().getResource("/Bilgin-Yachts.png")).getImage();
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Eren Konak\\Desktop\\Bilgin-Yachts.png"));
		contentPane.add(lblNewLabel);
		
	}
}
