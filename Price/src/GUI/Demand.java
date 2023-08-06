package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.ScrollPane;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.text.html.HTMLEditorKit.Parser;

import Code.Pri_dem;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;



public class Demand extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel demandmodel;
	private DefaultTableModel demandmodel1;
	private Object[] price_data=null;
	private Object[] demand_data=null;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	
	Connection connection;
	Helper.helper helper=new Helper.helper();
	Pri_dem pri=new Code.Pri_dem();
	private JTable Pri_table;
	private JTable table_1;
	private JTextField Price;
	private JTextField Cost;
	private JTextField T_Cost;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demand frame = new Demand();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Demand() throws SQLException {
		
		demandmodel=new DefaultTableModel();
		Object[] colname=new Object[19];
		colname[0]="Id";
		colname[1]="Customer_name";
		colname[2]="Project_name";
		colname[3]="Department";
		colname[4]="Item Name";
		colname[5]="Item Code";
		colname[6]="Brand";
		colname[7]="Item description";
		colname[8]="Size";
		colname[9]="Annual unit";
		colname[10]="Create date";
		colname[11]="Deadline";
		colname[12]="Status";
		colname[13]="Quote Date";
		colname[14]="Quote Dollar";
		colname[15]="NBA";
		colname[16]="Order Size";
		colname[17]="Lead Time";
		colname[18]="Price";
		
		
		demandmodel.setColumnIdentifiers(colname);
		
		demandmodel1=new DefaultTableModel();
		Object[] colname1=new Object[22];
		colname1[0]="Id";
		colname1[1]="Customer_name";
		colname1[2]="Project_name";
		colname1[3]="Department";
		colname1[4]="Item Name";
		colname1[5]="Item Code";
		colname1[6]="Brand";
		colname1[7]="Item description";
		colname1[8]="Size";
		colname1[9]="Annual unit";
		colname1[10]="Create date";
		colname1[11]="Deadline";
		colname1[12]="Status";
		colname1[13]="Quote Date";
		colname1[14]="Quote Dollar";
		colname1[15]="NBA";
		colname1[16]="Order Size";
		colname1[17]="Lead Time";
		colname1[18]="Price";
		colname1[19]="Profit Margin";
		colname1[20]="Cost";
		colname1[21]="Transportation Cost";
		
		
		demandmodel1.setColumnIdentifiers(colname1);
		
		price_data=new Object[22];
		if(pri.getlist().size()==0 || pri.getlist().isEmpty()) {
			
		}else {
			for(int i=0;i<pri.getlist().size();i++) {
				price_data[0]=pri.getlist().get(i).getItem_id();
				price_data[1]=pri.getlist().get(i).getCustomer_Name();
				price_data[2]=pri.getlist().get(i).getProject_name();
				price_data[3]=pri.getlist().get(i).getDepartment();
				price_data[4]=pri.getlist().get(i).getItem_name();
				price_data[5]=pri.getlist().get(i).getItem_code();
				price_data[6]=pri.getlist().get(i).getBrand();
				price_data[7]=pri.getlist().get(i).getÝtem_description();
				price_data[8]=pri.getlist().get(i).getSize();
				price_data[9]=pri.getlist().get(i).getAnnual_unit();
				price_data[10]=  dateFormat.format(pri.getlist().get(i).getCreate_time());
				price_data[11]=pri.getlist().get(i).getDeadline();
				if(pri.getlist().get(i).getStatus().equals("W")) {
					price_data[12]="Item Waiting Approval";
					
				}else if(pri.getlist().get(i).getStatus().equals("P")) {
					price_data[12]="Waiting to Price";

					
				}else if(pri.getlist().get(i).getStatus().equals("O")) {
				price_data[12]="Price Waiting Approval";	
			}else if(pri.getlist().get(i).getStatus().equals("A")) {
				price_data[12]="Price Determined";	
			}else {
				price_data[12]="Project Canceled";
				
			}
				price_data[13]=pri.getlist().get(i).getQuote_date();
				price_data[14]=pri.getlist().get(i).getQuote_dollar();
				price_data[15]=pri.getlist().get(i).getNBA();
				price_data[16]=pri.getlist().get(i).getOrder_Size();
				price_data[17]=pri.getlist().get(i).getLead_Time();
				price_data[18]=pri.getlist().get(i).getPrice();
				price_data[19]=pri.getlist().get(i).getProfit_Margin();
				price_data[20]=pri.getlist().get(i).getCost();
				price_data[21]=pri.getlist().get(i).getTrans_Cost();
				demandmodel1.addRow(price_data);
				
				
			}
			
		}
		
		
		demand_data=new Object[19];
		if(pri.getlist().size()==0 || pri.getlist().isEmpty()) {
			
		}else {
			for(int i=0;i<pri.getlist().size();i++) {
				demand_data[0]=pri.getlist().get(i).getItem_id();
				demand_data[1]=pri.getlist().get(i).getCustomer_Name();
				demand_data[2]=pri.getlist().get(i).getProject_name();
				demand_data[3]=pri.getlist().get(i).getDepartment();
				demand_data[4]=pri.getlist().get(i).getItem_name();
				demand_data[5]=pri.getlist().get(i).getItem_code();
				demand_data[6]=pri.getlist().get(i).getBrand();
				demand_data[7]=pri.getlist().get(i).getÝtem_description();
				demand_data[8]=pri.getlist().get(i).getSize();
				demand_data[9]=pri.getlist().get(i).getAnnual_unit();
				demand_data[10]=  dateFormat.format(pri.getlist().get(i).getCreate_time());
				demand_data[11]=pri.getlist().get(i).getDeadline();
				if(pri.getlist().get(i).getStatus().equals("W")) {
					demand_data[12]="Item Waiting Approval";
					
				}else if(pri.getlist().get(i).getStatus().equals("P")) {
					demand_data[12]="Waiting to Price";

					
				}else if(pri.getlist().get(i).getStatus().equals("O")) {
				demand_data[12]="Price Waiting Approval";	
			}else if(pri.getlist().get(i).getStatus().equals("A")) {
				demand_data[12]="Price Determined";	
			}else {
				demand_data[12]="Project Canceled";
				
			}
				demand_data[13]=pri.getlist().get(i).getQuote_date();
				demand_data[14]=pri.getlist().get(i).getQuote_dollar();
				demand_data[15]=pri.getlist().get(i).getNBA();
				demand_data[16]=pri.getlist().get(i).getOrder_Size();
				demand_data[17]=pri.getlist().get(i).getLead_Time();
				demand_data[18]=pri.getlist().get(i).getPrice();
				demandmodel.addRow(demand_data);
				
				
			}
			
		}
		
		


	
				
				
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1549, 707);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome "+KullanýcýGiris.name);
		lblNewLabel.setBounds(10, 10, 101, 22);
		contentPane.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 74, 1491, 586);
		contentPane.add(tabbedPane);
		
		table = new JTable(demandmodel);
		
        Font font = new Font("Verdana", Font.PLAIN, 12);
        JTableHeader header = table.getTableHeader();
        header.setFont(font);
        header.setBackground(Color.WHITE);
        header.setForeground(Color.BLACK);
        table.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        table.setBackground(Color.WHITE);
        table.setFillsViewportHeight(true);
        table.getColumnModel().getColumn(0).setPreferredWidth(20);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);
        table.getColumnModel().getColumn(5).setPreferredWidth(15);
        table.getColumnModel().getColumn(6).setPreferredWidth(80);
        table.getColumnModel().getColumn(7).setPreferredWidth(200);
        table.getColumnModel().getColumn(8).setPreferredWidth(20);
        table.getColumnModel().getColumn(9).setPreferredWidth(20);
        table.getColumnModel().getColumn(10).setPreferredWidth(80);
        table.getColumnModel().getColumn(11).setPreferredWidth(80);
        table.getColumnModel().getColumn(12).setPreferredWidth(150);
        table.getColumnModel().getColumn(13).setPreferredWidth(80);
        table.getColumnModel().getColumn(14).setPreferredWidth(20);
        table.getColumnModel().getColumn(15).setPreferredWidth(60);
        table.getColumnModel().getColumn(16).setPreferredWidth(20);
        table.getColumnModel().getColumn(17).setPreferredWidth(20);
        Pri_table = new JTable(demandmodel1);
        
        
        
       
        JTableHeader header1 = Pri_table.getTableHeader();
        header1.setFont(font);
        header1.setBackground(Color.WHITE);
        header1.setForeground(Color.BLACK);
        Pri_table.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Pri_table.setBackground(Color.WHITE);
        Pri_table.setFillsViewportHeight(true);
        Pri_table.getColumnModel().getColumn(0).setPreferredWidth(20);
        Pri_table.getColumnModel().getColumn(1).setPreferredWidth(80);
        Pri_table.getColumnModel().getColumn(2).setPreferredWidth(80);
        Pri_table.getColumnModel().getColumn(3).setPreferredWidth(80);
        Pri_table.getColumnModel().getColumn(4).setPreferredWidth(80);
        Pri_table.getColumnModel().getColumn(5).setPreferredWidth(15);
        Pri_table.getColumnModel().getColumn(6).setPreferredWidth(80);
        Pri_table.getColumnModel().getColumn(7).setPreferredWidth(200);
        Pri_table.getColumnModel().getColumn(8).setPreferredWidth(20);
        Pri_table.getColumnModel().getColumn(9).setPreferredWidth(20);
        Pri_table.getColumnModel().getColumn(10).setPreferredWidth(80);
        Pri_table.getColumnModel().getColumn(11).setPreferredWidth(80);
        Pri_table.getColumnModel().getColumn(12).setPreferredWidth(300);
        Pri_table.getColumnModel().getColumn(13).setPreferredWidth(80);
        Pri_table.getColumnModel().getColumn(14).setPreferredWidth(20);
        Pri_table.getColumnModel().getColumn(15).setPreferredWidth(60);
        Pri_table.getColumnModel().getColumn(16).setPreferredWidth(20);
        Pri_table.getColumnModel().getColumn(17).setPreferredWidth(20);
        Pri_table.setFont(font);
        Pri_table.setRowHeight(20);
        
        //GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(this);

        
        
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(5).setCellRenderer(new DateCellRenderer());
        


		table.setFont(font);
        table.setRowHeight(20);
        
        
        
        JScrollPane scrollPane1 = new JScrollPane();
        tabbedPane.addTab("Demand", null, scrollPane1, null);
        scrollPane1.setViewportView(table);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 5, 1185, 530);
        
        
        
        
        scrollPane.setViewportView(Pri_table);
        Pri_table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				try {
					Price.setText(Pri_table.getValueAt(Pri_table.getSelectedRow(), 18).toString());
					Cost.setText(Pri_table.getValueAt(Pri_table.getSelectedRow(), 20).toString());
					T_Cost.setText(Pri_table.getValueAt(Pri_table.getSelectedRow(), 21).toString());
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
	
				// TODO Auto-generated method stub				
			}
		});
        JPanel panel = new JPanel();
        
        
        tabbedPane.addTab("New tab", null, panel, null);
        panel.setLayout(null);
        panel.add(scrollPane);

        
        JLabel lblNewLabel_1 = new JLabel("Price");
        lblNewLabel_1.setBounds(1220, 101, 45, 13);
        panel.add(lblNewLabel_1);
        
        Price = new JTextField();
        Price.setBounds(1333, 98, 96, 19);
        panel.add(Price);
        Price.setColumns(10);
        
        JLabel lblNewLabel_1_1 = new JLabel("Cost");
        lblNewLabel_1_1.setBounds(1220, 154, 51, 13);
        panel.add(lblNewLabel_1_1);
        
        Cost = new JTextField();
        Cost.setColumns(10);
        Cost.setBounds(1333, 151, 96, 19);
        panel.add(Cost);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Transportation Cost");
        lblNewLabel_1_1_1.setBounds(1220, 202, 103, 13);
        panel.add(lblNewLabel_1_1_1);
        
        T_Cost = new JTextField();
        T_Cost.setColumns(10);
        T_Cost.setBounds(1333, 199, 96, 19);
        panel.add(T_Cost);
        
        JButton Price1 = new JButton("Ok");
        Price1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println(Pri_table.getValueAt(Pri_table.getSelectedRow(), 12).toString());
        		if(Pri_table.getValueAt(Pri_table.getSelectedRow(), 12).equals("Waiting to Price")) {
        			int id=(int) Pri_table.getValueAt(Pri_table.getSelectedRow(), 0);
            		double price=Double.parseDouble(Price.getText());
            		try {
    					pri.updatePrice(id, price, Double.parseDouble(Cost.getText()), Double.parseDouble(T_Cost.getText()));
    					try {
							updatemod1();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
    				} catch (NumberFormatException | IOException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
        			
        		}else {
        			helper.showmsg("Inappropriate Status");
        		}
        		
        		
        	}
        });
        Price1.setBounds(1344, 264, 85, 21);
        panel.add(Price1);
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int col = table.columnAtPoint(e.getPoint());
                JFrame frame = new JFrame("Date Table Example");


                if (col == 5) {
                    String formattedDate=dateFormat.format(table.getModel().getValueAt(row, col));
					formattedDate =  (String) JOptionPane.showInputDialog(frame,"Pick a date:", "Date Picker", 
					        JOptionPane.PLAIN_MESSAGE, null, null, formattedDate);
					if (formattedDate != null) {
					    table.getModel().setValueAt(formattedDate, row, col);
					}
                }
            }
        });
		
		table.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				if(e.getType()==TableModelEvent.UPDATE) {
					
					String c_name="";
					if(table.getValueAt(table.getSelectedRow(),1).toString().equals(null)) {
						 c_name="";			
					}else {
						 c_name=table.getValueAt(table.getSelectedRow(),1).toString();	
					}
					String p_name=" ";
					if(table.getValueAt(table.getSelectedRow(),2).toString().isEmpty()) {
						 p_name="";			
					}else {
						 p_name=table.getValueAt(table.getSelectedRow(),2).toString();	
					}
					String dep="";
					if(table.getValueAt(table.getSelectedRow(),3).toString().equals(null)) {
						 dep="";			
					}else {
						 dep=table.getValueAt(table.getSelectedRow(),3).toString();	
					}
					int i_id=Integer.parseInt(table.getValueAt(table.getSelectedRow(),5).toString());
					String i_name="";
					if(table.getValueAt(table.getSelectedRow(),4).toString().equals(null)) {
						 i_name="";			
					}else {
						 i_name=table.getValueAt(table.getSelectedRow(),4).toString();	
					}
					java.sql.Date dead=java.sql.Date.valueOf("0001-01-01");
					if(table.getValueAt(table.getSelectedRow(), 11).equals(null)) {
						 dead=java.sql.Date.valueOf("0001-01-01");

					}else {
						 dead=(Date) table.getValueAt(table.getSelectedRow(), 11);
					}
					String brand="";
					if(table.getValueAt(table.getSelectedRow(),6).toString().equals(null)) {
						 brand="";			
					}else {
						 brand=table.getValueAt(table.getSelectedRow(),6).toString();	
					}
						
					int selectedid=Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString());
					String item_des="";
					if(table.getValueAt(table.getSelectedRow(),7).toString().equals(null)) {
						item_des="";			
					}else {
						 item_des=table.getValueAt(table.getSelectedRow(),7).toString();	
					}
					
					int size=Integer.parseInt(table.getValueAt(table.getSelectedRow(),8).toString());
					int ann_un=Integer.parseInt(table.getValueAt(table.getSelectedRow(),9).toString());
					java.sql.Date quote_date=java.sql.Date.valueOf("0001-01-01");
					if(table.getValueAt(table.getSelectedRow(), 13).equals(null)) {
						 quote_date=java.sql.Date.valueOf("0001-01-01");

					}else {
						 quote_date=(Date) table.getValueAt(table.getSelectedRow(), 13);}
					Double quote_dollar= Double.parseDouble(table.getValueAt(table.getSelectedRow(), 14).toString());
					String NBA="";	
					if(table.getValueAt(table.getSelectedRow(),15).toString().equals(null)) {
						 NBA="";			
					}else {
						 NBA=table.getValueAt(table.getSelectedRow(),15).toString();	
					}
					int Order_size=Integer.parseInt(table.getValueAt(table.getSelectedRow(),16).toString());
					int Leadtime=Integer.parseInt(table.getValueAt(table.getSelectedRow(),17).toString());
					
					
		
					

			
			
					
					try {
						
						
						boolean x=pri.updateDemand1(p_name, c_name,dep, i_id, i_name, dead, brand, selectedid,item_des,size,ann_un,quote_date,quote_dollar,NBA,Order_size,Leadtime);
						if(x) {
							
							
						}else {
							helper.showmsg("Update Failed");
						}
						
					} catch (Exception e2) {
						// TODO: handle exception
						e2.getMessage();
						
					}


					
					
					
				}
				
			}
		});
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.setBounds(1262, 43, 85, 21);
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean x=pri.insert1();
				try {
					updatemod();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				System.out.println(x);
				
			}
		});
		contentPane.add(btnNewButton);
		
		JButton Export = new JButton("Excel");
		Export.setBounds(1167, 43, 85, 21);
		Export.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		         try {

	                    XSSFWorkbook workbook = new XSSFWorkbook();
	                    XSSFSheet sheet = workbook.createSheet("Data");
	                    int rowIndex = 0;
	                    Row headerRow = sheet.createRow(rowIndex++);   
	                    headerRow.createCell(0).setCellValue("Id");
	                    headerRow.createCell(1).setCellValue("Customer_name");
	                    headerRow.createCell(2).setCellValue("Project_name");
	                    headerRow.createCell(3).setCellValue("Department");
	                    headerRow.createCell(4).setCellValue("Item code");
	                    headerRow.createCell(5).setCellValue("Item name");
	                    headerRow.createCell(6).setCellValue("Brand");
	                    headerRow.createCell(7).setCellValue("Item Description");
	                    headerRow.createCell(8).setCellValue("Size");
	                    headerRow.createCell(9).setCellValue("Annual unit");
	                    headerRow.createCell(10).setCellValue("Create Time");
	                    headerRow.createCell(11).setCellValue("Deadline");
	                    headerRow.createCell(12).setCellValue("Status");
	                    headerRow.createCell(13).setCellValue("Quote Date");
	                    headerRow.createCell(14).setCellValue("Quote dollar");
	                    headerRow.createCell(15).setCellValue("NBA");
	                    headerRow.createCell(16).setCellValue("Order Size");
	                    headerRow.createCell(17).setCellValue("Lead Time");
	                	                  
	                    if(pri.getlist().size()==0 || pri.getlist().isEmpty()) {

	                    }else {
	                        for(int i=0;i<pri.getlist().size();i++) {
	                            Row row = sheet.createRow(rowIndex++);
	                            Cell	cell1	=	row.createCell(0);
	                            Cell	cell2	=	row.createCell(1);
	                            Cell	cell3	=	row.createCell(2);
	                            Cell	cell4	=	row.createCell(3);
	                            Cell	cell5	=	row.createCell(4);
	                            Cell	cell6	=	row.createCell(5);
	                            Cell	cell7	=	row.createCell(6);
	                            Cell	cell8	=	row.createCell(7);
	                            Cell	cell9	=	row.createCell(8);
	                            Cell	cell10	=	row.createCell(9);
	                            Cell	cell11	=	row.createCell(10);
	                            Cell	cell12	=	row.createCell(11);
	                            Cell	cell13	=	row.createCell(12);
	                            Cell	cell14	=	row.createCell(13);
	                            Cell	cell15	=	row.createCell(14);
	                            Cell	cell16	=	row.createCell(15);
	                            Cell	cell17	=	row.createCell(16);
	                            Cell	cell18	=	row.createCell(17);
	                            
	                            cell1.setCellValue(pri.getlist().get(i).getItem_id());
	                            cell2.setCellValue(pri.getlist().get(i).getCustomer_Name());
	                            cell3.setCellValue(pri.getlist().get(i).getProject_name());
	                            cell4.setCellValue(pri.getlist().get(i).getDepartment());
	                            cell5.setCellValue(pri.getlist().get(i).getItem_name());
	                            cell6.setCellValue(pri.getlist().get(i).getItem_code());
	                            cell7.setCellValue(pri.getlist().get(i).getBrand());
	                            cell8.setCellValue(pri.getlist().get(i).getÝtem_description());
	                            cell9.setCellValue(pri.getlist().get(i).getSize());
	                            cell10.setCellValue(pri.getlist().get(i).getAnnual_unit());
	                            cell11.setCellValue(dateFormat.format(pri.getlist().get(i).getCreate_time()));
	                            cell12.setCellValue(pri.getlist().get(i).getDeadline());
	                            cell13.setCellValue(pri.getlist().get(i).getStatus());
	                            cell14.setCellValue(pri.getlist().get(i).getQuote_date());
	                            cell15.setCellValue(pri.getlist().get(i).getQuote_dollar());
	                            cell16.setCellValue(pri.getlist().get(i).getNBA());
	                            cell17.setCellValue(pri.getlist().get(i).getOrder_Size());
	                            cell18.setCellValue(pri.getlist().get(i).getLead_Time());


	                            
	                           /* cell1.setCellValue(pri.getlist().get(i).getCustomer_Name());
	                            // cell2.setCellValue(pri.getlist().get(i).getCustomer_Name());*/


	                        }

	                    }

	                    FileOutputStream outputStream = new FileOutputStream("output.xlsx");
	                    workbook.write(outputStream);
	                    workbook.close();
	                    outputStream.close();
	                    System.out.println("Data written to Excel file successfully.");

	                } catch (SQLException ex) {
	                    throw new RuntimeException(ex);
	                } catch (FileNotFoundException ex) {
	                    throw new RuntimeException(ex);
	                } catch (IOException ex) {
	                    throw new RuntimeException(ex);
	                }
	            }
	        });
		contentPane.add(Export);
		
		JButton btnNewButton_1 = new JButton("Ýmport");
		btnNewButton_1.setBounds(1072, 43, 85, 21);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfile=new JFileChooser();
				FileNameExtensionFilter filter=new FileNameExtensionFilter("Excel files", "xlsx");
				jfile.setFileFilter(filter);
				int response=jfile.showOpenDialog(null);
				if(response==JFileChooser.APPROVE_OPTION) {
					File file=new File(jfile.getSelectedFile().getAbsolutePath());
					System.out.println(file);
					
					try {
						FileInputStream inputStream = new FileInputStream(file);
			             Workbook workbook = WorkbookFactory.create(inputStream); 
			            
			            org.apache.poi.xssf.usermodel.XSSFSheet sheet =  (XSSFSheet) workbook.getSheetAt(0);
			            Iterator<Row> rowIterator = sheet.iterator();
			            int a=0;
			            while (rowIterator.hasNext()) {
			            	if(a==0) {
			            		Row row = rowIterator.next();
			            		
			            	}
			                Row row = rowIterator.next();
			                a++;
			                Cell	cell1	=	row.getCell(0);
			                Cell	cell2	=	row.getCell(1);
			                Cell	cell3	=	row.getCell(2);
			                Cell	cell4	=	row.getCell(3);
			                Cell	cell5	=	row.getCell(4);
			                Cell	cell6	=	row.getCell(5);
			                Cell	cell7	=	row.getCell(6);
			                Cell	cell8	=	row.getCell(7);
			                Cell	cell9	=	row.getCell(8);
			                Cell	cell10	=	row.getCell(9);
			                Cell	cell11	=	row.getCell(10);
			                Cell	cell12	=	row.getCell(11);
			                Cell	cell13	=	row.getCell(12);
			                Cell	cell14	=	row.getCell(13);
			                Cell	cell15	=	row.getCell(14);
			                Cell	cell16	=	row.getCell(15);
			                Cell	cell17	=	row.getCell(16);
			                Cell	cell18	=	row.getCell(17);
			         
			                
			                
			                int id =0;
			                String C_name="";
			                String Pro_name  ="";
			                String Department ="";
			                String I_name ="";
			                int I_code=0;
			                String Brand="";
			                String Descr="";
			                int Size=0;
			                int Annual_unit=0;
			                String create_time="0001-01-01";
			                java.util.Date Deadline=new Date(0);
			                String Status="";
			                java.util.Date Quote_date=new Date(0);
			                Double Quote_dollar=(double) 0;
			                String NBA="";
			                int Order_size=0;
			                int Lead_time=0;
			                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			              
			                       			                
			                
			                if(cell1==null) {cell1.setCellType(CellType.NUMERIC);}else {  cell1.setCellType(CellType.NUMERIC); id = (int) cell1.getNumericCellValue();}
			                
			                if(cell2==null) { }else {  C_name= cell2.getStringCellValue();}
			                if(cell3==null) { }else {  Pro_name =cell3.getStringCellValue();}
			                if(cell4==null) { }else {  Department=cell4.getStringCellValue();}
			                if(cell5==null) { }else {  cell6.setCellType(CellType.STRING);I_name=cell6.getStringCellValue();}
			                if(cell6==null) { }else {  cell5.setCellType(CellType.NUMERIC);I_code=(int) cell5.getNumericCellValue();}
			                if(cell7==null) { }else {  Brand=cell7.getStringCellValue();}
			                if(cell8==null) { }else {  Descr=cell8.getStringCellValue();}
			                if(cell9==null) { }else {  cell9.setCellType(CellType.NUMERIC);Size=(int) cell9.getNumericCellValue();}
			                if(cell10==null) { }else { cell10.setCellType(CellType.NUMERIC); Annual_unit=(int) cell10.getNumericCellValue();}
			                if(cell11==null) { }else {  String create_time1=cell11.getStringCellValue();}
			                if(cell12==null) { }else {   Deadline=  dateFormat.parse(cell12.getStringCellValue());}
			                if(cell13==null) { }else {  Status=cell13.getStringCellValue();}
			                if(cell14==null) { }else {  Quote_date=  dateFormat.parse(cell14.getStringCellValue());}
			                if(cell15==null) {}else {  cell15.setCellType(CellType.NUMERIC); Quote_dollar=cell15.getNumericCellValue();}
			                if(cell16==null) { }else {  NBA=cell16.getStringCellValue();}
			                if(cell17==null) { }else { cell17.setCellType(CellType.NUMERIC); Order_size=(int) cell17.getNumericCellValue();}
			                if(cell18==null) { }else { cell18.setCellType(CellType.NUMERIC); Lead_time=(int) cell18.getNumericCellValue();}
			                
			                java.sql.Date Deadline1 = new java.sql.Date(Deadline.getTime());
			                java.sql.Date Quote_date1 = new java.sql.Date(Quote_date.getTime());

			                
			     

			                
			                
			                System.out.println(Deadline1);
			                
			                if(id==0) {
			                	pri.insert( Pro_name,C_name, Department, I_code, I_name,  Deadline1, Brand, Descr, Size, Annual_unit, Quote_date1,Quote_dollar, NBA, Order_size, Lead_time);
			                	
			                }else {
			                	try {
									
									
									boolean x=pri.updateDemand1(Pro_name, C_name,Department, I_code, I_name, Deadline1 , Brand, id,Descr,Size,Annual_unit,Quote_date1,Quote_dollar,NBA,Order_size,Lead_time);
									if(x) {
										updatemod();
										
									}else {
										helper.showmsg("Update Failed");
									}
									
								} catch (Exception e2) {
									// TODO: handle exception
									e2.getMessage();
									
								}
			                	
			                }
			                
			                
			               /* int id = (int) cell1.getNumericCellValue();
			                String C_name= cell2.getStringCellValue();
			                String Pro_name =cell3.getStringCellValue();
			                String Department=cell4.getStringCellValue();
			                String I_name=cell5.getStringCellValue();
			                int I_code=(int) cell6.getNumericCellValue();
			                String Brand=cell7.getStringCellValue();
			                String Descr=cell8.getStringCellValue();
			                int Size=(int) cell9.getNumericCellValue();
			                int Annual_unit=(int) cell10.getNumericCellValue();
			                Date create_time=(Date) cell11.getDateCellValue();
			                Date Deadline=(Date) cell12.getDateCellValue();
			                String Status=cell13.getStringCellValue();
			                Date Quote_date=(Date) cell14.getDateCellValue();
			                Double Quote_dollar=cell15.getNumericCellValue();
			                String NBA=cell16.getStringCellValue();
			                int Order_size=(int) cell17.getNumericCellValue();
			                int Lead_time=(int) cell18.getNumericCellValue();*/

			                
			                
			            
			                
			              ;
			            } try {
							updatemod();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			            
			            System.out.println("Data imported successfully!");
			        } catch (IOException e1) {
			            e1.printStackTrace();
			        } catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    }
						
					 
				
			}}
		);
		contentPane.add(btnNewButton_1);
		
		JButton Onay = new JButton("Confirm");
		Onay.setBounds(977, 43, 85, 21);
		Onay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=(int) table.getValueAt(table.getSelectedRow(), 0);
				String Sta= table.getValueAt(table.getSelectedRow(), 12).toString();
				Boolean x= helper.confirm("sure");
				if(x) {
					if(Sta.equals("Item Waiting Approval")) {
						try {
							pri.updateonay(id);
							updatemod();
							updatemod1();
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
					}else {
						helper.showmsg("Status inappropriate");
					}
					
				}
			
			}
		});
		contentPane.add(Onay);
		
		JButton Red = new JButton("Reject");
		Red.setBounds(882, 43, 85, 21);
		Red.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=(int) table.getValueAt(table.getSelectedRow(), 0);
				String Sta= table.getValueAt(table.getSelectedRow(), 12).toString();
				Boolean x= helper.confirm("sure");
				if(x) {
					if(Sta.equals("Waiting to Price")) {
						try {
							pri.updatereject(id);
							updatemod();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				}else {
					helper.showmsg("Status inappropriate");
				}
			}
		});
		contentPane.add(Red);
		

	}
	private void updatemod() throws SQLException {
		DefaultTableModel clearModel=(DefaultTableModel) table.getModel();
		clearModel.setRowCount(0);
		if(pri.getlist().size()==0 || pri.getlist().isEmpty()) {
			
		}else {
			for(int i=0;i<pri.getlist().size();i++) {
				demand_data[0]=pri.getlist().get(i).getItem_id();
				demand_data[1]=pri.getlist().get(i).getCustomer_Name();
				demand_data[2]=pri.getlist().get(i).getProject_name();
				demand_data[3]=pri.getlist().get(i).getDepartment();
				demand_data[4]=pri.getlist().get(i).getItem_name();
				demand_data[5]=pri.getlist().get(i).getItem_code();
				demand_data[6]=pri.getlist().get(i).getBrand();
				demand_data[7]=pri.getlist().get(i).getÝtem_description();
				demand_data[8]=pri.getlist().get(i).getSize();
				demand_data[9]=pri.getlist().get(i).getAnnual_unit();
				demand_data[10]=dateFormat.format(pri.getlist().get(i).getCreate_time());
				demand_data[11]=pri.getlist().get(i).getDeadline();
				if(pri.getlist().get(i).getStatus().equals("W")) {
					demand_data[12]="Item Waiting Approval";
					
				}else if(pri.getlist().get(i).getStatus().equals("P")) {
					demand_data[12]="Waiting to Price";

					
				}else if(pri.getlist().get(i).getStatus().equals("O")) {
				demand_data[12]="Price Waiting Approval";	
			}else if(pri.getlist().get(i).getStatus().equals("A")) {
				demand_data[12]="Price Determined";	
			}else {
				demand_data[12]="Project Canceled";
				
			}
				demand_data[13]=pri.getlist().get(i).getQuote_date();
				demand_data[14]=pri.getlist().get(i).getQuote_dollar();
				demand_data[15]=pri.getlist().get(i).getNBA();
				demand_data[16]=pri.getlist().get(i).getOrder_Size();
				demand_data[17]=pri.getlist().get(i).getLead_Time();
				demandmodel.addRow(demand_data);
				
				
				
			}
		
		
	}}
	
	private void updatemod1() throws SQLException {
		DefaultTableModel clearModel=(DefaultTableModel) Pri_table.getModel();
		clearModel.setRowCount(0);
		if(pri.getlist().size()==0 || pri.getlist().isEmpty()) {
			
		}else {
			
				for(int i=0;i<pri.getlist().size();i++) {
					price_data[0]=pri.getlist().get(i).getItem_id();
					price_data[1]=pri.getlist().get(i).getCustomer_Name();
					price_data[2]=pri.getlist().get(i).getProject_name();
					price_data[3]=pri.getlist().get(i).getDepartment();
					price_data[4]=pri.getlist().get(i).getItem_name();
					price_data[5]=pri.getlist().get(i).getItem_code();
					price_data[6]=pri.getlist().get(i).getBrand();
					price_data[7]=pri.getlist().get(i).getÝtem_description();
					price_data[8]=pri.getlist().get(i).getSize();
					price_data[9]=pri.getlist().get(i).getAnnual_unit();
					price_data[10]=  dateFormat.format(pri.getlist().get(i).getCreate_time());
					price_data[11]=pri.getlist().get(i).getDeadline();
					if(pri.getlist().get(i).getStatus().equals("W")) {
						price_data[12]="Item Waiting Approval";
						
					}else if(pri.getlist().get(i).getStatus().equals("P")) {
						price_data[12]="Waiting to Price";

						
					}else if(pri.getlist().get(i).getStatus().equals("O")) {
					price_data[12]="Price Waiting Approval";	
				}else if(pri.getlist().get(i).getStatus().equals("A")) {
					price_data[12]="Price Determined";	
				}else {
					price_data[12]="Project Canceled";
					
				}
					price_data[13]=pri.getlist().get(i).getQuote_date();
					price_data[14]=pri.getlist().get(i).getQuote_dollar();
					price_data[15]=pri.getlist().get(i).getNBA();
					price_data[16]=pri.getlist().get(i).getOrder_Size();
					price_data[17]=pri.getlist().get(i).getLead_Time();
					price_data[18]=pri.getlist().get(i).getPrice();
					price_data[19]=pri.getlist().get(i).getProfit_Margin();
					price_data[20]=pri.getlist().get(i).getCost();
					price_data[21]=pri.getlist().get(i).getTrans_Cost();
					demandmodel1.addRow(price_data);
					
					
				}
		
		
	}}
	
	private static class DateCellRenderer extends DefaultTableCellRenderer {
        private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            if (value instanceof Date) {
                value = format.format((Date) value);
            }
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }
}
