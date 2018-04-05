package 测试包;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
public class 一个时间表 {


	public static void main(String[] args) {
Timer t=new Timer();
Task tt=new Task();
t.schedule(tt, 0,1000);

		
	}

}
class Task extends TimerTask {

	public Task() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
	Date da=new Date();
	String s=String.format("%1$tY: %1$tm,%1$td  %1$tH: %1$tM:%1$tS", da);
	System.out.println(s);
	}

}
