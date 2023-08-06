package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Helper.Dbconnect;
import Helper.helper;
import Model.Depo;
import Model.Stockcard;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import java.io.*;



public class DepoGUI extends JFrame {
	private String product_cc;

	public String getProduct_cc() {
		return product_cc;
	}
	

	public void setProduct_cc(String product_cc) {
		this.product_cc = product_cc;
	}

	private JPanel contentPane;
	private JTextField malkod;
	private JTextField product_na;
	private JTextField Value;
	private JTextField buyer;
	Dbconnect con=new Dbconnect();
    Connection c=con.dbcon();
    Statement st=null;
    ResultSet rs=null;
    PreparedStatement preparedstatement=null;
    private static Depo dep=new Depo();
    private JTextField malkod2;
    private JTextField product_na2;
    private JTable mal_list;
    private DefaultTableModel l_model=new DefaultTableModel();
    private DefaultTableModel l_model1=new DefaultTableModel();
    Object[] l_Data;
    private JTextField Raf;
    private JTextField Proje1;
    private JTextField person2;
    private JTextField value2;
    private JTextField proje2;
    private JTable table_mallist;
    private JTextField product_na3;
   

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepoGUI frame = new DepoGUI();
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
	public DepoGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Object[] c_Data=new Object[7];
		c_Data[0]="Ürün kodu";
		c_Data[1]="Ürün ismi";
		c_Data[2]="birim";
		c_Data[3]="Ürün Miktarý";
		c_Data[4]="Alýcý";
		c_Data[5]="Proje";
		c_Data[6]="Raf";
		
