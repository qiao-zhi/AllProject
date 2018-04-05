package SimpleTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//控制标签体重复输出
public class Demo2 extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {

		//如果不希望输出标签体，取到标签体之后什么都不要做
		JspFragment jf = this.getJspBody();  //获取标签体
		for(int i=0;i<5;i++){
		jf.invoke(this.getJspContext().getOut());//执行标签体，null时输出到浏览器(参数是一个Writer流)
		}
	}

	@Override
	public void setJspBody(JspFragment jspBody) {
		// TODO Auto-generated method stub
		super.setJspBody(jspBody);
	}

	
}
