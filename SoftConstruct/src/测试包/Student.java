package ²âÊÔ°ü;

public class Student {
 private String name;
 private String sex;
 private Integer age;
 public Student(){
	 
 }
 
 public Student(String s1,String s2,int i){
	 this.name=s1;
	 this.sex=s2;
	 this.age=i;	 
 }
/* public String toString(){
		String format = "Sname:%s,sex:%s,age:%tF";
		String result = String.format(format, this.name,this.sex,this.age);
		return result;
	}*/
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}

 
 
}
