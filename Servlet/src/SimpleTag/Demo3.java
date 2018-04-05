package SimpleTag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//修改标签体
public class Demo3 extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {

		//如果不希望输出标签体，取到标签体之后什么都不要做
		JspFragment jf = this.getJspBody();  //获取标签体
		StringWriter sw = new StringWriter();
		jf.invoke(sw);//写到一个缓冲里面，需要用带缓冲的流
		
		String content=sw.toString().toUpperCase();  //将缓冲中数据变为大写
		this.getJspContext().getOut().write(content); //JspcContext==pageContext
		
	}

	@Override
	public void setJspBody(JspFragment jspBody) {
		// TODO Auto-generated method stub
		super.setJspBody(jspBody);
		
	}

	
}
