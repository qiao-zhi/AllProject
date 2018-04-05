package Thread;

public class Ex10_1_CaseRunnable implements Runnable {// 创建一个类实现（implements）Runnable接口
	String studentName;

	public Ex10_1_CaseRunnable(String studentName) {// 定义类的构造函数,传递参数
		System.out.println(studentName + "申请访问服务器");
		this.studentName = studentName;
	}

	public void run() {// 用需在此线程中执行的代码覆盖Thread类的run()方法
		for (int i = 0; i < 5; i++) {
			System.out.println("当前的服务对象是" + studentName + "同学");
			try {
				Thread.sleep((int) (Math.random() * 2000));
			} catch (InterruptedException ex) {
				System.err.println(ex.toString());
			}
		}// for
	}// run

	public static void main(String[] args) {
		Thread t1 = new Thread(new Ex10_1_CaseRunnable("张三")); // 用new实例化对象
		Thread t2 = new Thread(new Ex10_1_CaseRunnable("李四"));
		t1.start(); // 调用该对象的start()方法启动线程。
		t2.start();
	} // main
}
