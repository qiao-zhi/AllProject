package forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class StudyRecordMana {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudyRecordMana window = new StudyRecordMana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudyRecordMana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 200, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(63, 49, 109, 30);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("\u73ED\u7EC4");
		lblNewLabel.setBounds(23, 45, 41, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\u5458\u5DE5\u59D3\u540D\uFF1A");
		label.setBounds(249, 45, 60, 38);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(309, 45, 115, 34);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5458\u5DE5\u7F16\u53F7\uFF1A");
		label_1.setBounds(461, 41, 60, 38);
		frame.getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(521, 44, 115, 34);
		frame.getContentPane().add(textField_1);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.setBounds(681, 53, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		table = new JTable();
		table.setBounds(208, 153, 436, 225);
		frame.getContentPane().add(table);
	}
}
