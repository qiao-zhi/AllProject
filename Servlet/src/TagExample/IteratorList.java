package TagExample;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class IteratorList extends SimpleTagSupport {

	private Object items;
	private String var;
	public void setItems(Object items) {
		this.items = items;
	}
	public void setVar(String var) {
		this.var = var;
	}
	@Override
	public void doTag() throws JspException, IOException {
		List list = (List) items;
		Iterator it=list.iterator();//取到迭代器
		while(it.hasNext()){
			Object value=it.next();
		this.getJspContext().setAttribute(var,value);//存到域中
		this.getJspBody().invoke(null);//通知标签体执行。从域中取对象
			
		}
		
		super.doTag();
	}
	
}
