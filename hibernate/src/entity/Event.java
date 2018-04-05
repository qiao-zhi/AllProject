package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
@Entity                   //对应一个表
@Table(name="EVENT")    //表名字
public class Event {
	@Id
	@Column(name="event_id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
private long id;
	
	@Column(name="event_date")
private Date date;
	@Column(name="event_title",length=15)
private String title;
public Event(){}
public Event(Date date, String title) {
	super();
	this.date = date;
	this.title = title;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}

//@Temporal(TemporalType.TIMESTAMP)  注解也可以加在GET方法上面
//@Column(name = "EVE_DATE")
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}


}
