import org.junit.Test;

public class 可变参数 {
	public String sum(String s,int ...m){
		int result=0;
		for(int x:m){
			result+=x;
		}
		return s+result;
		
	}
	
  @Test
 public void te(){
	 System.out.println( sum("和为",1,5,2,2));
  }
	
}
