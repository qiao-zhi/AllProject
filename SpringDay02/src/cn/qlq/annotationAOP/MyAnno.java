package cn.qlq.annotationAOP;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
	// 定义注解的属性，这不是方法，没有默认值就是必填属性
	String name();

	// 有默认值，就是可选属性
	int value() default 20;
}
