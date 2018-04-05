package SimpleTag;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//控制标签体是否执行
public class Demo5 extends SimpleTagSupport {

	private int count;
    private Date date;
	
	public void setCount(int count) {
		this.count = count;
	}
	

	public void setDate(Date date) {
		this.date = date;
	}


	@Override
	public void doTag() throws JspException, IOException {

		//如果不希望输出标签体，取到标签体之后什么都不要做
		JspFragment jf = this.getJspBody();  //获取标签体
		this.getJspContext().getOut().write(date.toLocaleString()+"<br/>");

		for(int i=0;i<count;i++){
			jf.invoke(this.getJspContext().getOut());
			}
	}

	@Override
	public void setJspBody(JspFragment jspBody) {
		// TODO Auto-generated method stub
		super.setJspBody(jspBody);
	}
	
}
