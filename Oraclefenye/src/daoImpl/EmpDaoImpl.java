package daoImpl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import bean.Emp;
import dao.Empdao;
import utils.DataSourceUtils;
/**
 * 员工管理模块
* @author: qlq
* @date :  2017年7月14日上午9:59:51
* @description:Empdao的实现类
 */

public class EmpDaoImpl implements Empdao {

	/**
	 * 获取总的记录数
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int findAllRecord() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "SELECT COUNT(ID) FROM EMP";
		@SuppressWarnings({ "unused", "rawtypes" })
		BigDecimal bg  = qr.query(sql, new ScalarHandler());
		return bg.intValue();
	}

	/**
	 * 获取分页记录
	 */
	@Override
	public List<Emp> findAllRecord(int start, int end) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = " select xx.id,xx.name,xx.hiredate "+
		" from (select rownum xid,emp.* from emp where rownum<?) xx where  xid>?";		
		Object[]  paras={end,start};
		return qr.query(sql, new BeanListHandler<Emp>(Emp.class), paras);
	}
	@Test
	public void test1() throws SQLException{
		EmpDaoImpl eDaoImpl = new EmpDaoImpl();
		try {
			System.out.println("共有"+eDaoImpl.findAllRecord()+"条记录");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("取第2页数据------------------");
		try {
			System.out.println(eDaoImpl.findAllRecord(5, 11));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
