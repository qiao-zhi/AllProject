package FileTest;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class FileUtilsTest {
	@Test
	public void test1() throws IOException {
		/*
		 * 写文件 1.这里只列出3种方式全参数形式，api提供部分参数的方法重载 2.最后一个布尔参数都是是否是追加模式
		 * 3.如果目标文件不存在，FileUtils会自动创建
		 */
		// static void:write(File file, CharSequence data, String encoding,
		// boolean append)
		FileUtils.write(new File("E:/EclipseWorkspace/AllTest/Test2.txt"), "程序换api", "UTF-8", true);

		// static void:writeLines(File file, Collection<?> lines, boolean
		// append)
		List<String> lines = new ArrayList<String>();
		lines.add("欢迎访问:");
		lines.add("www.cxyapi.com");
		FileUtils.writeLines(new File("E:/EclipseWorkspace/AllTest/Test2.txt"), lines, true);

		// static void:writeStringToFile(File file, String data, String
		// encoding, boolean append)
		FileUtils.writeStringToFile(new File("E:/EclipseWorkspace/AllTest/Test2.txt"), "作者：cxy", "UTF-8", true);
	}

	@Test
	public void test2() throws IOException {
		// 读文件
		// static String:readFileToString(File file, String encoding)
		System.out.println(FileUtils.readFileToString(new File("E:/EclipseWorkspace/AllTest/Test2.txt"), "UTF-8"));

		// static List<String>:readLines(File file, String encoding)
		System.out.println(FileUtils.readLines(new File("E:/EclipseWorkspace/AllTest/Test2.txt"), "UTF-8")); // 返回一个list
	}

	@Test
	public void test3() throws IOException {
		// 删除目录
		// static void:deleteDirectory(File directory)
		FileUtils.deleteDirectory(new File("E:\\EclipseWorkspace\\AllTest\\text"));

		// static boolean:deleteQuietly(File file)
		FileUtils.deleteQuietly(new File("D:/not/cxyapi")); // 文件夹不是空任然可以被删除，永远不会抛出异常
	}

	@Test
	public void test4() throws IOException {

		// 移动文件 或 文件夹
		// static void：moveDirectory(File srcDir, File destDir)
		FileUtils.moveDirectory(new File("E:/EclipseWorkspace/AllTest/Test2.txt"), new File("C:/Test2.txt")); // 注意这里
		// 第二个参数文件不存在会引发异常
		// static void:moveDirectoryToDirectory(File src, File destDir, boolean
		// createDestDir)
		FileUtils.moveDirectoryToDirectory(new File("E:/EclipseWorkspace/AllTest/Test2.txt"),
				new File("E:/EclipseWorkspace/AllTest/new/Test2.txt"), true);
		/*
		 * 上面两个方法的不同是： moveDirectory：D:/cxyapi2里的内容是D:/cxyapi1的内容。
		 * moveDirectoryToDirectory：D:/cxyapi2文件夹移动到到D:/cxyapi3里
		 * 
		 * 下面的3个都比较简单没提供示例，只提供了api 其中moveToDirectory和其他的区别是 它能自动识别操作文件还是文件夹
		 */
		// static void:moveFileToDirectory(srcFile, destDir, createDestDir)
		// static void:moveFile(File srcFile, File destFile)
		// static void:moveToDirectory(File src, File destDir, boolean
		// createDestDir) }
	}

	@Test
	public void test5() throws IOException {

		// 结果是cxyapi和cxyapi1在同一目录
//		FileUtils.copyDirectory(new File("D:/cxyapi"), new File("D:/cxyapi1"));
		// 结果是将cxyapi拷贝到cxyapi2下
//		FileUtils.copyDirectoryToDirectory(new File("D:/cxyapi"), new File("D:/cxyapi2"));

		// 拷贝文件
//		FileUtils.copyFile(new File("d:/cxyapi.xml"), new File("d:/cxyapi.xml.bak"));
		// 拷贝文件到目录中
		FileUtils.copyFileToDirectory(new File("E:/EclipseWorkspace/AllTest/Test.txt"), new File(":\\"));
		// 拷贝url到文件
		FileUtils.copyURLToFile(new URL("http://www.cnblogs.com/qlqwjy/p/7183856.html"), new File("C:\\www.html"));
	}
}