package SoftConstruct;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class VerificateCode extends Canvas{        //该类继承画布。对象可以直接添加在JFrame中
	 public static String g_randomCode;           //该字符串记录产生的4个随机字符
	 private int positionOfX=0;
	 private int positionOfY=0;
	 private int width = 60;         
	    // 验证码图片的高度。         
	  private int height = 20;         
	    // 验证码字符个数         
	    private int codeCount = 4;         
	    private int x = 0;         
	    // 字体高度         
	    private int fontHeight;         
	    private int codeY;         
	    char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',         
	            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',         
	            'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };         
	  
	    
	    //这个方法设置验证码在画布中的坐标
	    private  void setPosition(int x,int y){
			 positionOfX=x;
			 positionOfY=y;						 
			 
		 }
	    
		    
	   private  void initxuan() {                
	        // 宽度         
	        String strWidth ="80";         
	        // 高度         
	        String strHeight ="30";         
	        // 字符个数         
	        String strCodeCount = "4";         
	        // 将配置的信息转换成数值         
	        try {         
	            if (strWidth != null && strWidth.length() != 0) {         
	                width = Integer.parseInt(strWidth);         
	            }         
	            if (strHeight != null && strHeight.length() != 0) {         
	                height = Integer.parseInt(strHeight);         
	            }         
	            if (strCodeCount != null && strCodeCount.length() != 0) {         
	                codeCount = Integer.parseInt(strCodeCount);         
	            }         
	        } catch (NumberFormatException e) {         
	        }         
	        x = width / (codeCount + 1);         
	        fontHeight = height - 2;         
	        codeY = height - 4;         
	    } 
	   
	
	 @Override
	public void paint(Graphics gx){
	     initxuan();
	     setPosition(0,0);            /****************设置验证码在画布中的位置*********/
	     Graphics2D g= (Graphics2D)gx; 
	     Random random = new Random();         
	        // 将图像填充为白色         
	        g.setColor(Color.WHITE);         
	      //  g.fillRect(200,20, width, height);         
	        // 创建字体，字体的大小应该根据图片的高度来定。         
	        Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);         
	        // 设置字体。         
	        g.setFont(font);         
	        // 画边框。         
	        g.setColor(Color.BLACK);  
	        g.drawRect(positionOfX+4, 2+positionOfY, width, height);         
	        // 随机产生20条干扰线，使图象中的认证码不易被其它程序探测到。         
	        g.setColor(Color.BLACK);         
	        for (int i = 0; i < 10; i++) {         
	            int x = random.nextInt(width)+positionOfX+4;         
	            int y = random.nextInt(height)+positionOfY+2;         
	            int xl = random.nextInt(width)+positionOfX+4;       
	            int yl =random.nextInt(height)+positionOfY+2;        
	            g.drawLine(x, y, xl, yl);         
	        }         
	        // g_randomCode用于保存随机产生的验证码，以便用户登录后进行验证。         
	         g_randomCode ="";    
	        int red = 0, green = 0, blue = 0;         
	        // 随机产生codeCount数字的验证码。         
	        for (int i = 0; i < codeCount; i++) {         
	            String strRand = String.valueOf(codeSequence[random.nextInt(36)]); // 得到随机产生的验证码数字或者字母。      
	            // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。         
	            red = random.nextInt(255);         
	            green = random.nextInt(255);         
	            blue = random.nextInt(255);         
	            // 用随机产生的颜色将验证码绘制到图像中。         
	            g.setColor(new Color(red, green, blue));         
	            g.drawString(strRand, (i + 1) * x+positionOfX, codeY+positionOfY);         
	            // 将产生的四个随机数组合在一起。         
	            g_randomCode+=strRand;  }
	       
	     
	 }
	 
	 
}


		
		
	

