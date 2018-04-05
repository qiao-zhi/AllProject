package entity;

import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Test2 {
public static void main(String s[]){
                // 第一种方法
	//	SessionFactory sf=new Configuration().configure().buildSessionFactory();
//	System.out.println(sf);

	
	//第二种方法
//	Configuration configuration=new Configuration();
//	configuration.configure();
//	ServiceRegistry   serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//	SessionFactory sf=configuration.buildSessionFactory();
//	System.out.println(sf);
	
	
	
	  //第三种方法
	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure() // configures settings from hibernate.cfg.xml
			.build();
	try {
		SessionFactory	sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		System.out.println(sessionFactory);
		
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
	
	
	
}
}
