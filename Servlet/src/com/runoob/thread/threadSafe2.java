package com.runoob.thread;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.SingleSelectionModel;

/**
 * �̰߳�ȫ����,���ñ�дweb.xml�ļ�����ע��
 */
@WebServlet(urlPatterns = { "/threadSafe2" })
public class threadSafe2 extends HttpServlet implements SingleThreadModel{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	int i = 0;
    public threadSafe2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		
		
		//���̷߳��ʣ�this������������threadSafe
		
			
			
			i++;
			response.setCharacterEncoding("GBK");
			
//			//��һ��������������ʽ��ֻ�ܵ���ʹ�����һ��
//		response.getOutputStream().write((i+"��һ�ַ���").getBytes());
		
		try {
			Thread.sleep(1000*4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			//�ڶ��ַ�������������
			response.getWriter().write("�ڶ��ַ���\n");
			
			
			//�����ַ���������ͬ�ڶ���һ��ʹ��
	     	PrintWriter out=response.getWriter();
			out.println(i+"  "+"�̰߳�ȫ"+"�����ַ���");
			
			
		}
		
	
		
		
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
