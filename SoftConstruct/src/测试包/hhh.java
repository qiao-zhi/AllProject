package ���԰�;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;



 

public class hhh extends JFrame
{

 JButton jbuttonAddHang                  = null;   // �����а���
 JButton jbuttonAddLie                   = null;   // �����а���
 JButton jbuttonRemoveHang               = null;   // ɾ���а���
 JButton jbuttonRemoveLie                = null;   // ɾ���а���

 DefaultTableModel defaultTableModel   = null;
 JTable    table       = null;

 public hhh()
 {
  // /////////////////////////////////////////////////////////////////////////
  // ��������
  setTitle("AddRemoveCells");
  
  // ��ȡ����
  Container container = getContentPane();

  // setLayout(null);
  container.setLayout(new BorderLayout());

  // ��ȡ��Ļ�������
  Dimension size = getToolkit().getScreenSize();

  setBounds((size.width - 500) / 2, (size.height - 200) / 2, 500, 200);

  setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
  

  // /////////////////////////////////////////////////////////////////////////
  // ���1
  JPanel jpanel1 = new JPanel();
  container.add(jpanel1, BorderLayout.NORTH);

  // /////////////////////////////////////////////////////////////////////////
  // ���� ������
  jbuttonAddHang = getButtonAddHang();
  
  jpanel1.add(jbuttonAddHang);
  
  
  // /////////////////////////////////////////////////////////////////////////
  // ���� ������
  jbuttonAddLie = getButtonAddLie();
  
  jpanel1.add(jbuttonAddLie);
  
  
  // /////////////////////////////////////////////////////////////////////////
  // ���� ɾ����
  jbuttonRemoveHang = getButtonRemoveHang();
  
  jpanel1.add(jbuttonRemoveHang);
  
  
  // /////////////////////////////////////////////////////////////////////////
  // ���� ɾ����
  jbuttonRemoveLie = getButtonRemoveLie();
  
  jpanel1.add(jbuttonRemoveLie);
  
  
  // /////////////////////////////////////////////////////////////////////////
  // JTable���
  
  //������
  String[] name = { "�ֶ� 1", "�ֶ� 2", "�ֶ� 3", "�ֶ� 4", "�ֶ� 5" };
  
  //��������
  String[][] data = new String[5][5];
  int value = 1;
  for (int i = 0; i < data.length; i++)
  {
   for (int j = 0; j < data[i].length; j++)
   {
    data[i][j] = String.valueOf(value);
    
    value ++;
   }
  }

  //�� DefaultTableModel�ӿ� ��ʼ�� JTable
  defaultTableModel = new DefaultTableModel( data,
            name);
  

  //�������: ����DefaultTableModel������JTable.
  table        = new JTable(defaultTableModel);
  
//  table.setPreferredScrollableViewportSize(new Dimension( 400,
//                80));
  
  //�󶨹�����
  JScrollPane jps1 = new JScrollPane(table);

  container.add(jps1, BorderLayout.CENTER);

  setVisible(true);

 }
 
 
 

 

 /**
  * ��ȡ�����а���
  * @return
  */
 private JButton getButtonAddHang()
 {
  if (jbuttonAddHang == null)
  {
   // ����
   jbuttonAddHang = new JButton();

   jbuttonAddHang.setText("������");

   jbuttonAddHang.setBounds(260, 160, 100, 20);

   jbuttonAddHang.addActionListener(new ActionListener()
   {
    public void actionPerformed(ActionEvent e)
    {
     defaultTableModel.addRow(new Vector());
     
     table.revalidate();
    }
   });
  }

  return jbuttonAddHang;
 }
 
 
 /**
  * ��ȡ�����а���
  * @return
  */
 private JButton getButtonAddLie()
 {
  if (jbuttonAddLie == null)
  {
   // ����
   jbuttonAddLie = new JButton();

   jbuttonAddLie.setText("������");

   jbuttonAddLie.setBounds(260, 160, 100, 20);

   jbuttonAddLie.addActionListener(new ActionListener()
   {
    public void actionPerformed(ActionEvent e)
    {
     defaultTableModel.addColumn("������");
     
     table.revalidate();
    }
   });
  }

  return jbuttonAddLie;
 }
 
 
 /**
  * ��ȡɾ���а���
  * @return
  */
 private JButton getButtonRemoveHang()
 {
  if (jbuttonRemoveHang == null)
  {
   // ����
   jbuttonRemoveHang = new JButton();

   jbuttonRemoveHang.setText("ɾ����");

   jbuttonRemoveHang.setBounds(260, 160, 100, 20);

   jbuttonRemoveHang.addActionListener(new ActionListener()
   {
    public void actionPerformed(ActionEvent e)
    {
     // getRowCount����������rowcount<0�����Ѿ�û���κ����ˡ�
     int rowcount = defaultTableModel.getRowCount() - 1;
     
     if (rowcount >= 0)
     {
      // ɾ���бȽϼ򵥣�ֻҪ��DefaultTableModel��removeRow()�������ɡ�
      defaultTableModel.removeRow(rowcount);
      
      // ɾ������Ϻ������������������Ҳ����ʹ��DefaultTableModel��setRowCount()���������á�
      defaultTableModel.setRowCount(rowcount);
     }
     
     table.revalidate();
    }
   });
  }

  return jbuttonRemoveHang;
 }
 
 
 
 /**
  * ��ȡɾ���а���
  * @return
  */
 private JButton getButtonRemoveLie()
 {
  if (jbuttonRemoveLie == null)
  {
   // ����
   jbuttonRemoveLie = new JButton();

   jbuttonRemoveLie.setText("ɾ����");

   jbuttonRemoveLie.setBounds(260, 160, 100, 20);

   jbuttonRemoveLie.addActionListener(new ActionListener()
   {
    public void actionPerformed(ActionEvent e)
    {
     int columncount = defaultTableModel.getColumnCount() - 1;
     
     if (columncount >= 0)// ��columncount<0�����Ѿ�û���κ����ˡ�
     {
      TableColumnModel columnModel = table.getColumnModel();
      TableColumn tableColumn = columnModel.getColumn(columncount);
      columnModel.removeColumn(tableColumn);
      
      defaultTableModel.setColumnCount(columncount);
     }
     
     table.revalidate();
    }
   });
  }

  return jbuttonRemoveLie;
 }
 

 public static void main(String args[])
 {
  new hhh();
 }
 
}