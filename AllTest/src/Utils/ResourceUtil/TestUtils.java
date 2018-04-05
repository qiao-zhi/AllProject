package Utils.ResourceUtil;

import org.junit.Test;

public class TestUtils {

	@Test
	public void Test1(){
		System.out.println(ResourcesUtil.getValue("path", "investigatePicture"));
		System.out.println(ResourcesUtil.getValue("path", "auditReprt"));
		System.out.println(ResourcesUtil.getValue("path", "jdbc.test"));
		System.out.println(ResourcesUtil.getValue("path", "jdbc.test", new Object[]{100,200} ));
	}
}
