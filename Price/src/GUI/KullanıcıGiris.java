package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Code.Dbconnect;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class KullanýcýGiris extends JFrame {

	private JPanel contentPane;
	Connection connection;
	Helper.helper helper=new Helper.helper();
	static String name;
	public static int  id;
	

	public JTextField getUser_name() {
		return User_name;
	}

	public void setUser_name(JTextField user_name) {
		User_name = user_name;
	}

	public JPasswordField getPassword() {
		return password;
	}

	public void setPassword(JPasswordField password) {
		this.password = password;
	}

	private JTextField User_name;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KullanýcýGiris frame = new KullanýcýGiris();
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
	public KullanýcýGiris() {
		setTitle("Pricing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBounds(50, 66, 72, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(50, 106, 58, 13);
		contentPane.add(lblNewLabel_1);
		
		User_name = new JTextField();
		User_name.setBounds(156, 64, 119, 16);
		contentPane.add(User_name);
		User_name.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(156, 104, 119, 16);
		contentPane.add(password);
		
		JButton Sign = new JButton("Sign in");
		Sign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Sign.setBounds(177, 140, 85, 21);
		contentPane.add(Sign);
		Sign.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Dbconnect c=new Dbconnect();
				connection=c.dbcon();
				System.out.println("deneme");


				
				try {
					String SQL="SELECT * FROM [user] where [User]='"+User_name.getText()+"'";
					Statement smt =connection.createStatement();
		            ResultSet set=smt.executeQuery(SQL);
		            
		            while(set.next()) {
		            	
				           
		            	if (getPassword().getText().equals(set.getString(3))) {
		            		name=set.getString(2);
		            		id=set.getInt(1);
		            		Demand demand=new Demand();
		            		demand.setVisible(true);
		            		dispose();
		            		
		            		
		            		
		            		
		            		
							
						}else {
							helper.showmsg("User_Name or Password is wrong");
						}
		            	
		            	
		            }
		            smt.close();
		          
		            

				} catch(Exception e1) {
					 
					e1.printStackTrace();
					System.out.println( "baþarýsýz");
					
					
				}
				
				
				
				
			}
		});
	}
}
