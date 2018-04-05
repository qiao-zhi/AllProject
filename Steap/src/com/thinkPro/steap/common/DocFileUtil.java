package com.thinkPro.steap.common;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;

/**
 * 读取word文档内容
 * @author yachao
 *
 */
public class DocFileUtil {

	/**
	 * 读取word文档内容
	 * @param f
	 * @return
	 * @throws Exception
	 */
	public static String getContent(File f) throws Exception {
		FileInputStream fis = new FileInputStream(f);
		HWPFDocument doc = new HWPFDocument(fis);
		
		Range range = doc.getRange();
		String text = range.text();
		
		return text;
	}

}
