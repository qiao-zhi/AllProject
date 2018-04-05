package Action;


import com.opensymphony.xwork2.ActionSupport;

public class FangzhichongfuAction extends ActionSupport {
	private String test;

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	@Override
	public String execute() throws Exception {
		Thread.sleep(5 * 1000);
		return super.execute();
	}
}
