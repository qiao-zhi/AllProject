package ws.qlq.a;


import javax.jws.WebService;

@WebService(endpointInterface="ws.qlq.a.JobService")//设置服务端点接口 ，指定对外提供服务的接口
public class JobServiceImpl implements JobService {

	@Override
	public String getJob() {
		return "JEE研发工程师|Android研发工程师|数据库工程师|前端工程师|测试工程师|运维工程师";
	}
    public void say(){
    	System.out.println("早上好!");
    }
}
