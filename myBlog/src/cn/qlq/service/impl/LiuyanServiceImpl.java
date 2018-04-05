package cn.qlq.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qlq.bean.Liuyan;
import cn.qlq.bean.LiuyanExample;
import cn.qlq.mapper.LiuyanCustomMapper;
import cn.qlq.mapper.LiuyanMapper;
import cn.qlq.service.LiuyanService;
import cn.qlq.utils.PageBean;
@Service
public class LiuyanServiceImpl implements LiuyanService {

	@Autowired
	private LiuyanMapper liuyanMapper;
	@Autowired
	private LiuyanCustomMapper liuyanCustomMapper;

	@Override
	public boolean addLiuyan(Liuyan liuyan) throws SQLException {
		int result = liuyanMapper.insert(liuyan);
		return result > 0 ? true : false;
	}

	@Override
	public PageBean<Liuyan> getPageBeanPage(Map condition) throws SQLException {
		// 目的：就是想办法封装一个PageBean 并返回
		PageBean<Liuyan> pageBean = new PageBean();
		// 1、当前页private int currentPage;
		int currentPage = (int) condition.get("currentPage");
		pageBean.setCurrentPage(currentPage);
		// 2、当前页显示的条数private int currentCount;
		int currentCount = (int) condition.get("currentCount");
		pageBean.setCurrentCount(currentCount);
		// 3、总条数private int totalCount;
		// 统计总数
		LiuyanExample liuyanExample = new LiuyanExample();
		LiuyanExample.Criteria criteria = liuyanExample.createCriteria();
		int totalCount = liuyanMapper.countByExample(liuyanExample);
		pageBean.setTotalCount(totalCount);
		// 4、总页数private int totalPage;
		/*
		 * 总条数 当前页显示的条数 总页数 10 4 3 11 4 3 12 4 3 13 4 4
		 * 
		 * 公式：总页数=Math.ceil(总条数/当前显示的条数)
		 * 
		 */
		int totalPage = (int) Math.ceil(1.0 * totalCount / (int) condition.get("currentCount"));
		pageBean.setTotalPage(totalPage);
		// 5、每页显示的数据private List<T> productList = new ArrayList<T>();
		/*
		 * 页数与limit起始索引的关系 例如 每页显示4条 页数 其实索引 每页显示条数 1 0 4 2 4 4 3 8 4 4 12 4
		 * 
		 * 索引index = (当前页数-1)*每页显示的条数
		 * 
		 */
		int index = (currentPage - 1) * currentCount;

		List<Liuyan> userList = liuyanCustomMapper.getAllLiuyan(condition);
		pageBean.setProductList(userList);
		return pageBean;
	}

}
