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
//Event event1=new Event(new Date(),"�ڰ˸�����");
//ed.addEvent(event1);  //������Գɹ�ִ��


/******************��ѯ���ж�����Գɹ�ִ��
List<Event> event_1=ed.getAll();
for(Event s:event_1){System.out.println(s.getId()+"\t"+s.getTitle()+"\t"+s.getDate());}
**************/

/*************ͨ��Id���ҿ��Գɹ�ִ��,�޸�Ҳ���Գɹ�ִ��
Event event1=ed.findById(1);
System.out.println(event1.getId()+"\t"+event1.getTitle());
event1.setDate(new Date());
event1.setTitle("�޸ĺ�ĵ�һ������");
ed.update(event1);
***********************/
		
//		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
//		Session session=sessionFactory.openSession();
//		Transaction transaction=session.beginTransaction();
//		Event event1=new Event(new Date(),"���������");   //��������ʱ״̬
//		session.save(event1);      //�������                                 //�־ö���
//		transaction.commit();     //�ύ����
//		session.close();          //�ر�����                                   //�йܶ���
	}

}
