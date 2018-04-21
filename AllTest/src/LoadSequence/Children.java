package LoadSequence;

public class Children extends Parent{
	static {
		System.out.println("子类静态代码块块");
	}
	{
		System.out.println("子类代码块");
	}
	 public static Parent parent = new Parent("B类的静态成员变量");
	 String string_1 = "子类成员变量";

	protected Children(String str) {
		super(str);
		System.out.println("子类构造方法");
	}
	
	public static void main(String[] args) {
		Children children = new Children("sss");
	}

}
