
import java.lang.*;
import java.text.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
public class 今天的日期和多少天后或多少分钟后日期 {
	public static void main(String[] args) throws InterruptedException, ParseException {
		/***********�����ʽ�������������*******/
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d=new Date();
		System.out.println(df.format(d));
		System.out.print(d.getDate()+"\n");
		d.setDate(1000+d.getDate());          //��������Ϊ1000��֮��(setDate�����޸�������setHours����Сʱ)
		System.out.println(df.format(d));       //���1000���Ժ������
		System.out.print(d.getYear()+"\n\n");
		System.out.println(System.getProperty("java.version"));
		System.out.println(System.getProperty("java.vendor"));
		System.out.println(System.getProperty("java.home"));
		String s;
		
		
		/************��ӡ��ǰ����******/
	     Calendar today;
	     today=Calendar.getInstance();
		System.out.print(today.get(today.YEAR)+"-"+(today.get(today.MONTH)+1)+"-"+today.get(today.DAY_OF_MONTH));
	    System.out.println("   "+today.get(today.HOUR_OF_DAY)+":"+(today.get(today.MINUTE))+":"+today.get(today.SECOND));
		Thread.sleep(1000);
		
		System.out.println(today.getTime());
		
		/*****Calendar中第一个月为January，数字为0*********/
		today.add(today.MONTH, 2);
		today.add(today.MINUTE,-12);
		System.out.print(today.get(today.YEAR)+"-"+(today.get(today.MONTH)+1)+"-"+today.get(today.DAY_OF_MONTH));
	    System.out.print("   "+today.get(today.HOUR_OF_DAY)+":"+(today.get(today.MINUTE))+":"+today.get(today.SECOND));
				
	
		 // System.out.print("   "+today.get(today.HOUR)+":"+(today.get(today.MINUTE))+":"+today.get(today.SECOND));
					
		
		
		
		
		
		
		
	


	}

}
