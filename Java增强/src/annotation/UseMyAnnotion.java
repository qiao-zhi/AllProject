package annotation;

public class UseMyAnnotion {

//	这里只用一个属性，另一个value属性有默认值不用设置
	@MyAnnotation(name = "QizoZhi")
	public void show(String str){
		System.out.println(str);
	}
}
