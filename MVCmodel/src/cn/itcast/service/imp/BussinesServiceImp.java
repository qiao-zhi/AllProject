package cn.itcast.service.imp;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.imp.UserDaoImp;
import cn.itcast.domain.User;
import cn.itcast.exception.UserExistException;
import cn.itcast.service.BussinessService;
import cn.itcast.web.utils.ServiceMD5;

public class BussinesServiceImp implements BussinessService {
    
	private UserDao dao=new UserDaoImp();
	
	
	//为web层提供登录服务,用户不存在就注册，存在就抛一个用户存在异常
	public void register(User user) throws UserExistException {
		//先判断用户是否存在
		boolean b=dao.find(user.getUsername());
		if(b){//用户存在，抛一个用户已经存在异常
		throw new UserExistException();//发现用户已经存在，给用户一个变异时异常，提醒web层处理这个异常，给用户一个友好提示
		}else{//用户不存在
		user.setPassword(ServiceMD5.md5(user.getPassword()));
		dao.add(user);
		}
		
		
	}
	
	public User login(String username,String password) {
		password=ServiceMD5.md5(password);
        return dao.find(username, password);
	}
	
	
}
