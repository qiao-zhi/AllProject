package entity;

import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class hibernateUtil {
private static SessionFactory sessionFactory;
	static{          //static代码自动执行
				
		//第一种方法
//	sessionFactory=new Configuration().configure().buildSessionFactory();   //3.0之前的方法
	
	
	          //第二种方法
	 StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();			
			}
			catch (Exception e) {
				// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
				// so destroy it manually.
				StandardServiceRegistryBuilder.destroy( registry );
			}
		
	
	}
	public static Session getCurrentSession(){		
		Session session=sessionFactory.openSession();
		return session;
	}
	public static void closeSession(Session session){
		if(session!=null){session.close();}
	}
	
}
