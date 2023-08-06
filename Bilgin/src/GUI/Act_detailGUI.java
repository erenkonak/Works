package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Model.activity;
import Model.activity_detail;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class Act_detailGUI extends JFrame {

	private JPanel contentPane;
	private JTextField Start;
	private JTextField Kodu;
	private JTextField Hour;
	private JTextField Percent;
	private JTextField End;
	private JTextField Exp;
	private JTextField Urun_adý;
	private JTextField Unit;
	private JTextField category2;
	private JTextField reserve;
	private JTextField needs;
	private JTextField demand;
	private JTextField transfer;
	private JTextField ceki_Storage;
	private JTextField consume;
	private JTextField ceki;
	private static activity ac=new activity();
	private activity_detail actd=new activity_detail();
	private DefaultTableModel detactmodel=new DefaultTableModel();
	Object[] detactdata=new Object[9];
	private JTable table_detail_activity;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Act_detailGUI frame = new Act_detailGUI(ac);
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
	public Act_detailGUI(activity ac) {
		setTitle("Activity_detail");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1128, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Object[] columndata=new Object[11];
		columndata[0]="Ürün Kod";
		columndata[1]="Ürün Adý";
		columndata[2]="Birim";
		columndata[3]="Kategori 2";
		columndata[4]="Ýhtiyaç";
		columndata[5]="Rezerve";
		columndata[6]="Transfer";
		columndata[7]="Talep";
		columndata[8]="Ceki";
		columndata[9]="Tüketim";
		columndata[10]="Çeki Depo";
		detactmodel.setColumnIdentifiers(columndata);
		Object[] detactdata=new Object[11];
		for(int i=0;i<actd.getactivity_Detail().size();i++) {
			detactdata[0]=actd.getactivity_Detail().get(i).getProduct_code();
			detactdata[1]=actd.getactivity_Detail().get(i).getProduct_name();
			detactdata[2]=actd.getactivity_Detail().get(i).getUnit();
			detactdata[3]=actd.getactivity_Detail().get(i).getCategory_2();
			detactdata[4]=(actd.getactivity_Detail().get(i).getNeeds());
			detactdata[5]=(actd.getactivity_Detail().get(i).getReserve());
			detactdata[6]=(actd.getactivity_Detail().get(i).getTransfer());
			detactdata[7]=(actd.getactivity_Detail().get(i).getDemand());
			detactdata[8]=(actd.getactivity_Detail().get(i).getCeki());
			detactdata[9]=(actd.getactivity_Detail().get(i).getConsume());
			detactdata[10]=actd.getactivity_Detail().get(i).getStorage();
			
			
					
					
	
		}
		
		JLabel lblNewLabel = new JLabel("Kodu");
		lblNewLabel.setBounds(10, 11, 119, 23);
		contentPane.add(lblNewLabel);
		
		Start = new JTextField();
		Start.setBounds(103, 55, 351, 23);
		contentPane.add(Start);
		Start.setText(ac.getBegindate());
		Start.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ba\u015Flang\u0131\u00E7");
		lblNewLabel_1.setBounds(10, 55, 119, 23);
		contentPane.add(lblNewLabel_1);
		
		Kodu = new JTextField();
		Kodu.setColumns(10);
		Kodu.setBounds(103, 11, 351, 23);
		Kodu.setText(ac.getAcitivity_code());
		contentPane.add(Kodu);
		
		JLabel lblNewLabel_1_1 = new JLabel("A\u00E7\u0131klama");
		lblNewLabel_1_1.setBounds(481, 11, 119, 23);
		contentPane.add(lblNewLabel_1_1);
		
		Hour = new JTextField();
		Hour.setColumns(10);
		Hour.setBounds(557, 99, 119, 23);
		String str=Float.toString(ac.getP_hours());
		Hour.setText(str);
		contentPane.add(Hour);
		
		JLabel lblNewLabel_2 = new JLabel("\u0130\u015F Y\u00FCzdes\u015F");
		lblNewLabel_2.setBounds(10, 99, 119, 23);
		contentPane.add(lblNewLabel_2);
		
		Percent = new JTextField();
		Percent.setForeground(Color.RED);
		Percent.setText("%100 tamamlanan aktiviteler i\u00E7in malzeme giri\u015Fi yap\u0131lamaz");
		Percent.setColumns(10);
		Percent.setBounds(103, 99, 351, 23);
		contentPane.add(Percent);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Biti\u015F");
		lblNewLabel_1_1_1.setBounds(481, 55, 119, 23);
		contentPane.add(lblNewLabel_1_1_1);
		
		End = new JTextField();
		End.setColumns(10);
		End.setBounds(557, 55, 119, 23);
		End.setText(ac.getEnddate());
		contentPane.add(End);
		
		JLabel lblNewLabel_2_1 = new JLabel("Adam/Saat");
		lblNewLabel_2_1.setBounds(481, 99, 119, 23);
		contentPane.add(lblNewLabel_2_1);
		
		Exp = new JTextField();
		Exp.setColumns(10);
		Exp.setBounds(557, 11, 119, 23);
		Exp.setText(ac.getTanim());
		contentPane.add(Exp);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 230, 1049, 344);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1029, 322);
		panel.add(scrollPane);
		
		table_detail_activity = new JTable();
		scrollPane.setViewportView(table_detail_activity);
		
		JLabel lblNewLabel_3 = new JLabel("\u00DCr\u00FCn Kod");
		lblNewLabel_3.setBounds(10, 133, 70, 25);
		contentPane.add(lblNewLabel_3);
		
		JComboBox Urunkod = new JComboBox();
		Urunkod.setBounds(10, 155, 72, 23);
		contentPane.add(Urunkod);
		
		JLabel lblNewLabel_3_1 = new JLabel("\u00DCr\u00FCn Ad\u0131");
		lblNewLabel_3_1.setBounds(103, 133, 70, 25);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Birim");
		lblNewLabel_3_1_1.setBounds(252, 133, 70, 25);
		contentPane.add(lblNewLabel_3_1_1);
		
		Urun_adý = new JTextField();
		Urun_adý.setBounds(103, 156, 139, 20);
		contentPane.add(Urun_adý);
		Urun_adý.setColumns(10);
		
		Unit = new JTextField();
		Unit.setBounds(252, 156, 86, 20);
		contentPane.add(Unit);
		Unit.setColumns(10);
		
		category2 = new JTextField();
		category2.setColumns(10);
		category2.setBounds(348, 156, 86, 20);
		contentPane.add(category2);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Kategori 2");
		lblNewLabel_3_1_1_1.setBounds(348, 133, 70, 25);
		contentPane.add(lblNewLabel_3_1_1_1);
		
		reserve = new JTextField();
		reserve.setColumns(10);
		reserve.setBounds(540, 158, 86, 20);
		contentPane.add(reserve);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Rezerve");
		lblNewLabel_3_1_1_1_1.setBounds(540, 135, 70, 25);
		contentPane.add(lblNewLabel_3_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_2 = new JLabel("\u0130hitya\u00E7");
		lblNewLabel_3_1_1_2.setBounds(444, 135, 70, 25);
		contentPane.add(lblNewLabel_3_1_1_2);
		
		needs = new JTextField();
		needs.setColumns(10);
		needs.setBounds(444, 158, 86, 20);
		contentPane.add(needs);
		
		demand = new JTextField();
		demand.setColumns(10);
		demand.setBounds(732, 156, 86, 20);
		contentPane.add(demand);
		
		JLabel lblNewLabel_3_1_1_1_1_1 = new JLabel("Talep");
		lblNewLabel_3_1_1_1_1_1.setBounds(732, 133, 70, 25);
		contentPane.add(lblNewLabel_3_1_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_2_1 = new JLabel("Transfer");
		lblNewLabel_3_1_1_2_1.setBounds(636, 133, 70, 25);
		contentPane.add(lblNewLabel_3_1_1_2_1);
		
		transfer = new JTextField();
		transfer.setColumns(10);
		transfer.setBounds(636, 156, 86, 20);
		contentPane.add(transfer);
		
		ceki_Storage = new JTextField();
		ceki_Storage.setColumns(10);
		ceki_Storage.setBounds(1020, 156, 86, 20);
		contentPane.add(ceki_Storage);
		
		JLabel lblNewLabel_3_1_1_1_1_1_1 = new JLabel("\u00C7eki Depo");
		lblNewLabel_3_1_1_1_1_1_1.setBounds(1020, 133, 70, 25);
		contentPane.add(lblNewLabel_3_1_1_1_1_1_1);
		
		JLabel lblNewLabel_3_1_1_2_1_1 = new JLabel("Tuketim");
		lblNewLabel_3_1_1_2_1_1.setBounds(924, 133, 70, 25);
		contentPane.add(lblNewLabel_3_1_1_2_1_1);
		
		consume = new JTextField();
		consume.setColumns(10);
		consume.setBounds(924, 156, 86, 20);
		contentPane.add(consume);
		
		JLabel lblNewLabel_3_1_1_1_1_2 = new JLabel("Ceki");
		lblNewLabel_3_1_1_1_1_2.setBounds(828, 135, 70, 25);
		contentPane.add(lblNewLabel_3_1_1_1_1_2);
		
		ceki = new JTextField();
		ceki.setColumns(10);
		ceki.setBounds(828, 158, 86, 20);
		contentPane.add(ceki);
		
		JButton btnNewButton = new JButton("\u0130stek Olu\u015Ftur");
		btnNewButton.setBounds(1004, 187, 102, 23);
		contentPane.add(btnNewButton);
	}

	private String toString(float p_hours) {
		// TODO Auto-generated method stub
		return null;
	}
}
