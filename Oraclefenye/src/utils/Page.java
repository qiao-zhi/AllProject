package utils;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {
	private Integer currentPage;  //当前页
	private Integer pageSize;     //每页条数
	private Integer totalRecord;   //总记录数
	private Integer totalPage;    //总页数
	private List<T> list = new ArrayList<T>();  //显示的数据
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public Page(){
		
	}

}
