package forms;

/*******增加做好了****/
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

public class AddTrainPlan {

	public static  JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_7;
	private JTextField textField_5;
	private JTextField textField_8;
    private static int id=1110;
    private JTextField textField_6;
    private JTextField textField_9;
    private JTextField textField_10;

    public static AddTrainPlan window = new AddTrainPlan();
					

	/**
	 * Create the application.
	 */
	public AddTrainPlan() {
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
		
		JLabel lblNewLabel = new JLabel("\u5E74   \u5EA6");
		lblNewLabel.setBounds(57, 63, 74, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5F00\u59CB\u65F6\u95F4");
		lblNewLabel_1.setBounds(57, 109, 74, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("\u540D    \u79F0");
		label.setBounds(309, 16, 81, 30);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u7ED3\u675F\u65F6\u95F4");
		label_1.setBounds(309, 109, 74, 30);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setBounds(141, 68, 81, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(141, 110, 81, 30);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(389, 18, 98, 28);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(393, 110, 98, 30);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, 209, 54, 1);
		frame.getContentPane().add(lblNewLabel_2);
		
	
		
		JLabel label_2 = new JLabel("\u4E13    \u4E1A");
		label_2.setBounds(57, 149, 74, 36);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u6388  \u8BFE  \u4EBA ");
		label_3.setBounds(57, 195, 74, 36);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u8BFE   \u65F6");
		label_4.setBounds(309, 149, 74, 36);
		frame.getContentPane().add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(393, 153, 98, 30);
		frame.getContentPane().add(textField_4);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(141, 199, 81, 30);
		frame.getContentPane().add(textField_7);
		
		JButton button = new JButton("\u53D6\u6D88");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTrainPlan.window.frame.setVisible(false);
			}
		});
		button.setBounds(443, 428, 93, 23);
		frame.getContentPane().add(button);
		
		JLabel label_5 = new JLabel("\u57F9\u8BAD\u76EE\u7684");
		label_5.setBounds(57, 275, 74, 36);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("\u57F9\u8BAD\u5185\u5BB9");
		label_6.setBounds(57, 367, 74, 36);
		frame.getContentPane().add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(155, 262, 345, 64);
		frame.getContentPane().add(textField_5);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(153, 354, 345, 64);
		frame.getContentPane().add(textField_8);
		
		
		Object []major={"电气","汽机","锅炉"};
		final JComboBox comboBox = new JComboBox(major);
		comboBox.setBounds(141, 157, 81, 21);
		frame.getContentPane().add(comboBox);
		
		JLabel label_7 = new JLabel("\u4EBA  \u6570");
		label_7.setBounds(309, 195, 74, 36);
		frame.getContentPane().add(label_7);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(393, 199, 98, 30);
		frame.getContentPane().add(textField_6);
		
		JLabel lblid = new JLabel("\u8BA1\u5212ID");
		lblid.setBounds(57, 10, 74, 36);
		frame.getContentPane().add(lblid);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(141, 18, 81, 28);
		frame.getContentPane().add(textField_9);
		
		JLabel label_8 = new JLabel("\u521B\u5EFA\u65F6\u95F4");
		label_8.setBounds(309, 63, 74, 36);
		frame.getContentPane().add(label_8);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(389, 68, 98, 28);
		frame.getContentPane().add(textField_10);
		
		
		JButton btnNewButton_1 = new JButton("\u589E\u52A0");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DataBaseConnection data=new DataBaseConnection();
				Connection con=data.getconnection();
				QueryRunner  qr=new QueryRunner();
//				if(textField.){
				String sql = "insert into train_plan_basic values (?,?,?,?,?,?,?,?,?,?)";
				
				Object ins[]={textField_9.getText(),textField_2.getText(),textField_1.getText(),textField_3.getText(),textField_10.getText(),textField_2.getText(),textField.getText(),"未开始",textField_6.getText(),comboBox.getSelectedItem()};
                try {
					qr.update(con,sql,ins);	
					System.out.println("插入基础成功！");	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
                String sql_1= "insert into train_plan_detailed(basic_plan_id,major_id,train_reason,train_content,lesson_hour,lesson_teacher) values (?,?,?,?,?,?)";
                String major_id = null;
                if(comboBox.getSelectedIndex()==0){major_id="14051";};
                if(comboBox.getSelectedIndex()==1){major_id="14052";};
                if(comboBox.getSelectedIndex()==2){major_id="14053";};                
                   Object ins_1[]={textField_9.getText(),major_id,textField_5.getText(),textField_8.getText(),textField_4.getText(),textField_7.getText()};
                   try {
   					qr.update(con,sql_1,ins_1);	
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
		
	}
}
