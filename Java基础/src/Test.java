import java.util.Calendar;

public class Test {
public static void main(String s[]){
	Calendar c;
	c=Calendar.getInstance();
	System.out.print(c.get(c.YEAR)+"\t"+(c.get(c.MONTH)+1)+"\t"+c.get(c.DAY_OF_MONTH));
	
	
	
}
}
