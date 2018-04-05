package Utils.validate;

import org.junit.Test;

public class ValidateTest {

	@Test
	public void test1(){
		System.out.println(ValidateUtil.isNotNull("     "));
		System.out.println(ValidateUtil.isNotNull("www"));
		System.out.println(ValidateUtil.isNull("     "));
	}
}
