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
	
	/******�����ݷ�װ��Bean���ͣ�����ȫ��String****/
	public static <T>T request2bean(HttpServletRequest request,Class<T> beanClass ){
               		
		T bean;
		try {
			//����Ҫ��װ���ݵ�bean
			bean = beanClass.newInstance();
			//��������
			Enumeration e=request.getParameterNames();
			while(e.hasMoreElements()){
				String name=(String) e.nextElement();
				String value=request.getParameter(name);
				//����BeanUtils���߷�װ����
				BeanUtils.setProperty(bean, name, value);
			}
			
		} catch (Exception e) {
            
			throw new RuntimeException(e);
		}
		return  bean;
	}
	
	
	//������������Ը�����Ӧ��JavaBean����
	public static void copyBean(Object dest,Object src){
		
		
		//ע��һ������ת����
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


	
	
	

