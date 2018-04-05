package Cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//代表商品信息带Servlet

@WebServlet("/ShouYe")
public class ShouYe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ShouYe() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
		//1.显示商品的详细信息
		out.println("本网站有如下商品，欢迎阅览：<br/>");
//		out.print("<img src='/Servlet/1.jpg' alt='无法显示'/>");  //显示一张图片
		Map<String,Book> map=Db.getAll();
		//循环遍历该Map集合
		for(Map.Entry<String, Book> entry:map.entrySet()){
			Book book=entry.getValue();
			out.print("<a href='/Servlet/DetailInfo?id="+book.getId()+"' target='_blank' >"+book.getName()+"</a><br/>");
			
			
			
		}
//		2.显示用户看过的商品
		out.println("<br/>您曾经看过的书：<br/>");
		Cookie cookies[]=request.getCookies();
		for(int i=0;cookies!=null&&i<cookies.length;i++){
			if(cookies[i].getName().equals("bookHistory")){
				String[] ids=cookies[i].getValue().split("\\,");   //以逗号分隔返回来的id;    //2,3,1
			
				for(String id:ids){
					Book book=(Book)Db.getAll().get(id);   //根据id检索map中的值，返回类型为Map<e,V>的V
				    out.print(book.getName()+"<br/>");
				}
			}
			
			
			
			
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
	
	//获取所有的书籍
	public  static Map getAll(){	return map;
	}

}

class Book{
	private String id;
	private String name;
	private String author;
	private String description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Book(String id, String name, String author, String description) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.description = description;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}