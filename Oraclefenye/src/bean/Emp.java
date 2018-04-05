package bean;

import java.util.Date;

public class Emp {
	private int id;
	private String name;
	private  Date hiredate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", hiredate=" + hiredate + "]";
	}
	
}
