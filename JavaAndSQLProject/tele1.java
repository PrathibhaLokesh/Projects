import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import java.awt.Color;


public class tele1 extends JFrame {

	private JPanel contentPane;
	private JTextField btid;
	private JTextField btno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tele1 frame = new tele1();
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
	public tele1() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 478, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTelpehone = new JLabel("TELPEHONE  DETAILS");
		lblTelpehone.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblTelpehone.setBounds(32, 11, 288, 38);
		contentPane.add(lblTelpehone);
		
		JLabel lblTelephoneId = new JLabel("TELEPHONE ID");
		lblTelephoneId.setForeground(new Color(0, 0, 0));
		lblTelephoneId.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblTelephoneId.setBounds(32, 79, 161, 20);
		contentPane.add(lblTelephoneId);
		
		btid = new JTextField();
		btid.setBounds(240, 76, 106, 31);
		contentPane.add(btid);
		btid.setColumns(10);
		
		JLabel lblTelephoneNumber = new JLabel("TELEPHONE NUMBER");
		lblTelephoneNumber.setForeground(new Color(0, 0, 0));
		lblTelephoneNumber.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblTelephoneNumber.setBounds(10, 131, 191, 20);
		contentPane.add(lblTelephoneNumber);
		
		btno = new JTextField();
		btno.setBounds(240, 128, 143, 30);
		contentPane.add(btno);
		btno.setColumns(10);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tid=btid.getText();
				String tno=btno.getText();
	
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Success");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/svit2", "root", "");
					System.out.println("Success2222");
					String query="insert into telephone(tid,tno)"+"values(?,?)";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, tid);
					ps.setString(2, tno);
					
					ps.execute();
					
					System.out.println("Data inserted successfully");
					//connect c1=new connect();
					//c1.setVisible(true);
				}
				
				catch(Exception e)
				{
					System.out.println("Cannot connect to database"+e.getMessage());
				}
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnUpdate.setBounds(83, 220, 161, 33);
		contentPane.add(btnUpdate);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Shreya\\Desktop\\images (6).jpeg"));
		label.setBounds(0, 0, 462, 332);
		contentPane.add(label);
	}

}
