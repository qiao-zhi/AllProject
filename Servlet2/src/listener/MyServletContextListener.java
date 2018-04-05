package listener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.tomcat.jni.Time;

public class MyServletContextListener implements ServletContextListener {

//	监听servletContext对象创建
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
/*//		获得被监听的对象
		ServletContext servletContext = sce.getServletContext();
		System.out.println(servletContext);
//		也是获取被监听对象，可以强转为指定的监听对象
		Object source = sce.getSource();
		System.out.println(source);*/
		/*Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				System.out.println("银行计息了..............");
			}
		}, new Date(), 6000);*/
		
		
//		银行计算利息的实际过程  每天十二点计算利息
		SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date=null;
		try {
			 date = df.parse("2017-07-17 00:00:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timer timer = new Timer();
		System.out.println(date.toLocaleString());
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				System.out.println("银行计息了..............");
			}
		}, date, 24*60*60*1000);
		System.out.println("servletContext对象创建..............");
	}
//	监听servletContext对象销毁
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("servletContext对象销毁..............");
	}
}
