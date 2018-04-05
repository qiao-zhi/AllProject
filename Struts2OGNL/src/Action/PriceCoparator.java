package Action;

import java.util.Comparator;

public class PriceCoparator implements Comparator<Book> {

	@Override
	public int compare(Book arg0, Book arg1) {
	
		//double类型可以乘以很高的倍数后比较大小
		return -(int) (arg0.getPrice()*10000000-arg1.getPrice()*10000000);
	}

}
