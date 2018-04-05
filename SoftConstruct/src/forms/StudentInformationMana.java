package forms;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dto.departmentDTO;
import dto.employeeDTO;
import dto.trainPlanBasicDTO;
import util.DataBaseConnection;

public class StudentInformationMana {
	public  static JTable table;
	public  static JFrame frame;
	public static StudentInformationMana window = new StudentInformationMana();
	public static String idid=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInformationMana window = new StudentInformationMana();
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
	public StudentInformationMana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(150, 200, 1200, 500);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("\u5220\u9664");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectedRow()==-1){
					JOptionPane.showMessageDialog(null, "请选择一行");	}
		else {StudentInformationMana.window.sc_1();
		JOptionPane.showMessageDialog(null, "删除成功！");
		StudentInformationMana.window.cx();
		}
				
			}
		});
		btnNewButton.setBounds(153, 10, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()==-1){
					JOptionPane.showMessageDialog(null, "请选择一行");	}
		else {int[] rows    = StudentInformationMana.table.getSelectedRows();
		      int[] columns =StudentInformationMana.table.getSelectedColumns();	
		   
		  for (int i = 0; i < rows.length; i++)
		  {
		   for (int j = 0; j < columns.length; j++)
		   {
			 idid=(String) StudentInformationMana.table.getValueAt(rows[i], columns[0]);
		   }
		  }
			new UpdateStudentInfor().frame.setVisible(true);
		}
				
			}
		});
		button.setBounds(269, 10, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u67E5\u8BE2");
		button_1.setBounds(397, 10, 93, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u589E\u52A0");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				AddEmployee.window.frame.setVisible(true);
			}
		});
		button_2.setBounds(41, 10, 93, 23);
		frame.getContentPane().add(button_2);
		
		this.cx();
		
		

	}
	public static void cx(){
		String []name={"员工id","名字","性别","身份证号","出生日期","工作","岗位","地址","电话号码"};
		DataBaseConnection data=new DataBaseConnection();
		Connection con=(Connection) data.getconnection();

		QueryRunner qr = new QueryRunner();
		String sql="Select * from employee;";
		try {
	List<employeeDTO> train = new ArrayList<employeeDTO>();
	train=qr.query(con, sql, new BeanListHandler<employeeDTO>(employeeDTO.class));
	int num=train.size(),xuhao=0;
	Object [][]ss_1=new Object[num][10];
	for(employeeDTO in:train ){
		System.out.println(in.getdepartment_id());	
		}
	for(int i=0;i<num;i++){
	for(int j=0;j<10;j++)
	{if(j==0){ss_1[i][j]=train.get(i).getEmployee_id();}
	if(j==1){ss_1[i][j]=train.get(i).getEmployee_name();}
	if(j==2){ss_1[i][j]=train.get(i).getEmployee_sex();}
	if(j==3){ss_1[i][j]=train.get(i).getEmployee_idcard();}
	if(j==4){ss_1[i][j]=train.get(i).getEmployeebirth();}
	if(j==5){ss_1[i][j]=train.get(i).getEmployee_job();};
	if(j==6){ss_1[i][j]=train.get(i).getEmployee_post();}
	if(j==7){ss_1[i][j]=train.get(i).getEmployee_address();}
	if(j==8){ss_1[i][j]=train.get(i).getEmployee_phone_num();}
	

	}
	System.out.println(ss_1[i][0]);

	}	

			
		table = new JTable(ss_1,name);
		JScrollPane js=new JScrollPane(table);
		table.setCellSelectionEnabled(true);
		frame.getContentPane().add(js);
	 	js.setBounds(30, 150, 1100, 250);
		table.setRowHeight(20);
	//  table_1.setModel(new DefaultTableModel(){ss_1;},table_name)
		
		 DefaultTableCellRenderer render_1 = new DefaultTableCellRenderer();  //使文字在表格中居中
	     render_1.setHorizontalAlignment(SwingConstants.CENTER);
	     table.setDefaultRenderer(Object.class, render_1);
	     table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
	     
	     JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
	     btnNewButton_1.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		StudentInformationMana.frame.setVisible(false);
	     	}
	     });
	     btnNewButton_1.setBounds(549, 10, 93, 23);
	     frame.getContentPane().add(btnNewButton_1);
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		
	}



//	private static void xg(){
//		DataBaseConnection data=new DataBaseConnection();
//		Connection con=data.getconnection();
//	
//		  QueryRunner qr_1 = new QueryRunner();
//		  int[] rows    = table.getSelectedRows();
//		  int[] columns = table.getSelectedColumns();	
//		  String tempString = null;
//		  for (int i = 0; i < rows.length; i++)
//		  {
//		   for (int j = 0; j < columns.length; j++)
//		   {
//			 tempString=(String) table.getValueAt(rows[i], columns[0]);
//		   }
//		  }
//		String sql="delete  from employee where employee_Id=?";
//		String sql="delete  from employee where employee_Id=?";
//		Object ss[]={tempString};
//		try {
//			System.out.println(  tempString);
//            qr_1.update(con,sql, ss);
//           
//	}
//catch(Exception eee){  }
//		}
	
	//删除表格
		private static void sc_1(){
			DataBaseConnection data=new DataBaseConnection();
			Connection con=data.getconnection();
		
			QueryRunner qr_1 = new QueryRunner();
			  int[] rows    = table.getSelectedRows();
			  int[] columns = table.getSelectedColumns();	
			  String tempString = null;
			  for (int i = 0; i < rows.length; i++)
			  {
			   for (int j = 0; j < columns.length; j++)
			   {
				 tempString=(String) table.getValueAt(rows[i], columns[0]);
			   }
			  }
			String sql="delete  from employee where employee_Id=?";
			Object ss[]={tempString};
			try {
				System.out.println(  tempString);
	            qr_1.update(con,sql, ss);
	           
		}
	catch(Exception eee){  }
			}
	
}
