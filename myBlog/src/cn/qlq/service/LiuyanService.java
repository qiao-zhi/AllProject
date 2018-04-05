package cn.qlq.service;

import java.sql.SQLException;
import java.util.Map;

import cn.qlq.bean.Liuyan;
import cn.qlq.utils.PageBean;

/**
 * 留言板service
 * 
 * @author: qlq
 * @date : 2017年10月2日上午9:20:06
 */
public interface LiuyanService {

	/**
	 * 增加留言
	 * 
	 * @param liuyan
	 * @return
	 * @throws SQLException
	 */
	public boolean addLiuyan(Liuyan liuyan) throws SQLException;

	/**
	 * 分页显示留言内容
	 * 
	 * @param condition
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Liuyan> getPageBeanPage(Map condition) throws SQLException;

}
