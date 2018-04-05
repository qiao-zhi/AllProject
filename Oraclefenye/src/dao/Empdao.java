package dao;

import java.util.List;

import bean.Emp;

/**
 * 
* @author: qlq
* @date :  2017年7月14日上午9:53:52
* @description:员工管理模块
 */
public interface Empdao {

	/**
	 * 获取总的记录数
	 * @return返回代表总的记录数
	 */
	public int findAllRecord() throws Exception;
	/**
	 * @return分批查询员工记录
	 * @param start；从第几条记录开始
	 * @param end:到第几条记录
	 */
	public List<Emp> findAllRecord(int start,int end) throws Exception;
}
