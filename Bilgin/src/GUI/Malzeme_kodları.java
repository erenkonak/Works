package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Helper.helper;
import Model.Stockcard;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Malzeme_kodlarý extends JFrame {

	private JPanel contentPane;
	private JTextField product_name;
	private JTable table_list;
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
					Malzeme_kodlarý frame = new Malzeme_kodlarý();
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
	public Malzeme_kodlarý() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		product_name = new JTextField();
		product_name.setBounds(44, 11, 300, 31);
		contentPane.add(product_name);
		product_name.setColumns(10);
		
		JButton btnNewButton = new JButton("Ara");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(product_name.getText().length()==0) {
					helper.showmsg("fill");
				}else {
					DefaultTableModel clearmodel=(DefaultTableModel) table_list.getModel();
				clearmodel.setRowCount(0);
				Object[] columndata=new Object[3];
				columndata[0]="Ürün Kodu";
				columndata[1]="Ürün Adý";
				columndata[2]="Birimi";
				stokmodel.setColumnIdentifiers(columndata);
			
				try {
					String find=product_name.getText();
					for(int i=0;i<sto.getfindstokkardname(find).size();i++) {
						stokdata[0]=sto.getfindstokkardname(find).get(i).getProduct_code();
						stokdata[1]=sto.getfindstokkardname(find).get(i).getProduct_name();
						stokdata[2]=sto.getfindstokkardname(find).get(i).getUnit();
						stokmodel.addRow(stokdata);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				}
				
			}
		});
		btnNewButton.setBounds(368, 11, 135, 31);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 64, 513, 281);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 493, 259);
		panel.add(scrollPane);
		
		table_list = new JTable(stokmodel);
		table_list.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Point point=e.getPoint();
				int selectedRow=table_list.rowAtPoint(point);
				table_list.setRowSelectionInterval(selectedRow, selectedRow);
				if(e.getClickCount()==2 && table_list.getValueAt(table_list.getSelectedRow(), 0).toString()!=null) {
					DepoGUI dep1=new DepoGUI();
					dep1.setProduct_cc(table_list.getValueAt(table_list.getSelectedRow(), 0).toString());
					dep1.deneme(dep1.getProduct_cc());
					System.out.println(dep1.getProduct_cc());
					Malzeme_kodlarý mal2=new Malzeme_kodlarý();
					mal2.setVisible(false);
					dispose();
				
					
				}
			}
		});
		scrollPane.setViewportView(table_list);
	}
}
