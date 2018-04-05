package Service;

import java.util.List;

import Bean.Menu;
import Bean.RoleMenu;
import Bean.User;
import Bean.UserRole;

public interface MenuService {
	/**
	 * 根据角色功能查询用户所具有的功能
	 *@param list
	 *@return
	 *@throws Exception 
	 *@throws
	 */
	public List<Menu> findMenuByRoleMenu(List<RoleMenu> list) throws Exception;

}
