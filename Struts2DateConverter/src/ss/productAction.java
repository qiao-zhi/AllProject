package ss;

public class productAction {

	private String msg;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String add(){
		msg="add";
		System.out.println("add...");
		return "add";
	}
	
	public String delete(){
		msg="delete";
		System.out.println("dedete...");
		return "delete";
	}
	
}
