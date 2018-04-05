package servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.TestFreemarkerBean;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@SuppressWarnings("serial")
@WebServlet("/WebHtmlFreemark")
public class WebHtmlFreemark extends HttpServlet {
	// 负责管理FreeMarker模板的Configuration实例
	private Configuration cfg = null;

	public void init() throws ServletException {
		// 创建一个FreeMarker实例
		cfg = new Configuration();
		// 指定FreeMarker模板文件的位置
		cfg.setServletContextForTemplateLoading(getServletContext(), "/WEB-INF/templates");
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 建立数据模型
		Map<String,Object> root = new HashMap();
		/*root.put("message", "第一个入门程序");
		root.put("name", "freemarker");*/
		List<TestFreemarkerBean> list = new ArrayList<>();
		list.add(new TestFreemarkerBean("乔治", "123456", "男", "wwwwwwww"));
		list.add(new TestFreemarkerBean("乔治", "123456", "男", "wwwwwwww"));
		list.add(new TestFreemarkerBean("乔治", "123456", "男", "wwwwwwww"));
		list.add(new TestFreemarkerBean("乔治", "123456", "男", "wwwwwwww"));
		list.add(new TestFreemarkerBean("乔治", "123456", "男", "wwwwwwww"));
		list.add(new TestFreemarkerBean("乔治", "123456", "男", "wwwwwwww"));
		list.add(new TestFreemarkerBean("乔治", "123456", "男", "wwwwwwww"));
		list.add(new TestFreemarkerBean("乔治", "123456", "男", "wwwwwwww"));
		list.add(new TestFreemarkerBean("乔治", "123456", "男", "wwwwwwww"));
		list.add(new TestFreemarkerBean("乔治", "123456", "男", "wwwwwwww"));
		root.put("mylist", list);
		// 获取模板文件
		Template t = cfg.getTemplate("test.ftl");

		// 使用模板文件的Charset作为本页面的charset
		// 使用text/html MIME-type
		response.setContentType("text/html; charset=" + t.getEncoding());
		Writer out = response.getWriter();
		// 合并数据模型和模板，并将结果输出到out中
		try {
			// t.process(list, out); // 往模板里写数据
//			request.setAttribute("mylist", list);
			t.process(root, out); // 往模板里写数据
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void destroy() {
		super.destroy();
	}
}