
public class 反射 {
	public static String s="sss";

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub

//		System.out.println(Class.forName("遍历Map"));
		反射 ss = 反射.class.newInstance();
          System.out.println(ss.s);
	}

}
