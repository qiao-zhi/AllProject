package ConstructorTest;

public class Children extends Parent {
	private String string;

	protected Children(String string) {
		super(string);
		this.string = string;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}
	
}
