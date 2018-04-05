package cn.qlq.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class testCMD {

	@Test
	public void ww() throws IOException{
		List<String> command = new ArrayList<String>();
		ProcessBuilder pb = new ProcessBuilder(command);
//		pb.directory(new File("E:\\酷狗\\KGMusic"));
		System.out.println(pb.directory());
		command.add( "E:\\酷狗\\KGMusic/KuGou.exe" );
//		command.add( "C:/Users/liqiang/Desktop/1.bat" );
		System.out.println(111);
		Map map = pb.environment();   //返回该进程映射视图
		System.out.println(map);
		Process p = pb.start();
	}
}
