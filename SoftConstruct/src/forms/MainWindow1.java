package forms;
/*******�޸������ǩ���ԣ�����ߵ�������¼�***/

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




public class MainWindow1 {
public static 	JLabel label_2 = new JLabel("\u65F6\u95F4");;   /*****ȫ�ֱ�ǩ���ڱ���ʱ��**/
	public static  JFrame frame;
   private JTable table;
   private JTable table_1;
   public static MainWindow1 window = new MainWindow1();
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
	public MainWindow1() {
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
		
		
		/******�޸������ǩ*******/
		final JLabel lblNewLabel_3 = new JLabel("   \u4FEE\u6539\u5BC6\u7801");
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(new Color(0, 153, 51));
		lblNewLabel_3.setBounds(1044, 197, 152, 48);
		lblNewLabel_3.addMouseListener(new MouseListener(){
    		@Override
			public void mouseClicked(MouseEvent e) {  //����һ���������Ĵ��ڣ���ʾΪ�ɼ�
    			xiugaimima.window.frame.setVisible(true);
    		}
    		@Override
			public void mouseEntered(MouseEvent e) {
    			// �����������
    			lblNewLabel_3.setForeground(Color.red);
    		}
    		@Override
			public void mouseExited(MouseEvent e) {
    			lblNewLabel_3.setForeground(Color.black);
    		}
    		@Override
			public void mousePressed(MouseEvent e) {
    			// ������갴��
    		}
    		@Override
			public void mouseReleased(MouseEvent e) {
    			// ��������ͷ�
    		}
    	});
		frame.getContentPane().add(lblNewLabel_3);
		
		
		/******�˳�ϵͳ��ǩ*******/
		final JLabel label = new JLabel("  \u9000\u51FA\u7CFB\u7EDF");
		label.setOpaque(true);
		label.setBackground(new Color(0, 153, 51));
		label.setBounds(1279, 197, 71, 48);
		label.addMouseListener(new MouseListener(){
    		@Override
			public void mouseClicked(MouseEvent e) {
    		int t=JOptionPane.showConfirmDialog(null,"ȷ���˳�");   //ȷ���˳�ʱ����ϵͳ
    		if( t==JOptionPane.YES_OPTION){
    		System.exit(0);}
    		}
    		@Override
			public void mouseEntered(MouseEvent e) {
    			// �����������
    			label.setForeground(Color.red);
    		}
    		@Override
			public void mouseExited(MouseEvent e) {
    			label.setForeground(Color.black);
    		}
    		@Override
			public void mousePressed(MouseEvent e) {
    			// ������갴��
    		}
    		@Override
			public void mouseReleased(MouseEvent e) {
    			// ��������ͷ�
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
		 DefaultTableCellRenderer render = new DefaultTableCellRenderer();  //ʹ�����ڱ���о���
	     render.setHorizontalAlignment(SwingConstants.CENTER);
	     table.setDefaultRenderer(Object.class, render);
	     table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"��ҳ"},
				{"��ѵ�ƻ�����"},
				{"���"},
				{"�޸�"},
				{"ɾ��"},
				{"��ѯ"},
				{"��ѵ�ɼ�����"},
				{"¼��"},
				{"�޸�"},
				{"��ѯ"},
				{"��ѵ���ڹ���"},
				{"��ѯ"},
				{"ͳ��"},
				{"ѧԱ����"},
				{"���Ź���"},
				{"ѧԱ������Ϣ����"},
				{"ѧϰ��¼����"},
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

    			int col = table.getSelectedColumn();//��ȡѡ�е��к�
    			int row = table.getSelectedRow();//��ȡѡ�е��к�
//    			DefaultTableModel model = (DefaultTableModel) table.getModel();
    			if(row==0){}
    			if(row==1){EventQueue.invokeLater(new Runnable() {
    				public void run() {
    					try {
    						DateAndTime da=new DateAndTime();
    						TrainPlanMana.window.frame.setVisible(true);
    					} catch (Exception e) {
    						e.printStackTrace();
    					}
    				}
    			});}
    			if(row==2){AddTrainPlan.window.frame.setVisible(true);}
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
    			// ��������뿪
    		}
    		@Override
			public void mousePressed(MouseEvent e) {
    			// ������갴��
    		}
    		@Override
			public void mouseReleased(MouseEvent e) {
    			// ��������ͷ�
    		}
    	});
		table.setBounds(0, 197, 206, 544);
		frame.getContentPane().add(table);
		
		
	}
}
