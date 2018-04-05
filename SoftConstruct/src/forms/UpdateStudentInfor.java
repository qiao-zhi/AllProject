package forms;

/*******增加做好了****/
import java.awt.EventQueue;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTree;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import dto.employeeDTO;
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

public class UpdateStudentInfor {
public static String tempString=null;
	public static  JFrame frame;
	private JTextField textField_01;
	private JTextField textField_02;
    private static int id=1110;
    private JTextField textField_03;
    private JTextField textField_00;
    public static UpdateStudentInfor window = new UpdateStudentInfor();
    private JTextField textField_04;
    private JTextField textField_05;
    private JTextField textField_06;
    private JTextField textField_07;
    private JTextField textField_08;
					
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStudentInfor window = new UpdateStudentInfor();
					window.frame.setVisible(true);
			UpdateStudentInfor.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UpdateStudentInfor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
			System.out.println(StudentInformationMana.idid);
		
		
		frame = new JFrame();
		frame.setBounds(300, 200, 800, 500);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label_1 = new JLabel("\u5458\u5DE5\u6027\u522B");
		label_1.setBounds(65, 109, 74, 30);
		frame.getContentPane().add(label_1);
		
		textField_01 = new JTextField();
		textField_01.setBounds(196, 110, 98, 30);
		frame.getContentPane().add(textField_01);
		textField_01.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, 209, 54, 1);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel label_4 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7");
		label_4.setBounds(65, 149, 74, 36);
		frame.getContentPane().add(label_4);
		
		textField_02 = new JTextField();
		textField_02.setColumns(10);
		textField_02.setBounds(196, 153, 98, 30);
		frame.getContentPane().add(textField_02);
		
		JButton button = new JButton("\u53D6\u6D88");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateStudentInfor.window.frame.setVisible(false);
			}
		});
		button.setBounds(443, 428, 93, 23);
		frame.getContentPane().add(button);
		
		
		Object []major={"电气","汽机","锅炉"};
		
		JLabel label_7 = new JLabel("\u51FA\u751F\u65E5\u671F");
		label_7.setBounds(65, 195, 74, 36);
		frame.getContentPane().add(label_7);
		
		textField_03 = new JTextField();
		textField_03.setColumns(10);
		textField_03.setBounds(196, 193, 98, 30);
		frame.getContentPane().add(textField_03);
		
		JLabel label_8 = new JLabel("\u5458\u5DE5\u59D3\u540D");
		label_8.setBounds(65, 63, 74, 36);
		frame.getContentPane().add(label_8);
		
		textField_00 = new JTextField();
		textField_00.setColumns(10);
		textField_00.setBounds(196, 68, 98, 28);
		frame.getContentPane().add(textField_00);
		
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DataBaseConnection data=new DataBaseConnection();
				Connection con=data.getconnection();
				QueryRunner  qr=new QueryRunner();
//				if(textField.){
				String sql = "insert into employee(employee_name,employee_sex,employee_idcard,employeebirth,department_id,employee_job,employee_post,employee_address,employee_photo,employee_phone_num) values (?,?,?,?,?,?,?,?,?,?)";
			    String sql_1="delete  from employee where employee_Id=? ";                     
                Object del[]={UpdateStudentInfor.tempString};
                Object ins[]={textField_00.getText(),textField_01.getText(),textField_02.getText(),textField_03.getText(),"15001",textField_04.getText(),textField_05.getText(),textField_06.getText(),textField_07.getText(),textField_08.getText()};
                   try {
   					qr.update(con,sql_1,del);	
   					qr.update(con,sql,ins);
   					System.out.println("删除成功！");	
   					JOptionPane.showMessageDialog(null, "修改成功！");
   					
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
		
		textField_04 = new JTextField();
		textField_04.setColumns(10);
		textField_04.setBounds(196, 249, 98, 30);
		frame.getContentPane().add(textField_04);
		
		textField_05 = new JTextField();
		textField_05.setColumns(10);
		textField_05.setBounds(196, 293, 98, 30);
		frame.getContentPane().add(textField_05);
		
		textField_06 = new JTextField();
		textField_06.setColumns(10);
		textField_06.setBounds(196, 339, 98, 30);
		frame.getContentPane().add(textField_06);
		
		textField_07 = new JTextField();
		textField_07.setColumns(10);
		textField_07.setBounds(196, 383, 98, 30);
		frame.getContentPane().add(textField_07);
		
		textField_08 = new JTextField();
		textField_08.setColumns(10);
		textField_08.setBounds(495, 63, 251, 28);
		frame.getContentPane().add(textField_08);
		
		JLabel label_6 = new JLabel("\u7167\u7247");
		label_6.setBounds(443, 63, 74, 36);
		frame.getContentPane().add(label_6);
		
		int[] rows    = StudentInformationMana.table.getSelectedRows();
		  int[] columns =StudentInformationMana.table.getSelectedColumns();	
		   tempString = null;
		  for (int i = 0; i < rows.length; i++)
		  {
		   for (int j = 0; j < columns.length; j++)
		   {
			 tempString=(String) StudentInformationMana.table.getValueAt(rows[i], columns[0]);
		   }
		  }
		String sql="select *  from employee where employee_Id=?";
		Object ss[]={Integer.parseInt(StudentInformationMana.idid)};
		try {QueryRunner qr = new QueryRunner();
		DataBaseConnection data=new DataBaseConnection();
		Connection con=data.getconnection();
		System.out.println("123456");
		employeeDTO tt=(employeeDTO)qr.query(con, sql, new BeanHandler<employeeDTO>(employeeDTO.class),ss);
		System.out.println(tt.getdepartment_id());
		textField_00.setText(tt.getEmployee_name());
		textField_01.setText(tt.getEmployee_sex());
		textField_02.setText(tt.getEmployee_idcard());
		
		textField_03.setText(tt.getEmployeebirth());
		textField_04.setText(tt.getEmployee_job());
        textField_05.setText(tt.getEmployee_post());
         textField_06.setText(tt.getEmployee_address());
        textField_07.setText(tt.getEmployee_phone_num());
        textField_08.setText(tt.getEmployee_photo());
		
		
		
		
	}
catch(Exception eee){  }
		}
		
	}

