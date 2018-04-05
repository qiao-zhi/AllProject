package DaoImpl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import Bean.Role;
import Bean.RoleMenu;
import Bean.UserRole;
import Dao.RoleDao;
import Utils.DataSourceUtils;

public class RoleDaoImpl implements RoleDao{

	@Override
	public List<Role> findRoleByUserRole(List<UserRole> list) throws Exception {
		List<Role>  list1 = null;
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
//		SELECT * FROM role WHERE roleid IN (1,2)
//		查询出用户具有的权限,批量查询
		StringBuilder sql = new StringBuilder("SELECT * FROM role WHERE roleid IN (");
		for(UserRole userRole:list){
			sql.append(userRole.getRoleId()+",");
		}
		String sql1 = sql.substring(0, sql.length()-1).toString();
		list1 = runner.query(sql1+")",new BeanListHandler<Role>(Role.class));
		return list1;
	}

	@Override
	public List<RoleMenu> findRoleMenuByRole(List<Role> list) throws Exception {
		List<RoleMenu> list1=null;
//		SELECT * FROM rolemenu WHERE roleid IN (1,2)
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		StringBuilder sql = new StringBuilder("SELECT * FROM rolemenu WHERE roleid IN (");
		for(Role role:list){
			sql.append(role.getRoleId()+",");
		}
		String sql1 = sql.substring(0, sql.length()-1).toString();
		list1 = runner.query(sql1+")",new BeanListHandler<RoleMenu>(RoleMenu.class));
		return list1;
	}

}
