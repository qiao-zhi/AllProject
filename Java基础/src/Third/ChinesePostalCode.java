package Third;

public class ChinesePostalCode {

	
	 boolean sValidChinesePCode(String pCode,String state){
		if(pCode.length()!=6){System.out.println("长度不是6位！");return false;}
		char ch[]=pCode.toCharArray();
		for(char c:ch){
			if(!('0'<=c&&c<='9')){System.out.println("必须是数字！");return false;}
		}
		System.out.println("合法！");
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChinesePostalCodeAdapter cpc=new ChinesePostalCodeAdapter();
		cpc.isValidZipCode("025612", "Chinese");
		cpc.isValidZipCode("02562", "Chinese");
		cpc.isValidZipCode("02!!62", "Chinese");
	}

}
