package it.qlq.service;

import cn.qlq.Dao.StudentDao;
import cn.qlq.Dao.StudentDaoImpl;
import it.qlq.javabean.Pager;
import it.qlq.javabean.Student;

public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;
	
	public  StudentServiceImpl() {
		//谁用服务谁创建Dao实现类
		studentDao = new StudentDaoImpl();
	}

	@Override
	public Pager<Student> findStudent( int pageNum, int pageSize) {
	
		Pager<Student> result = studentDao.findStudent(pageNum, pageSize);
		return result;
	}

}
