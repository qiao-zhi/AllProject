package cn.qlq.jd.dao;


import java.util.List;

import cn.qlq.jd.pojo.ProductModel;


public interface JdDao {
	
	
	//// 通过上面四个条件查询对象商品结果集
	public List<ProductModel> selectProductModelListByQuery(String queryString, String catalog_name,
			String price,String sort) throws Exception ;

}
