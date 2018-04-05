package TagExample;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HTMLbiaoqian extends SimpleTagSupport {

	
	
	
	
	
	@Override
	public void doTag() throws JspException, IOException {
		StringWriter sw=new StringWriter();
	     JspFragment jf=this.getJspBody();
	     jf.invoke(sw);
	     
	     String html=sw.getBuffer().toString();//从缓存流中读取数据
	     html= filter(html);
	     this.getJspContext().getOut().write(html);
		super.doTag();
	}

	
//	HTML特殊字符转义
	String filter(String content) {
		 if(content==null) return "";       
		     String html = content;
		    
		 //    html = html.replace( "'", "&apos;");
		     html = html.replaceAll( "&", "&amp;");
		     html = html.replace( "\"", "&quot;");  //"
		     html = html.replace( "\t", "&nbsp;&nbsp;");// 替换跳格
		     html = html.replace( " ", "&nbsp;");// 替换空格
		     html = html.replace("<", "&lt;");
		     html = html.replaceAll( ">", "&gt;");
		 
		     return html;
		 }
}
