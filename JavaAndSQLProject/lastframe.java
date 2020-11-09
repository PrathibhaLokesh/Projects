import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import com.onbarcode.barcode.Code39;
import com.toedter.calendar.JDateChooser;

import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;


public class lastframe extends JFrame {
	Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();

	private JPanel contentPane;
	private JTextField tot;
	private JTextField ser;
	private JTextField am;
	private JTextField dis;
	private JTextField tc;
	private JTextField cname;
	private JTextField trid;
	private JTextField bno;
	private JTextField bdate;
	private JTextField textField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lastframe frame = new lastframe();
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
	public lastframe() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1012,750);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 0, 993, 729);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("BILL INFORMATION");
		label.setBounds(287, 19, 285, 55);
		label.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panel.add(label);
		
		JLabel label_1 = new JLabel("BILL NO");
		label_1.setBounds(712, 55, 77, 18);
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("TOTAL CHARGE");
		label_2.setBounds(134, 257, 133, 18);
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("BILL DATE");
		label_3.setBounds(698, 96, 94, 18);
		label_3.setFont(new Font("Times New Roman", Font.BOLD, 17));
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("DD/MM/YYYY");
		label_4.setBounds(813, 138, 134, 14);
		label_4.setFont(new Font("Times New Roman", Font.BOLD, 17));
		panel.add(label_4);
		
		tot = new JTextField();
		tot.setBounds(366, 250, 133, 33);
		tot.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		tot.setColumns(10);
		panel.add(tot);
		
		ser = new JTextField();
		ser.setBounds(366, 345, 137, 34);
		ser.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		ser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				float t1=Float.parseFloat(tot.getText());
				float t2=Float.parseFloat(dis.getText());
				float t3=(t2/100)*t1;
				float t4=t1-t3;
				float t5=Float.parseFloat(ser.getText());
				float t6=t4+t5;
				String t7=String.valueOf(t6);
				am.setText(t7);
			}
		});
		ser.setColumns(10);
		panel.add(ser);
		
		JLabel lblServiceTax = new JLabel("SERVICE TAX");
		lblServiceTax.setBounds(141, 353, 126, 18);
		lblServiceTax.setFont(new Font("Times New Roman", Font.BOLD, 17));
		panel.add(lblServiceTax);
		
		am = new JTextField();
		am.setBounds(366, 398, 137, 33);
		am.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		am.setColumns(10);
		panel.add(am);
		
		JLabel label_6 = new JLabel("AMOUNT ");
		label_6.setBounds(162, 407, 94, 18);
		label_6.setFont(new Font("Times New Roman", Font.BOLD, 17));
		panel.add(label_6);
		
		dis = new JTextField();
		dis.setBounds(366, 300, 134, 33);
		dis.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		dis.setColumns(10);
		panel.add(dis);
		
		JLabel label_7 = new JLabel("DISCOUNT");
		label_7.setBounds(162, 307, 105, 18);
		label_7.setFont(new Font("Times New Roman", Font.BOLD, 17));
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("PAYMENT DUE DATE");
		label_8.setBounds(112, 447, 196, 35);
		label_8.setFont(new Font("Times New Roman", Font.BOLD, 17));
		panel.add(label_8);
		
		JDateChooser pd = new JDateChooser();
		pd.setBounds(366, 447, 145, 35);
		pd.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		pd.setDateFormatString("dd/MMM/yyyy");
		panel.add(pd);
		
		JLabel label_9 = new JLabel("PAYMENT MODE");
		label_9.setBounds(134, 506, 141, 18);
		label_9.setFont(new Font("Times New Roman", Font.BOLD, 17));
		panel.add(label_9);
		
		JComboBox pm = new JComboBox();
		pm.setBounds(366, 499, 135, 33);
		pm.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "CASH", "CHEQUE", "NEFT"}));
		pm.setFont(new Font("Times New Roman", Font.BOLD, 17));
		panel.add(pm);
		
		JLabel label_10 = new JLabel("CUSTOMER NAME");
		label_10.setBounds(134, 150, 151, 18);
		label_10.setFont(new Font("Times New Roman", Font.BOLD, 17));
		panel.add(label_10);
		
		JLabel label_11 = new JLabel("CUSTOMER ID");
		label_11.setBounds(152, 96, 133, 18);
		label_11.setFont(new Font("Times New Roman", Font.BOLD, 17));
		panel.add(label_11);
		
		tc = new JTextField();
		tc.setBounds(366, 85, 133, 35);
		tc.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		tc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String val=tc.getText();
				String sql="select cname from jointtable where cid=?";
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/svit2", "root", "");
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, val);
					ResultSet rs=ps.executeQuery();
					if(rs.next())
					{
						String v1=rs.getString("cname");
						cname.setText(v1);
					}
				}
				
				catch(Exception e)
				{
					System.out.println("cannot display value"+e.getMessage());
				}
			}
		});
		tc.setColumns(10);
		panel.add(tc);
		
		cname = new JTextField();
		cname.setBounds(366, 141, 133, 36);
		cname.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		cname.setColumns(10);
		panel.add(cname);
		
		JLabel label_12 = new JLabel("TARIFF ID");
		label_12.setBounds(162, 206, 105, 18);
		label_12.setFont(new Font("Times New Roman", Font.BOLD, 17));
		panel.add(label_12);
		
		trid = new JTextField();
		trid.setBounds(366, 198, 133, 35);
		trid.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		trid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String val1=trid.getText();
				String sql1="select totcharge,billno from tariffcalculation where tariffid=?";
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/svit2", "root", "");
					PreparedStatement ps1=con1.prepareStatement(sql1);
					ps1.setString(1, val1);
					ResultSet rs=ps1.executeQuery();
					if(rs.next())
					{
						String v2=rs.getString("totcharge");
						tot.setText(v2);
						String v3=rs.getString("billno");
						bno.setText(v3);
					}
				}
				
				catch(Exception e)
				{
					System.out.println("cannot display value"+e.getMessage());
				}
			}
		});
		trid.setColumns(10);
		panel.add(trid);
		
		bno = new JTextField();
		bno.setBounds(845, 51, 92, 24);
		bno.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		bno.setColumns(10);
		panel.add(bno);
		
		bdate = new JTextField();
		bdate.setBounds(820, 91, 136, 28);
		panel.add(bdate);
		bdate.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(547, 175, 425, 437);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(799, 639, 148, 58);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Shreya\\Pictures\\m.png"));
		panel.add(btnNewButton);
		
		JLabel lblEnterString = new JLabel("ENTER STRING ");
		lblEnterString.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblEnterString.setBounds(143, 551, 133, 18);
		panel.add(lblEnterString);
		
		textField = new JTextField();
		textField.setBounds(366, 543, 171, 38);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblBarcodeWillBe = new JLabel("BARCODE WILL BE GENERATED FOR THE STIRING");
		lblBarcodeWillBe.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblBarcodeWillBe.setBounds(153, 591, 297, 14);
		panel.add(lblBarcodeWillBe);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(199, -21, 1002, 750);
		label_5.setFont(new Font("Times New Roman", Font.BOLD, 17));
		label_5.setIcon(new ImageIcon("C:\\Users\\Shreya\\Desktop\\green-abstract-crystal-background-vector-2222914.jpg"));
		panel.add(label_5);
		
		JLabel label_13 = new JLabel("");
		label_13.setForeground(Color.WHITE);
		label_13.setBackground(Color.BLACK);
		label_13.setBounds(153, 605, 275, 43);
		panel.add(label_13);
		
		
		JButton button = new JButton("GENERATE BILL");
		button.setBounds(365, 659, 179, 43);
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String billno=bno.getText();
				String billdate=bdate.getText();
				String custid=tc.getText();
				String custname=cname.getText();
				String totalcharge=tot.getText();
				String discount=dis.getText();
				String service=ser.getText();
				String amount=am.getText();
				String paymode=(String) pm.getSelectedItem();
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Success");
					Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/svit2", "root", "");
					System.out.println("#######");
					PreparedStatement cs;
					cs=con2.prepareCall("{call bill2(?,?,?,?,?,?,?,?,?,?)}");
					
					cs.setString(1, billno);
					cs.setString(2, billdate);
					cs.setString(3, custid);
					cs.setString(4, custname);
					cs.setString(5, totalcharge);
					cs.setString(6, discount);
					cs.setString(7, service);
					cs.setString(8, amount);
					cs.setString(9, pd.getDate().toString());
					cs.setString(10, paymode);
					cs.execute();
					
					String a=textField.getText();
					Code39 barcode=new Code39();
					barcode.setData(a);
					ImageIcon icon = null;
					try {
						icon = new ImageIcon(barcode.drawBarcode());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					label_13.setIcon(icon);
					
					System.out.println("data inserted successfully");
				}
				
				catch(Exception e)
				{
					System.out.println("cannot retrieve"+e.getMessage());
				}
			}
		});
		button.setFont(new Font("Times New Roman", Font.BOLD, 17));
		panel.add(button);
		
		JButton btnPrint = new JButton("PRINT");
		btnPrint.setBounds(595, 659, 113, 42);
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ImageIcon icon;
				textArea.append("\t\t  BILL INFORMATION \t\t" + "\n" +
						
						"\t BILL NUMBER :     "+bno.getText() + "\n" +
						"\t BILL DATE :\t"+bdate.getText() + "\n" +
						"\n\t----------------------------------------------------\n\t" +
							"CUSTOMER ID :   "+tc.getText() + "\n" +
							"\tCUSTOMER NAME :   "+cname.getText() + "\n" +
							"\tTOTAL CHARGE :  "+tot.getText() + "\n" +
							"\tDISCOUNT :  "+dis.getText() + "\n" +
							"\tSERVICE TAX :  "+ser.getText() + "\n" +
							"\tAMOUNT :  "+am.getText() + "\n" +
							"\tPAYMENT DUE DATE :  "+ pd.getDate().toString() + "\n" +
							"\tPAYMENT MODE :  "+pm.getSelectedItem() + "\n" +
							//"\tBARCODE : "+label_13.getIconTextGap() + "\n" +
						"\n\t*****************THANK YOU******************\n\t"
						);
			}
		});
		btnPrint.setFont(new Font("Times New Roman", Font.BOLD, 17));
		panel.add(btnPrint);
		
		
	}
}