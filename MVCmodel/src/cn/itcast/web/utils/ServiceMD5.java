package cn.itcast.web.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class ServiceMD5 {

	/*********对密码进行加密*****/
	public static String md5(String str) {
		
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("md5");
			byte md5[]=md.digest(str.getBytes());
			BASE64Encoder base=new BASE64Encoder();
			return base.encode(md5);
		} catch (NoSuchAlgorithmException e) {
         throw new RuntimeException();
		}

	}
	
	
	
	
	
	
	
}
