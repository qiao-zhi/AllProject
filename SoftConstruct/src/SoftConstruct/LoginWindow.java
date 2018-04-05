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
    public static String cookie="管理员";
//    public static  JLabel loginPromoptLabel; 

	

	public LoginWindow(){
		frame = new JFrame();
		frame.setTitle("\u767B\u5F55");
		frame.setBounds(500, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);                        //使登录窗口不能改变大小
		frame.getContentPane().setLayout(null);
	
		
	
		
		
		JLabel userPasswordLabel = new JLabel("\u5BC6  \u7801");
		userPasswordLabel.setBounds(143, 116, 68, 30);
		userPasswordLabel.setFont(new Font("宋体", Font.BOLD, 17));
		frame.getContentPane().add(userPasswordLabel);
		
		
		JLabel userNameLabel = new JLabel("\u7528\u6237\u540D");
		userNameLabel.setBounds(143, 76, 68, 30);
		userNameLabel.setFont(new Font("宋体", Font.BOLD, 17));
		frame.getContentPane().add(userNameLabel);
		
		
		
		
		JLabel VerificateLabel = new JLabel("\u9A8C\u8BC1\u7801");
		VerificateLabel.setFont(new Font("宋体", Font.BOLD, 17));
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
		
		/****给小键盘图标增加事件***/
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
    			// 处理鼠标移入
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
		
		
		inputVerificateCode = new JTextField();
		inputVerificateCode.setBounds(221, 156, 94, 21);
		frame.getContentPane().add(inputVerificateCode);
		inputVerificateCode.setColumns(10);
		
		JLabel oskLabel_1=new JLabel();
		oskLabel_1.setIcon(new ImageIcon("src/images/3.jpg"));
		frame.getContentPane().add(oskLabel_1 );
		oskLabel_1.setBounds(320,150,20,30);
		
		/****给小键盘图标增加事件***/
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
    			// 处理鼠标移入
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
		
//		/**********空标签在登录时给出提示****/
//	    loginPromoptLabel =new JLabel("");
//        loginPromoptLabel.setBounds(334,220, 100,30);
//        frame.getContentPane().add(loginPromoptLabel);
//		
		
		JLabel lblNewLabel = new JLabel("\u7535\u5382\u804C\u5DE5\u57F9\u8BAD\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setBounds(60, 23, 267, 43);
		lblNewLabel.setForeground(new Color(0, 51, 255));
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		frame.getContentPane().add(lblNewLabel);
		
	    /*********增加验证码******/
        verificateCode=new VerificateCode();
        verificateCode.setBounds(344, 148, 90, 41);
        frame.getContentPane().add(verificateCode);
       
        
        /**********************增加一个标签，当验证码模糊时可以点击更换验证码**************/
        JLabel changeVeriCodeLabel = new JLabel("\u770B\u4E0D\u6E05?\u6362\u4E00\u5F20");
        changeVeriCodeLabel.setBounds(334, 185, 90, 21);
        frame.getContentPane().add(changeVeriCodeLabel);
        changeVeriCodeLabel.addMouseListener(new MouseListener(){
    		@Override
			public void mouseClicked(MouseEvent e) {
    		frame.remove(verificateCode);                              //点击时先删除再重新增加验证码
    		  verificateCode=new VerificateCode();
    	      verificateCode.setBounds(344, 148, 90, 41);
    	      frame.getContentPane().add(verificateCode);
    		}
    		@Override
			public void mouseEntered(MouseEvent e) {
    			// 处理鼠标移入
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
        
        
    	/*******给登录按钮添加事件处理机制,根据输入的用户名与密码查询数据库，查到有记录则说明用户名密码正确，进入主窗口****/
		JButton loginButton = new JButton("\u767B\u5F55");
		loginButton.setBounds(60, 203, 93, 23);
		loginButton.setBorder(null);
		frame.getContentPane().add(loginButton);
		 loginButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){try{
					//System.out.println(YanZhengMa.g_randomCode);
					/**********先验证验证码是否正确*****/
					if(!(inputVerificateCode.getText().equals(VerificateCode.g_randomCode))){JOptionPane.showMessageDialog(null,"验证码错误！");}
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
					 /****查到记录则说明存在这个用户，否则不存在这个用户。如果存在再看输入的密码与查到的密码是否一样，如果不一样则说明密码错误****/
					if(res1.next()){ 
						
						if(inputPasswordText.getText().equals(res1.getString(2))){     //账号与密码均正确
							LoginWindow.g_loginWindow.frame.setVisible(false);   
							MainWindow1.window.frame.setVisible(true);
						       
						     LoginWindow.cookie=inputNameText.getText();
						       }
						else JOptionPane.showMessageDialog(null, "密码错误，请重新输入！");
						
				              	}					
					else{	JOptionPane.showMessageDialog(null, "用户名不存在，请重新输入或注册！");
						
					}
					dataBaseConn.closeConn(connectionUserInfor);
				
				}
					}
				catch(Exception exception){exception.printStackTrace();}
					
					
				}
						});
		
		 
		
		/***********给注册按钮增加事件处理机制，点击注册进入注册界面并关掉登录界面***********/ 
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
