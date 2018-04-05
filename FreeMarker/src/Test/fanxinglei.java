package Test;

import org.junit.Test;

//可以有一个，也可以有多个
public class fanxinglei<T, T2> {
	// 泛型属性
	private T t1;

	public T getT1() {
		return t1;
	}

	public void setT1(T t1) {
		this.t1 = t1;
	}

	// 泛型方法
	public void testFanxing(T2 t2) {
		System.out.println(t2);
		System.out.println(this.getT1());
	}

	public static void main(String[] args) {
		fanxinglei<String, Integer> fanxinglei = new fanxinglei<String, Integer>();
		fanxinglei.setT1("泛型类");
		fanxinglei.testFanxing(4);
	}
}
