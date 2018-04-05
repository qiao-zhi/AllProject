package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import service.EmpService;
import serviceImpl.EmpServiceImpl;
import utils.Page;

/**
 * @author liqiang  
 * @version 创建时间：2017年7月14日  上午11:37:44
 * tags
 */
@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
//		获取当前页号
			String pageNum = request.getParameter("page");
			Integer currentNum=null;
			if(pageNum==null||pageNum==""){
				currentNum=1;
			}
			else {
				currentNum=Integer.valueOf(pageNum);
			}
			System.out.println(currentNum);
			//		获取分页数据
			EmpService eService = new EmpServiceImpl();
			Page page = eService.show(currentNum);
			//创建Map集合
			Map<String,Object> map = new LinkedHashMap<String,Object>();
			map.put("total",page.getTotalRecord());
			map.put("rows",page.getList());
			
			//使用第三方工具将map转成json文本
			JSONArray jsonArray = JSONArray.fromObject(map);
			String jsonJAVA = jsonArray.toString();
			
			//去掉二边的空格
			jsonJAVA = jsonJAVA.substring(1,jsonJAVA.length()-1);
			System.out.println("jsonJAVA=" + jsonJAVA);
			
			//以字符流的方式，将json字符串输出到客户端
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter pw = response.getWriter();
			pw.write(jsonJAVA);
			pw.flush();
			pw.close();
			
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}