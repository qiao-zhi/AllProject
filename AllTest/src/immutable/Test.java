package immutable;

public class Test {
	public static void main(String[] args) {
		String s = "SSSS";
		String s1 = s;
		System.out.println("改变s前--------");
		System.out.println("s=" + s);
		System.out.println("s1=" + s1);
		System.out.println("s的hashCode=" + s.hashCode());
		System.out.println("s1的hashCode=" + s1.hashCode());
		s = "WWWW";
		System.out.println("改变s后--------");
		System.out.println("s=" + s);
		System.out.println("s1=" + s1);
		System.out.println("s的hashCode=" + s.hashCode());
		System.out.println("s1的hashCode=" + s1.hashCode());
	}
}
