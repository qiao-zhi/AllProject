package ServiceImpl;

import java.util.List;

import Bean.Role;
import Bean.RoleMenu;
import Bean.UserRole;
import Dao.RoleDao;
import DaoImpl.RoleDaoImpl;
import Service.RoleService;

public class RoleServiceImpl implements RoleService{
	private RoleDao roleDao;
	

	public RoleServiceImpl() {
		roleDao = new RoleDaoImpl();
	}

	@Override
	public List<Role> findRoleByUserRole(List<UserRole> list) throws Exception {
		return roleDao.findRoleByUserRole(list);
	}

	@Override
	public List<RoleMenu> findRoleMenuByRole(List<Role> list) throws Exception {
		return roleDao.findRoleMenuByRole(list);
	}
}
