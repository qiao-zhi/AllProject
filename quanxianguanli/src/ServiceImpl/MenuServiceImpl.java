package ServiceImpl;

import java.util.List;

import Bean.Menu;
import Bean.RoleMenu;
import Dao.MenuDao;
import DaoImpl.MenuDaoImpl;
import Service.MenuService;

public class MenuServiceImpl implements MenuService{

	private MenuDao menuDao;
	
	public MenuServiceImpl() {
		menuDao = new MenuDaoImpl();
	}

	@Override
	public List<Menu> findMenuByRoleMenu(List<RoleMenu> list) throws Exception {
		return menuDao.findMenuByRoleMenu(list);
	}

}
