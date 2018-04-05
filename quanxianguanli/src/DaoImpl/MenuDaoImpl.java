package DaoImpl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import Bean.Menu;
import Bean.Role;
import Bean.RoleMenu;
import Dao.MenuDao;
import Utils.DataSourceUtils;

public class MenuDaoImpl implements MenuDao{

	@Override
	public List<Menu> findMenuByRoleMenu(List<RoleMenu> list) throws Exception {
		List<Menu> list1 = null;
//		SELECT * FROM menu WHERE menuid IN (1,2,5,3,4,6)
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		StringBuilder sql = new StringBuilder("SELECT * FROM menu WHERE menuid IN (");
		for(RoleMenu roleMenu:list){
			sql.append(roleMenu.getMenuId()+",");
		}
//		拼接字符串，批量查询
		String sql1 = sql.substring(0, sql.length()-1).toString();
		list1 = runner.query(sql1+")",new BeanListHandler<Menu>(Menu.class));
		return list1;
	}

}
