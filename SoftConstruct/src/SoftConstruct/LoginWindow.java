package SoftConstruct;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

import util.DataBaseConnection;
import forms.*;



public class LoginWindow {
    public static LoginWindow g_loginWindow=new LoginWindow(); 
	public JFrame frame;
	private static  VerificateCode  verificateCode;
	private JTextField inputNameText;
	private JPasswordField inputPasswordText;
	private JTextField inputVerificateCode;
    private JLabel oskLabel;
    public static String cookie="����Ա";
//    public static  JLabel loginPromoptLabel; 

	

	public LoginWindow(){
		frame = new JFrame();
		frame.setTitle("\u767B\u5F55");
		frame.setBounds(500, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);                        //ʹ��¼���ڲ��ܸı��С
		frame.getContentPane().setLayout(null);
	
		
	
		
		
		JLabel userPasswordLabel = new JLabel("\u5BC6  \u7801");
		userPasswordLabel.setBounds(143, 116, 68, 30);
		userPasswordLabel.setFont(new Font("����", Font.BOLD, 17));
		frame.getContentPane().add(userPasswordLabel);
		
		
		JLabel userNameLabel = new JLabel("\u7528\u6237\u540D");
		userNameLabel.setBounds(143, 76, 68, 30);
		userNameLabel.setFont(new Font("����", Font.BOLD, 17));
		frame.getContentPane().add(userNameLabel);
		
		
		
		
		JLabel VerificateLabel = new JLabel("\u9A8C\u8BC1\u7801");
		VerificateLabel.setFont(new Font("����", Font.BOLD, 17));
		VerificateLabel.setBounds(143, 141, 68, 48);
		frame.getContentPane().add(VerificateLabel);
		
		
		
		
		inputNameText = new JTextField();
		inputNameText.setBounds(221, 82, 94, 21);
		frame.getContentPane().add(inputNameText);
		inputNameText.setColumns(10);
		
		
		
	
		
		JLabel promptLabel = new JLabel("\u4F7F\u7528\u524D\u8BF7\u5148\u767B\u5F55\uFF0C\u5982\u679C\u6CA1\u6709\u6CE8\u518C\u8BF7\u5148\u6CE8\u518C");
		promptLabel.setBounds(84, 246, 255, 15);
		promptLabel.setForeground(Color.RED);
		frame.getContentPane().add(promptLabel);
		
		inputPasswordText = new JPasswordField();
		inputPasswordText.setBounds(221, 122, 94, 21);
		frame.getContentPane().add(inputPasswordText);
		
		oskLabel=new JLabel();
		oskLabel.setIcon(new ImageIcon("src/images/3.jpg"));
		frame.getContentPane().add(oskLabel );
		oskLabel.setBounds(320,120,20,30);
		
		/****��С����ͼ�������¼�***/
		oskLabel.addMouseListener(new MouseListener(){
    		@Override
			public void mouseClicked(MouseEvent e) {
    			try {
					Runtime.getRuntime().exec("C:/Windows/System32/cmd.exe /k osk");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
    		}
    		@Override
			public void mouseEntered(MouseEvent e) {
    			// �����������
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
		
		
		inputVerificateCode = new JTextField();
		inputVerificateCode.setBounds(221, 156, 94, 21);
		frame.getContentPane().add(inputVerificateCode);
		inputVerificateCode.setColumns(10);
		
		JLabel oskLabel_1=new JLabel();
		oskLabel_1.setIcon(new ImageIcon("src/images/3.jpg"));
		frame.getContentPane().add(oskLabel_1 );
		oskLabel_1.setBounds(320,150,20,30);
		
		/****��С����ͼ�������¼�***/
		oskLabel_1.addMouseListener(new MouseListener(){
    		@Override
			public void mouseClicked(MouseEvent e) {
    			try {
					Runtime.getRuntime().exec("C:/Windows/System32/cmd.exe /k osk");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
    		}
    		@Override
			public void mouseEntered(MouseEvent e) {
    			// �����������
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
		
//		/**********�ձ�ǩ�ڵ�¼ʱ������ʾ****/
//	    loginPromoptLabel =new JLabel("");
//        loginPromoptLabel.setBounds(334,220, 100,30);
//        frame.getContentPane().add(loginPromoptLabel);
//		
		
		JLabel lblNewLabel = new JLabel("\u7535\u5382\u804C\u5DE5\u57F9\u8BAD\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setBounds(60, 23, 267, 43);
		lblNewLabel.setForeground(new Color(0, 51, 255));
		lblNewLabel.setFont(new Font("����", Font.BOLD, 20));
		frame.getContentPane().add(lblNewLabel);
		
	    /*********������֤��******/
        verificateCode=new VerificateCode();
        verificateCode.setBounds(344, 148, 90, 41);
        frame.getContentPane().add(verificateCode);
       
        
        /**********************����һ����ǩ������֤��ģ��ʱ���Ե��������֤��**************/
        JLabel changeVeriCodeLabel = new JLabel("\u770B\u4E0D\u6E05?\u6362\u4E00\u5F20");
        changeVeriCodeLabel.setBounds(334, 185, 90, 21);
        frame.getContentPane().add(changeVeriCodeLabel);
        changeVeriCodeLabel.addMouseListener(new MouseListener(){
    		@Override
			public void mouseClicked(MouseEvent e) {
    		frame.remove(verificateCode);                              //���ʱ��ɾ��������������֤��
    		  verificateCode=new VerificateCode();
    	      verificateCode.setBounds(344, 148, 90, 41);
    	      frame.getContentPane().add(verificateCode);
    		}
    		@Override
			public void mouseEntered(MouseEvent e) {
    			// �����������
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
        
        
    	/*******����¼��ť����¼��������,����������û����������ѯ���ݿ⣬�鵽�м�¼��˵���û���������ȷ������������****/
		JButton loginButton = new JButton("\u767B\u5F55");
		loginButton.setBounds(60, 203, 93, 23);
		loginButton.setBorder(null);
		frame.getContentPane().add(loginButton);
		 loginButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){try{
					//System.out.println(YanZhengMa.g_randomCode);
					/**********����֤��֤���Ƿ���ȷ*****/
					if(!(inputVerificateCode.getText().equals(VerificateCode.g_randomCode))){JOptionPane.showMessageDialog(null,"��֤�����");}
					else{
//						Thread1 th=new Thread1();
//						th.query=true;
//						th.start();
						
					DataBaseConnection dataBaseConn=new DataBaseConnection();
					Connection connectionUserInfor=dataBaseConn.getconnection();
					PreparedStatement pstmt = connectionUserInfor.prepareStatement("select * from user_information where user_Name=? ");
					pstmt.setString(1,inputNameText.getText());
				//	pstmt.setString(2,inputPasswordText.getText());
					ResultSet res1=pstmt.executeQuery();
//					   th.query=false;
//					   LoginWindow.loginPromoptLabel.setText("");
					 /****�鵽��¼��˵����������û������򲻴�������û�����������ٿ������������鵽�������Ƿ�һ���������һ����˵���������****/
					if(res1.next()){ 
						
						if(inputPasswordText.getText().equals(res1.getString(2))){     //�˺����������ȷ
							LoginWindow.g_loginWindow.frame.setVisible(false);   
							MainWindow1.window.frame.setVisible(true);
						       
						     LoginWindow.cookie=inputNameText.getText();
						       }
						else JOptionPane.showMessageDialog(null, "����������������룡");
						
				              	}					
					else{	JOptionPane.showMessageDialog(null, "�û��������ڣ������������ע�ᣡ");
						
					}
					dataBaseConn.closeConn(connectionUserInfor);
				
				}
					}
				catch(Exception exception){exception.printStackTrace();}
					
					
				}
						});
		
		 
		
		/***********��ע�ᰴť�����¼�������ƣ����ע�����ע����沢�ص���¼����***********/ 
		JButton registerButton = new JButton("\u6CE8\u518C");
		registerButton.setBounds(222, 203, 93, 23);
		registerButton.setBorder(null);
		frame.getContentPane().add(registerButton);
         registerButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				
				LoginWindow.g_loginWindow.frame.setVisible(false);
				RegisterWindow.g_registerWindow.frame.setVisible(true);
				
			}
					});
         
    
       
         
			
	 
	}
}
