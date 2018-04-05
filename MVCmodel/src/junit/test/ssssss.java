package junit.test;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

public class ssssss {

	@Test
	public void ssss() {
		DateLocaleConverter dlc=new DateLocaleConverter();
		dlc.convert("1999-05-05", "yyyy-MM-dd");
		System.out.println(dlc.convert("1999-05-05", "yyyy-MM-dd"));
	}

}
