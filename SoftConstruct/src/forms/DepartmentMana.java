package forms;
//删除部门做好了
import java.awt.EventQueue;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dto.departmentDTO;
import dto.trainPlanBasicDTO;
import util.DataBaseConnection;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DepartmentMana {
	public static DepartmentMana window = new DepartmentMana();
    public static  JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentMana window = new DepartmentMana();
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
	public DepartmentMana() {
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
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddDepart.window.frame.setVisible(true);
			}
		});
		button.setBounds(207, 409, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.setBounds(360, 409, 93, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(table.getSelectedRow()==-1){
							JOptionPane.showMessageDialog(null, "请选择一行");	}
				else {DepartmentMana.window.ss_1();
				JOptionPane.showMessageDialog(null, "删除成功！");
				 DepartmentMana.window.ss();
				}
				
			}
		});
		button_2.setBounds(487, 409, 93, 23);
		frame.getContentPane().add(button_2);
		
		JLabel lblNewLabel = new JLabel("\u90E8\u95E8\u7F16\u53F7");
		lblNewLabel.setBounds(89, 44, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u90E8\u95E8\u540D\u5B57");
		lblNewLabel_1.setBounds(399, 44, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(157, 41, 66, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(472, 41, 66, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.setBounds(552, 64, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		this.ss();
		
	} 
	
	//更新表格
	private static void ss(){
		table = new JTable();
		// 使得表格的选取是以cell为单位,而不是以列为单位.若你没有写此行,则在选取表格数
		table.setCellSelectionEnabled(true);
		table.setBounds(142, 251, 228, -56);
		frame.getContentPane().add(table);
		String []name={"部门id","部门名字","部门编号","上级部门编号","备注","联系方式"};
		DataBaseConnection data=new DataBaseConnection();
		Connection con=data.getconnection();
	
		QueryRunner qr = new QueryRunner();
		String sql="Select * from Department";
		try {
List<departmentDTO> train = new ArrayList<departmentDTO>();
train=qr.query(con, sql, new BeanListHandler<departmentDTO>(departmentDTO.class));
con.close();
int num=train.size(),xuhao=0;
Object [][]ss_1=new Object[num][10];
for(int i=0;i<num;i++){
	for(int j=0;j<6;j++)
	{if(j==0){ss_1[i][j]=train.get(i).getDepartment_id();}
	if(j==1){ss_1[i][j]=train.get(i).getDepartment_name();}
	if(j==2){ss_1[i][j]=train.get(i).getDepartment_num();}
	if(j==3){ss_1[i][j]=train.get(i).getSuperior_depar_num();}
	if(j==4){ss_1[i][j]=train.get(i).getRemark();}
	if(j==5){ss_1[i][j]=train.get(i).getConnect_way();}

	
	}
	System.out.println(ss_1[i][3]);
	
}	

			

/****************带滚动条的表格***/
		table = new JTable(ss_1,name);
		table.setRowHeight(29);
//	  table_1.setModel(new DefaultTableModel(){ss_1;},table_name);
		table.setCellSelectionEnabled(true);
		JScrollPane js=new JScrollPane(table);
		frame.getContentPane().add(js);
				
     	js.setBounds(23, 108, 600, 250);
     	
     	JButton button_3 = new JButton("\u53D6\u6D88");
     	button_3.addActionListener(new ActionListener() {
     		public void actionPerformed(ActionEvent e) {
     			DepartmentMana.window .frame.setVisible(false);
     		}
     	});
     	button_3.setBounds(626, 409, 93, 23);
     	frame.getContentPane().add(button_3);
		}catch(Exception ee){}
	}
	
	
	
	//删除表格
	static void ss_1(){
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
		String sql="delete  from department where  department_id=?";
		Object ss[]={Integer.parseInt(tempString)};
		try {
			System.out.println(  tempString);
            qr_1.update(con,sql, ss);

	}
catch(Exception eee){  }
		}
	
	
	
	
}
