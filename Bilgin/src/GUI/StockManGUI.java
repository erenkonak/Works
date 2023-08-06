package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Helper.helper;
import Model.Stockcard;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class StockManGUI extends JFrame {

	private JPanel contentPane;
	private JTextField Urunk;
	private JTextField urunn;
	private JTable table_stokk;
	private Stockcard sto=new Stockcard();
	private DefaultTableModel stokmodel=new DefaultTableModel();
	Object[] stokdata=new Object[3];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockManGUI frame = new StockManGUI();
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
	public StockManGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Object[] columndata=new Object[3];
		columndata[0]="Ürün Kodu";
		columndata[1]="Ürün Adý";
		columndata[2]="Birimi";
		stokmodel.setColumnIdentifiers(columndata);
		Object[] stokdata=new Object[3];
		try {
			for(int i=0;i<sto.getstokkard1().size();i++) {
				stokdata[0]=sto.getstokkard1().get(i).getProduct_code();
				stokdata[1]=sto.getstokkard1().get(i).getProduct_name();
				stokdata[2]=sto.getstokkard1().get(i).getUnit();
				stokmodel.addRow(stokdata);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
				
				
		
		JLabel Urun_Code = new JLabel("\u00DCr\u00FCn Kodu");
		Urun_Code.setBounds(10, 11, 89, 24);
		contentPane.add(Urun_Code);
		
		JLabel lblNewLabel_1 = new JLabel("\u00DCr\u00FCn Ad\u0131");
		lblNewLabel_1.setBounds(10, 58, 89, 24);
		contentPane.add(lblNewLabel_1);
		
		Urunk = new JTextField();
		Urunk.setBounds(83, 13, 162, 22);
		contentPane.add(Urunk);
		Urunk.setColumns(10);
		
		urunn = new JTextField();
		urunn.setColumns(10);
		urunn.setBounds(83, 60, 229, 22);
		contentPane.add(urunn);
		
		JLabel lblBirim = new JLabel("Birim");
		lblBirim.setBounds(314, 11, 39, 24);
		contentPane.add(lblBirim);
		
		JComboBox Birim = new JComboBox();
		Birim.setModel(new DefaultComboBoxModel(new String[] {"Adet", "Metre"}));
		Birim.setBounds(346, 12, 65, 23);
		contentPane.add(Birim);
		
		JButton btnNewButton = new JButton("Ekle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(urunn.getText().length()==0||Urunk.getText().length()==0 ) {
					helper.showmsg("fill");
				}else {
					Stockcard k=new Stockcard();
					boolean control=k.addstockkart(Urunk.getText(),urunn.getText(),Birim.getSelectedItem().toString());
					if(control) {
						helper.showmsg("succes");
						try {
							uptadetable();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
						helper.showmsg("error");
					}
					
				}
				
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(346, 59, 89, 23);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 112, 683, 276);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 683, 276);
		panel.add(scrollPane);
		
		table_stokk = new JTable(stokmodel);
		table_stokk.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane.setViewportView(table_stokk);
		table_stokk.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

				Urunk.setText(table_stokk.getValueAt(table_stokk.getSelectedRow(), 0).toString());
				urunn.setText(table_stokk.getValueAt(table_stokk.getSelectedRow(), 1).toString());
				Birim.setSelectedItem(table_stokk.getValueAt(table_stokk.getSelectedRow(), 2));
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JButton btnNewButton_1 = new JButton("Sil");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table_stokk.getValueAt(table_stokk.getSelectedRow(), 0).toString()!=null) {
					helper.confirm("sure");
					sto.deletestokkart(table_stokk.getValueAt(table_stokk.getSelectedRow(), 0).toString());
					try {
						helper.showmsg("succes");
						uptadetable();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					helper.showmsg("error");
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(456, 59, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Bul");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Urunk.getText().length()==0) {
					helper.showmsg("fill");
				}else {
					DefaultTableModel clearmodel=(DefaultTableModel) table_stokk.getModel();
				clearmodel.setRowCount(0);
			
				try {
					String find=Urunk.getText();
					for(int i=0;i<sto.getfindstokkard(find).size();i++) {
						stokdata[0]=sto.getfindstokkard(find).get(i).getProduct_code();
						stokdata[1]=sto.getfindstokkard(find).get(i).getProduct_name();
						stokdata[2]=sto.getfindstokkard(find).get(i).getUnit();
						stokmodel.addRow(stokdata);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				}
				
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1_1.setBounds(573, 59, 89, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Temizle");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					uptadetable();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1_1_1.setBounds(573, 12, 89, 23);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_2 = new JButton("G\u00FCncelle");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean control1=helper.confirm("sure");
				if(control1){
		            System.out.println(table_stokk.getValueAt(table_stokk.getSelectedRow(), 1).toString());
					boolean control=sto.updatestokkart(Urunk.getText(),urunn.getText(),Birim.getSelectedItem().toString(),table_stokk.getValueAt(table_stokk.getSelectedRow(), 0).toString());
					if(control) {
						helper.showmsg("succes");
						try {
							uptadetable();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
						helper.showmsg("error");
					}
				}
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1_2.setBounds(456, 12, 89, 23);
		contentPane.add(btnNewButton_1_2);
	}
	public void uptadetable() throws SQLException {
		DefaultTableModel clearmodel=(DefaultTableModel) table_stokk.getModel();
		clearmodel.setRowCount(0);
		for(int i=0;i<sto.getstokkard1().size();i++) {
			stokdata[0]=sto.getstokkard1().get(i).getProduct_code();
			stokdata[1]=sto.getstokkard1().get(i).getProduct_name();
			stokdata[2]=sto.getstokkard1().get(i).getUnit();
			stokmodel.addRow(stokdata);
		}
	}
}
