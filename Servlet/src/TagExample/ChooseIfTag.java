package TagExample;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ChooseIfTag extends SimpleTagSupport {

	private boolean test;

	public void setTest(boolean test) {
		this.test = test;
	}

	@Override
	public void doTag() throws JspException, IOException {
		Choose choose = (Choose) this.getParent(); //得到父标签
		System.out.println("if~~~~~~~~"+choose.isDo());
		if(test && !choose.isDo()){  //如果条件为真并且父标签的isDo为false
			this.getJspBody().invoke(null);
			choose.setDo(true);
		}
		super.doTag();
	}
	
	
}
