package Second;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class QuickSortTest {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testQuickSort() {
		QuickSort qc = new QuickSort();
		int[] a = new int[]{1,5,8,4,2,3,6};
		a = qc.quickSort(a);
		for(int i:a){
			System.out.println(i);
		}
	}

}
