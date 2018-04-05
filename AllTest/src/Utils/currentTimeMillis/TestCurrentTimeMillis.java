package Utils.currentTimeMillis;

public class TestCurrentTimeMillis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("开始计算---");
		int total = 0;
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			total+= i;
		}
		System.out.println(total);
		System.out.println("计算完毕---");
		long end = System.currentTimeMillis();
		System.out.println("用时:---"+(end-start)+"ms.");
		
	}

}