		l_model1.setColumnIdentifiers(c_Data);
		Object[] l_Data=new Object[7];
		try {
			for(int i=0;i<dep.getdepo2().size();i++) {
				l_Data[0]=dep.getdepo2().get(i).getProduct_code();
				l_Data[1]=dep.getdepo2().get(i).getProduct_name();
				l_Data[2]=dep.getdepo2().get(i).getUnit();
				l_Data[3]=dep.getdepo2().get(i).getValue();
				l_Data[4]=dep.getdepo2().get(i).getBuyer();
				l_Data[5]=dep.getdepo2().get(i).getProje();
				l_Data[6]=dep.getdepo2().get(i).getRaf();
				l_model1.addRow(l_Data);;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 764, 482);
		contentPane.add(tabbedPane);
		
		JPanel purper = new JPanel();
		tabbedPane.addTab("Malzeme Giriþ", null, purper, null);
		purper.setLayout(null);
		
		JComboBox birim = new JComboBox();
		birim.setEnabled(false);
		birim.setModel(new DefaultComboBoxModel(new String[] {"Metre", "Adet"}));
		birim.setBounds(204, 117, 62, 23);
		purper.add(birim);
		
		malkod = new JTextField();
		malkod.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_BACK_SPACE:
				break;
				case KeyEvent.VK_ENTER:
					malkod.setText(malkod.getText());
					break;
					default:
					EventQueue.invokeLater(new Runnable()	{

						@Override
						public void run() {
						String txt=malkod.getText();
						deneme1(txt);
							
						}
					
						
					});
				}
							
						
			}
		});
		malkod.setBounds(10, 48, 149, 26);
		
		malkod.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean control;
				try {
					st=c.createStatement();
					rs=st.executeQuery("select * from stokkart");
					while(rs.next()) {
						if(rs.getString("product_code").equals(malkod.getText())) {
							product_na.setText(rs.getString("product_name"));
							birim.setSelectedItem(rs.getString("Unit"));
							
							
						}
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
			
		});
		
		
		
		
		
		purper.add(malkod);
		malkod.setColumns(10);
		
		JButton btnNewButton = new JButton("Malzeme Kodu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Malzeme_kodlarý mal=new Malzeme_kodlarý();
				mal.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 21, 129, 26);
		purper.add(btnNewButton);
		
		product_na = new JTextField();
		product_na.setBounds(206, 50, 149, 23);
		product_na.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					st=c.createStatement();
					rs=st.executeQuery("select * from stokkart");
					while(rs.next()) {
						if(rs.getString("product_name").equals(product_na.getText())) {
							malkod.setText(rs.getString("product_code"));
							birim.setSelectedItem(rs.getString("Unit"));
							
							
						}
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
			
		});
		product_na.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_BACK_SPACE:
				break;
				case KeyEvent.VK_ENTER:
					product_na.setText(product_na.getText());
					break;
					default:
					EventQueue.invokeLater(new Runnable()	{

						@Override
						public void run() {
						String txt=product_na.getText();
						deneme2(txt);
							
						}
					
						
					});
					
			}
		}});
				
		purper.add(product_na);
		product_na.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Malzeme Ad\u0131");
		lblNewLabel.setBounds(206, 23, 129, 23);
		purper.add(lblNewLabel);
		
		JLabel lblBirim = new JLabel("Birim");
		lblBirim.setBounds(206, 89, 129, 23);
		purper.add(lblBirim);
		
		JLabel lblNewLabel_1 = new JLabel("De\u011Fer");
		lblNewLabel_1.setBounds(10, 87, 129, 26);
		purper.add(lblNewLabel_1);
		
		Value = new JTextField();
		Value.setColumns(10);
		Value.setBounds(10, 118, 149, 26);
		purper.add(Value);
		
		JLabel lblNewLabel_1_1 = new JLabel("Sat\u0131n Alan");
		lblNewLabel_1_1.setBounds(10, 159, 129, 26);
		purper.add(lblNewLabel_1_1);
		
		buyer = new JTextField();
		buyer.setColumns(10);
		buyer.setBounds(10, 190, 149, 26);
		purper.add(buyer);
		
		JButton btnNewButton_1 = new JButton("Ekle");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean control=false;
				try {
					st=c.createStatement();
					rs=st.executeQuery("select * from depog");
					while(rs.next()) {
						if(rs.getString("product_code").equals(malkod.getText())) {
							control=true;
						}
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(control) {
					try {
						rs=st.executeQuery("select * from depog where product_code='"+malkod.getText()+"' and status='A' fetch first 1 rows  only");
						while(rs.next()) {
							int val=rs.getInt("value");
							int value=(Integer.parseInt(Value.getText())+val);
							dep.updatedepo(malkod.getText());
							
							boolean control1=dep.adddepo(malkod.getText(), product_na.getText(), birim.getSelectedItem().toString(),value, buyer.getText(),Proje1.getText(),Raf.getText());
							System.out.println("eren");
							if(control1) {
								helper.showmsg("succes");
								
							}else {
								helper.showmsg("error");
							}
						}
		
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					
				}else {
					boolean control1=dep.adddepo(malkod.getText(), product_na.getText(), birim.getSelectedItem().toString(), Integer.parseInt(Value.getText()), buyer.getText(),Proje1.getText(),Raf.getText());
					if(control1) {
						helper.showmsg("succes");
					}else {
						helper.showmsg("error");
					}
					
					
				}
				
			
			}
		});
		btnNewButton_1.setBounds(219, 330, 108, 26);
		purper.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Raf");
		lblNewLabel_1_1_2.setBounds(204, 159, 129, 26);
		purper.add(lblNewLabel_1_1_2);
		
		Raf = new JTextField();
		Raf.setColumns(10);
		Raf.setBounds(204, 190, 149, 26);
		purper.add(Raf);
		
		JLabel Proje = new JLabel("Proje");
		Proje.setBounds(10, 231, 129, 26);
		purper.add(Proje);
		
		Proje1 = new JTextField();
		Proje1.setColumns(10);
		Proje1.setBounds(10, 262, 149, 26);
		purper.add(Proje1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Malzeme Listeleme", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel Urun_Code = new JLabel("\u00DCr\u00FCn Kodu");
		Urun_Code.setBounds(10, 11, 89, 24);
		panel_2.add(Urun_Code);
		
		malkod2 = new JTextField();
		malkod2.setEnabled(false);
		malkod2.setBounds(83, 13, 162, 22);
		malkod2.setColumns(10);
		panel_2.add(malkod2);
		
		JComboBox Birim2 = new JComboBox();
		Birim2.setEditable(true);
		Birim2.setEnabled(false);
		Birim2.setModel(new DefaultComboBoxModel(new String[] {"Adet", "Metre\t"}));
		Birim2.setBounds(321, 12, 65, 23);
		panel_2.add(Birim2);
		
		JLabel lblBirim_2 = new JLabel("Birim");
		lblBirim_2.setBounds(286, 11, 39, 24);
		panel_2.add(lblBirim_2);
		
		product_na2 = new JTextField();
		product_na2.setBounds(83, 60, 193, 22);
		product_na2.setColumns(10);
		panel_2.add(product_na2);
		
		
		JLabel lblNewLabel_1_3 = new JLabel("\u00DCr\u00FCn Ad\u0131");
		lblNewLabel_1_3.setBounds(10, 58, 89, 24);
		panel_2.add(lblNewLabel_1_3);
		
		JButton btnNewButton_2 = new JButton("\u00C7\u0131kar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println(malkod2.getText());
					st=c.createStatement();
					rs=st.executeQuery("select * from depog where product_code='"+malkod2.getText()+"' and status='A' fetch first 1 rows  only");
					while(rs.next()) {
						int val=rs.getInt("value");
						int value=(val-Integer.parseInt(value2.getText()));
						String raf=rs.getString("Raf");
						if(value>0) {
							dep.updatedepo(malkod2.getText());
						boolean control1=dep.dropdepo(malkod2.getText(), product_na2.getText(), Birim2.getSelectedItem().toString(),value, person2.getText(),proje2.getText(),raf);
						System.out.println("eren");
						if(control1) {
							helper.showmsg("succes");
							
						}else {
							helper.showmsg("error");
						
						}}else {
							helper.showmsg("yeterli sayýda ürün yok.");
						}
					}
	
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				updatemal1();
			}
		
	
			}
		);
		btnNewButton_2.setBounds(526, 60, 89, 23);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("Bul");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object[] c_Data=new Object[5];
				c_Data[0]="Ürün kodu";
				c_Data[1]="Ürün ismi";
				c_Data[2]="birim";
				c_Data[3]="Ürün Miktarý";
				c_Data[4]="Raf";
				
				l_model.setColumnIdentifiers(c_Data);
				Object[] l_Data=new Object[5];
				try {
					for(int i=0;i<dep.getdepo3(product_na2.getText()).size();i++) {
						l_Data[0]=dep.getdepo3(product_na2.getText()).get(i).getProduct_code();
						l_Data[1]=dep.getdepo3(product_na2.getText()).get(i).getProduct_name();
						l_Data[2]=dep.getdepo3(product_na2.getText()).get(i).getUnit();
						l_Data[3]=dep.getdepo3(product_na2.getText()).get(i).getValue();
						l_Data[4]=dep.getdepo3(product_na2.getText()).get(i).getRaf();
						l_model.addRow(l_Data);;
					}
					product_na2.setEnabled(false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1_1.setBounds(641, 60, 89, 23);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_2.add(btnNewButton_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 106, 739, 337);
		panel_2.add(scrollPane);
		
		mal_list = new JTable(l_model);
		scrollPane.setViewportView(mal_list);
		
		JLabel lblKii = new JLabel("Ki\u015Fi");
		lblKii.setBounds(286, 58, 32, 26);
		panel_2.add(lblKii);
		
		person2 = new JTextField();
		person2.setColumns(10);
		person2.setBounds(321, 58, 149, 26);
		panel_2.add(person2);
		
		JLabel Proje_1_1 = new JLabel("De\u011Fer");
		Proje_1_1.setBounds(412, 11, 39, 26);
		panel_2.add(Proje_1_1);
		
		value2 = new JTextField();
		value2.setColumns(10);
		value2.setBounds(461, 10, 49, 26);
		panel_2.add(value2);
		
		JLabel Proje_1_1_1 = new JLabel("Proje");
		Proje_1_1_1.setBounds(520, 10, 39, 26);
		panel_2.add(Proje_1_1_1);
		
		proje2 = new JTextField();
		proje2.setColumns(10);
		proje2.setBounds(556, 9, 173, 26);
		panel_2.add(proje2);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Malzemeler", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 52, 759, 402);
		panel.add(scrollPane_1);
		
		table_mallist = new JTable(l_model1);
		scrollPane_1.setViewportView(table_mallist);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("\u00DCr\u00FCn Ad\u0131");
		lblNewLabel_1_3_1.setBounds(10, 11, 89, 24);
		panel.add(lblNewLabel_1_3_1);

		JCheckBox history = new JCheckBox("Ge\u00E7mi\u015F i\u015Flemlerini getir");
		history.setBounds(302, 12, 131, 23);
		panel.add(history);
		
		product_na3 = new JTextField();
		product_na3.setBounds(83, 13, 193, 22);
		product_na3.setColumns(10);
		panel.add(product_na3);
		
		JButton Getir = new JButton("Getir");
		Getir.setBounds(493, 12, 89, 23);
		Getir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(history.isSelected()) {
					DefaultTableModel clearmodel= (DefaultTableModel) table_mallist.getModel();
					clearmodel.setRowCount(0);
					Object[] c_Data=new Object[10];
					c_Data[0]="Ürün kodu";
					c_Data[1]="Ürün ismi";
					c_Data[2]="birim";
					c_Data[3]="Ürün Miktarý";
					c_Data[4]="Satýn Alan";
					c_Data[5]="Proje";
					c_Data[6]="Raf";
					c_Data[7]="statü";
					c_Data[8]="Giriþ-Çýkýþ";
					c_Data[9]="Ýþlem Zamaný";
					
					l_model1.setColumnIdentifiers(c_Data);
					Object[] l_Data=new Object[10];
					try {
						for(int i=0;i<dep.getdepo4(product_na3.getText()).size();i++) {
							l_Data[0]=dep.getdepo4(product_na3.getText()).get(i).getProduct_code();
							l_Data[1]=dep.getdepo4(product_na3.getText()).get(i).getProduct_name();
							l_Data[2]=dep.getdepo4(product_na3.getText()).get(i).getUnit();
							l_Data[3]=dep.getdepo4(product_na3.getText()).get(i).getValue();
							l_Data[4]=dep.getdepo4(product_na3.getText()).get(i).getBuyer();
							l_Data[5]=dep.getdepo4(product_na3.getText()).get(i).getProje();
							l_Data[6]=dep.getdepo4(product_na3.getText()).get(i).getRaf();
							l_Data[7]=dep.getdepo4(product_na3.getText()).get(i).getStatus();
							l_Data[8]=dep.getdepo4(product_na3.getText()).get(i).getEO();
							l_Data[9]=dep.getdepo4(product_na3.getText()).get(i).getInstance_id();
							l_model1.addRow(l_Data);;
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else {
					DefaultTableModel clearmodel= (DefaultTableModel) table_mallist.getModel();
					clearmodel.setRowCount(0);
					Object[] c_Data=new Object[7];
					c_Data[0]="Ürün kodu";
					c_Data[1]="Ürün ismi";
					c_Data[2]="birim";
					c_Data[3]="Ürün Miktarý";
					c_Data[4]="Satýn Alan";
					c_Data[5]="Proje";
					c_Data[6]="Raf";
					
					l_model1.setColumnIdentifiers(c_Data);
					Object[] l_Data=new Object[7];
					try {
						for(int i=0;i<dep.getdepo3(product_na3.getText()).size();i++) {
							l_Data[0]=dep.getdepo3(product_na3.getText()).get(i).getProduct_code();
							l_Data[1]=dep.getdepo3(product_na3.getText()).get(i).getProduct_name();
							l_Data[2]=dep.getdepo3(product_na3.getText()).get(i).getUnit();
							l_Data[3]=dep.getdepo3(product_na3.getText()).get(i).getValue();
							l_Data[4]=dep.getdepo3(product_na3.getText()).get(i).getBuyer();
							l_Data[5]=dep.getdepo3(product_na3.getText()).get(i).getProje();
							l_Data[6]=dep.getdepo3(product_na3.getText()).get(i).getRaf();
							l_model1.addRow(l_Data);;
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
				
				
			}
				
				
		});
		Getir.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(Getir);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toExcel(table_mallist, null);
				
			}
		});
		btnNewButton_3.setBounds(626, 12, 89, 23);
		panel.add(btnNewButton_3);
		
		
		mal_list.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Point point=e.getPoint();
				int selectedRow=mal_list.rowAtPoint(point);
				mal_list.setRowSelectionInterval(selectedRow, selectedRow);
				if(e.getClickCount()==2 && mal_list.getSelectedRow()>-1) {
				product_na2.setText(mal_list.getValueAt(mal_list.getSelectedRow(), 1).toString());
				malkod2.setText(mal_list.getValueAt(mal_list.getSelectedRow(), 0).toString());
				Birim2.setSelectedItem(mal_list.getValueAt(mal_list.getSelectedRow(), 2).toString());
				value2.setText(mal_list.getValueAt(mal_list.getSelectedRow(), 3).toString());
				
				}
			}
		}
	);}

	
	
	
	public void deneme1(String txt) {
		String complete="";
		int start=txt.length();
		int last=txt.length();
		int a;
		Stockcard dep=new Stockcard();
		try {
			for (a=0; a<dep.getstokkard1().get(a).getProduct_code().length();a++) {
				if(dep.getstokkard1().get(a).getProduct_code().toString().startsWith(txt)) {
					complete=dep.getstokkard1().get(a).getProduct_code().toString();
					last=complete.length();
					break;
				}
				
			}
			if(last>start) {
				malkod.setText(complete);
				malkod.setCaretPosition(last);
				malkod.moveCaretPosition(start);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		

	}
	
	public void deneme2(String txt) {
		String complete="";
		int start=txt.length();
		int last=txt.length();
		int a;
		Stockcard dep=new Stockcard();
		try {
			for (a=0; a<dep.getstokkard1().get(a).getProduct_name().length();a++) {
				if(dep.getstokkard1().get(a).getProduct_name().toString().startsWith(txt)) {
					complete=dep.getstokkard1().get(a).getProduct_name().toString();
					last=complete.length();
					break;
				}
				
			}
			if(last>start) {
				product_na.setText(complete);
				product_na.setCaretPosition(last);
				product_na.moveCaretPosition(start);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		

	}
	
	public void updatemal1() {
		DefaultTableModel clearmodel= (DefaultTableModel) mal_list.getModel();
		clearmodel.setRowCount(0);
		try {
			for(int i=0;i<dep.getdepo3(product_na2.getText()).size();i++) {
				l_Data[0]=dep.getdepo3(product_na2.getText()).get(i).getProduct_code();
				l_Data[1]=dep.getdepo3(product_na2.getText()).get(i).getProduct_name();
				l_Data[2]=dep.getdepo3(product_na2.getText()).get(i).getUnit();
				l_Data[3]=dep.getdepo3(product_na2.getText()).get(i).getValue();
				l_Data[4]=dep.getdepo3(product_na2.getText()).get(i).getRaf();
				l_model.addRow(l_Data);;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	public void toExcel(JTable table, File file){
	    try{
	        TableModel model = mal_list.getModel();
	        FileWriter excel = new FileWriter(file);

	        for(int i = 0; i < model.getColumnCount(); i++){
	            excel.write(model.getColumnName(i) + "\t");
	        }

	        excel.write("\n");

	        for(int i=0; i< model.getRowCount(); i++) {
	            for(int j=0; j < model.getColumnCount(); j++) {
	                excel.write(model.getValueAt(i,j).toString()+"\t");
	            }
	            excel.write("\n");
	        }

	        excel.close();

	    }catch(IOException e){ System.out.println(e); }
	}
}
