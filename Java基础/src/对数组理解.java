import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class 对数组理解 {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub

		int a[]=new int[2];
		System.out.println(a);
		Class c1 = Class.forName("int[]");
		Constructor  c=c1.getConstructor(int[].class); 
		int[] xx=(int[]) c.newInstance(new int[]{1,2});
		System.out.println(xx[1]);
	}

}
