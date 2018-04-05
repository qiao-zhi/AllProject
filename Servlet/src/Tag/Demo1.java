package Tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class Demo1 extends TagSupport {

	@Override
	public int doStartTag() throws JspException {

	/************************
	 * 查找权限
	 * **/
		
		return Tag.SKIP_BODY;//显示标签体
	}

	
}
