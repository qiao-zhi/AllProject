package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyServletContextAttributeListener implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		// TODO Auto-generated method stub
		System.out.println("这是添加属性的！");
//		获取放到域中的键与值
		System.out.println(scae.getName()+"  "+scae.getValue());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		// TODO Auto-generated method stub
		System.out.println("这是删除属性的！");
//		获取删除的键与值
		System.out.println(scae.getName()+"  "+scae.getValue());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		// TODO Auto-generated method stub
		System.out.println("这是修改属性的！");
//		获取修改前的键与值
		System.out.println(scae.getName()+"  "+scae.getValue());  
	}

}
