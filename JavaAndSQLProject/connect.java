import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import java.awt.Color;


public class connect extends JFrame {

	private JPanel contentPane;
	private JTextField connid;
	private JTextField btid;
	private JTextField tan;
	private JTextField taid;
	private JTextField tab;
	private JTextField tno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					connect frame = new connect();
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
	public connect() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 715, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConnectionAndIts = new JLabel("CONNECTION AND ITS PROVIDED AGENT INFORMATION");
		lblConnectionAndIts.setForeground(new Color(0, 0, 0));
		lblConnectionAndIts.setBounds(64, 11, 573, 24);
		lblConnectionAndIts.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(lblConnectionAndIts);
		
		JLabel lblConnectionId = new JLabel("CONNECTION ID");
		lblConnectionId.setForeground(new Color(0, 0, 0));
		lblConnectionId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblConnectionId.setBounds(21, 55, 141, 20);
		contentPane.add(lblConnectionId);
		
		connid = new JTextField();
		connid.setBounds(183, 56, 118, 22);
		contentPane.add(connid);
		connid.setColumns(10);
		
		JLabel lblTelephoneId = new JLabel("TELEPHONE ID");
		lblTelephoneId.setForeground(new Color(0, 0, 0));
		lblTelephoneId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTelephoneId.setBounds(21, 98, 127, 20);
		contentPane.add(lblTelephoneId);
		
		btid = new JTextField();
		btid.setBounds(183, 98, 118, 22);
		contentPane.add(btid);
		btid.setColumns(10);
		
		JLabel lblConnectionType = new JLabel("CONNECTION TYPE");
		lblConnectionType.setForeground(new Color(0, 0, 0));
		lblConnectionType.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblConnectionType.setBounds(339, 78, 170, 20);
		contentPane.add(lblConnectionType);
		
		JRadioButton ll = new JRadioButton("LL");
		ll.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ll.setBounds(544, 42, 109, 23);
		contentPane.add(ll);
		
		JRadioButton bb = new JRadioButton("BB");
		bb.setFont(new Font("Times New Roman", Font.BOLD, 20));
		bb.setBounds(544, 79, 109, 24);
		contentPane.add(bb);
		
		JRadioButton llbb = new JRadioButton("LL+BB");
		llbb.setFont(new Font("Times New Roman", Font.BOLD, 20));
		llbb.setBounds(544, 117, 109, 23);
		contentPane.add(llbb);
		
		JLabel lblAgentName = new JLabel("AGENT NAME");
		lblAgentName.setForeground(new Color(0, 0, 0));
		lblAgentName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAgentName.setBounds(21, 160, 127, 20);
		contentPane.add(lblAgentName);
		
		tan = new JTextField();
		tan.setBounds(184, 154, 141, 24);
		contentPane.add(tan);
		tan.setColumns(10);
		
		JLabel lblAgentId = new JLabel("AGENT ID");
		lblAgentId.setForeground(new Color(0, 0, 0));
		lblAgentId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAgentId.setBounds(23, 209, 96, 20);
		contentPane.add(lblAgentId);
		
		taid = new JTextField();
		taid.setBounds(186, 205, 101, 24);
		contentPane.add(taid);
		taid.setColumns(10);
		
		JLabel lblAuthorizedBy = new JLabel("AUTHORIZED BY");
		lblAuthorizedBy.setForeground(new Color(0, 0, 0));
		lblAuthorizedBy.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAuthorizedBy.setBounds(21, 256, 141, 20);
		contentPane.add(lblAuthorizedBy);
		
		tab = new JTextField();
		tab.setBounds(187, 253, 117, 24);
		contentPane.add(tab);
		tab.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("PHONE NUMBER");
		lblPhoneNumber.setForeground(new Color(0, 0, 0));
		lblPhoneNumber.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPhoneNumber.setBounds(24, 305, 141, 20);
		contentPane.add(lblPhoneNumber);
		
		tno = new JTextField();
		tno.setBounds(189, 304, 86, 24);
		contentPane.add(tno);
		tno.setColumns(10);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String conid=connid.getText();
				String tid=btid.getText();
				String connectionType;
				if(ll.isSelected())
				{
					connectionType=ll.getText();
				}
				else if(bb.isSelected())
				{
					connectionType=bb.getText();
				}
				else
				{
					connectionType=llbb.getText();
				}
				
				ButtonGroup bg=new ButtonGroup();
				bg.add(ll);
				bg.add(bb);
				bg.add(llbb);
				
				String aid=taid.getText();
				String agname=tan.getText();
				String authorize=tab.getText();
				String pho=tno.getText();
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Success");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/svit2", "root", "");
					System.out.println("Success2222");
					String query="insert into connection(conid,tid,connectionType,aid,agname,authorize,pho)"+"values(?,?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, conid);
					ps.setString(2, tid);
					ps.setString(3, connectionType);
					ps.setString(4, aid);
					ps.setString(5, agname);
					ps.setString(6, authorize);
					ps.setString(7, pho);
					ps.execute();
					
					System.out.println("Data inserted successfully");
					//tables4update ta=new tables4update();
					//ta.setVisible(true);
				}
				
				catch(Exception e)
				{
					System.out.println("Cannot connect to database"+e.getMessage());
				}
			}
		});
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSave.setBounds(424, 363, 141, 33);
		contentPane.add(btnSave);
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_1.setIcon(new ImageIcon("C:\\Users\\Shreya\\Desktop\\20181127_073046.jpg"));
		label_1.setBounds(0, 0, 699, 428);
		contentPane.add(label_1);
	}
}
