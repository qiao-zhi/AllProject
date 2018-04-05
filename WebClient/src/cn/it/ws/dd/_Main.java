package cn.it.ws.dd;

public class _Main {
	/**
	 * 测试自己发布的webservice
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 服务
		PhoneManager1 phoneServiceService = new PhoneManager1();
		// 访问方式
		PhoneService phoneService = phoneServiceService.getPhoneServicePort();
		Phone phoneInfo = phoneService.getMObileInfo("ios");
		System.out.println(phoneInfo.getOwner());
		System.out.println(phoneInfo.getPhoneName());
		System.out.println(phoneInfo.getTotal());
	}

}
