package cn.qlq.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.qlq.bean.Liuyan;

/**
 * 留言mapper
 * 
 * @author: qlq
 * @date : 2017年10月2日上午9:46:36
 */
public interface LiuyanCustomMapper {

	/**
	 * 根据条件查询留言
	 * 
	 * @param condition
	 *            条件
	 * @return
	 * @throws SQLException
	 */
	public List<Liuyan> getAllLiuyan(Map condition) throws SQLException;
}
