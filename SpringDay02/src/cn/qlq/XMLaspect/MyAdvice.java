package cn.qlq.XMLaspect;
import org.aspectj.lang.ProceedingJoinPoint;
public class MyAdvice {
	//前置通知
	public void before(){
		System.out.println("这是前置通知~~~~~~~~~~~");
	}
	//后置通知(异常发生后不会调用)
	public void afterRunning(){
		System.out.println("这是后置通知(异常发生后不会调用)");
	}
	//环绕通知
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("这是环绕通知之前的部分~！！！！");
		Object proceed = pjp.proceed();
		System.out.println("这是环绕通知之后的部分~~~~~~~~~");
		return proceed;
	}
	//异常通知
	public void afterException(){
		System.out.println("这是异常通知(发生异常后调用)~~~~~~~~~~~");
	}
	//后置通知(发生异常也会在最终调用)
	public void after(){
		System.out.println("这是后置通知(发生异常也会在最终调用)");
	}
}
