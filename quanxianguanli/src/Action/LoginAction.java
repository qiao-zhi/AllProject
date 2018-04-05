package Action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import com.opensymphony.xwork2.ActionSupport;

import Bean.Menu;
import Bean.Role;
import Bean.RoleMenu;
import Bean.User;
import Bean.UserRole;
import Service.MenuService;
import Service.RoleService;
import Service.UserService;
import ServiceImpl.MenuServiceImpl;
import ServiceImpl.RoleServiceImpl;
import ServiceImpl.UserServiceImpl;

public class LoginAction extends ActionSupport {

	private String name;
	private String password;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
	/**
	 * 处理登录
	 */
	public String execute() throws Exception {
		
		System.out.println(name + "   "+password);
		UserServiceImpl us = new UserServiceImpl();
		 RoleService rs = new RoleServiceImpl();
		 MenuService ms  =new MenuServiceImpl();
		 User user = us.findUser(name, password);
		 if(user == null){
			 return "login";
		 }
		 List<UserRole> userRole = us.findRoleByUserId(user.getUserId());
		 List<Role> roles = rs.findRoleByUserRole(userRole);
		 List<RoleMenu> roleMenus = rs.findRoleMenuByRole(roles);
		 List<Menu> menus = ms.findMenuByRoleMenu(roleMenus);
		 HttpSession session = ServletActionContext.getRequest().getSession();
		 session.setAttribute("userPri", menus);
		 session.setAttribute("user", user);
		// TODO Auto-generated method stub
		return super.execute();
	}
}
