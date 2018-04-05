package Utils.UUID;

import org.junit.Test;

public class TestUUID {
	@Test
	public void test3(){
		System.out.println(UUIDUtil.getUUID().replace("-", ""));
		System.out.println(UUIDUtil.getUUID());
		System.out.println(UUIDUtil.getUUID());
	}
}
