package First;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
 
public class Test extends JFrame {
 
    Graphics2D g2d;
    public Test(){
 
    	this.setBackground(new Color(238,238,238));
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
 
    public void erase(){
        this.g2d = (Graphics2D) this.getGraphics();
        g2d.setColor(new Color(238,238,238));
        g2d.fillRect(0, 0, 600, 600);
    	
    }
    public void draw(){
        this.g2d = (Graphics2D) this.getGraphics();
        g2d.setColor(Color.GREEN);
        g2d.drawLine(0,0,200,200);
        g2d.fillOval(110, 340, 100, 100);
    }
    @Override
    public void paint(Graphics arg0) {

    	
    }
     
    public static void main(String[] args){
        new Test();
    }
    

}
