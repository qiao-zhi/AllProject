package entity;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.*;
public class Test1 {
public static void main(String s[]){
	
	/*********************第一种创建数据库表（产生SesiionFactory对象）的方法*********
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	System.out.println(sf);**************/
	
	
	//第二种创建数据库表（产生SesiionFactory对象）的方法，自动加载hibernate.cfg.xml文件，在hibernate.cfg.xml文件中找到对表的映射
	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure() // configures settings from hibernate.cfg.xml
			.build();
	try {
		SessionFactory	sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		System.out.println(sessionFactory);
		
		/***************保存对象的第一种方法
		EntityManager entityManager = sessionFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist( new Event(  new Date(),"Our very first event!") );
		entityManager.getTransaction().commit();  //提交事物
		entityManager.close();********/
		
		
		/*保存对象第二种方法，容易理解且具有逻辑性。先产生一个SessionFactory对象sessionFactory，再利用sessionFactory产生一个
		 Session对象，再产生一个行为的对象（Transction类的对象transction），利用session保存对象，用transction提交事
		 务，最后用session.close()关闭对话*/
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Event event1=new Event(new Date(),"第四个对象");
		session.save(event1);      //保存对象
		transaction.commit();     //提交事物
		session.close();          //关闭连接
		
		
		
		/*******查询方法利用sessionFctory产生一个EntityManager对象
		 * entityManager，开启entityManager事务，用一个List对象记录
		 * 的结果，打印结果，提交事务，关闭entityManager * *************/
//		EntityManager entityManager = sessionFactory.createEntityManager();
//		entityManager.getTransaction().begin();
//		List<Event> result = entityManager.createQuery( "from Event", Event.class ).getResultList();  //from后面是类名
//		for ( Event event : result ) {
//			System.out.println( "Event (" + event.getDate() + ") : " + event.getTitle() );
//		}
//		entityManager.getTransaction().commit();
//		entityManager.close();
//		
		
		
		
	}
	catch (Exception e) {
		// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
		// so destroy it manually.
		StandardServiceRegistryBuilder.destroy( registry );
	}
	}
	
	
	
}


