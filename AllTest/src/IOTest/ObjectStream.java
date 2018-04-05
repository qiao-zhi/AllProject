package IOTest;
import java.io.*;
public class ObjectStream{
	public static void main(String arg[])throws Exception{
		Employee e1 = new Employee(1001,"Wang",5678.50);
		FileOutputStream fos = new FileOutputStream(".\\object.dat");
		ObjectOutputStream out = new ObjectOutputStream(fos); //创建输出对象流
		out.writeObject(e1); //写入对象
		out.close();
		FileInputStream fis = new FileInputStream(".\\object.dat");
		ObjectInputStream in = new ObjectInputStream(fis);  //创建输入对象流
		Employee e2 = (Employee)in.readObject(); //读取对象
		System.out.println("Id: "+e2.id);
		System.out.println("Name: "+e2.name);
		System.out.println("Salary: "+e2.salary);
		in.close();
	}
}
class Employee  implements Serializable{ //必须实现Serializable接口
	int id;
	String name;
	double salary;
	Employee(int i,String n,double s)
	{
		id=i;
		name=n;
		salary=s;
	}
}
