package Utils.dateHandler;

import java.text.ParseException;
import java.util.Date;

import org.junit.Test;

public class Test111 {

	@Test
	public void test1() throws ParseException{
		System.out.println(DateHandler.dateToString(new Date()));
		System.out.println(DateHandler.dateToString(new Date(), "yyyy-MM-dd hh:mm:ss"));
		System.out.println(DateHandler.dateToStringHourMinute(new Date()));
		System.out.println(DateHandler.changeStringToDate("1900-05-06"));
		System.out.println(DateHandler.changeStringToDate("1925-02-20 15:25:30","yyyy-MM-dd hh:mm:ss" ));
	}
}
