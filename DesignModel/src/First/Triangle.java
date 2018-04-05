package First;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
 
public class Triangle extends JFrame {
 
    Graphics2D g2d;
    public Triangle(){
 
    	this.setTitle("画图板");
    	this.setBackground(new Color(255,255,255));
//        this.setSize(200, 200);
        this.setBounds(689, 150, 400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(false);
    }
 
    public void erase(){
        this.g2d = (Graphics2D) this.getGraphics();
        g2d.setColor(new Color(255,255,255));
        g2d.fillRect(0, 0, 400, 400);
    	
    }
    public void draw(){
        this.g2d = (Graphics2D) this.getGraphics();
        g2d.setColor(Color.GREEN);
//        g2d.drawLine(0,0,200,200);
        g2d.drawLine(100, 100, 300, 100);
        g2d.drawLine(100, 100, 200, 250);
        g2d.drawLine(200, 250, 300, 100);
//        g2d.fillOval(100, 100, 200, 200);
    }
    @Override
    public void paint(Graphics arg0) {

    	
    }
     
    

}
