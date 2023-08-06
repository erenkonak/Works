package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Helper.helper;
import Model.proj;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class ProjeupdateGUI extends JFrame {

	private JPanel contentPane;
	private JTextField proj_t;
	private JTextField taným_g;
	private JTextField detay_u;
	private JTextField grup_u;
	private JTextField enddate_u;
	private static proj pro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjeupdateGUI frame = new ProjeupdateGUI(pro);
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
	public ProjeupdateGUI(proj pro) {
		setTitle("Proje G\u00FCncelleme Men\u00FCs\u00FC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		proj_t = new JTextField();
		proj_t.setColumns(10);
		proj_t.setBounds(10, 83, 169, 29);
		proj_t.setText(pro.getProje());
		contentPane.add(proj_t);
		
		JLabel lblNewLabel_1 = new JLabel("Proje");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(10, 49, 169, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tan\u0131m");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1_1.setBounds(238, 49, 169, 29);
		contentPane.add(lblNewLabel_1_1_1);
		
		taným_g = new JTextField();
		taným_g.setColumns(10);
		taným_g.setBounds(238, 83, 490, 29);
		taným_g.setText(pro.getTaným());
		contentPane.add(taným_g);
		
		detay_u = new JTextField();
		detay_u.setColumns(10);
		detay_u.setBounds(10, 170, 739, 29);
		detay_u.setText(pro.getDetay());
		contentPane.add(detay_u);
		
		JLabel lblNewLabel_1_1 = new JLabel("Detay");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(10, 136, 169, 29);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Kategori");
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1_1_1.setBounds(10, 226, 169, 29);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JComboBox kategori_t = new JComboBox();
		kategori_t.setModel(new DefaultComboBoxModel(new String[] {"PROJELER"}));
		kategori_t.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		kategori_t.setBackground(Color.WHITE);
		kategori_t.setBounds(10, 253, 169, 29);
		kategori_t.setSelectedItem(pro.getKategori());
		contentPane.add(kategori_t);
		
		JComboBox dogrulama_t = new JComboBox();
		dogrulama_t.setModel(new DefaultComboBoxModel(new String[] {"Ba\u015Flang\u0131\u00E7"}));
		dogrulama_t.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		dogrulama_t.setBackground(Color.WHITE);
		dogrulama_t.setBounds(238, 253, 169, 29);
		dogrulama_t.setSelectedItem(pro.getDurum());
		contentPane.add(dogrulama_t);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Do\u011Frulama");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1_1_1_1.setBounds(238, 226, 169, 29);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		grup_u = new JTextField();
		grup_u.setColumns(10);
		grup_u.setBounds(499, 260, 169, 29);
		grup_u.setText(pro.getGrup());
		contentPane.add(grup_u);
		
		JLabel lblNewLabel_1_2 = new JLabel("Grup");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(499, 226, 169, 29);
		contentPane.add(lblNewLabel_1_2);
		
		enddate_u = new JTextField();
		enddate_u.setColumns(10);
		enddate_u.setBounds(238, 354, 169, 29);
		enddate_u.setText(pro.getEnddate());
		contentPane.add(enddate_u);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Biti\u015F Tarihi");
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_2_1.setBounds(238, 320, 169, 29);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("\u0130\u015F T\u00FCr\u00FC");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1_1_1_2.setBounds(10, 320, 169, 29);
		contentPane.add(lblNewLabel_1_1_1_1_2);
		
		JComboBox Type_t = new JComboBox();
		Type_t.setModel(new DefaultComboBoxModel(new String[] {"Mobilya"}));
		Type_t.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		Type_t.setBackground(Color.WHITE);
		Type_t.setBounds(10, 347, 169, 29);
		Type_t.setSelectedItem(pro.getType());
		contentPane.add(Type_t);
		
		JButton Güncelle = new JButton("G\u00FCncelle");
		Güncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(helper.confirm("sure")) {
					pro.updateProje(proj_t.getText() , taným_g.getText(), detay_u.getText(), enddate_u.getText(), kategori_t.getSelectedItem().toString(), dogrulama_t.getSelectedItem().toString(), grup_u.getText(), Type_t.getSelectedItem().toString(), pro.getP_ID());
					helper.showmsg("succes");
					dispose();
					
					
				}
			}
		});
		Güncelle.setBounds(520, 384, 151, 36);
		contentPane.add(Güncelle);
	}
}
