import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;


public class menu1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu1 frame = new menu1();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public menu1() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Shreya\\Documents\\tele5.jpg"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 473);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		menuBar.setBackground(Color.BLACK);
		menuBar.setBounds(0, 4, 745, 37);
		contentPane.add(menuBar);
		
		JMenu mnHome = new JMenu("HOME");
		mnHome.setForeground(Color.WHITE);
		mnHome.setBackground(Color.BLACK);
		mnHome.setFont(new Font("Times New Roman", Font.BOLD, 17));
		menuBar.add(mnHome);
		
		JMenu mnFile = new JMenu("FILE");
		mnFile.setBackground(Color.BLACK);
		mnFile.setForeground(Color.WHITE);
		mnFile.setFont(new Font("Times New Roman", Font.BOLD, 17));
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("NEW");
		mntmNew.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				log1 l=new log1();
				l.setVisible(true);
			}
		});
		mnFile.add(mntmNew);
		
		JMenuItem mntmSave = new JMenuItem("SAVE");
		mntmSave.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mnFile.add(mntmSave);
		
		JMenuItem mntmPrint = new JMenuItem("PRINT");
		mntmPrint.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mnFile.add(mntmPrint);
		
		JMenuItem mntmEmail = new JMenuItem("EMAIL");
		mntmEmail.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mnFile.add(mntmEmail);
		
		JMenu mnView = new JMenu("VIEW");
		mnView.setBackground(Color.BLACK);
		mnView.setForeground(Color.WHITE);
		mnView.setFont(new Font("Times New Roman", Font.BOLD, 17));
		menuBar.add(mnView);
		
		JMenuItem mntmLogin = new JMenuItem("LOGIN");
		mntmLogin.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mntmLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				log1 l=new log1();
				l.setVisible(true);
			}
		});
		mnView.add(mntmLogin);
		
		JMenuItem mntmCustomer = new JMenuItem("CUSTOMER");
		mntmCustomer.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mntmCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cust1 c=new cust1();
				c.setVisible(true);
			}
		});
		mnView.add(mntmCustomer);
		
		JMenuItem mntmConnection = new JMenuItem("CONNECTION");
		mntmConnection.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mntmConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				connect c=new connect();
				c.setVisible(true);
			}
		});
		mnView.add(mntmConnection);
		
		JMenuItem mntmContentTable = new JMenuItem("CONTENT TABLE");
		mntmContentTable.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mntmContentTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tables4update t=new tables4update();
				t.setVisible(true);
			}
		});
		mnView.add(mntmContentTable);
		
		JMenuItem mntmTariff = new JMenuItem("TARIFF");
		mntmTariff.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mntmTariff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tariff1 ta=new tariff1();
				ta.setVisible(true);
			}
		});
		mnView.add(mntmTariff);
		
		JMenuItem mntmBill = new JMenuItem("BILL");
		mntmBill.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mntmBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lastframe fb=new lastframe();
				fb.setVisible(true);
			}
		});
		mnView.add(mntmBill);
		
		JMenu mnKnowMore = new JMenu("KNOW MORE                  ");
		mnKnowMore.setForeground(Color.WHITE);
		mnKnowMore.setBackground(Color.BLACK);
		mnKnowMore.setFont(new Font("Times New Roman", Font.BOLD, 17));
		menuBar.add(mnKnowMore);
		
		JLabel label_1 = new JLabel("");
		label_1.setBackground(new Color(255, 255, 255));
		label_1.setIcon(new ImageIcon("C:\\Users\\Shreya\\Pictures\\images (5).jpeg"));
		label_1.setBounds(0, 46, 734, 388);
		contentPane.add(label_1);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
