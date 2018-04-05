package Thread;

public class Ex10_4_seatorderedCase {
	private int seatResource;                     // 共享缓冲区
	private boolean empty = true;         // seatResource是否为空的信号量
    public void setEmpty(){
    	empty=true;
    }
	public synchronized void push(int pubResource) {
		while (!empty) {                   // 当缓冲区满的时候，等待
			try {                             // 阻塞自己
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		seatResource = pubResource;        // 将生成的座位号放到缓冲区
		empty = false;                      // 设置缓冲区满状态
		notify();                           // 唤醒其他等待线程
	}
	public synchronized int pop() {       // 从缓冲区订座位
		while (empty) {
			try {
				wait();                    // 当缓冲区空的时候，等待
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int popResource = seatResource;
		seatResource = 0;
		empty = true;                    // 设置缓冲区空状态
		notify();
		return popResource;            // 返回所订座位号
	}
	public static void main(String[] args) {
		Ex10_4_seatorderedCase so = new Ex10_4_seatorderedCase();
		SeatProcedure sp = new SeatProcedure(so);
		sp.start();
		SeatConsumer sc = new SeatConsumer(so);
		sc.start();
		SeatRelease sr=new SeatRelease(so);
		sr.start();
	}
}
class SeatProcedure extends Thread { //生成空座位线程            
	private Ex10_4_seatorderedCase so;          
	public SeatProcedure(Ex10_4_seatorderedCase so) {   
		this.so = so;
	}
	public void run() {
		for (int i = 1; i <= 30; i++) {     //连续向缓冲区生成空座位号
			int pubResource = i;
			so.push(pubResource);
			System.out.println("第" + pubResource + "号座位为空");
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}//class end
class SeatConsumer extends Thread{	//预订座位线程
	private Ex10_4_seatorderedCase so;          
	public SeatConsumer(Ex10_4_seatorderedCase so) {         
		this.so= so;  
	}
		public void run() {
			for (int i = 1; i <= 50; i++) {//50个学生连续从缓冲区取出座位号 
				synchronized (so) {
					int sh = so.pop();
					if (sh != 0) {
						System.out.println("学生" + i + " "+"占了第" + sh+"号座位");
					} else {
						System.out.println("没有空座，请等待！");
					}
				}
				try {
					sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}//class end
class SeatRelease  extends Thread {  //释放座位线程                     
	private Ex10_4_seatorderedCase so;                         
	public SeatRelease(Ex10_4_seatorderedCase so) {        
		this.so = so;
	}
	public void run() {
		try {
			sleep(20000);//20秒后
             this.so.setEmpty();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 1; i <= 30; i++) {      //从第一个开始,连续释放已预订的座位
			int pubResource = i;
			so.push(pubResource);
			System.out.println("第" + pubResource + "号座位取消预订");
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}



