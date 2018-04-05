package service;


import utils.Page;

public interface EmpService {
	/**
	 * 根据页号获取该页需要显示的内容
	 * @param currentPage 当前页号
	 * @return 封装该页需要显示的内容 
	 */
	public Page show(int currentPage) throws Exception;
	
}
