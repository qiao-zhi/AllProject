package Thread;

public class Ex10_1_CaseThread extends Thread {// 创建一个类继承（extend）Thread类
	String studentName;

	public Ex10_1_CaseThread(String studentName) {// 定义类的构造函数,传递参数
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
		Ex10_1_CaseThread t1 = new Ex10_1_CaseThread("张三"); // 用new实例化对象
		Ex10_1_CaseThread t2 = new Ex10_1_CaseThread("李四");
		t1.start(); // 调用该对象的start()方法启动线程。
		t2.start();
	} // main
}// class
