
public class Test22 {

	
	public static void main(String[] args) {
		

		String s[]=new String[9];
		for(int  i=0;i<9;i++){
			s[i]=String.valueOf((9+(i+1)));
//			System.out.println(s[i]);
			int first=Integer.valueOf((s[i].substring(0, 1))); //取十位数
//			System.out.println(first);
			int second=Integer.valueOf((s[i].substring(1, 2)));  //取个位数
			if((first+second)==(i+1)){System.out.println("i="+(i+1)+"成立");}
		}
		
	}
	
	
}
