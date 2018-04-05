import javax.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetHttpHeadInfo
 */
@WebServlet("/GetHttpHeadInfo")
public class GetHttpHeadInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetHttpHeadInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//设置响应内容
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();		
		String title="获取头信息";
		String docType="<!DOCTYPE html>";
		out.println(docType+"<html>\n"+
		"<head>\n"+
		"<title>\n"+title+"</title>\n"+
		"<meta charset=\"UTF-8\">"+
		"</head>\n"+
		"<body>\n"+"试试能不能输出参数信息"+
		"<table width=\"100%\" border=\"1\" align=\"center\">\n" +
		"<tr bgcolor=\"#949494\">\n" +
		"<th>Header 名称</th><th>Header 值</th>\n"+
		"</tr>\n");
		Enumeration headerNames=request.getHeaderNames();
		while(headerNames.hasMoreElements()){
			String parameName=(String) headerNames.nextElement();
			out.println("<tr><td>"+parameName+"</td>\n");
			String paraValue=(String)request.getHeader(parameName);
			out.println("<td>"+paraValue+"</td>\n");
					}
		
		out.println("</table>\n</body></html>");
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);    //默认自动调用get方法
	}

}
