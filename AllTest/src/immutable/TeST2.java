package immutable;

public class TeST2 {

	public static void main(String[] args) {
		Integer s = 3;
		int s1 = s;
		System.out.println("改变s前--------");
		System.out.println("s=" + s);
		System.out.println("s1=" + s1);
		System.out.println("s的hashCode=" + s.hashCode());
		s = 333;
		System.out.println("改变s后--------");
		System.out.println("s=" + s);
		System.out.println("s1=" + s1);
		System.out.println("s的hashCode=" + s.hashCode());
	}

}
