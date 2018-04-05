package cn.itcast.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.User;
import cn.itcast.exception.UserExistException;
import cn.itcast.service.BussinessService;
import cn.itcast.service.imp.BussinesServiceImp;
import cn.itcast.web.formbean.RegisterForm;
import cn.itcast.web.utils.WebUtil;

@WebServlet("/Servlet/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegisterServlet() {
       

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1.�����ݽ��кϷ���У��(formBean),�ѱ����ݷ�װ��form
		request.setCharacterEncoding("UTF-8");
		RegisterForm form=WebUtil.request2bean(request, RegisterForm.class);
		boolean isOK=form.validate();
//		System.out.println("form-------------"+form.getBirthday());
//		System.out.println("form-------------"+form.getEmail());
		//2.���У��ʧ�ܣ����ص�ע��ҳ�棬����ʧ����Ϣ
		System.out.println("У��ɹ���"+isOK);
		if(!isOK){

			request.setAttribute("form", form);
			request.getRequestDispatcher("/JSP/register.jsp").forward(request, response);
			return ;
		}
		
		//3.У��ɹ��������Servlet����ע������(��Ҫ�������ݷ�װ��User����)
		User user=new User();
		BussinessService bsi=new BussinesServiceImp();
		try {
		WebUtil.copyBean( user,form);
		System.out.println("���ƺ�User----"+user.getBirthday());
		bsi.register(user);	
		
		} catch (UserExistException e) {
			//4.���Servlet�����ɹ�ԭ�����û��Ѵ��ڣ����ص�ע�������ʾ�û�ע���û��Ѵ���
			form.getErrors().put("username", "�û����Ѵ��ڣ�");
			request.setAttribute("form", form);
			System.out.println("�û��Ѵ���ע�����������������");
			request.getRequestDispatcher("/JSP/register.jsp").forward(request, response);
			return ;			
		}catch(Exception e){
			//5.���Servlet�����ɹ�ԭ�����������⣬��ת��ȫ����Ϣҳ�棬Ϊ�û���ʾ��Ϣ��ʾ
			request.setAttribute("message", "�Բ��𣬷������ڲ������ˣ�");
			request.getRequestDispatcher("/JSP/message.jsp").forward(request, response);
			return ;
		}
		

		

				
		//6.����ɹ�����ת��ȫ��ҳ�������û�ע��ɹ�
		
		request.setAttribute("message", "<meta http-equiv='Refresh'  content='5;url="+request.getServletContext().getContextPath()+"/index.jsp' >ע��ɹ�����ҳ�潫���������ת����ҳ�����û����ת������<a href='"+request.getServletContext().getContextPath()+"/index.jsp'>��ҳ</a>");
		request.getRequestDispatcher("/JSP/message.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
