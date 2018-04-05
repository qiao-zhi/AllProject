package forms;
//ื๖บรมห
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import SoftConstruct.LoginWindow;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class xiugaimima {

public static  JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
    public static xiugaimima window = new xiugaimima();
					

	public xiugaimima() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 300, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528  \u6237  \u540D");
		lblNewLabel.setBounds(36, 31, 66, 15);
		frame.getContentPane().add(lblNewLabel);
		
	
		
		JLabel lblNewLabel_1 = new JLabel("\u65B0  \u5BC6  \u7801");
		lblNewLabel_1.setBounds(36, 84, 76, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u518D\u6B21\u8F93\u5165\u5BC6\u7801");
		lblNewLabel_2.setBounds(36, 139, 93, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(154, 28, 86, 21);
		frame.getContentPane().add(textField);
		textField.setText(LoginWindow.cookie);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(154, 81, 86, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(154, 136, 86, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.setBounds(19, 190, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xiugaimima.window.frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(147, 190, 93, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
