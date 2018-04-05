import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.coyote.http11.filters.VoidInputFilter;
import org.apache.log4j.Logger;
import org.junit.Test;
public class Log4jDemo {
	@Test
	public void test1(){
//		获得log4j对象
		Logger logger = Logger.getLogger(Log4jDemo.class);
		FileReader fileReader = null;
		try {
			fileReader=new FileReader("log4j.properties");
			logger.info("begain to read!!!!!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.fatal("这是fatal");
			logger.error(e.getMessage(),e);
			logger.error("系统找不到指定文件");
			logger.warn("这是警告！");
			logger.info("这是信息！！！");
//			debug经常用于调试程序
			logger.debug("这是debug！！！");
		}
		try {
			fileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("file not find", e);
		}
	}
	
	@Test
	public void test2(){
		Logger logger = Logger.getLogger(Log4jDemo.class);
		logger.debug("进来了");
	}
	

	public String vv(int ii,String ww){
		return ww;
		
		
	}
}
