package forms;

/*******增加做好了****/
import java.awt.EventQueue;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTree;

import org.apache.commons.dbutils.QueryRunner;

import util.DataBaseConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class AddEmployee {

	public static  JFrame frame;
	private JTextField textField_3;
	private JTextField textField_4;
    private static int id=1110;
    private JTextField textField_6;
    private JTextField textField_10;

    public static AddEmployee window = new AddEmployee();
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_5;
    private JTextField textField_7;
					
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployee window = new AddEmployee();
					window.frame.setVisible(true);
			AddEmployee.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddEmployee() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 200, 800, 500);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label_1 = new JLabel("\u5458\u5DE5\u6027\u522B");
		label_1.setBounds(65, 109, 74, 30);
		frame.getContentPane().add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(196, 110, 98, 30);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, 209, 54, 1);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel label_4 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7");
		label_4.setBounds(65, 149, 74, 36);
		frame.getContentPane().add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(196, 153, 98, 30);
		frame.getContentPane().add(textField_4);
		
		JButton button = new JButton("\u53D6\u6D88");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEmployee.window.frame.setVisible(false);
			}
		});
		button.setBounds(443, 428, 93, 23);
		frame.getContentPane().add(button);
		
		
		Object []major={"电气","汽机","锅炉"};
		
		JLabel label_7 = new JLabel("\u51FA\u751F\u65E5\u671F");
		label_7.setBounds(65, 195, 74, 36);
		frame.getContentPane().add(label_7);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(196, 193, 98, 30);
		frame.getContentPane().add(textField_6);
		
		JLabel label_8 = new JLabel("\u5458\u5DE5\u59D3\u540D");
		label_8.setBounds(65, 63, 74, 36);
		frame.getContentPane().add(label_8);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(196, 68, 98, 28);
		frame.getContentPane().add(textField_10);
		
		
		JButton btnNewButton_1 = new JButton("\u589E\u52A0");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DataBaseConnection data=new DataBaseConnection();
				Connection con=data.getconnection();
				QueryRunner  qr=new QueryRunner();
//				if(textField.){
				String sql = "insert into employee(employee_name,employee_sex,employee_idcard,employeebirth,department_id,employee_job,employee_post,employee_address,employee_photo,employee_phone_num) values (?,?,?,?,?,?,?,?,?,?)";
			                                
              Object ins[]={textField_10.getText(),textField_3.getText(),textField_4.getText(),textField_6.getText(),"15001",textField.getText(),textField_1.getText(),textField_2.getText(),textField_7.getText(),textField_5.getText()};
                   try {
   					qr.update(con,sql,ins);	
   					System.out.println("插入详细成功！");	
   					JOptionPane.showMessageDialog(null, "插入成功！");
   				} catch (SQLException e) {
   					// TODO Auto-generated catch block
   					e.printStackTrace();
   				}
                
                
//				}else{
//					
//					
//				}
				
				
				
				
			}
		});
		btnNewButton_1.setBounds(155, 428, 93, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel label = new JLabel("\u5DE5\u4F5C");
		label.setBounds(65, 241, 74, 36);
		frame.getContentPane().add(label);
		
		JLabel label_2 = new JLabel("\u5C97\u4F4D");
		label_2.setBounds(65, 285, 74, 36);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u5730\u5740");
		label_3.setBounds(65, 331, 74, 36);
		frame.getContentPane().add(label_3);
		
		JLabel label_5 = new JLabel("\u7535\u8BDD\u53F7\u7801");
		label_5.setBounds(65, 375, 74, 36);
		frame.getContentPane().add(label_5);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(196, 249, 98, 30);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(196, 293, 98, 30);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(196, 339, 98, 30);
		frame.getContentPane().add(textField_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(196, 383, 98, 30);
		frame.getContentPane().add(textField_5);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(495, 63, 251, 28);
		frame.getContentPane().add(textField_7);
		
		JLabel label_6 = new JLabel("\u7167\u7247");
		label_6.setBounds(443, 63, 74, 36);
		frame.getContentPane().add(label_6);
		
	}
}
