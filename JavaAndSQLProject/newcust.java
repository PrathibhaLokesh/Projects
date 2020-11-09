import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;


public class newcust extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newcust frame = new newcust();
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
	public newcust() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewCustomerEntry = new JLabel("NEW CUSTOMER ENTRY FORM");
		lblNewCustomerEntry.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewCustomerEntry.setBounds(232, 11, 316, 46);
		contentPane.add(lblNewCustomerEntry);
		
		JLabel lblCustomerName = new JLabel(" NAME");
		lblCustomerName.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblCustomerName.setBounds(89, 69, 86, 20);
		contentPane.add(lblCustomerName);
		
		textField = new JTextField();
		textField.setBounds(219, 68, 112, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblLastName = new JLabel("LAST NAME");
		lblLastName.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblLastName.setBounds(63, 118, 112, 20);
		contentPane.add(lblLastName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(219, 115, 112, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblResidentialAddress = new JLabel("RESIDENTIAL ADDRESS");
		lblResidentialAddress.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblResidentialAddress.setBounds(10, 164, 191, 20);
		contentPane.add(lblResidentialAddress);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(219, 164, 169, 36);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblPermamentAddress = new JLabel("PERMAMENT ADDRESS");
		lblPermamentAddress.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblPermamentAddress.setBounds(10, 208, 191, 20);
		contentPane.add(lblPermamentAddress);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(219, 208, 172, 34);
		contentPane.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		
		JLabel lblState = new JLabel("STATE");
		lblState.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblState.setBounds(91, 295, 62, 20);
		contentPane.add(lblState);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"SELECT YOUR STATE", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarath", "Haryana", "Himachal Pradesh", "Jammu & Kashmir", "Jharkand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttarakhand", "Uttar Pradesh", "West Bengal"}));
		comboBox.setBounds(219, 296, 157, 23);
		contentPane.add(comboBox);
		
		JLabel lblEmailId = new JLabel("EMAIL ID");
		lblEmailId.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblEmailId.setBounds(80, 252, 73, 20);
		contentPane.add(lblEmailId);
		
		textField_2 = new JTextField();
		textField_2.setBounds(219, 253, 191, 23);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblGender.setBounds(468, 74, 97, 17);
		contentPane.add(lblGender);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "MALE", "FEMALE", "NEUTRAL"}));
		comboBox_1.setBounds(575, 70, 86, 23);
		contentPane.add(comboBox_1);
		
		JLabel lblCaste = new JLabel("CASTE");
		lblCaste.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblCaste.setBounds(468, 118, 80, 20);
		contentPane.add(lblCaste);
		
		JCheckBox chckbxSc = new JCheckBox("SC");
		chckbxSc.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		chckbxSc.setBounds(564, 119, 49, 23);
		contentPane.add(chckbxSc);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("ST");
		chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		chckbxNewCheckBox.setBounds(632, 119, 55, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxOthers = new JCheckBox("OTHERS");
		chckbxOthers.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		chckbxOthers.setBounds(689, 119, 73, 23);
		contentPane.add(chckbxOthers);
		
		JLabel lblPincode = new JLabel("PINCODE");
		lblPincode.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblPincode.setBounds(80, 339, 95, 20);
		contentPane.add(lblPincode);
		
		textField_3 = new JTextField();
		textField_3.setBounds(219, 341, 157, 23);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblAddharNo = new JLabel("ADDHAR NO");
		lblAddharNo.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblAddharNo.setBounds(436, 164, 112, 20);
		contentPane.add(lblAddharNo);
		
		textField_4 = new JTextField();
		textField_4.setBounds(575, 164, 187, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("DATE OF BIRTH");
		lblDateOfBirth.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblDateOfBirth.setBounds(425, 208, 136, 20);
		contentPane.add(lblDateOfBirth);
		
		textField_5 = new JTextField();
		textField_5.setBounds(575, 208, 136, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnRegister.setBounds(575, 375, 136, 29);
		contentPane.add(btnRegister);
	}
}
