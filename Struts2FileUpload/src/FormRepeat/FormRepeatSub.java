package FormRepeat;
import com.opensymphony.xwork2.ActionSupport;
public class FormRepeatSub extends ActionSupport {
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String execute() throws Exception {
		Thread.sleep(2000);
		System.out.println(username);
		return super.execute();
	}
}
