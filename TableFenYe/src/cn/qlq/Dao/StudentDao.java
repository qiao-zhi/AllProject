package cn.qlq.Dao;

import it.qlq.javabean.Pager;
import it.qlq.javabean.Student;
/****根据查询条件，查询学生分页信息
 * searchModel:风装查询条件
 * pageNum:查询第几页数据
 * pageSize:每页显示多少条数据
 * 返回查询结果
 * */
public interface StudentDao{
	public Pager<Student> findStudent(int pageNum,int pageSize);

}
