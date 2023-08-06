package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Helper.Dbconnect;
import Helper.helper;
import Model.User;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Window.Type;

public class Giris extends JFrame {
	Dbconnect conn=new Dbconnect();

	private JPanel contentPane;
	private JTextField User_id;
	private JPasswordField Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Giris frame = new Giris();
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
	public Giris() {
		setForeground(Color.BLACK);
		setTitle("Bilgin Yacht");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kullan\u0131c\u0131 Ad\u0131:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel.setBounds(101, 52, 194, 26);
		contentPane.add(lblNewLabel);
		
		User_id = new JTextField();
		User_id.setBounds(95, 90, 200, 26);
		contentPane.add(User_id);
		User_id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u015Eifre");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1.setBounds(95, 127, 200, 26);
		contentPane.add(lblNewLabel_1);
		
		Password = new JPasswordField();
		Password.setBounds(95, 170, 200, 26);
		contentPane.add(Password);
		
		JButton btnNewButton = new JButton("Giriþ");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(User_id.getText().length()==0|| Password.getText().length()==0) {
					helper.showmsg("fill");
				}else {
					Connection c = conn.dbcon();
					boolean key=false;
					try {
						Statement st=c.createStatement();
						ResultSet rs=st.executeQuery("SELECT * FROM user");
						while(rs.next()) {
							if(User_id.getText().equals(rs.getString("user_name"))&&Password.getText().equals(rs.getString("password"))){
							System.out.println(rs.getString("user_name"));
							
								helper.showmsg("succes");
								User user=new User();
								user.setID(rs.getInt("ID"));
								user.setUser_name(rs.getString("user_name"));
								user.setPassword(rs.getString("password"));
								user.setType(rs.getString("Type"));
								Proje gui=new Proje(user);
								gui.setVisible(true);
								dispose();
							 key=true;
							
							}
						if(key) {
							
							
							
						}else {
							helper.showmsg("þifre hatalý");
						}}}catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			}
		});
		btnNewButton.setBounds(153, 221, 89, 23);
		contentPane.add(btnNewButton);
	}
}
