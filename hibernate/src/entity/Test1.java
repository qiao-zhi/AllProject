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
	
	/*********************��һ�ִ������ݿ������SesiionFactory���󣩵ķ���*********
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	System.out.println(sf);**************/
	
	
	//�ڶ��ִ������ݿ������SesiionFactory���󣩵ķ������Զ�����hibernate.cfg.xml�ļ�����hibernate.cfg.xml�ļ����ҵ��Ա��ӳ��
	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure() // configures settings from hibernate.cfg.xml
			.build();
	try {
		SessionFactory	sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		System.out.println(sessionFactory);
		
		/***************�������ĵ�һ�ַ���
		EntityManager entityManager = sessionFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist( new Event(  new Date(),"Our very first event!") );
		entityManager.getTransaction().commit();  //�ύ����
		entityManager.close();********/
		
		
		/*�������ڶ��ַ�������������Ҿ����߼��ԡ��Ȳ���һ��SessionFactory����sessionFactory��������sessionFactory����һ��
		 Session�����ٲ���һ����Ϊ�Ķ���Transction��Ķ���transction��������session���������transction�ύ��
		 �������session.close()�رնԻ�*/
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Event event1=new Event(new Date(),"���ĸ�����");
		session.save(event1);      //�������
		transaction.commit();     //�ύ����
		session.close();          //�ر�����
		
		
		
		/*******��ѯ��������sessionFctory����һ��EntityManager����
		 * entityManager������entityManager������һ��List�����¼
		 * �Ľ������ӡ������ύ���񣬹ر�entityManager * *************/
//		EntityManager entityManager = sessionFactory.createEntityManager();
//		entityManager.getTransaction().begin();
//		List<Event> result = entityManager.createQuery( "from Event", Event.class ).getResultList();  //from����������
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


