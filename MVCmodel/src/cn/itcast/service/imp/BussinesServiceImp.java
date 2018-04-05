package cn.itcast.service.imp;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.imp.UserDaoImp;
import cn.itcast.domain.User;
import cn.itcast.exception.UserExistException;
import cn.itcast.service.BussinessService;
import cn.itcast.web.utils.ServiceMD5;

public class BussinesServiceImp implements BussinessService {
    
	private UserDao dao=new UserDaoImp();
	
	
	//Ϊweb���ṩ��¼����,�û������ھ�ע�ᣬ���ھ���һ���û������쳣
	public void register(User user) throws UserExistException {
		//���ж��û��Ƿ����
		boolean b=dao.find(user.getUsername());
		if(b){//�û����ڣ���һ���û��Ѿ������쳣
		throw new UserExistException();//�����û��Ѿ����ڣ����û�һ������ʱ�쳣������web�㴦������쳣�����û�һ���Ѻ���ʾ
		}else{//�û�������
		user.setPassword(ServiceMD5.md5(user.getPassword()));
		dao.add(user);
		}
		
		
	}
	
	public User login(String username,String password) {
		password=ServiceMD5.md5(password);
        return dao.find(username, password);
	}
	
	
}
