package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Helper.helper;
import Model.User;
import Model.activity;
import Model.proj;

import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Proje extends JFrame {
	private static User user=new User();

	private JPanel contentPane;
	private JTextField proje_t;
	private JTextField detay_t;
	private JTextField taným_t;
	private JTextField grup_t;
	private JTextField date_t;
	proj pro=new proj();
	private JTable table_proje;
	DefaultTableModel projemodel=new DefaultTableModel();
	Object[] projedata=new Object[9];
	private JPopupMenu projemenu;
    private activity ac=new activity();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proje frame = new Proje(user);
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
	public Proje(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Object[] columnpro=new Object[9];
		columnpro[0]="ID";
		columnpro[1]="Proje";
		columnpro[2]="Taným";
		columnpro[3]="Detay";
		columnpro[4]="Bitiþ Tarih";
		columnpro[5]="Kategori";
		columnpro[6]="Doðrulama";
		columnpro[7]="Grup";
		columnpro[8]="Ýþ Türü";
		projemodel.setColumnIdentifiers(columnpro);
		Object[] projedata=new Object[9];
		for(int i=0;i<pro.getProje1().size();i++) {
			projedata[0]=pro.getProje1().get(i).getP_ID();
			projedata[1]=pro.getProje1().get(i).getProje();
			projedata[2]=pro.getProje1().get(i).getTaným();
			projedata[3]=pro.getProje1().get(i).getDetay();
			projedata[4]=pro.getProje1().get(i).getEnddate();
			projedata[5]=pro.getProje1().get(i).getKategori();
			projedata[6]=pro.getProje1().get(i).getDurum();
			projedata[7]=pro.getProje1().get(i).getGrup();
			projedata[8]=pro.getProje1().get(i).getType();
			projemodel.addRow(projedata);
		}
		
		
		
		JLabel lblNewLabel = new JLabel("Ho\u015F Geldiniz Sayýn \n"+user.getUser_name());
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 11, 205, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Çýkýþ Yap");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(640, 13, 134, 32);
		contentPane.add(btnNewButton);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 63, 764, 438);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Projelerim", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 739, 399);
		panel.add(scrollPane);
		
		projemenu= new JPopupMenu();
		JMenuItem update=new JMenuItem("Update");
		JMenuItem delete=new JMenuItem("Delete");
		projemenu.add(update);
		projemenu.add(delete);
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(helper.confirm("sure")) {
					int selproje=Integer.parseInt(table_proje.getValueAt(table_proje.getSelectedRow(), 0).toString());
					if(pro.deleteProje(selproje)) {
						helper.showmsg("succes");
						updateproje();
					}else {
						helper.showmsg("silerken hata aldým");
					}
					
					
				}
				
			}
			
		});
		
		update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selproje=Integer.parseInt(table_proje.getValueAt(table_proje.getSelectedRow(), 0).toString());
				proj selectpro=pro.getFetch(selproje);
				ProjeupdateGUI updateGUI=new ProjeupdateGUI(selectpro);
				updateGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				updateGUI.setVisible(true);
				updateGUI.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						updateproje();
					}
					
				});
				
			}
			
		});
		
		table_proje = new JTable(projemodel);
		table_proje.setEnabled(false);
		table_proje.setComponentPopupMenu(projemenu);
		table_proje.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Point point=e.getPoint();
				int selectedRow=table_proje.rowAtPoint(point);
				table_proje.setRowSelectionInterval(selectedRow, selectedRow);
				if(e.getClickCount()==2 && table_proje.getSelectedRow()>-1) {
					int selproje=Integer.parseInt(table_proje.getValueAt(table_proje.getSelectedRow(), 0).toString());
					ac.setSelected_id(selproje);
					System.out.println(ac.getSelected_id());
					ActivityGUI actGUI=new ActivityGUI(ac);
					actGUI.setVisible(true);
					dispose();
				}
			}
		});
		scrollPane.setViewportView(table_proje);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Proje Ekle", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Proje");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(10, 11, 169, 29);
		panel_1.add(lblNewLabel_1);
		
		proje_t = new JTextField();
		proje_t.setBounds(10, 45, 169, 29);
		panel_1.add(proje_t);
		proje_t.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Detay");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(10, 98, 169, 29);
		panel_1.add(lblNewLabel_1_1);
		
		detay_t = new JTextField();
		detay_t.setColumns(10);
		detay_t.setBounds(10, 132, 739, 29);
		panel_1.add(detay_t);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tan\u0131m");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1_1.setBounds(238, 11, 169, 29);
		panel_1.add(lblNewLabel_1_1_1);
		
		taným_t = new JTextField();
		taným_t.setColumns(10);
		taným_t.setBounds(238, 45, 490, 29);
		panel_1.add(taným_t);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Kategori");
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1_1_1.setBounds(10, 188, 169, 29);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Do\u011Frulama");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1_1_1_1.setBounds(238, 188, 169, 29);
		panel_1.add(lblNewLabel_1_1_1_1_1);
		
		JComboBox kategori_t = new JComboBox();
		kategori_t.setModel(new DefaultComboBoxModel(new String[] {"PROJELER"}));
		kategori_t.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		kategori_t.setBackground(Color.WHITE);
		kategori_t.setBounds(10, 215, 169, 29);
		panel_1.add(kategori_t);
		
		JComboBox dogrulama_t = new JComboBox();
		dogrulama_t.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		dogrulama_t.setModel(new DefaultComboBoxModel(new String[] {"Ba\u015Flang\u0131\u00E7"}));
		dogrulama_t.setBackground(Color.WHITE);
		dogrulama_t.setBounds(238, 215, 169, 29);
		panel_1.add(dogrulama_t);
		
		JLabel lblNewLabel_1_2 = new JLabel("Grup");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(499, 188, 169, 29);
		panel_1.add(lblNewLabel_1_2);
		
		grup_t = new JTextField();
		grup_t.setColumns(10);
		grup_t.setBounds(499, 222, 169, 29);
		panel_1.add(grup_t);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("\u0130\u015F T\u00FCr\u00FC");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1_1_1_2.setBounds(10, 282, 169, 29);
		panel_1.add(lblNewLabel_1_1_1_1_2);
		
		JComboBox Type_t = new JComboBox();
		Type_t.setModel(new DefaultComboBoxModel(new String[] {"Mobilya", "Boru", "\u00C7elik Tekne", "Havaland\u0131rma"}));
		Type_t.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		Type_t.setBackground(Color.WHITE);
		Type_t.setBounds(10, 309, 169, 29);
		panel_1.add(Type_t);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Biti\u015F Tarihi");
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_2_1.setBounds(238, 282, 169, 29);
		panel_1.add(lblNewLabel_1_2_1);
		
		date_t = new JTextField();
		date_t.setColumns(10);
		date_t.setBounds(238, 316, 169, 29);
		panel_1.add(date_t);
		
		JButton btnNewButton_1 = new JButton("Ekle");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(proje_t.getText().length()==0||taným_t.getText().length()==0||detay_t.getText().length()==0||date_t.getText().length()==0||grup_t.getText().length()==0) {
					helper.showmsg("fill");
				}else {
					pro.addProje(proje_t.getText(),taným_t.getText(),detay_t.getText(),date_t.getText(),kategori_t.getSelectedItem().toString(),dogrulama_t.getSelectedItem().toString(),grup_t.getText(),Type_t.getSelectedItem().toString());
					helper.showmsg("succes");
					updateproje();
				}
				
			}
		});
		btnNewButton_1.setBounds(520, 346, 151, 36);
		panel_1.add(btnNewButton_1);
	}
	public void updateproje() {
		DefaultTableModel clearmodel= (DefaultTableModel) table_proje.getModel();
		clearmodel.setRowCount(0);
		for(int i=0;i<pro.getProje1().size();i++) {
			projedata[0]=pro.getProje1().get(i).getP_ID();
			projedata[1]=pro.getProje1().get(i).getProje();
			projedata[2]=pro.getProje1().get(i).getTaným();
			projedata[3]=pro.getProje1().get(i).getDetay();
			projedata[4]=pro.getProje1().get(i).getEnddate();
			projedata[5]=pro.getProje1().get(i).getKategori();
			projedata[6]=pro.getProje1().get(i).getDurum();
			projedata[7]=pro.getProje1().get(i).getGrup();
			projedata[8]=pro.getProje1().get(i).getType();
			projemodel.addRow(projedata);
		}
		
	}
}
