package ws.myWebService;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * 手机的业务类，该业务类通过webservice 对外提供服务 1. 声明： @webservice 2. 发布 EndPoint
 */
@WebService
public class PhoneService {

	public Phone getPhoneInfo(String phoneName) {
		Phone phone = new Phone();
		if (phoneName != null && "android".equals(phoneName)) {
			phone.setPhoneName("android");
			phone.setOwner("google");
			phone.setTotal(80);
		} else if (phoneName != null && "ios".equals(phoneName)) {
			phone.setPhoneName("ios");
			phone.setOwner("apple");
			phone.setTotal(15);
		} else {
			phone.setPhoneName("windows phone");
			phone.setOwner("microsoft");
			phone.setTotal(5);
		}
		return phone;
	}

	public static void main(String[] args) {
		// 发布的两个地址
		String address1 = "http://127.0.0.1/ws/phoneService";
		String address2 = "http://127.0.0.1:8888/ws/phoneManager";
		/**
		 * 发布webservice服务 1.address：服务的地址 2：implementor 服务的实现对象
		 */
		Endpoint.publish(address1, new PhoneService());
		Endpoint.publish(address2, new PhoneService());
		System.out.println("wsdl地址 :" + address1 + "?WSDL");
	}

}
