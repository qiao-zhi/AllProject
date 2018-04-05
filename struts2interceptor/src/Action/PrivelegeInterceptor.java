package Action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class PrivelegeInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		//初始化方法，获得数据库信息。调用服务
	}

	
	/**
	 * 
	 */
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {

		//如果用户登录了就会有user属性(Session里面存一个session属性)
		Object user = arg0.getInvocationContext().getSession().get("user");
        //	上面可能是系统权限的管理	
		String result="";
		System.out.println(user);
		if(user!=null){
//			当满足条件时，让其执行，相当于是放行
			arg0.invoke();
		}else {
			result = "logon";
			ActionContext.getContext().put("msg", "您没有权限管理");
			}
			System.out.println(result);
			return result;
	}
}
