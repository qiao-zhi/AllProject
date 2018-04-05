package TagExample;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ChooseElse extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		Choose choose = (Choose) this.getParent(); //得到父标签
		System.out.println("Else..........."+choose.isDo());
		if(!choose.isDo()){     //如果父标签的isDo为false,证明if条件为假
			this.getJspBody().invoke(null);
			choose.setDo(true);
		}
		super.doTag();
	}

	
}
