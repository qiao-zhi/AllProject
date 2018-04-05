package entity;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class EventDao {
	
	
	//���洢���󷽷����
public void addEvent(Event event){
	Session session=hibernateUtil.getCurrentSession();
	Transaction transction=session.beginTransaction();
	session.save(event);     //��Ӷ���ʱ��ֱ�����
	transction.commit();
	session.close();
}

/******��ѯȡ�����ж���***********/
public List<Event>  getAll(){
	Session session=hibernateUtil.getCurrentSession();  //ȡ��Session����
//	List<Event> events=(List<Event>) session.createQuery("from Event");//��һ�ַ���
	List<Event> events= session.createQuery("from Event").list();  //�ڶ��ַ���
    session.close();
	return events;
	
	
}


/********************ͨ��id���Ҷ���*****/
public Event findById(long id){
	Session session=hibernateUtil.getCurrentSession();
	Event event=(Event)session.get(Event.class,id);
	session.close();
	return event;
}

/***********�޸Ķ���*********/
public void update(Event event){
	Session session=hibernateUtil.getCurrentSession();
	Transaction transction=session.beginTransaction();
	session.update(event);
	transction.commit();
	session.close();
}

}
