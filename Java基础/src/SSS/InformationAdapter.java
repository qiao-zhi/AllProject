package SSS;


/*---------------------------------------------------------*/
/* This adapter class extends InfoValidation and           */
/* implements CusInfoValidator, and so the first           */
/* 4 functionalities listed in class CusInfoValidator      */
/* are automatically inherited from class InfoValidation,  */
/* and in this addapter class, isValidSSNNum(String SSNNum)*/
/* is emplemented.                                         */
/*---------------------------------------------------------*/


class InformationAdapter extends InfoValidation implements CusInfoValidator{

    /*------------------------------------------*/
	/* The Social Security number is a 9-digit  */
	/* number in the format "AAA-GG-SSSS".      */
	/*------------------------------------------*/
	public boolean isValidSSNNum(String SSNNum){
	   boolean isValid=true;
       String ns = SSNNum.trim();
	   String nStr = ns.replaceAll("\\s{1,}", "");
	   int len = nStr.length();

	   if ( (nStr.charAt(3) == '-') && (nStr.charAt(6) == '-') && (len==11) ) {
	      for(int m=0; m<len; m++){
		     if(  (m != 3) && (m !=6) && ( Character.isDigit(nStr.charAt(m))==false) ){
		        isValid=false;
		     }
	      }
	      return isValid;
	   }
	   else{
		  return false;
	   }
	}

	@Override
	public boolean isValidEmailAddr(String EmailAddr) {
		//至少包含.与@
	if(!EmailAddr.contains("@")||!EmailAddr.contains(".")){
		System.out.println("至少包含@或者.");
		return false;}
	
	//只能有一个@
	String str1[]=EmailAddr.split("@");
	if(str1.length>=3){System.out.println("只能包含一个@");return false;}
	
	//至少5位
	if(EmailAddr.length()<5){System.out.println("至少为6位");return false;}
	
	//以字母开头
	char first=EmailAddr.charAt(0);
	if(!((first>='a'&&first<='z')||(first>='A'&&first<='Z'))){System.out.println("请以字母开头！");return false;}

		
	//判断字符串是否包含不合法的字符
	char ch[]=EmailAddr.toCharArray();
	for(char c:ch){
		if(!(('a'<=c&&c<='z')||('A'<=c&&c<='Z')||('0'<=c&&c<='9')||(c=='.'||c=='@'))){
			
			System.out.println("包含不合法的字符！");
			return false;}
	}
	
	
	
	return true;
		
	}
    public static void main(String[] args) {
		
    	InformationAdapter in=new InformationAdapter();
    	if(in.isValidEmailAddr("AAAs#ad@s.s")){System.out.println("合法");}
    	
	}
	
}


