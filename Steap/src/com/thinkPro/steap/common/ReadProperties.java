package com.thinkPro.steap.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ReadProperties { 
	private String investigatePath;
	private String auditPath;

    public String getInvestigatePath() {
		return investigatePath;
	}

	public String getAuditPath() {
		return auditPath;
	}

	public ReadProperties() {

		String resources = "/path.properties";

		// 将配置文件加载单独写成一个函数，将异常处理进行封装，使代码整洁

		Properties properties = loadProperties(resources);

		// 直接用getProperty获取属性值

		this.investigatePath = properties.getProperty("investigatePicture");

		this.auditPath = properties.getProperty("auditPicture");


		}

		 

		private Properties loadProperties(String resources) {

		   // 使用InputStream得到一个资源文件

		   InputStream inputstream = this.getClass()

		         .getResourceAsStream(resources);

		   // new 一个Properties

		   Properties properties = new Properties();

		   try {

		   // 加载配置文件

		      properties.load(inputstream);

		      return properties;

		   } catch (IOException e) {

		      throw new RuntimeException(e);

		   } finally {

		      try {

		         inputstream.close();

		      } catch (IOException e) {

		         throw new RuntimeException(e);

		      }

		   }

		}
	
}