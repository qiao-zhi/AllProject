package cn.qlq.annotationAOP;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect    //表示该类是一个通知类
public class MyAdvice {
	
	//定义一个空方法，借用其注解
	@Pointcut("execution(* cn.qlq.service.*ServiceImpl.*(..))")
	public void pc(){}
	//前置通知
	@Before("MyAdvice.pc()")
	public void before(){
		System.out.println("这是前置通知~~~~~~~~~~~");
	}
	//后置通知(异常发生后不会调用)
	@AfterReturning("execution(* cn.qlq.service.*ServiceImpl.*(..))")
	public void afterRunning(){
		System.out.println("这是后置通知(异常发生后不会调用)");
	}
	//环绕通知
	@Around("execution(* cn.qlq.service.*ServiceImpl.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("这是环绕通知之前的部分~！！！！");
		Object proceed = pjp.proceed();
		System.out.println("这是环绕通知之后的部分~~~~~~~~~");
		return proceed;
	}
	//异常通知
	@AfterThrowing("execution(* cn.qlq.service.*ServiceImpl.*(..))")
	public void afterException(){
		System.out.println("这是异常通知(发生异常后调用)~~~~~~~~~~~");
	}
	//后置通知(发生异常也会在最终调用)
	@After("execution(* cn.qlq.service.*ServiceImpl.*(..))")
	public void after(){
		System.out.println("这是后置通知(发生异常也会在最终调用)");
	}
}
