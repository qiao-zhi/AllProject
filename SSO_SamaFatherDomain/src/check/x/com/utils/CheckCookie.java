package check.x.com.utils;


public class CheckCookie {

	public static boolean checkCookie(String cookieName, String cookieValue) {
		// 验证是否存在cookie
		if ("ssocookie".equals(cookieName) && "sso".equals(cookieValue))
			return true;
		return false;
	}
}
