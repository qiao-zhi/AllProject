package ws.qlq.a;

import javax.jws.WebService;

/**
 * 面向接口的webservice发布方式
 * 
 * 
 */
@WebService
public interface JobService {
	public String getJob();
}
