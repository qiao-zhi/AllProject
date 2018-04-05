package ws.mywebservice;

public class _Main {
	/**
	 * 测试自己发布的webservice
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 服务
		PhoneServiceService phoneServiceService = new PhoneServiceService();
		// 访问方式
		PhoneService phoneService = phoneServiceService.getPhoneServicePort();
		Phone phoneInfo = phoneService.getPhoneInfo("ios");
		System.out.println(phoneInfo.getOwner());
		System.out.println(phoneInfo.getPhoneName());
		System.out.println(phoneInfo.getTotal());
	}

}
