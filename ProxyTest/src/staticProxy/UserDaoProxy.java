package staticProxy;

/**
 * 代理对象,静态代理
 */
public class UserDaoProxy implements UserDao {
	// 接收保存目标对象
	private UserDaoImpl target;

	public UserDaoProxy(UserDaoImpl target) {
		this.target = target;
	}

	public void save() {
		System.out.println("开始事务...");
		target.save();// 执行目标对象的方法
		System.out.println("提交事务...");
	}
}