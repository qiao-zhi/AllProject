package 测试包;

public class Thread1 extends Thread{
public static Boolean query=false;
	public Thread1(){}
	

	public void run(){
		while(query){
		SSSSSS.lblNewLabel_1.setText("正在连接.");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SSSSSS.lblNewLabel_1.setText("正在连接..");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SSSSSS.lblNewLabel_1.setText("正在连接...");	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	
		
	}
	

}
