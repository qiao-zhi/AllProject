package SoftConstruct;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import util.DataBaseConnection;

import java.sql.*;



public class RegisterWindow {

	public static RegisterWindow g_registerWindow=new RegisterWindow();
	private boolean testInputName,testInputPassword, testInputPassword_1, testInputRealName, testInputAge, testInputPhone, testInputSex;                //布尔变量判断输入的数据时否合法，不合法就将其改为false。
	public  JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel userNameTestLabel;
	private JLabel userPasswordTestLabel;
	private JLabel passwordConfirmLabel;
	private JLabel realNameTestLabel;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_1;
	private JLabel phoneTestLabel;
	private JLabel sexTestLabel;
	

	/**
	 * Create the application.
	 */
	public RegisterWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame= new JFrame();
		frame.setBounds(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width,  Toolkit.getDefaultToolkit().getScreenSize().height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5E26*\u7684\u4E3A\u5FC5\u586B");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(73, 10, 103, 24);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("\u7528 \u6237 \u540D");
		lblNewLabel_1.setBounds(75, 45, 55, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6    \u7801");
		lblNewLabel_2.setBounds(75, 80, 55, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		lblNewLabel_3.setBounds(75, 115, 55, 25);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u771F\u5B9E\u59D3\u540D");
		lblNewLabel_4.setBounds(75, 150, 55, 25);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u7535\u8BDD\u53F7\u7801");
		lblNewLabel_5.setBounds(75, 185, 55, 25);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u5E74    \u9F84");
		lblNewLabel_6.setBounds(75, 220, 54, 25);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\u6027    \u522B");
		lblNewLabel_7.setBounds(75, 255, 54, 25);
		frame.getContentPane().add(lblNewLabel_7);
		
		
		userNameTestLabel = new JLabel("*");
		userNameTestLabel.setForeground(new Color(255, 0, 0));
		userNameTestLabel.setBounds(257, 46, 167, 22);
		frame.getContentPane().add(userNameTestLabel);
		
		userPasswordTestLabel = new JLabel("*");
		userPasswordTestLabel.setForeground(new Color(255, 0, 0));
		userPasswordTestLabel.setBounds(257, 81, 149, 15);
		frame.getContentPane().add(userPasswordTestLabel);
		
		passwordConfirmLabel = new JLabel("*");
		passwordConfirmLabel.setForeground(new Color(255, 0, 0));
		passwordConfirmLabel.setBounds(257, 120, 127, 15);
		frame.getContentPane().add(passwordConfirmLabel);
		
	    realNameTestLabel = new JLabel("*");
	    realNameTestLabel.setForeground(new Color(255, 0, 0));
	    realNameTestLabel.setBounds(257, 155, 127, 15);
	    frame.getContentPane().add(realNameTestLabel);
		
		phoneTestLabel = new JLabel("*");
		phoneTestLabel.setForeground(Color.RED);
		phoneTestLabel.setBounds(257, 190, 234, 15);
		frame.getContentPane().add(phoneTestLabel);
		
		final JLabel ageTestLabel = new JLabel("*");
		ageTestLabel.setForeground(Color.RED);
		ageTestLabel.setBounds(257, 230, 167, 15);
		frame.getContentPane().add(ageTestLabel);
		
		sexTestLabel = new JLabel("*");
		sexTestLabel.setForeground(Color.RED);
		sexTestLabel.setBounds(257, 260, 149, 15);
		frame.getContentPane().add(sexTestLabel);
		
		
		/********验证用户用户名的输入为6-18位的字符**********/
		textField = new JTextField();
		textField.setBounds(157, 44, 90, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.addFocusListener(new FocusListener(){
			  @Override
			public void focusGained(FocusEvent e){
				 
				  
			  }
			  
			  @Override
			public void focusLost(FocusEvent e){
				  
				if (textField.getText().isEmpty()){
					userNameTestLabel.setText("*用户名不能为空！");
					testInputName=false;
			                                    }
				else {
					if(textField.getText().length()<6||textField.getText().length()>18){userNameTestLabel.setText("*用户名必须为6-18位！");testInputName=false;}
					else{userNameTestLabel.setText("");	testInputName = true;}
				
			      	}
				
				  			                    }
			  		  
		  });
		
		passwordField = new JPasswordField();
		passwordField.setBounds(157, 75, 90, 25);
		frame.getContentPane().add(passwordField);
		passwordField.addFocusListener(new FocusListener(){
			  @Override
			public void focusGained(FocusEvent e){
				 
				  
			  }
			  @Override
			public void focusLost(FocusEvent e){
				  
				if (passwordField.getText().isEmpty()){
					userPasswordTestLabel.setText("*密码不能为空！");
					testInputPassword=false;
			                                    	}
				else {
					if(passwordField.getText().length()<6||textField.getText().length()>18){userPasswordTestLabel.setText("*用户密码必须为6-18位！");testInputPassword=false;}
					else{userPasswordTestLabel.setText("");	testInputPassword = true;}
				
				}
				
				  
			  }
			  
			 
			  
			  
		  });
		
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(157, 110, 90, 25);
		frame.getContentPane().add(passwordField_1);
		
		/***********判断输入的密码是否一样*******/
	  passwordField_1.addFocusListener(new FocusListener(){
		  @Override
		public void focusGained(FocusEvent e){
			
			  
		  }
		  @Override
		public void focusLost(FocusEvent e){
			  if(!passwordField.getText().equals(passwordField_1.getText())){passwordConfirmLabel.setText("*两次密码不一样");testInputPassword_1=false;}
			  if(passwordField.getText().equals(passwordField_1.getText())){passwordConfirmLabel.setText("");testInputPassword_1=true;}
		  }
		  
		  
		  
		  
	  });

	
		
		textField_2 = new JTextField();
		textField_2.setBounds(157, 152, 90, 25);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		textField_2.addFocusListener(new FocusListener(){
			  @Override
			public void focusGained(FocusEvent e){
				 
				  
			  }
			  @Override
			public void focusLost(FocusEvent e){
				  
				if (textField_2.getText().isEmpty()){
					realNameTestLabel.setText("*真实姓名不能为空！");
					testInputRealName=false;
			                                    	}
				else {realNameTestLabel.setText("");
				testInputRealName = true;
				
				}
				
				  
			  }
			  
			 
			  
			  
		  });
	
		
		/************判断输入的电话号码是否合法********/
		textField_3 = new JTextField();
		textField_3.setBounds(157, 189, 90, 25);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		textField_3.addFocusListener(new FocusListener(){
			  @Override
			public void focusGained(FocusEvent e){
				 
				  
			  }
			  @Override
			public void focusLost(FocusEvent e){
				  
				if (textField_3.getText().isEmpty()){
					
					phoneTestLabel.setText("*电话号码不能为空！");
					testInputPhone=false;
			                                    	}
				else {
					/***********先判断长度*****/
					if(textField_3.getText().length()>11) {
					testInputPhone=false;								
					phoneTestLabel.setText("电话号码最大长度为11位 ！");		
					}else{
					 boolean testInputNumber=true;
					 char str[]=textField_3.getText().toCharArray();
					for(int i=0;i<textField_3.getText().length();i++){
						if(str[i]<'0'||str[i]>'9')   testInputNumber=false;	
						  								}
					if(!testInputNumber){phoneTestLabel.setText("*请输入合法的电话号码（数字组成） ！");testInputPhone=false;}
					else{phoneTestLabel.setText("");testInputPhone=true;}
					
						}
				
					
				}
				
				  
			  }
			  			 
			  			  
		  });
		
		
		
		
		/************判断输入的年龄是否为1-99的整数********/
		textField_4 = new JTextField();
		textField_4.setBounds(157, 222, 90, 25);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		textField_4.addFocusListener(new FocusListener(){
		  @Override
		public void focusGained(FocusEvent e){
				 
				  
			  }
			  @Override
			public void focusLost(FocusEvent e){
				  
					if (textField_4.getText().isEmpty()){
						ageTestLabel.setText("*年龄不能为空！");
						testInputAge=false;
				                                    	}
					else {
				 		
				  
				  boolean testInputInt=true;
				  char str[]=textField_4.getText().toCharArray();
				  
				  /**********鼠标移动到性别框时判断年龄输入的是否为整数！是整数不做处理，不是整数给出提示******/
				  
				for(int i=0;i<textField_4.getText().length();i++){
					if(str[i]<'0'||str[i]>'9')    testInputInt=false;
						  								}
				if(textField_4.getText().length()>2) testInputInt=false;
				
				if(!testInputInt){ageTestLabel.setText("年龄必须为1-99的整数！");			}
				else{ageTestLabel.setText("");testInputAge=true;	    }
				  
				
				
					}
			  }
			  
			  			  
			  
		  });
		
		
		
		/************判断输入的性别是否合法********/
		textField_5 = new JTextField();
		textField_5.setBounds(157, 257, 90, 25);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		textField_5.addFocusListener(new FocusListener(){
			  @Override
			public void focusGained(FocusEvent e){
				 
				  
			  }
			  @Override
			public void focusLost(FocusEvent e){
				  
				if (textField_5.getText().isEmpty()){
					sexTestLabel.setText("*性别不能为空！");
					testInputSex=false;
			                                    	}
				else {
			 		
			    	if(!(textField_5.getText().equals("男")||textField_5.getText().equals("女"))){sexTestLabel.setText("*性别只能为男或女");testInputSex=false;}
			      	else{sexTestLabel.setText("");	testInputSex = true;}
				
				    }
				
				  
			  }
			  			 
			  			  
		  });
		
	
		
		/*************增加确认注册按钮并增加事件处理机制***/
		JButton btnNewButton = new JButton("\u786E\u8BA4\u6CE8\u518C");
		btnNewButton.setBounds(50, 331, 93, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
						try{
							
		boolean testInputTrue=testInputName&&testInputPassword&& testInputPassword_1 && testInputRealName&& testInputAge&& testInputPhone&& testInputSex;     
			/***********如果输入的数据均合法就执行数据库操作********/
		if(testInputTrue){
			DataBaseConnection dataBaseConn=new DataBaseConnection();
			Connection connectionUserInfor=dataBaseConn.getconnection();
			PreparedStatement pstmt = connectionUserInfor.prepareStatement("select * from user_information where user_Name=?");
			pstmt.setString(1,textField.getText());
			ResultSet res1=pstmt.executeQuery();
			
			
			/******************如果存在这个用户,提示用户已经存在，请重新注册！**/
			if(res1.next()){JOptionPane.showMessageDialog(null, "用户名已经存在，请重新注册！");}
			else{ 
				PreparedStatement pstmt_insert = connectionUserInfor.prepareStatement("insert into user_information values(?,?,?,?,?,?,?)");                                //用户名不存在就将记录写入数据库，并提示用户注册成功！
				pstmt_insert.setString(1, textField.getText());
				pstmt_insert.setString(2, passwordField.getText());
				pstmt_insert.setString(3, passwordField_1.getText());
				pstmt_insert.setString(4, textField_2.getText());
				pstmt_insert.setString(5, textField_3.getText());
				pstmt_insert.setInt(6,Integer.valueOf(textField_4.getText()));  //将字符串变为整数
				pstmt_insert.setString(7, textField_5.getText());
				pstmt_insert.execute();
				dataBaseConn.closeConn(connectionUserInfor);
				
				JOptionPane.showMessageDialog(null, "注册成功，请登录！");
				RegisterWindow.g_registerWindow.frame.setVisible(false);
				LoginWindow.g_loginWindow.frame.setVisible(true);
				}
		
		}
				else{JOptionPane.showMessageDialog(null, "请输入合法数据！");}
			
						    }
			catch(Exception ee){ee.printStackTrace();}
			
			}});
		
		
		
		/****添加返回按钮并设置处理事件******/
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.setBounds(239, 331, 93, 23);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
					RegisterWindow.g_registerWindow.frame.setVisible(false);
				LoginWindow.g_loginWindow.frame.setVisible(true);
			
				
			}
					});
		
		
	}	
}/********最外层*/

