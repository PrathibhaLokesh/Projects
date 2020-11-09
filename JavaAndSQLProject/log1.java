import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class log1 extends JFrame {

	private JPanel contentPane;
	private JTextField tu;
	private JPasswordField tp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					log1 frame = new log1();
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
	public log1() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 645, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToTelephone = new JLabel("WELCOME TO TELEPHONE BILLING SYSTEM");
		lblWelcomeToTelephone.setForeground(Color.BLUE);
		lblWelcomeToTelephone.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblWelcomeToTelephone.setBounds(46, 11, 533, 27);
		contentPane.add(lblWelcomeToTelephone);
		
		JLabel lblUserName = new JLabel("USER NAME");
		lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblUserName.setBounds(93, 106, 144, 24);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPassword.setBounds(93, 167, 127, 24);
		contentPane.add(lblPassword);
		
		tu = new JTextField();
		tu.setBounds(275, 106, 276, 27);
		contentPane.add(tu);
		tu.setColumns(10);
		
		tp = new JPasswordField();
		tp.setBounds(275, 167, 276, 27);
		contentPane.add(tp);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String uname=tu.getText();
				String pwd=tp.getText();
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Success");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/svit2", "root", "");
					System.out.println("Success2222");
					String query="select * from frame1 where uname=? and pwd=?";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, uname);
					ps.setString(2, pwd);
					ps.execute();
					ResultSet rs=ps.executeQuery();
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null, "SUCCESSFUL LOGIN");
						cust1 c=new cust1();
						c.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "INVALID LOGIN");
					}
					System.out.println("Data inserted successfully");
				}
				
				catch(Exception e)
				{
					System.out.println("Cannot connect to database"+e.getMessage());
				}
			}
		});
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnLogin.setBounds(443, 266, 136, 33);
		contentPane.add(btnLogin);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Shreya\\Pictures\\images (4).jpeg"));
		label.setBounds(0, 49, 629, 334);
		contentPane.add(label);
	}
}
