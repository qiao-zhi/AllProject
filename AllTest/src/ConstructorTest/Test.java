package ConstructorTest;

public class Test {
	public static void main(String[] args) {
		Parent parent = new Children("children");
		System.out.println(parent.getStr());
	}
}
