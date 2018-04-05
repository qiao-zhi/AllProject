
public class SSSSSSS {

	public static void main(String[] args) {
		
		
		System.out.println(mmsum(5));
		System.out.println((double)1/2+(double)2/3+(double)3/5+(double)5/8+(double)8/13);
		
	}
	
	static double mmsum(int n){
	       double d=2;
	       double s=0;
	        for(int i=0;i<n;i++){
	            int u=i+1;
	            double mm=u/d;
	            s=s+mm;
	            d=u+d; 
	        }
	        return s;
	}


}
