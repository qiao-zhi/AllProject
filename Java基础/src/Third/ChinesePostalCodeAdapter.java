package Third;

public class ChinesePostalCodeAdapter  extends ChinesePostalCode implements ZipCodeValidator {


	
	public boolean isValidZipCode(String zip, String state) {
	boolean b=this.sValidChinesePCode(zip,state);
	return b;
		
	} 
	
	
}
