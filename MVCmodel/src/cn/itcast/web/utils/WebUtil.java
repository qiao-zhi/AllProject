package cn.itcast.web.utils;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.ConvertUtils;


public class WebUtil {

	public WebUtil() {
		
	}
	
	/******表单数据封装成Bean类型，类型全是String****/
	public static <T>T request2bean(HttpServletRequest request,Class<T> beanClass ){
               		
		T bean;
		try {
			//创建要封装数据的bean
			bean = beanClass.newInstance();
			//设置属性
			Enumeration e=request.getParameterNames();
			while(e.hasMoreElements()){
				String name=(String) e.nextElement();
				String value=request.getParameter(name);
				//利用BeanUtils工具封装属性
				BeanUtils.setProperty(bean, name, value);
			}
			
		} catch (Exception e) {
            
			throw new RuntimeException(e);
		}
		return  bean;
	}
	
	
	//将表单对象的属性赋给对应的JavaBean对象
	public static void copyBean(Object dest,Object src){
		
		
		//注册一个日期转换器
		ConvertUtils.register(new Converter(){
			public Object convert(Class type,Object value){
				if(value==null){
					return null;
				}
			String str=(String) value;
				if(str.trim().equals("")){
				return null;
		}		
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		try {
				return df.parse(str);
			} catch (ParseException e) {
		throw new RuntimeException(e);
		}
	
			}	
		}, Date.class);
		

		
		try {
			BeanUtils.copyProperties(dest, src);
		}  catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	
	

}


	
	
	

