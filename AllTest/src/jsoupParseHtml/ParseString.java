package jsoupParseHtml;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class ParseString {

	// 解析html字符串
	@Test
	public void testHtmlToString() {
		String html = "<html><head><title>First parse</title></head>"
				+ "<body><p style='center'>Parsed HTML into a doc.</p></body></html>";
		Document doc = Jsoup.parse(html);
		System.out.println(doc); // 输出带标签的html文档
		System.out.println("---------------------\n" + doc.text()); // 输出内容
	}

	@Test
	public void testHtmlToString2() {
		String html = "<p>这是一个段落<img src=\"test.img\"/>内容;</p>";
		Document doc = Jsoup.parse(html);
		System.out.println(doc); // 输出带标签的html文档
		System.out.println("---------------------\n" + doc.text()); // 输出内容
		Elements element = doc.getElementsByTag("p");
		System.out.println("---------------------\n" + element.get(0).html());
	}

	// 解析body片段
	@Test
	public void test2() {
		String html = "<span class=\"bigNum\">二</span>、 <span><input class=\"el_modifiedTitle\" type=\"text\" value=\"多选题\">每到题 <input type=\"text\" class=\"el_modifiedGrade\" value=\"20\">"
				+ "分） </span>";
		Document doc = Jsoup.parseBodyFragment(html);
		Elements links = doc.select(".el_modifiedTitle"); // 带有href属性的a元素
		System.out.println(links.get(0).attr("value"));
		System.out.println(doc);
		System.out.println(doc.text());
	}

	// 解析body片段
	@Test
	public void test3() {
		String html = "Lorem ipsum";
		Document doc = Jsoup.parseBodyFragment(html);
		System.out.println(doc.toString());
		System.out.println(doc.text());
	}

	// 解析一个url(相当于查看源码)
	@Test
	public void test4() throws IOException {
		Document doc = Jsoup.connect("http://qiaoliqiang.cn:8080/").get();
		String title = doc.title();// 获取title
		System.out.println(title);
		System.out.println("---------------------\n" + doc.toString() + "---------------------\n");// 输出文档全部
		Elements links = doc.getElementsByTag("a");
		for (Element ele : links) {
			System.out.println(ele.toString());
		}
	}

	// 解析一个url(相当于查看源码)
	@Test
	public void test5() throws IOException {
		Document doc = Jsoup.connect("http://qiaoliqiang.cn:8080/").get();
		// System.out.println(doc.text());// 输出doc.text()
		String title = doc.title();// 获取title
		System.out.println(title);
		// System.out.println(doc.toString());// 输出文档全部
		Elements links = doc.select("img"); // 带有img标签
		for (Element ele : links) {
			System.out.println(ele.toString());
		}
	}

	// 解析body片段
	@Test
	public void test6() {
		String html = "<span class=\"bigNum\">二</span>、 <span><input class=\"el_modifiedTitle\" value=\"多选题\" type=\"text\">"
				+ "（每到题 <input class=\"el_modifiedGrade\" value=\"2\" type=\"text\">" + "分；共2</span>分/<span>1</span>题）";
		Document doc = Jsoup.parseBodyFragment(html);
		System.out.println(doc);
		System.out.println("---------------------华丽的分割线-----------------");
		System.out.println(doc.text());
		System.out.println("---------------------华丽的分割线-----------------");
		// 提取出来二
		System.out.print(doc.select(".bigNum").get(0).text());
		// 提出多选题
		System.out.print(doc.select(".el_modifiedTitle").get(0).attr("value"));
		System.out.print(doc.select("span").get(1).text());
		System.out.print(doc.select(".el_modifiedGrade").get(0).attr("value"));

	}

}
