package TagExample;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Choose extends SimpleTagSupport {

	private boolean isDo;

	//对应get方法
	public boolean isDo() {
		return isDo;
	}

//	对应set方法
	public void setDo(boolean isDo) {
		this.isDo = isDo;
	}

	@Override
	public void doTag() throws JspException, IOException {
	
		this.getJspBody().invoke(null);//让标签体执行
		super.doTag();
	}
	
	
	
}
