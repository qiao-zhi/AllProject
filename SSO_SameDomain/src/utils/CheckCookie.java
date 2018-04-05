package utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CheckCookie {

	public static boolean checkCookie(HttpServletRequest request) {
		Cookie cookies[] = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				// 验证是否存在cookie
				if ("ssocookie".equals(cookie.getName()) && "sso".equals(cookie.getValue()))
					return true;
			}
		}
		return false;
	}
}
