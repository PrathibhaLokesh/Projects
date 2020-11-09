import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.ImageIcon;

public class tariff1 extends JFrame {

	private JPanel contentPane;
	private JTextField tarid;
	private JTextField noc;
	private JTextField tuc;
	private JTextField tmc;
	public JTextField ttc;
	public JTextField bno;
	private JTextField conid;
	private JTextField tmode;
	private JTextField data;
	private JTextField concharge;
	private JTextField type;
	private JTextField crate;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tariff1 frame = new tariff1();
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
	public tariff1() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 897, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 887, 501);
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		tarid = new JTextField();
		tarid.setBounds(292, 110, 86, 20);
		panel.add(tarid);
		tarid.setColumns(10);
		
		JLabel lblNumberOfCalls = new JLabel("NUMBER OF SECONDS");
		lblNumberOfCalls.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNumberOfCalls.setBounds(27, 154, 214, 25);
		panel.add(lblNumberOfCalls);
		
		noc = new JTextField();
		noc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				float pa1=Float.parseFloat(noc.getText());
				float pa2=Float.parseFloat(concharge.getText());
				double pa3=pa1*pa2;
				String pa4=String.valueOf(pa3);
				crate.setText(pa4);
				
			}
		});
		noc.setBounds(292, 158, 86, 20);
		panel.add(noc);
		noc.setColumns(10);
		
		JLabel lblDataRate = new JLabel("USED DATA");
		lblDataRate.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblDataRate.setBounds(88, 205, 109, 18);
		panel.add(lblDataRate);
		
		JComboBox tud = new JComboBox();
		tud.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent arg0) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
				
				String tmp=(String) tud.getSelectedItem();
				String sql="select price from dataused where data=?";
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/svit2", "root", "");
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, tmp);
					ResultSet rs=ps.executeQuery();
					if(rs.next())
					{
						String a1=rs.getString("price");
						data.setText(a1);
					}
				}
				
				catch(Exception e)
				{
					System.out.println("cannot display value"+e.getMessage());
				}
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
			}
		});
		tud.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "1GB", "2GB", "3GB", "UNLIMIT"}));
		tud.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tud.setBounds(288, 203, 96, 22);
		panel.add(tud);
		
		JLabel lblUsageCharge = new JLabel("USAGE CHARGE");
		lblUsageCharge.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblUsageCharge.setBounds(468, 302, 176, 18);
		panel.add(lblUsageCharge);
		
		tuc = new JTextField();
		tuc.setBounds(692, 299, 86, 24);
		panel.add(tuc);
		tuc.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("MONTHLY CHARGE");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel.setBounds(48, 298, 188, 18);
		panel.add(lblNewLabel);
		
		//total charge
		tmc = new JTextField();
		tmc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				float am1=Float.parseFloat(tmc.getText());
				float am2=Float.parseFloat(tuc.getText());
				double am3=am1+am2;
				String am4=String.valueOf(am3);
				ttc.setText(am4);
			}
		});
		tmc.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		tmc.setText("180\r\n");
		tmc.setBounds(290, 297, 86, 20);
		panel.add(tmc);
		tmc.setColumns(10);
		
		JLabel lblTotalCharge = new JLabel("TOTAL CHARGE");
		lblTotalCharge.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblTotalCharge.setBounds(469, 355, 162, 27);
		panel.add(lblTotalCharge);
		
		ttc = new JTextField();
		ttc.setBounds(691, 352, 86, 27);
		panel.add(ttc);
		ttc.setColumns(10);
		
		JLabel lblBillNo = new JLabel("BILL NUMBER");
		lblBillNo.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblBillNo.setBounds(76, 347, 162, 17);
		panel.add(lblBillNo);
		
		bno = new JTextField();
		bno.setBounds(290, 347, 86, 22);
		panel.add(bno);
		bno.setColumns(10);
		
		JLabel lblTariffId = new JLabel("TARIFF ID");
		lblTariffId.setBounds(94, 111, 120, 18);
		panel.add(lblTariffId);
		lblTariffId.setFont(new Font("Times New Roman", Font.BOLD, 19));
		
		JLabel lblConnectionId = new JLabel("CONNECTION ID");
		lblConnectionId.setBounds(64, 69, 168, 17);
		panel.add(lblConnectionId);
		lblConnectionId.setFont(new Font("Times New Roman", Font.BOLD, 19));
		
		conid = new JTextField();
		conid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String temp1=conid.getText();
				String mysql1="select connectionType from connection where conid=?";
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/svit2", "root", "");
					PreparedStatement ps1=con.prepareStatement(mysql1);
					
					ps1.setString(1, temp1);
					ResultSet rs2=ps1.executeQuery();
					if(rs2.next())
					{
						String a2=rs2.getString("connectionType");
						type.setText(a2);
					}
				}
			
				catch(Exception e)
				{
					System.out.println("cannot show"+e.getMessage());
				}
			}
		});
		conid.setBounds(291, 66, 86, 20);
		panel.add(conid);
		conid.setColumns(10);
		
		JLabel lblTariffDetails = new JLabel("TARIFF DETAILS");
		lblTariffDetails.setBounds(334, 19, 238, 25);
		panel.add(lblTariffDetails);
		lblTariffDetails.setFont(new Font("Times New Roman", Font.BOLD, 24));
		
		JLabel lblDataPrice = new JLabel("DATA PRICE");
		lblDataPrice.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblDataPrice.setBounds(85, 249, 124, 21);
		panel.add(lblDataPrice);
		
		data = new JTextField();
		data.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				float par1=Float.parseFloat(data.getText());
				float par2=Float.parseFloat(crate.getText());
				double par3=par1+par2;
				String par4=String.valueOf(par3);
				tuc.setText(par4);
			}
		});
		data.setBounds(289, 249, 86, 20);
		panel.add(data);
		data.setColumns(10);
		
		JLabel lblConnectionCharge = new JLabel("CONNECTION CHARGE");
		lblConnectionCharge.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblConnectionCharge.setBounds(419, 112, 226, 24);
		panel.add(lblConnectionCharge);
		
		concharge = new JTextField();
		concharge.setBounds(677, 116, 86, 20);
		panel.add(concharge);
		concharge.setColumns(10);
		
		JLabel lblConnectionType = new JLabel("CONNECTION TYPE");
		lblConnectionType.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblConnectionType.setBounds(464, 69, 191, 21);
		panel.add(lblConnectionType);
		
		type = new JTextField();
		type.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) 
			{
				String temp=type.getText();
				String mysql="select amount from connselected where conn=?";
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/svit2", "root", "");
					PreparedStatement ps5=con.prepareStatement(mysql);
					
					ps5.setString(1, temp);
					ResultSet rs2=ps5.executeQuery();
					if(rs2.next())
					{
						String a2=rs2.getString("amount");
						concharge.setText(a2);
					}
				}
			
				catch(Exception e)
				{
					System.out.println("cannot show"+e.getMessage());
				}
			}
		});
		type.setBounds(677, 70, 86, 20);
		panel.add(type);
		type.setColumns(10);
		
		JLabel lblCallRate = new JLabel("CALL RATE");
		lblCallRate.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblCallRate.setBounds(504, 161, 114, 18);
		panel.add(lblCallRate);
		
		crate = new JTextField();
		crate.setBounds(677, 162, 86, 20);
		panel.add(crate);
		crate.setColumns(10);
		
		JButton btnUpdate = new JButton("SUBMIT");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String connid=conid.getText();
				String tariffid=tarid.getText();
				String ncalls=noc.getText();
				String usecharge=tuc.getText();
				String moncharge=tmc.getText();
				String totcharge=ttc.getText();
				String udata=(String) tud.getSelectedItem();
				String billno=bno.getText();
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Success");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/svit2", "root", "");
					System.out.println("#######");
					
					String query2="insert into tariffcalculation(connid,tariffid,ncalls,udata,usecharge,moncharge,totcharge,billno)"+"values(?,?,?,?,?,?,?,?)";
					
					PreparedStatement pre=con.prepareStatement(query2);
					pre.setString(1, connid);
					pre.setString(2, tariffid);
					pre.setString(3, ncalls);
					pre.setString(4, udata);
					pre.setString(5, usecharge);
					pre.setString(6, moncharge);
					pre.setString(7, totcharge);
					pre.setString(8, billno);
					pre.execute();
					
					System.out.println("data inserted successfully");
				}
				
				catch(Exception e)
				{
					System.out.println("cannot retrieve"+e.getMessage());
				}
			}
			});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnUpdate.setBounds(610, 410, 114, 44);
		panel.add(btnUpdate);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Shreya\\Pictures\\20181127_073027.jpg"));
		label.setBounds(-2, 0, 881, 498);
		panel.add(label);
	}
}
