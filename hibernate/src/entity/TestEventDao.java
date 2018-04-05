package entity;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestEventDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

EventDao ed=new EventDao();
//Event event1=new Event(new Date(),"第八个对象");
//ed.addEvent(event1);  //插入可以成功执行


/******************查询所有对象可以成功执行
List<Event> event_1=ed.getAll();
for(Event s:event_1){System.out.println(s.getId()+"\t"+s.getTitle()+"\t"+s.getDate());}
**************/

/*************通过Id查找可以成功执行,修改也可以成功执行
Event event1=ed.findById(1);
System.out.println(event1.getId()+"\t"+event1.getTitle());
event1.setDate(new Date());
event1.setTitle("修改后的第一个对象");
ed.update(event1);
***********************/
		
//		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
//		Session session=sessionFactory.openSession();
//		Transaction transaction=session.beginTransaction();
//		Event event1=new Event(new Date(),"第五个对象");   //对象处于临时状态
//		session.save(event1);      //保存对象                                 //持久对象
//		transaction.commit();     //提交事物
//		session.close();          //关闭连接                                   //托管对象
	}

}
