package ���԰�;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class SelectionModelDemo implements ActionListener,
             ListSelectionListener
{
 
 JTable    table   = null;
 ListSelectionModel selectionMode = null;
 JLabel    label   = null; // ��ʾ�û�ѡȡ���֮��

 public SelectionModelDemo()
 {
  JFrame f = new JFrame();
  String[] name =
  { "�ֶ�1", "�ֶ�2", "�ֶ�3", "�ֶ�4", "�ֶ�5" };
  String[][] data = new String[5][5];
  int value = 1;
  for (int i = 0; i < data.length; i++)
  {
   for (int j = 0; j < data[i].length; j++)
   {
    data[i][j] = String.valueOf(value++);
   }
  }

  table = new JTable( data,
       name);

  table.setPreferredScrollableViewportSize(new Dimension( 400,
                80));

  table.setCellSelectionEnabled(true);// ʹ�ñ���ѡȡ����cellΪ��λ,����������Ϊ��λ.����û��д����,����ѡȡ�����

  // ��ʱ������Ϊ��λ.
  selectionMode = table.getSelectionModel();// ȡ��table��ListSelectionModel.
  selectionMode.addListSelectionListener(this);
  JScrollPane s = new JScrollPane(table);
  JPanel panel = new JPanel();
  JButton b = new JButton("��һѡ��");
  panel.add(b);
  b.addActionListener(this);
  
  b = new JButton("��������ѡ��");
  panel.add(b);
  b.addActionListener(this);
  b = new JButton("����ѡ��");
  panel.add(b);
  b.addActionListener(this);

  label = new JLabel("��ѡȡ:");

  Container contentPane = f.getContentPane();
  contentPane.add(panel,
      BorderLayout.NORTH);
  contentPane.add(s,
      BorderLayout.CENTER);
  contentPane.add(label,
      BorderLayout.SOUTH);

  f.setTitle("SelectionModelDemo");
  f.pack();
  f.setVisible(true);
  f.addWindowListener(new WindowAdapter()
  {
   public void windowClosing(WindowEvent e)
   {
    System.exit(0);
   }
  });
 }

 /**
  * ����ť�¼�,����ListSelectionModel�����������setSelectionMode()���������ñ��ѡȡģʽ. 
  */
 public void actionPerformed(ActionEvent e)
 {
  if (e.getActionCommand().equals("��һѡ��"))
  {
   selectionMode.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
  }
  
  if (e.getActionCommand().equals("��������ѡ��"))
  {
   selectionMode.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
  }
  
  if (e.getActionCommand().equals("����ѡ��"))
  {
   selectionMode.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
  }
  
  table.revalidate();
 }

 /**
  * ���û�ѡȡ�������ʱ�ᴥ��ListSelectionEvent,
  * ����ʵ��ListSelectionListener������������һ�¼�.
  * ListSelectionListener����ֻ����һ������,�Ǿ���valueChanged().
  */
 public void valueChanged(ListSelectionEvent el)
 {
  String tempString = "";
  
  // JTable��getSelectedRows()��getSelectedColumns()����
  // �᷵����ѡȡ���cell��index Array����.
  int[] rows    = table.getSelectedRows();
  int[] columns = table.getSelectedColumns();

  // JTable��getValueAt()�����᷵��ĳ�е�cell����,����ֵ��Object��������,�������Ҫ����ת��String��������.
  for (int i = 0; i < rows.length; i++)
  {
   for (int j = 0; j < columns.length; j++)
   {
    tempString +=   " "
            + (String) table.getValueAt(rows[i], columns[j]);
   }
  }
  
  label.setText("��ѡȡ:" + tempString);
 }

 public static void main(String[] args)
 {
  new SelectionModelDemo();
 }
 
}