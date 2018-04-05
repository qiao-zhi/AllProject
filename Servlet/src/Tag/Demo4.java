package Tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class Demo4 extends BodyTagSupport {

	@Override
	public int doEndTag() throws JspException {

		BodyContent bc=this.getBodyContent();
		String ss=bc.getString();
		ss=ss.toUpperCase();
		try {
			this.pageContext.getOut().write(ss);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Tag.EVAL_BODY_INCLUDE;
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		return BodyTagSupport.EVAL_BODY_BUFFERED;//返回一个标签体对象
	}

	
}
