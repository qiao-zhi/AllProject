package forms;


/******增加部门完成了*********/
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.commons.dbutils.QueryRunner;

import util.DataBaseConnection;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddDepart {
	public static AddDepart window = new AddDepart();
public static JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDepart window = new AddDepart();
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
	public AddDepart() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(400, 300, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u90E8\u95E8\u540D\u5B57");
		label.setBounds(33, 23, 54, 15);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u90E8\u95E8\u7F16\u53F7");
		label_1.setBounds(33, 58, 54, 15);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u5907     \u6CE8");
		label_2.setBounds(33, 92, 78, 15);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u4E0A\u7EA7\u90E8\u95E8\u7F16\u53F7");
		label_3.setBounds(33, 124, 93, 15);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u8054\u7CFB\u65B9\u5F0F");
		label_4.setBounds(33, 160, 78, 15);
		frame.getContentPane().add(label_4);
		
		textField = new JTextField();
		textField.setBounds(110, 20, 106, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(110, 55, 106, 21);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(110, 89, 106, 21);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(110, 117, 106, 21);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(110, 149, 106, 21);
		frame.getContentPane().add(textField_4);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DataBaseConnection data=new DataBaseConnection();
				Connection con=data.getconnection();
				QueryRunner  qr=new QueryRunner();
//				if(textField.){
				String sql = "insert into department(department_name,department_num,remark,superior_dapar_num,connect_way) values(?,?,?,?,?)";
				Object ss[]={textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText(),textField_4.getText(),};
				try {
   					qr.update(con,sql,ss);	
   					System.out.println("插入详细成功！");	
   					JOptionPane.showMessageDialog(null, "插入成功！");
   				} catch (SQLException ee) {
   					// TODO Auto-generated catch block
   					ee.printStackTrace();
   				}
			}
		});
		btnNewButton.setBounds(10, 214, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("\u53D6\u6D88");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDepart.window.frame.setVisible(false);
			}
		});
		button.setBounds(132, 214, 93, 23);
		frame.getContentPane().add(button);
	}

}
