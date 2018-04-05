package cn.qlq.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import cn.qlq.Dao.UserDao;
import cn.qlq.bean.User;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

/*	private JdbcTemplate jt;
	
	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
*/
	@Override
	public void save(User u) {
		String sql = "INSERT INTO `spring`.`t_user` (`id`, `name`) VALUES (null, ?)";
		super.getJdbcTemplate().update(sql, u.getName());
	}

	@Override
	public void deleteById(int i) {
		String sql = "delete from `spring`.`t_user` where id=?";
		super.getJdbcTemplate().update(sql, i);
	}

	@Override
	public void update(User u) {
		String sql = "update  t_user set name=? where id=?";
		super.getJdbcTemplate().update(sql, u.getName(),u.getId());
	}

	@Override
	public User findById(int id) {
		String sql = "select * from t_user where id=?";
		return 	super.getJdbcTemplate().queryForObject(sql, new RowMapper<User>(){
	
				@Override
				public User mapRow(ResultSet rs, int arg1) throws SQLException {
					User u = new User();
					u.setId(rs.getInt("id"));
					u.setName(rs.getString("name"));
					return u;
				}
				
			}, id);
			
	}

	@Override
	public List<User> findAll() {
		String sql = "select * from t_user ";
		List<User> list = super.getJdbcTemplate().query(sql, new RowMapper<User>(){
	
				@Override
				public User mapRow(ResultSet rs, int arg1) throws SQLException {
					User u = new User();
					u.setId(rs.getInt("id"));
					u.setName(rs.getString("name"));
					return u;
				}
				
			});  //可变参数可以是零个
		return list;
		
	}

	@Override
	public int getTotalCount() {
		String sql = "select count(*) from t_user ";
		Integer total = super.getJdbcTemplate().queryForObject(sql, Integer.class);
		return total;
		
	}

}
