import java.util.Date;

import javax.swing.JFrame;

public class FormatTime  {

	
	//参考类Formatter类。
	
	public static void main(String[] args)
	{

    Date d=new Date();
    String s = String.format("Duke's Birthday: %1$tY: %1$tm,%1$td  %1$tH: %1$tM:%1$tS", d);  //t代表转换的是日期类型。后面的Y，H是具体的格式
    System.out.println(s);  //转换格式的第一个参数    %[argument_index$][flags][width]conversion，1$代表参数列表的第一个位置

  /*****连续两次格式化数据需要指定位置用1$,表示格式化第一个参数，可以连续格
   式化，%表示一次格式化的开始.第二个用%2$表示第二次格式化开始且取第二个参数。格式
   化数字时用%2$.2f，且.2必须在f前面，如果没有则默认为6位小数点；若.2在f后面
   则默认为在六位小数点后再加.2
    *********/
    float x=5.6f,y=0.8f;
    String ss=String.format("%1$.6f   %2$.2f", x,y);
    System.out.println(ss);          

	
}}
