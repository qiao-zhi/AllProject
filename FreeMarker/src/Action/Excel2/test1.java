package Action.Excel2;

import java.util.List;

import org.junit.Test;
import org.junit.validator.PublicClassValidator;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import bean.Question;

public class test1 {

	@Test
	public void test1(){
		String excel2Json = Excel2JSON.excel2Json("F://a.xls");
		List<Question> json2list = (List<Question>)JSON2BeanList.json2list(excel2Json);
		System.out.println(json2list);
		System.out.println(json2list.size());
		for(Question q:json2list){
			System.out.println(q);
			System.out.println(q.getAxuanxiang());
		}
	}
}
