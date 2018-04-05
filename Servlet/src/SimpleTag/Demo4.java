package SimpleTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//控制标签体是否执行
public class Demo4 extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {

		throw new SkipPageException();
	}

	@Override
	public void setJspBody(JspFragment jspBody) {
		// TODO Auto-generated method stub
		super.setJspBody(jspBody);
	}

	
}
