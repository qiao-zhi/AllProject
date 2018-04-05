import java.util.Date;

public class FormatData {

	static public  void main(String... args) {
		// TODO Auto-generated method stub
		double x=5.0000000008; 
		System.out.printf("%.6f\n",x);   //%是必须放在开头的参数，格式化输出，使输出保留小数点后6位。参加java的Formatter类。f代表十进制浮点数
		System.out.printf("%.5f\n",x);   //数据格式化时.6表示精度。f是转换类型
		


	        Date d=new Date();
		System.out.printf("%tT", d);   //t代表转换是时间类型，T是具体的格式
	}

}
