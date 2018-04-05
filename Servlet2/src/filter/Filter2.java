package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter2 implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		String filterName = filterConfig.getFilterName();
		System.out.println(filterName);
		ServletContext sc = filterConfig.getServletContext();
		System.out.println(sc);
		String initName = filterConfig.getInitParameter("name");
		System.out.println(initName);
		
		System.out.println("filter2创建");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("过滤器2执行················");
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("filter2销毁");
	}

}
