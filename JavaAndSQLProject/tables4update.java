import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;
import javax.swing.ImageIcon;


public class tables4update extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tcid;
	private JTextField con;
	private JTextField cid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tables4update frame = new tables4update();
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
	public tables4update() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 954, 616);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 64, 786, 157);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		JButton btnGetUpdated = new JButton("DISPLAY");
		btnGetUpdated.setBounds(694, 247, 139, 29);
		btnGetUpdated.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Success");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/svit2", "root", "");
					System.out.println("**!!!!!!!Success******");
					
					String query="select * from jointtable";
					PreparedStatement ps=con.prepareStatement(query);
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					ps.execute();
				}
				catch(Exception e)
						{
					System.out.println("cannot get values"+e.getMessage());
				}
			}
		});
		contentPane.setLayout(null);
		btnGetUpdated.setFont(new Font("Times New Roman", Font.BOLD, 17));
		contentPane.add(btnGetUpdated);
		
		
		JLabel lblDisplayingTheDetails = new JLabel("DISPLAYING THE DETAILS");
		lblDisplayingTheDetails.setBounds(276, 11, 312, 23);
		lblDisplayingTheDetails.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(lblDisplayingTheDetails);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(126, 430, 129, 29);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("done");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/svit2", "root", "");
					System.out.println("$$$$$$$$$$$$(Success)******");
					
					String query="update jointtable set connectionType='"+con.getText()+"' where cid="+tcid.getText()+"";
					
					PreparedStatement ps1=conn.prepareStatement(query);
					
					ps1.execute();
				}
				
				catch(Exception e)
				{
					System.out.println("cannot update"+e.getMessage());
				}
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 17));
		contentPane.add(btnUpdate);
		
		JPanel panel = new JPanel();
		panel.setBounds(24, 284, 416, 213);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "UPDATE HERE", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCustomerId = new JLabel("CUSTOMER ID ");
		lblCustomerId.setBounds(10, 33, 129, 18);
		panel.add(lblCustomerId);
		lblCustomerId.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		
		JLabel lblTypeOfCall = new JLabel("CONNECTION TYPE");
		lblTypeOfCall.setBounds(10, 79, 175, 23);
		panel.add(lblTypeOfCall);
		lblTypeOfCall.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		
		tcid = new JTextField();
		tcid.setBounds(204, 31, 129, 23);
		panel.add(tcid);
		tcid.setColumns(10);
		
		con = new JTextField();
		con.setBounds(204, 81, 129, 23);
		panel.add(con);
		con.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(474, 318, 447, 180);
		panel_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		panel_1.setBorder(new TitledBorder(null, "COMPLETE RECORD OF SPECIFIED CUSTOMER ID WILL BE DELETED", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCustomerId_1 = new JLabel("CUSTOMER ID");
		lblCustomerId_1.setBounds(46, 56, 110, 20);
		panel_1.add(lblCustomerId_1);
		lblCustomerId_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		
		cid = new JTextField();
		cid.setBounds(221, 57, 114, 22);
		panel_1.add(cid);
		cid.setColumns(10);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Successsssss");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/svit2", "root", "");
					System.out.println("-------------------");
					
					String query2="Delete from customer where cid=cid.getText()";
					PreparedStatement ps7=conn.prepareStatement(query2);
					ps7.execute();
				}
				
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, "cannot delete from procedure");
				}
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnDelete.setBounds(143, 117, 110, 29);
		panel_1.add(btnDelete);
		
		JButton btnMoveForword = new JButton("MOVE FORWORD");
		btnMoveForword.setBounds(633, 537, 193, 35);
		btnMoveForword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMoveForword.setFont(new Font("Times New Roman", Font.BOLD, 17));
		contentPane.add(btnMoveForword);
		
	}
}
