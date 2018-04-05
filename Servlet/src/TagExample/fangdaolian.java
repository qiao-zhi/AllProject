package TagExample;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class fangdaolian extends SimpleTagSupport {

	private String site;
	private String page;
	public void setSite(String site) {
		this.site = site;
	}
	public void setPage(String page) {
		this.page = page;
	}
	@Override
	public void doTag() throws JspException, IOException {
	
		PageContext pageContext = (PageContext)this.getJspContext();
		HttpServletRequest request=(HttpServletRequest) pageContext.getRequest();
		HttpServletResponse response=(HttpServletResponse) pageContext.getResponse();
        //得到来访者referer
		String referer=request.getHeader("referer");
		//前一个页面非空或者不是从指定网站而来，则为盗链
		if(referer==null||!referer.startsWith(site)){
			//跳转的页面带工程名字
			if(page.startsWith(request.getContextPath())){
				response.sendRedirect(page);
			}
			//跳转的页面不带工程名字
			else if(page.startsWith("/")){
				
				response.sendRedirect(request.getContextPath()+page);
			}
			else response.sendRedirect(request.getContextPath()+"/"+page);
			
			throw new SkipPageException();
			
		}
		//到这里来不是盗链者.正常显示页面
		else{}
		
		super.doTag();
	}
	
	
	
	
	
	
	
}
