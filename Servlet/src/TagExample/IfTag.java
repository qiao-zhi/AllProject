package TagExample;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class IfTag extends SimpleTagSupport {

	private boolean test;

	
	public void setTest(boolean test) {
		this.test = test;
	}


	@Override
	public void doTag() throws JspException, IOException {
		if(test){
			//如果为true让标签体正常执行
			this.getJspBody().invoke(null);
		}
		
		super.doTag();
	}
	
}
