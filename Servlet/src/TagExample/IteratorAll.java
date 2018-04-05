package TagExample;

import java.lang.reflect.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class IteratorAll extends SimpleTagSupport {

	private Object items;
	private String var;
	private Collection collection;
	public void setItems(Object items) {//都转为单列集合
		if(items instanceof Collection){
			collection=(Collection) items;
		}
		
		if(items instanceof Map){
			Map map=(Map)items;
			collection=(Collection) map.entrySet(); //转为Set集合
		}		
		
		
		if(items instanceof Object[]){     //如果是对象数组

			Object obj[]=(Object[])items;
			collection=Arrays.asList(obj);
		}		
		
		
//		if(items instanceof int[]){     //如果是基本数据类型数组
//			int a[]=(int[])items;
//			this.collection=new ArrayList();
//			for(int i:a){
//				this.collection.add(i);
//			}
//
//		}		
//				
				
		if(items.getClass().isArray()){//判断是不是数组类型
			
			this.collection=new ArrayList();
//			int length=collection.size();
			int length=Array.getLength(items);
			for(int i=0;i<length;i++){
			Object value=Array.get(items,i);
			collection.add(value);
		}
		}
		
		
	}
	public void setVar(String var) {
		this.var = var;
	}
	@Override
	public void doTag() throws JspException, IOException {
		Iterator it=this.collection.iterator();
		while(it.hasNext()){
			Object value=it.next();
			this.getJspContext().setAttribute(var, value);
			this.getJspBody().invoke(null);             //通知标签体执行
		}
		
		super.doTag();
	}
	
	

	
}
