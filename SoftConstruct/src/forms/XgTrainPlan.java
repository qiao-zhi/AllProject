package forms;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import dto.trainPlanBasicDTO;
import util.DataBaseConnection;
import javax.swing.JTextField;

public class XgTrainPlan {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XgTrainPlan window = new XgTrainPlan();
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
	public XgTrainPlan() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 200, 1000, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblNewLabel_4 = new JLabel("\u57F9\u8BAD\u8BA1\u5212\u5E74\u5EA6");
		lblNewLabel_4.setBounds(189, 50, 97, 25);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel label_3 = new JLabel("\u5F00\u59CB\u65F6\u95F4");
		label_3.setBounds(189, 108, 97, 25);
		frame.getContentPane().add(label_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(308, 52, 71, 21);
		frame.getContentPane().add(comboBox);
		
		JLabel label_4 = new JLabel("\u540D\u79F0");
		label_4.setBounds(449, 50, 97, 25);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u7ED3\u675F\u65F6\u95F4");
		label_5.setBounds(449, 108, 97, 25);
		frame.getContentPane().add(label_5);
		
		JButton button = new JButton("\u589E\u52A0");
		button.setBounds(230, 437, 93, 23);
		frame.getContentPane().add(button);
		
		
		/********主页显示的表格***************/
		String []name={"序号","培训计划名称","开始时间","结束时间","创建时间","培训类型","年度","完成情况","培训人数","培训专业"};
		DataBaseConnection data=new DataBaseConnection();
		Connection con=(Connection) data.getconnection();
	
		QueryRunner qr = new QueryRunner();
		String sql="Select * from train_plan_basic;";
		try {
List<trainPlanBasicDTO> train = new ArrayList<trainPlanBasicDTO>();
train=qr.query(con, sql, new BeanListHandler<trainPlanBasicDTO>(trainPlanBasicDTO.class));
int num=train.size(),xuhao=0;
Object [][]ss_1=new Object[num][10];
for(trainPlanBasicDTO in:train ){
		System.out.println(in.getBuild_Time());	
		}
for(int i=0;i<num;i++){
	for(int j=0;j<10;j++)
	{if(j==0){ss_1[i][j]=(++xuhao);}
	if(j==1){ss_1[i][j]=train.get(i).getPlan_name();}
	if(j==2){ss_1[i][j]=train.get(i).getStart_time();}
	if(j==3){ss_1[i][j]=train.get(i).getEnd_time();}
	if(j==4){ss_1[i][j]=train.get(i).getStartYear();}
	if(j==5){ss_1[i][j]=train.get(i).getTrain_Plan_Type();}
	if(j==6){ss_1[i][j]=train.get(i).getStart_time().toString().substring(0,4);}
	if(j==7){ss_1[i][j]=train.get(i).getFinish_Status();}
	if(j==8){ss_1[i][j]=train.get(i).getTrain_people_num();}
	if(j==9){ss_1[i][j]=train.get(i).getTrain_major();}
	
	}
	System.out.println(ss_1[i][0]);
	
}
		 DefaultTableCellRenderer render_1 = new DefaultTableCellRenderer();  //使文字在表格中居中
	     render_1.setHorizontalAlignment(SwingConstants.CENTER);
	     
	     JButton button_1 = new JButton("\u5220   \u9664");
	     button_1.setBounds(598, 437, 143, 23);
	     frame.getContentPane().add(button_1);
	     
	     textField = new JTextField();
	     textField.setBounds(308, 110, 66, 21);
	     frame.getContentPane().add(textField);
	     textField.setColumns(10);
	     
	     textField_1 = new JTextField();
	     textField_1.setColumns(10);
	     textField_1.setBounds(526, 52, 66, 21);
	     frame.getContentPane().add(textField_1);
	     
	     textField_2 = new JTextField();
	     textField_2.setColumns(10);
	     textField_2.setBounds(526, 108, 66, 21);
	     frame.getContentPane().add(textField_2);
	     
	     table = new JTable();
	     table.setBounds(159, 193, 582, 202);
	     frame.getContentPane().add(table);
		System.out.println(ss_1[5][5]);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
