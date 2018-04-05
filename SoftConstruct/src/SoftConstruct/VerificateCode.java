package SoftConstruct;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class VerificateCode extends Canvas{        //����̳л������������ֱ�������JFrame��
	 public static String g_randomCode;           //���ַ�����¼������4������ַ�
	 private int positionOfX=0;
	 private int positionOfY=0;
	 private int width = 60;         
	    // ��֤��ͼƬ�ĸ߶ȡ�         
	  private int height = 20;         
	    // ��֤���ַ�����         
	    private int codeCount = 4;         
	    private int x = 0;         
	    // ����߶�         
	    private int fontHeight;         
	    private int codeY;         
	    char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',         
	            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',         
	            'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };         
	  
	    
	    //�������������֤���ڻ����е�����
	    private  void setPosition(int x,int y){
			 positionOfX=x;
			 positionOfY=y;						 
			 
		 }
	    
		    
	   private  void initxuan() {                
	        // ���         
	        String strWidth ="80";         
	        // �߶�         
	        String strHeight ="30";         
	        // �ַ�����         
	        String strCodeCount = "4";         
	        // �����õ���Ϣת������ֵ         
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
	     setPosition(0,0);            /****************������֤���ڻ����е�λ��*********/
	     Graphics2D g= (Graphics2D)gx; 
	     Random random = new Random();         
	        // ��ͼ�����Ϊ��ɫ         
	        g.setColor(Color.WHITE);         
	      //  g.fillRect(200,20, width, height);         
	        // �������壬����Ĵ�СӦ�ø���ͼƬ�ĸ߶�������         
	        Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);         
	        // �������塣         
	        g.setFont(font);         
	        // ���߿�         
	        g.setColor(Color.BLACK);  
	        g.drawRect(positionOfX+4, 2+positionOfY, width, height);         
	        // �������20�������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽��         
	        g.setColor(Color.BLACK);         
	        for (int i = 0; i < 10; i++) {         
	            int x = random.nextInt(width)+positionOfX+4;         
	            int y = random.nextInt(height)+positionOfY+2;         
	            int xl = random.nextInt(width)+positionOfX+4;       
	            int yl =random.nextInt(height)+positionOfY+2;        
	            g.drawLine(x, y, xl, yl);         
	        }         
	        // g_randomCode���ڱ��������������֤�룬�Ա��û���¼�������֤��         
	         g_randomCode ="";    
	        int red = 0, green = 0, blue = 0;         
	        // �������codeCount���ֵ���֤�롣         
	        for (int i = 0; i < codeCount; i++) {         
	            String strRand = String.valueOf(codeSequence[random.nextInt(36)]); // �õ������������֤�����ֻ�����ĸ��      
	            // �����������ɫ������������ɫֵ�����������ÿλ���ֵ���ɫֵ������ͬ��         
	            red = random.nextInt(255);         
	            green = random.nextInt(255);         
	            blue = random.nextInt(255);         
	            // �������������ɫ����֤����Ƶ�ͼ���С�         
	            g.setColor(new Color(red, green, blue));         
	            g.drawString(strRand, (i + 1) * x+positionOfX, codeY+positionOfY);         
	            // ���������ĸ�����������һ��         
	            g_randomCode+=strRand;  }
	       
	     
	 }
	 
	 
}


		
		
	

