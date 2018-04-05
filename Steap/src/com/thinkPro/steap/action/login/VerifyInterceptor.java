package com.thinkPro.steap.action.login;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
@Component
public class VerifyInterceptor extends AbstractInterceptor{
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		/* 获取session和request */
		Map<String, Object> session = ActionContext.getContext().getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		
		/* 得到页面的code 和 系统生成的code */
		String verifyCode = request.getParameter("pCode");
		String VCode = (String) session.get("VCode");
		if (VCode == null) {
			session.put("msg", "验证码错误，请重新输入");
			return "login";
		}
		
		if (VCode.equalsIgnoreCase(verifyCode)) {
			session.remove("msg");
			return invocation.invoke();
		}
//		System.err.println("验证码输入错误");
//		Login aciton = (Login) invocation.getAction();
//		aciton.addActionError("验证码错误，请重新输入");
		session.put("msg", "验证码错误，请重新输入");
		return "login";
	}

}
