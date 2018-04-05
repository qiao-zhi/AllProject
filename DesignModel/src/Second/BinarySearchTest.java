package Second;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class BinarySearchTest {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBinarySearch() {
		
		BinarySearch bs = new BinarySearch();
		int a[]={1,2,3,4,5,6,7,8,9,25};
		int ss=bs.binarySearch(a, 7);
		System.out.println(ss);
	}

}
