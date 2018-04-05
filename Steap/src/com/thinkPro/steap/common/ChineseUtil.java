package com.thinkPro.steap.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChineseUtil {

	/**
	 * 判断字符串是否纯英文
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEnglish(String str) {
		byte[] bytes = str.getBytes();
		int i = bytes.length;// i为字节长度
		int j = str.length();// j为字符长度
		boolean result = i == j ? true : false;
		return result;
	}

	 public static boolean contains(String name, String search) {  
	  
	        boolean flag = false;  
	  
	        // 简拼匹配,如果输入在字符串长度大于6就不按首字母匹配了  
	        if (search.length() < 6) {  
	            String firstLetters = ChineseConvertFrist.convertFrist(name);
	            // 不区分大小写  
	            Pattern firstLetterMatcher = Pattern.compile(search,  
	                    Pattern.CASE_INSENSITIVE);  
	            flag = firstLetterMatcher.matcher(firstLetters).find();  
	        }  
	  
	        if (!flag) { // 如果简拼已经找到了，就不使用全拼了  
	            // 全拼匹配  
	        	String allLetters = ChineseConvertAll.ConvertAll(name);
	            // 不区分大小写  
	            Pattern pattern2 = Pattern  
	                    .compile(search, Pattern.CASE_INSENSITIVE);  
	            Matcher matcher2 = pattern2.matcher(allLetters);  
	            flag = matcher2.find();  
	        }   
	        return flag;  
	    }
}
