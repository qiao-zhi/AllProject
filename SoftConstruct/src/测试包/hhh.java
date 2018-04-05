package 测试包;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;



 

public class hhh extends JFrame
{

 JButton jbuttonAddHang                  = null;   // 增加行按键
 JButton jbuttonAddLie                   = null;   // 增加列按键
 JButton jbuttonRemoveHang               = null;   // 删除行按键
 JButton jbuttonRemoveLie                = null;   // 删除列按键

 DefaultTableModel defaultTableModel   = null;
 JTable    table       = null;

 public hhh()
 {
  // /////////////////////////////////////////////////////////////////////////
  // 设置容器
  setTitle("AddRemoveCells");
  
  // 获取容器
  Container container = getContentPane();

  // setLayout(null);
  container.setLayout(new BorderLayout());

  // 获取屏幕最大坐标
  Dimension size = getToolkit().getScreenSize();

  setBounds((size.width - 500) / 2, (size.height - 200) / 2, 500, 200);

  setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
  

  // /////////////////////////////////////////////////////////////////////////
  // 面板1
  JPanel jpanel1 = new JPanel();
  container.add(jpanel1, BorderLayout.NORTH);

  // /////////////////////////////////////////////////////////////////////////
  // 按键 增加行
  jbuttonAddHang = getButtonAddHang();
  
  jpanel1.add(jbuttonAddHang);
  
  
  // /////////////////////////////////////////////////////////////////////////
  // 按键 增加列
  jbuttonAddLie = getButtonAddLie();
  
  jpanel1.add(jbuttonAddLie);
  
  
  // /////////////////////////////////////////////////////////////////////////
  // 按键 删除行
  jbuttonRemoveHang = getButtonRemoveHang();
  
  jpanel1.add(jbuttonRemoveHang);
  
  
  // /////////////////////////////////////////////////////////////////////////
  // 按键 删除列
  jbuttonRemoveLie = getButtonRemoveLie();
  
  jpanel1.add(jbuttonRemoveLie);
  
  
  // /////////////////////////////////////////////////////////////////////////
  // JTable表格
  
  //列名称
  String[] name = { "字段 1", "字段 2", "字段 3", "字段 4", "字段 5" };
  
  //具体内容
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

  //用 DefaultTableModel接口 初始化 JTable
  defaultTableModel = new DefaultTableModel( data,
            name);
  

  //创建表格: 利用DefaultTableModel来建立JTable.
  table        = new JTable(defaultTableModel);
  
//  table.setPreferredScrollableViewportSize(new Dimension( 400,
//                80));
  
  //绑定滚动条
  JScrollPane jps1 = new JScrollPane(table);

  container.add(jps1, BorderLayout.CENTER);

  setVisible(true);

 }
 
 
 

 

 /**
  * 获取增加行按键
  * @return
  */
 private JButton getButtonAddHang()
 {
  if (jbuttonAddHang == null)
  {
   // 创建
   jbuttonAddHang = new JButton();

   jbuttonAddHang.setText("增加行");

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
  * 获取增加列按键
  * @return
  */
 private JButton getButtonAddLie()
 {
  if (jbuttonAddLie == null)
  {
   // 创建
   jbuttonAddLie = new JButton();

   jbuttonAddLie.setText("增加列");

   jbuttonAddLie.setBounds(260, 160, 100, 20);

   jbuttonAddLie.addActionListener(new ActionListener()
   {
    public void actionPerformed(ActionEvent e)
    {
     defaultTableModel.addColumn("增加列");
     
     table.revalidate();
    }
   });
  }

  return jbuttonAddLie;
 }
 
 
 /**
  * 获取删除行按键
  * @return
  */
 private JButton getButtonRemoveHang()
 {
  if (jbuttonRemoveHang == null)
  {
   // 创建
   jbuttonRemoveHang = new JButton();

   jbuttonRemoveHang.setText("删除行");

   jbuttonRemoveHang.setBounds(260, 160, 100, 20);

   jbuttonRemoveHang.addActionListener(new ActionListener()
   {
    public void actionPerformed(ActionEvent e)
    {
     // getRowCount返回行数，rowcount<0代表已经没有任何行了。
     int rowcount = defaultTableModel.getRowCount() - 1;
     
     if (rowcount >= 0)
     {
      // 删除行比较简单，只要用DefaultTableModel的removeRow()方法即可。
      defaultTableModel.removeRow(rowcount);
      
      // 删除行完毕后必须重新设置列数，也就是使用DefaultTableModel的setRowCount()方法来设置。
      defaultTableModel.setRowCount(rowcount);
     }
     
     table.revalidate();
    }
   });
  }

  return jbuttonRemoveHang;
 }
 
 
 
 /**
  * 获取删除列按键
  * @return
  */
 private JButton getButtonRemoveLie()
 {
  if (jbuttonRemoveLie == null)
  {
   // 创建
   jbuttonRemoveLie = new JButton();

   jbuttonRemoveLie.setText("删除列");

   jbuttonRemoveLie.setBounds(260, 160, 100, 20);

   jbuttonRemoveLie.addActionListener(new ActionListener()
   {
    public void actionPerformed(ActionEvent e)
    {
     int columncount = defaultTableModel.getColumnCount() - 1;
     
     if (columncount >= 0)// 若columncount<0代表已经没有任何列了。
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