package entity;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class EventDao {
	
	
	//将存储对象方法打包
public void addEvent(Event event){
	Session session=hibernateUtil.getCurrentSession();
	Transaction transction=session.beginTransaction();
	session.save(event);     //添加对象时候直接添加
	transction.commit();
	session.close();
}

/******查询取出所有对象***********/
public List<Event>  getAll(){
	Session session=hibernateUtil.getCurrentSession();  //取得Session对象
//	List<Event> events=(List<Event>) session.createQuery("from Event");//第一种方法
	List<Event> events= session.createQuery("from Event").list();  //第二种方法
    session.close();
	return events;
	
	
}


/********************通过id查找对象*****/
public Event findById(long id){
	Session session=hibernateUtil.getCurrentSession();
	Event event=(Event)session.get(Event.class,id);
	session.close();
	return event;
}

/***********修改对象*********/
public void update(Event event){
	Session session=hibernateUtil.getCurrentSession();
	Transaction transction=session.beginTransaction();
	session.update(event);
	transction.commit();
	session.close();
}

}
