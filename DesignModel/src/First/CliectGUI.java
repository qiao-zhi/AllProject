package First;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JLabel;

public class CliectGUI extends JFrame {
	private static Circle ttt=new Circle();
	private static Rectangle rec=new Rectangle();
	private static Triangle tri=new Triangle();
	private JPanel contentPane;
	private static JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CliectGUI frame = new CliectGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CliectGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(20, 145, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		


/*

		ttt.setVisible(false);
		tri.setVisible(false);
		rec.setVisible(false);
		*//**������**/
		JButton btnNewButton = new JButton("\u521B\u5EFA\u5706");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rec.setVisible(false);
				tri.setVisible(false);
				lblNewLabel.setText(null);
				ttt.setVisible(true);
				ttt.draw();
			}
		});
		btnNewButton.setBounds(25, 21, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u64E6\u9664\u5706");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rec.setVisible(false);
				tri.setVisible(false);
				lblNewLabel.setText(null);
				ttt.setVisible(true);
				ttt.erase();
			}
		});
		btnNewButton_1.setBounds(25, 65, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u521B\u5EFA\u4E09\u89D2\u5F62");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rec.setVisible(false);
				ttt.setVisible(false);
				lblNewLabel.setText(null);
				tri.setVisible(true);
				tri.draw();
			}
		});
		btnNewButton_2.setBounds(149, 21, 114, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u64E6\u9664\u4E09\u89D2\u5F62");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rec.setVisible(false);
				ttt.setVisible(false);
				lblNewLabel.setText(null);
				tri.setVisible(true);
				tri.erase();
			}
		});
		btnNewButton_3.setBounds(149, 65, 118, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u521B\u5EFA\u77E9\u5F62");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tri.setVisible(false);
				ttt.setVisible(false);
				lblNewLabel.setText(null);
				rec.setVisible(true);
				rec.draw();
			}
		});
		btnNewButton_4.setBounds(304, 15, 93, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("\u64E6\u9664\u77E9\u5F62");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText(null);
				tri.setVisible(false);
				ttt.setVisible(false);
				rec.setVisible(true);
				rec.erase();
			}
		});
		btnNewButton_5.setBounds(305, 62, 93, 23);
		contentPane.add(btnNewButton_5);
		
		JButton button = new JButton("画其他");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				throw new UnsupportedshapeException("不支持的类型");
				}
				catch(Exception un){
				lblNewLabel.setText(un.getMessage());
				}
			}
		});
		button.setBounds(25, 116, 93, 23);
		contentPane.add(button);
		
        lblNewLabel = new JLabel();
		lblNewLabel.setBounds(169, 120, 203, 19);
		contentPane.add(lblNewLabel);




	}
}
