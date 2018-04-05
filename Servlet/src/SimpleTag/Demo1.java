package SimpleTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//控制标签体是否执行
public class Demo1 extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {

		//如果不希望输出标签体，取到标签体之后什么都不要做
		JspFragment jf = this.getJspBody();  //获取标签体
		jf.invoke(this.getJspContext().getOut());//执行标签体，null时输出到浏览器(参数是一个Writer流)
		//jf.invoke(null);   //与上面式子一样输出到浏览器
	}

	@Override
	public void setJspBody(JspFragment jspBody) {
		// TODO Auto-generated method stub
		super.setJspBody(jspBody);
	}

	
}
