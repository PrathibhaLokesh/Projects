import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;




import com.onbarcode.barcode.Code39;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class barcode4 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					barcode4 frame = new barcode4();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public barcode4() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblString = new JLabel("STRING");
		lblString.setBounds(82, 49, 46, 14);
		contentPane.add(lblString);
		
		textField = new JTextField();
		textField.setBounds(175, 46, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBounds(100, 92, 179, 45);
		contentPane.add(label);
		
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
				label.setIcon(icon);
			}
		});
		btnOk.setBounds(175, 163, 89, 23);
		contentPane.add(btnOk);
	}
}
