import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;

public class cust1 extends JFrame {

	private JPanel contentPane;
	private JTextField tc;
	private JTextField tcid;
	private JTextField tp;
	private JTextField te;
	private JTextField teid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cust1 frame = new cust1();
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
	public cust1() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 691, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JLabel lblCustomerInformation = new JLabel("CUSTOMER INFORMATION");
				lblCustomerInformation.setFont(new Font("Times New Roman", Font.BOLD, 20));
				lblCustomerInformation.setBounds(115, 11, 282, 24);
				contentPane.add(lblCustomerInformation);
				
				JLabel lblCustomerName = new JLabel("CUSTOMER NAME");
				lblCustomerName.setFont(new Font("Times New Roman", Font.BOLD, 17));
				lblCustomerName.setBounds(59, 63, 165, 24);
				contentPane.add(lblCustomerName);
				
				tc = new JTextField();
				tc.setBounds(293, 63, 219, 24);
				contentPane.add(tc);
				tc.setColumns(10);
				
				JLabel lblCustomerId = new JLabel("CUSTOMER ID");
				lblCustomerId.setFont(new Font("Times New Roman", Font.BOLD, 17));
				lblCustomerId.setBounds(59, 113, 147, 20);
				contentPane.add(lblCustomerId);
				
				tcid = new JTextField();
				tcid.setBounds(293, 113, 109, 24);
				contentPane.add(tcid);
				tcid.setColumns(10);
				
				JLabel lblAddress = new JLabel("ADDRESS");
				lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 17));
				lblAddress.setBounds(59, 160, 118, 20);
				contentPane.add(lblAddress);
				
				JTextArea ta = new JTextArea();
				ta.setBounds(293, 160, 225, 24);
				contentPane.add(ta);
				
				JLabel lblPhoneNumber = new JLabel("PHONE NUMBER");
				lblPhoneNumber.setFont(new Font("Times New Roman", Font.BOLD, 17));
				lblPhoneNumber.setBounds(59, 210, 165, 20);
				contentPane.add(lblPhoneNumber);
				
				tp = new JTextField();
				tp.setBounds(293, 210, 186, 24);
				contentPane.add(tp);
				tp.setColumns(10);
				
				JLabel lblEmailId = new JLabel("EMAIL ID");
				lblEmailId.setFont(new Font("Times New Roman", Font.BOLD, 17));
				lblEmailId.setBounds(59, 258, 118, 20);
				contentPane.add(lblEmailId);
				
				te = new JTextField();
				te.setBounds(293, 260, 336, 24);
				contentPane.add(te);
				te.setColumns(10);
				
				JLabel lblTelephoneId = new JLabel("TELEPHONE ID");
				lblTelephoneId.setFont(new Font("Times New Roman", Font.BOLD, 17));
				lblTelephoneId.setBounds(59, 308, 165, 20);
				contentPane.add(lblTelephoneId);
				
				teid = new JTextField();
				teid.setBounds(293, 308, 109, 24);
				contentPane.add(teid);
				teid.setColumns(10);
				
				JButton btnProceed = new JButton("PROCEED");
				btnProceed.setBackground(Color.WHITE);
				btnProceed.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String cname=tc.getText();
						String cid=tcid.getText();
						String address=ta.getText();
						String phone=tp.getText();
						String email=te.getText();
						String tid=teid.getText();
						
						try
						{
							Class.forName("com.mysql.jdbc.Driver");
							System.out.println("Success");
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/svit2", "root", "");
							System.out.println("Success2222");
							String query="insert into customer(cname,cid,address,phone,email,tid)"+"values(?,?,?,?,?,?)";
							PreparedStatement ps=con.prepareStatement(query);
							ps.setString(1, cname );
							ps.setString(2, cid);
							ps.setString(3, address);
							ps.setString(4, phone);
							ps.setString(5, email);
							ps.setString(6, tid);
							ps.execute();
							
							System.out.println("Data inserted successfully");
							tele1 t=new tele1();
							t.setVisible(true);
							t.setTitle(tcid.getText());
						}
						
						catch(Exception e)
						{
							JOptionPane.showMessageDialog(null, "INVALID INFORMATION");
							System.out.println("Cannot connect to database"+e.getMessage());
						}
					}
				});
				btnProceed.setFont(new Font("Times New Roman", Font.BOLD, 17));
				btnProceed.setBounds(398, 362, 147, 45);
				contentPane.add(btnProceed);
				
				JButton button = new JButton("");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//menu1 m=new menu1();
						//m.setVisible(true);
					}
				});
				button.setIcon(new ImageIcon("C:\\Users\\Shreya\\Pictures\\h.png"));
				button.setBounds(21, 354, 81, 53);
				contentPane.add(button);
				
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon("C:\\Users\\Shreya\\Pictures\\job-1.jpg"));
				label.setBounds(0, -23, 675, 453);
				contentPane.add(label);
				teid.setColumns(10);
			}
		}
