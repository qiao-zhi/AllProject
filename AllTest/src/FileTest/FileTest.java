package FileTest;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class FileTest {
	// 测试文件
	@Test
	public void test1() throws IOException {
		String contextPath = System.getProperty("user.dir");// 获取项目名字
		System.out.println("文件路径：  " + contextPath + "/Test.txt");
		// 创建File的第一种方式
		// File file = new File(contextPath + "/Test.txt");
		// 第二种方式
		File file = new File(contextPath, "/Test.txt");
		// 判断文件是否存在，如果不存在就新创文件
		if (!file.exists()) {
			// file.delete();删除文件
			file.createNewFile();// 创建一个Text.txt文件
			System.out.println("新增文件");
		}
		System.out.println("是否是文件" + file.isFile());
		System.out.println("是否是目录" + file.isDirectory());
		// 获取文件大小(以字节为单位)
		if (file.isFile()) {
			System.out.println("文件大小:" + file.length() + "字节");
		}
		System.out.println("此文件的上级目录是" + file.getParent());
	}

	// 测试目录
	@Test
	public void test2() throws IOException {
		String contextPath = System.getProperty("user.dir");// 获取项目名字
		System.out.println("文件路径：  " + contextPath + "\\text");
		// 第一种方式
		// File file = new File(contextPath,"text");
		// 第二种
		File file = new File(contextPath, "text");
		System.out.println("文件是否存在" + file.exists());
		if (!file.exists()) {// 如果目录不存在
			file.mkdir();// 创建目录
		}
		// 判断文件是否存在，如果存在删除文件
		System.out.println("是否是文件" + file.isFile());
		System.out.println("是否是目录" + file.isDirectory());
		// 列举目录下的文件的名字
		if (file.isDirectory()) {
			File[] listFiles = file.listFiles();
			System.out.println("目录下的文件有:");
			for (File fi : listFiles) {
				// 列举文件名字与大小
				System.out.println(fi.getName() + "   大小    " + fi.length() * 1.0 / 1024 + "KB");
				// 删除文件
				System.out.println("文件将被删除");
				fi.delete();
			}
		}
		System.out.println("此文件的上级目录是" + file.getParent());
	}
}
