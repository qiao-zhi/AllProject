package cn.qlq.annotationAOP;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect // 表示该类是一个通知类
@Component // 交给spring管理
public class MyAdvice {

	// 匹配传入的参数类型标有MyAnno注解的方法
	@Pointcut("@annotation(cn.qlq.annotationAOP.MyAnno)")
	public void pc() {
	}

	// 前置通知(下面两种方式均可以)
	// @Before("MyAdvice.pc()")
	@Before(value = "pc() && args(arg)")
	public void before(JoinPoint joinPoint,Object arg) throws Exception {
		System.out.println("---------------前置通知开始(注解)~~~~~~~~~~~");
		System.out.println("参数是:"+arg.toString());
		System.out.println("---------------前置通知结束(注解)~~~~~~~~~~~");
	}

	//后置通知(异常发生后不会调用)
	@AfterReturning(value = "MyAdvice.pc()", returning = "result")
	public void afterRunning(Object result) {
		System.out.println(result);
		System.out.println("这是后置通知(@AfterReturning--异常发生后不会调用)。。。。(注解)");
	}

	// 最终通知(发生异常也会在最终调用)
	@After(value = "MyAdvice.pc()")
	public void after() {
		System.out.println("这是最终通知----after(发生异常也会在最终调用)........(注解)");
	}
	// 异常通知
	@AfterThrowing("MyAdvice.pc()")
	public void afterException() {
		System.out.println("这是异常通知(发生异常后调用)~~~~~~~~~~~(注解)");
	}
	// 环绕通知
	@Around("MyAdvice.pc()")
	public Object around(ProceedingJoinPoint pjp) {
		System.out.println("----------------环绕通知之前 的部分(相当于前置通知)----------------");
		// 获取到类名
		String targetName = pjp.getTarget().getClass().getName();
		System.out.println("代理的类是:" + targetName);
		// 获取到参数
		Object[] parameter = pjp.getArgs();
		System.out.println("传入的参数是:" + Arrays.toString(parameter));
		// 获取到方法签名，进而获得方法
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Method method = signature.getMethod();
		System.out.println("增强的方法名字是:" + method.getName());
		// 处理一些业务逻辑

		// 获取参数类型
		Class<?>[] parameterTypes = method.getParameterTypes();
		System.out.println("参数类型是:" + parameterTypes.toString());

		// 让方法执行
		System.out.println("--------------方法开始执行(注解)------------------");
		Object proceed = null;
		try {
			proceed = pjp.proceed();
			// 环绕通知之后的业务逻辑部分
			System.out.println("----------------环绕通知之后的部分(相当于后置通知AfterReturning)-----------------");
		} catch (Throwable e) {
			System.out.println("-------------环绕通知的异常部分(相当于异常通知AfterThrowing)--------------------------");
			e.printStackTrace();
		} finally {
			System.out.println("-------------环绕通知的最终部分部分(相当于最终通知After)--------------------------");
		}

		return proceed;
	}

}
