package Utils.GenerateNewFileName;

import org.junit.Test;

public class TestUtils {

	@Test
	public void Test1(){
		System.out.println(FileUtils.getNewFileName("1.DOC"));
		System.out.println(FileUtils.getNewFileName("1.X.DOCX"));
		System.out.println(FileUtils.getNewFileNameWithTimeStamp("1.X.DOCX"));
		System.out.println(FileUtils.getNewFileNameWithTimeStamp("1.DOCX"));
	}
}
