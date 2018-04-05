package six;

import java.util.Scanner;
public class Test {
	public static void main(String[] args) {
		Gupiao gp = new Gupiao(0.50d);
		User user = new User("乔利强");
		user.buyGuPiao(gp);
		while(true){
			double bianhua = (new Scanner(System.in)).nextDouble();
		    gp.change(bianhua);
		}
	}
}
