package Session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//差一个关了还有没做！


//列出书店所有的书，并有购买链接，书存在数据库中
@WebServlet("/BookShopShoYe")
public class BookShopShoYe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BookShopShoYe() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setHeader("content-type", "text/html;charset=utf-8");
//		HttpSession session=request.getSession(false);
		PrintWriter out=response.getWriter();
		
		//列出所有的书条目：
		out.println("本网站有如下商品，欢迎阅览：<br/>");
	
		Map<String,Book> map=Db.getAll();
		//循环遍历该Map集合
		for(Map.Entry<String, Book> entry:map.entrySet()){
			Book book=entry.getValue();
			out.print(book.getName()+"<a href='/Servlet/BuyServlet?id="+book.getId()+"' target='_blank' >"+"购买"+"</a><br/>");
			
			
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}


class Db{
	private static  Map<String,Book> map= new LinkedHashMap();  //用于检索的java容器
	static{
		//static中的代码在类加载时候执行，向map中添加关键字与对象的映射关系
		map.put("1", new Book("1","javaweb","老张","一本好书！！！"));
		map.put("2", new Book("2","spring","老李","一本好书！！！"));
		map.put("3", new Book("3","structs","老网","一本好书！！！"));
		map.put("4", new Book("4","hibernate","老乔","一本好书！！！"));
		map.put("5", new Book("5","servlet","老红","一本好书！！！"));
		map.put("6", new Book("6","mybatis","老或","一本好书！！！"));
	}
	public static Map getAll(){
		return map;
	}
}

class Book{
	private String id;
	private String name;
	private String author;
	private String desc;
	
	
	public Book() {
		super();
	}
	public Book(String id, String name, String author, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.desc = desc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}