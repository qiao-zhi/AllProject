package servlet;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.Test;

public class POIExportWord {
	
	
	
	public void exportDoc(String destFile, String fileCon) {
		try {
			// doc content
			ByteArrayInputStream bais = new ByteArrayInputStream(fileCon.getBytes());
			POIFSFileSystem fs = new POIFSFileSystem();
			DirectoryEntry directory = fs.getRoot();
			directory.createDocument("WordDocument", bais);
			FileOutputStream ostream = new FileOutputStream(destFile);
			fs.writeFilesystem(ostream);
			bais.close();
			ostream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@Test
	public void test1(){
		String destFile="F:\\11.doc";
		String ssString="[题干]请在这里写题干?\n[类型]单选\n[选项]{A:请在这里写A选项},{B:请在这里写B选项},{C:请在这里写C选项},{D:请在这里写D选项}\n[答案]请在这里填写正确答案\n[解析]:在这里写解析";
		new POIExportWord().exportDoc(destFile, ssString);
	}
	
	
}