import java.util.Scanner;

public class Main
{
	
	public static void main(String[] args)
	{
		int i=new Scanner(System.in).nextInt();
	 test(i);
		
		
		
	}

	private static void test(int i) {
		for(int a=0;a<i;a++){
			for(int b=0;b<i;b++){
				for(int c=0;c<i;c++){
					for(int d=0;d<i;d++){
						if(i==a*a+b*b+c*c+d*d){
							int shuzu[]={a,b,c,d};
							System.out.println(a+" "+b+" "+c+" "+d);
							return;
						}
					}
				}	
			}
		}
		
		
	}
}