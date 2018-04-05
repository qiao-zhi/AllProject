package serviceImpl;

import java.util.List;

import org.junit.Test;

import bean.Emp;
import daoImpl.EmpDaoImpl;
import service.EmpService;
import utils.Page;

public class EmpServiceImpl implements EmpService {

	private EmpDaoImpl edi = new EmpDaoImpl(); 
	/**
	 * @return一页的数据
	 * @param currentPage:代表当前页号
	 */
	@Override
	public Page show(int currentPage) throws Exception {
		Page<Emp> page = new Page<Emp>();
//		当前页
		page.setCurrentPage(currentPage);
//		页大小
		Integer pageSize = 5;
		page.setPageSize(pageSize);
//		总记录数
		Integer totalRecord = edi.findAllRecord();
		page.setTotalRecord(totalRecord);
//		总页数
		Integer totalPage=null;
		if(totalRecord % pageSize==0){
			totalPage = totalRecord / pageSize;
		}else{
			totalPage = totalRecord / pageSize+1;
		}
		page.setTotalPage(totalPage);
//		页数据
		Integer start = pageSize*(currentPage-1);
		Integer end = pageSize*currentPage+1;
		List<Emp> list = edi.findAllRecord(start, end);
		page.setList(list);
		
		
		return page;
	}
	@Test
	public void fn1() throws Exception{
		EmpServiceImpl empServiceImpl=new EmpServiceImpl();
		Page page=null;
		List<Emp> list = null;
		page  = empServiceImpl.show(1);
		System.out.println("---------------------------------第一页-----------");
		list = page.getList();
		for(Emp e:list){
			System.out.println(e);
		}
		page  = empServiceImpl.show(2);
		System.out.println("---------------------------------第2页-----------");
		list = page.getList();
		for(Emp e:list){
			System.out.println(e);
		}
		page  = empServiceImpl.show(3);
		System.out.println("---------------------------------第3页-----------");
		list = page.getList();
		for(Emp e:list){
			System.out.println(e);
		}
		page  = empServiceImpl.show(4);
		System.out.println("---------------------------------第4页-----------");
		list = page.getList();
		for(Emp e:list){
			System.out.println(e);
		}
		
		
		
	}

}
