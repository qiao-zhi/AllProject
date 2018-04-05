/*package filter;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.sun.corba.se.impl.protocol.giopmsgheaders.ReplyMessage_1_0;

public class EncodingFilter2 implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	HttpServletRequest req = (HttpServletRequest) request;	
	
	HttpServletRequest enhanceRequset = (HttpServletRequest) Proxy.newProxyInstance(
			req.getClass().getClassLoader(), 
			req.getClass().getInterfaces(),
			new InvocationHandler() {
				
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//					对getParameter进行增强
					if(method.getName().equals("getParameter")){
						String invoke = (String) method.invoke(req, args);//乱码
						invoke = new String(invoke.getBytes("iso8859-1"),"UTF-8");//转码
						return invoke;
					}
					return method.invoke(req, args);
				}
			});
		chain.doFilter(enhanceRequset, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
}
*/