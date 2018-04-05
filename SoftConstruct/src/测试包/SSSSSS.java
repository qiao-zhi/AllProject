package ²âÊÔ°ü;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class SSSSSS {
	public static  JLabel lblNewLabel_1=new JLabel("New label");;
	private JFrame frame;
	public JTextField txtJjj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SSSSSS window = new SSSSSS();
					window.frame.setVisible(true);
					
					Thread1 th=new Thread1();
					th.start();
					th.query=true;
					
					
				th.query=false;
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SSSSSS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\liqiang\\Desktop\\1.jpg"));
		lblNewLabel.setBounds(146, 37, 48, 30);
		frame.getContentPane().add(lblNewLabel);
		
		txtJjj = new JTextField();
		txtJjj.setText("JJJ");
		txtJjj.setBounds(67, 42, 127, 21);
		frame.getContentPane().add(txtJjj);
		txtJjj.setColumns(10);
		

		lblNewLabel_1.setBounds(107, 126, 150, 46);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
