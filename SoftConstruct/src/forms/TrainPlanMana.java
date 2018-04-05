package forms;
/*******修改密码标签不对，给左边导航添加事件***/

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




public class TrainPlanMana {
public static 	JLabel label_2 = new JLabel("\u65F6\u95F4");;   /*****全局标签用于保存时间**/
	public static JFrame frame;
   private JTable table;
   private JTable table_1;
   public static TrainPlanMana window = new TrainPlanMana();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DateAndTime da=new DateAndTime();
					
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
	public TrainPlanMana() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 40, 1370, 800);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(102, 255, 255));
		lblNewLabel.setBounds(0, 0, 1350, 195);
//		lblNewLabel.setForeground(new Color(175, 238, 238));
		lblNewLabel.setIcon(new ImageIcon("src/images\\1.jpg"));
		
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(0, 153, 51));
		lblNewLabel_1.setBounds(206, 197, 501, 48);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("  \u6B22\u8FCE\uFF1A"+LoginWindow.cookie);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(0, 153, 51));
		lblNewLabel_2.setBounds(875, 197, 170, 48);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		/******修改密码标签*******/
		final JLabel lblNewLabel_3 = new JLabel("   \u4FEE\u6539\u5BC6\u7801");
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(new Color(0, 153, 51));
		lblNewLabel_3.setBounds(1044, 197, 152, 48);
		lblNewLabel_3.addMouseListener(new MouseListener(){
    		@Override
			public void mouseClicked(MouseEvent e) {  //增加一个需改密码的窗口，显示为可见
    			xiugaimima.window.frame.setVisible(true);
    		}
    		@Override
			public void mouseEntered(MouseEvent e) {
    			// 处理鼠标移入
    			lblNewLabel_3.setForeground(Color.red);
    		}
    		@Override
			public void mouseExited(MouseEvent e) {
    			lblNewLabel_3.setForeground(Color.black);
    		}
    		@Override
			public void mousePressed(MouseEvent e) {
    			// 处理鼠标按下
    		}
    		@Override
			public void mouseReleased(MouseEvent e) {
    			// 处理鼠标释放
    		}
    	});
		frame.getContentPane().add(lblNewLabel_3);
		
		
		/******退出系统标签*******/
		final JLabel label = new JLabel("  \u9000\u51FA\u7CFB\u7EDF");
		label.setOpaque(true);
		label.setBackground(new Color(0, 153, 51));
		label.setBounds(1279, 197, 71, 48);
		label.addMouseListener(new MouseListener(){
    		@Override
			public void mouseClicked(MouseEvent e) {
    		int t=JOptionPane.showConfirmDialog(null,"确认退出");   //确认退出时结束系统
    		if( t==JOptionPane.YES_OPTION){
    		System.exit(0);}
    		}
    		@Override
			public void mouseEntered(MouseEvent e) {
    			// 处理鼠标移入
    			label.setForeground(Color.red);
    		}
    		@Override
			public void mouseExited(MouseEvent e) {
    			label.setForeground(Color.black);
    		}
    		@Override
			public void mousePressed(MouseEvent e) {
    			// 处理鼠标按下
    		}
    		@Override
			public void mouseReleased(MouseEvent e) {
    			// 处理鼠标释放
    		}
    	});
		frame.getContentPane().add(label);
		
		
		JLabel label_1 = new JLabel("");
		label_1.setOpaque(true);
		label_1.setBackground(new Color(0, 153, 51));
		label_1.setBounds(1192, 197, 91, 48);
		frame.getContentPane().add(label_1);
		
		
		label_2.setOpaque(true);
		label_2.setBackground(new Color(0, 153, 51));
		label_2.setBounds(706, 197, 170, 48);
		frame.getContentPane().add(label_2);
		
		table = new JTable();
		table.setRowHeight(29);
		 DefaultTableCellRenderer render = new DefaultTableCellRenderer();  //使文字在表格中居中
	     render.setHorizontalAlignment(SwingConstants.CENTER);
	     table.setDefaultRenderer(Object.class, render);
	     table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"首页"},
				{"培训计划管理"},
				{"添加"},
				{"修改"},
				{"删除"},
				{"查询"},
				{"培训成绩管理"},
				{"录入"},
				{"修改"},
				{"查询"},
				{"培训考勤管理"},
				{"查询"},
				{"统计"},
				{"学员管理"},
				{"部门管理"},
				{"学员基本信息管理"},
				{"学习记录管理"},
			},
			new String[] {
				"New column"
			}
		));
		table.setColumnSelectionAllowed(false); 
		table.setRowSelectionAllowed(false);
		table.addMouseListener(new MouseListener(){
    		@Override
			public void mouseClicked(MouseEvent e) {

    			int col = table.getSelectedColumn();//获取选中的列号
    			int row = table.getSelectedRow();//获取选中的行号
//    			DefaultTableModel model = (DefaultTableModel) table.getModel();
    			if(row==0){MainWindow1.window.frame.setVisible(true);}
    			if(row==1){}
    			if(row==2){AddTrainPlan.window.frame.setVisible(true); }
    			if(row==3){System.out.println("3");}
    			if(row==4){DelTrainPlan.window.frame.setVisible(true);}
    			if(row==5){TrainPlanMana.window.frame.setVisible(true);}
    			if(row==6){System.out.println("6");}
    			if(row==7){System.out.println("7");}
    			if(row==8){System.out.println("8");}
    			if(row==9){System.out.println("9");}
    			if(row==10){System.out.println("10");}
    			if(row==11){System.out.println("11");}
    			if(row==12){System.out.println("12");}
    			if(row==13){StudentInformationMana.window.frame.setVisible(true);}
    			if(row==14){DepartmentMana.window .frame.setVisible(true);}
    			if(row==15){System.out.println("15");}
    			if(row==16){System.out.println("16");}
    			
    		}
    		@Override
			public void mouseEntered(MouseEvent e) {
////    			if(table.getRowCount()){
//    			
//    		table.setBackground(new Color(00,99,66));
//    		}
    		}
    		@Override
			public void mouseExited(MouseEvent e) {
    			// 处理鼠标离开
    		}
    		@Override
			public void mousePressed(MouseEvent e) {
    			// 处理鼠标按下
    		}
    		@Override
			public void mouseReleased(MouseEvent e) {
    			// 处理鼠标释放
    		}
    	});
		table.setBounds(0, 197, 206, 544);
		frame.getContentPane().add(table);
		
		JLabel lblNewLabel_4 = new JLabel("\u57F9\u8BAD\u8BA1\u5212\u5E74\u5EA6");
		lblNewLabel_4.setBounds(292, 255, 97, 25);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel label_3 = new JLabel("\u57F9\u8BAD\u8BA1\u5212\u7C7B\u578B");
		label_3.setBounds(292, 290, 97, 25);
		frame.getContentPane().add(label_3);
		
		Object []niandu={"2014","2015"};
		JComboBox comboBox = new JComboBox(niandu);
		comboBox.setBounds(399, 257, 97, 21);
		frame.getContentPane().add(comboBox);
		
		//培训计划类型
		Object []type={"新生入学培训","学习技术培训"};
		JComboBox comboBox_1 = new JComboBox(type);
		comboBox_1.setBounds(399, 292, 97, 21);
		frame.getContentPane().add(comboBox_1);
		
		
		Object []major={"电气","汽机","锅炉"};
		JComboBox comboBox_2 = new JComboBox(major);
		comboBox_2.setBounds(670, 257, 71, 21);
		frame.getContentPane().add(comboBox_2);
		
		
		//完成情况
		Object []finishStstus={"未开始","正在进行","已经完成"};
		JComboBox comboBox_3 = new JComboBox(finishStstus);
		comboBox_3.setBounds(670, 292, 71, 21);
		frame.getContentPane().add(comboBox_3);
		
		JLabel label_4 = new JLabel("\u57F9\u8BAD\u4E13\u4E1A");
		label_4.setBounds(555, 255, 97, 25);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u5B8C\u6210\u60C5\u51B5");
		label_5.setBounds(555, 290, 97, 25);
		frame.getContentPane().add(label_5);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.setBounds(805, 270, 93, 23);
		frame.getContentPane().add(button);
		
		
		/********主页显示的表格***************/
		String []name={"序号","培训计划名称","开始时间","结束时间","创建时间","培训类型","年度","完成情况","培训人数","培训专业"};
		DataBaseConnection data=new DataBaseConnection();
		Connection con=data.getconnection();
	
		QueryRunner qr = new QueryRunner();
		String sql="Select * from train_plan_basic;";
		try {
List<trainPlanBasicDTO> train = new ArrayList<trainPlanBasicDTO>();
train=qr.query(con, sql, new BeanListHandler<trainPlanBasicDTO>(trainPlanBasicDTO.class));
con.close();
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

			

/****************带滚动条的表格***/
		table_1 = new JTable(ss_1,name);
		table_1.setRowHeight(29);
//	  table_1.setModel(new DefaultTableModel(){ss_1;},table_name);
		JScrollPane js=new JScrollPane(table_1);
		frame.getContentPane().add(js);
				
     	js.setBounds(240, 363, 1079, 312);
		
		 DefaultTableCellRenderer render_1 = new DefaultTableCellRenderer();  //使文字在表格中居中
	     render.setHorizontalAlignment(SwingConstants.CENTER);
	     table_1.setDefaultRenderer(Object.class, render_1);
	     table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		System.out.println(ss_1[5][5]);
		} catch (SQLException e) {
			e.printStackTrace();
		}


		
		
		JButton btnNewButton = new JButton("\u521B\u5EFA");
		btnNewButton.setBounds(875, 319, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.setBounds(979, 319, 93, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.setBounds(1082, 319, 93, 23);
		frame.getContentPane().add(button_2);
	}
}
