package ConstructorTest;

public class Parent {
	private String str;

	protected Parent(String str) {
		super();
		this.str = str;
	}

	public String getStr() {
		return str;
	}

	public void setString(String string) {
		this.str = string;
	}
	
}
