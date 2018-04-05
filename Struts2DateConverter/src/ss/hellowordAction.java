package ss;

public class hellowordAction {

	/**
	 * 
	 */
	private String message;
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	private static final long serialVersionUID = 1L;

	public String execute(){
		System.out.println(message);
		System.out.println("Helloword,Action!");
		return "AAA";
	}
}
