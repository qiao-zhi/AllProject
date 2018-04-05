package util;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import forms.*;
public class DateAndTime {

public DateAndTime(){
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
	String s=String.format("%1$tY-%1$tm-%1$td  %1$tH: %1$tM:%1$tS", da);  /***格式化时间***/
	TrainPlanMana.label_2.setText(s);    /******开启线程不断的更新时间***/
	MainWindow1.label_2.setText(s); 
	}

}
