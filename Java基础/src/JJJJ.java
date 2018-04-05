import java.math.BigDecimal;
import java.text.DecimalFormat;

public class JJJJ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(sumSequence(5));
	}
	
	static double sumSequence(int n){
	
		double result=0;
		int x[][]=new int[n][2];
		x[0][0]=1;
		x[0][1]=2;
		if(n==1){result=(double)1/2; return result;}
		for(int i=0;i<x.length;i++){
			if(i==0){result=(double)1/2; continue;}
		
			x[i][0]=x[i-1][1];
			x[i][1]=x[i-1][1]+x[i-1][0];
			BigDecimal fir=new BigDecimal(String.valueOf(x[i][0]));
			BigDecimal sec=new BigDecimal(String.valueOf(x[i][1]));
			result+=Double.valueOf(fir.divide(sec, 10, BigDecimal.ROUND_HALF_DOWN).toString());
		}


		return result;
	}

}
