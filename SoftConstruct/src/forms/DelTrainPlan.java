package forms;

//删除做完了
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import SoftConstruct.*;
import util.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import SoftConstruct.LoginWindow;
import SoftConstruct.VerificateCode;
import dto.trainPlanBasicDTO;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DelTrainPlan { 
	public static JFrame frame;

public static 	DelTrainPlan window = new DelTrainPlan();

public  static  JTable table_1;
					
	public DelTrainPlan() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(300, 200, 1000, 530);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblNewLabel_4 = new JLabel("\u57F9\u8BAD\u8BA1\u5212\u5E74\u5EA6");
		lblNewLabel_4.setBounds(189, 50, 97, 25);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel label_3 = new JLabel("\u57F9\u8BAD\u8BA1\u5212\u7C7B\u578B");
		label_3.setBounds(189, 108, 97, 25);
		frame.getContentPane().add(label_3);
		
		DelTrainPlan.sc();
		Object []niandu={"2014","2015"};
		JComboBox comboBox = new JComboBox(niandu);
		comboBox.setBounds(308, 50, 118, 23);
		frame.getContentPane().add(comboBox);
		
		Object []type={"新生入学培训","学习技术培训"};
		JComboBox comboBox_1 = new JComboBox(type);
		comboBox_1.setBounds(308, 110, 118, 21);
		frame.getContentPane().add(comboBox_1);
		
		Object []major={"电气","汽机","锅炉"};
		JComboBox comboBox_2 = new JComboBox(major);
		comboBox_2.setBounds(530, 52, 107, 21);
		frame.getContentPane().add(comboBox_2);
		
		Object []finishStstus={"未开始","正在进行","已经完成"};
		JComboBox comboBox_3 = new JComboBox(finishStstus);
		comboBox_3.setBounds(530, 110, 107, 21);
		frame.getContentPane().add(comboBox_3);
		
		JLabel label_4 = new JLabel("\u57F9\u8BAD\u4E13\u4E1A");
		label_4.setBounds(449, 50, 97, 25);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u5B8C\u6210\u60C5\u51B5");
		label_5.setBounds(449, 108, 97, 25);
		frame.getContentPane().add(label_5);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.setBounds(686, 88, 93, 23);
		frame.getContentPane().add(button);
		
		
		/********主页显示的表格***************/
	
	     
	     JButton button_1 = new JButton("\u5220   \u9664");
	     button_1.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		int col = table_1.getSelectedColumn();//获取选中的列号
    			int row = table_1.getSelectedRow();//获取选中的行号
    			if(row==-1){JOptionPane.showMessageDialog(null, "请选择一行删除");}
    			else{       DelTrainPlan.sc_1();
    			JOptionPane.showMessageDialog(null, "删除成功！");
    			  DelTrainPlan.sc();
    			}
	     	}
	     });
	     button_1.setBounds(164, 447, 143, 23);
	     frame.getContentPane().add(button_1);
	     
	     JButton button_2 = new JButton("\u8FD4\u56DE");
	     button_2.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		DelTrainPlan.window.frame.setVisible(false);
	     	}
	     });
	     button_2.setBounds(389, 447, 143, 23);
	     frame.getContentPane().add(button_2);
		
		
}
	
	
	
	
	
	
	
	
	
public static void sc(){
	String []name={"培训id","培训计划名称","开始时间","结束时间","创建时间","培训类型","年度","完成情况","培训人数","培训专业"};
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
{if(j==0){ss_1[i][j]=train.get(i).getPlan_Id();}
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

		
	table_1 = new JTable(ss_1,name);
	JScrollPane js=new JScrollPane(table_1);
	table_1.setCellSelectionEnabled(true);
	frame.getContentPane().add(js);
 	js.setBounds(100, 150, 1000, 280);
	table_1.setRowHeight(20);
//  table_1.setModel(new DefaultTableModel(){ss_1;},table_name)
	
	 DefaultTableCellRenderer render_1 = new DefaultTableCellRenderer();  //使文字在表格中居中
     render_1.setHorizontalAlignment(SwingConstants.CENTER);
     table_1.setDefaultRenderer(Object.class, render_1);
     table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
	} catch (SQLException ee) {
		ee.printStackTrace();
	}
	
}



//删除表格
	private static void sc_1(){
		DataBaseConnection data=new DataBaseConnection();
		Connection con=data.getconnection();
	
		QueryRunner qr_1 = new QueryRunner();
		  int[] rows    = table_1.getSelectedRows();
		  int[] columns = table_1.getSelectedColumns();	
		  String tempString = null;
		  for (int i = 0; i < rows.length; i++)
		  {
		   for (int j = 0; j < columns.length; j++)
		   {
			 tempString=(String) table_1.getValueAt(rows[i], columns[0]);
		   }
		  }
		String sql="delete  from train_plan_basic where  plan_Id=?";
		Object ss[]={tempString};
		try {
			System.out.println(  tempString);
          qr_1.update(con,sql, ss);

	}
catch(Exception eee){  }
		}
}
