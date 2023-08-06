package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import Helper.helper;
import Model.activity;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class ActivityGUI extends JFrame {

	private JPanel contentPane;
	private JTextField Sr_w;
	private JTextField Aktivite_w;
	private JTextField baz_w;
	private JTextField taným_w;
	private JTextField plan_w;
	private JTextField endate_w;
	private JTextField succes_d;
	private JTextField start_w;
	private JTable table_activity;
	private static activity ac=new activity();
	private DefaultTableModel acmodel;
	Object[] acdata=new Object[8];
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActivityGUI frame = new ActivityGUI(ac);
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
	
	

	
	public ActivityGUI(activity ac) {
		setTitle("Proje");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		acmodel=new DefaultTableModel();
		Object[] columac=new Object[8];
		columac[0]="Sr";
		columac[1]="Aktivite kodu";
		columac[2]="Taným";
		columac[3]="Baz Bilgi";
		columac[4]="Baþl.T";
		columac[5]="Bit.T";
		columac[6]="Ger.Bit.T";
		columac[7]="Pln.Saat";
		acmodel.setColumnIdentifiers(columac);
		Object[] acdata=new Object[8];
		
		for(int i=0;i<ac.getactivity1().size();i++) {
			acdata[0]=ac.getactivity1().get(i).getSr();
			acdata[1]=ac.getactivity1().get(i).getAcitivity_code();
			acdata[2]=ac.getactivity1().get(i).getTanim();
			acdata[3]=ac.getactivity1().get(i).getBase_inf();
			acdata[4]=ac.getactivity1().get(i).getBegindate();
			acdata[5]=ac.getactivity1().get(i).getEnddate();
			acdata[6]=ac.getactivity1().get(i).getSuccesdate();
			acdata[7]=ac.getactivity1().get(i).getP_hours();
            acmodel.addRow(acdata);
		}
		
		JLabel lblNewLabel = new JLabel("Sr");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 71, 27, 21);
		contentPane.add(lblNewLabel);
		
		Sr_w = new JTextField();
		Sr_w.setBounds(10, 99, 41, 21);
		contentPane.add(Sr_w);
		Sr_w.setColumns(10);
		
		Aktivite_w = new JTextField();
		Aktivite_w.setColumns(10);
		Aktivite_w.setBounds(61, 99, 146, 21);
		contentPane.add(Aktivite_w);
		
		JLabel activity_c = new JLabel("Aktivite Kodu");
		activity_c.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		activity_c.setBounds(60, 71, 111, 21);
		contentPane.add(activity_c);
		
		baz_w = new JTextField();
		baz_w.setColumns(10);
		baz_w.setBounds(386, 99, 142, 21);
		contentPane.add(baz_w);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ger.Bit.T");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(704, 71, 73, 21);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblTanm = new JLabel("Tan\u0131m");
		lblTanm.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblTanm.setBounds(217, 71, 73, 21);
		contentPane.add(lblTanm);
		
		taným_w = new JTextField();
		taným_w.setColumns(10);
		taným_w.setBounds(217, 99, 159, 21);
		contentPane.add(taným_w);
		
		plan_w = new JTextField();
		plan_w.setColumns(10);
		plan_w.setBounds(787, 99, 63, 21);
		contentPane.add(plan_w);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Pln.Saat");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1_1.setBounds(787, 71, 73, 21);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Bit.T");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_2_1.setBounds(621, 71, 73, 21);
		contentPane.add(lblNewLabel_2_1);
		
		endate_w = new JTextField();
		endate_w.setColumns(10);
		endate_w.setBounds(621, 99, 73, 21);
		contentPane.add(endate_w);
		
		JLabel lblBazBilgi = new JLabel("Baz Bilgi");
		lblBazBilgi.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblBazBilgi.setBounds(386, 71, 73, 21);
		contentPane.add(lblBazBilgi);
		
		succes_d = new JTextField();
		succes_d.setColumns(10);
		succes_d.setBounds(704, 99, 73, 21);
		contentPane.add(succes_d);
		
		JLabel lblNewLabel_1_2 = new JLabel("Ba\u015Fl.T");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(538, 71, 73, 21);
		contentPane.add(lblNewLabel_1_2);
		
		start_w = new JTextField();
		start_w.setColumns(10);
		start_w.setBounds(538, 99, 73, 21);
		contentPane.add(start_w);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 146, 843, 352);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 833, 330);
		panel.add(scrollPane);
		
		table_activity = new JTable(acmodel);
		table_activity.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Point point=e.getPoint();
				int selectedrow=table_activity.rowAtPoint(point);
				table_activity.setRowSelectionInterval(selectedrow, selectedrow);
				if(e.getClickCount()==2&&table_activity.getSelectedRow()>-1) {
					String activity_code=table_activity.getValueAt(selectedrow, 1).toString();
					String taným=table_activity.getValueAt(selectedrow, 2).toString();
					String start_Date=table_activity.getValueAt(selectedrow, 4).toString();
					String enddate=table_activity.getValueAt(selectedrow, 5).toString();
					float p_hours=Float.parseFloat(table_activity.getValueAt(selectedrow, 7).toString());   
					ac.setAcitivity_code(activity_code);
					ac.setEnddate(enddate);
					ac.setBegindate(start_Date);
					ac.setP_hours(p_hours);
					ac.setTanim(taným);
					Act_detailGUI act=new Act_detailGUI(ac);
					act.setVisible(true);
					dispose();
				}
			}
		});
		scrollPane.setViewportView(table_activity);
	table_activity.getModel().addTableModelListener(table_activity);
	
		table_activity.getModel().addTableModelListener(new TableModelListener() {
        
			@Override
			public void tableChanged(TableModelEvent e) {
				if(e.getType()==TableModelEvent.UPDATE) {
					int selectsr=Integer.parseInt(table_activity.getValueAt(table_activity.getSelectedRow(), 0).toString());
					String selectactivitycode=table_activity.getValueAt(table_activity.getSelectedRow(), 1).toString();
					String selecttaným=table_activity.getValueAt(table_activity.getSelectedRow(), 2).toString();
					String selectbase=table_activity.getValueAt(table_activity.getSelectedRow(), 3).toString();
					String selectbegin=table_activity.getValueAt(table_activity.getSelectedRow(), 4).toString();
					String selectaend=table_activity.getValueAt(table_activity.getSelectedRow(), 5).toString();
					String selectsucces=table_activity.getValueAt(table_activity.getSelectedRow(), 6).toString();
					float selectahours=Float.parseFloat(table_activity.getValueAt(table_activity.getSelectedRow(), 7).toString()); 
					boolean c=helper.confirm("sure");
					if(c) {boolean control=ac.updateactivity(selectsr, selectactivitycode, selecttaným, selectbase, selectbegin, selectaend, selectsucces, selectahours);
					if(control) {
						helper.showmsg("succes");
						updateactivitymodel();
						
					}
						
					
					}
					}
					
				}
				
			}
			
		);
		
	
		
		JButton btnNewButton = new JButton("Ekle");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			boolean control =	ac.addProje(Integer.parseInt(Sr_w.getText()),Aktivite_w.getText(), taným_w.getText(), baz_w.getText(), start_w.getText(), endate_w.getText(), succes_d.getText(), Float.parseFloat(plan_w.getText()));
				if(control) {
					helper.showmsg("succes");
					updateactivitymodel();
				}else {
					helper.showmsg("error");
				}
			}
		});
		btnNewButton.setBounds(870, 98, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton sil = new JButton("Sil");
		sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean c=helper.confirm("sure");
				int sr1=Integer.parseInt(table_activity.getModel().getValueAt(table_activity.getSelectedRow(), 0).toString()); 
				if(c) {
					ac.deleteactivity(sr1);
					helper.showmsg("succes");
					updateactivitymodel();
				}
			
			}
		});
		sil.setFont(new Font("Tahoma", Font.BOLD, 11));
		sil.setBounds(863, 460, 89, 23);
		contentPane.add(sil);
	}
	
	
	public void updateactivitymodel() {
		DefaultTableModel clearmodel=(DefaultTableModel) table_activity.getModel();
		clearmodel.setRowCount(0);
		for(int i=1;i<ac.getactivity1().size();i++) {
			acdata[0]=ac.getactivity1().get(i).getSr();
			acdata[1]=ac.getactivity1().get(i).getAcitivity_code();
			acdata[2]=ac.getactivity1().get(i).getTanim();
			acdata[3]=ac.getactivity1().get(i).getBase_inf();
			acdata[4]=ac.getactivity1().get(i).getBegindate();
			acdata[5]=ac.getactivity1().get(i).getEnddate();
			acdata[6]=ac.getactivity1().get(i).getSuccesdate();
			acdata[7]=ac.getactivity1().get(i).getP_hours();
            acmodel.addRow(acdata);
		}
		
	}
}
