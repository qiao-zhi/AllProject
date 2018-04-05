package com.thinkPro.steap.common;

/**
 * 实现Word转换成PDF
 * @author yachao
 *
 */
public class WordToPDF {
	private static WordToPDF2 wtpByOffice;
	private static WTPByWPS wtpByWPS;
	
	public synchronized static boolean convert(String wordFileName, String PDFFileName) throws Exception {
		boolean result = false;
		try {
			wtpByWPS = new WTPByWPS();
			result = wtpByWPS.convert(wordFileName, PDFFileName);
			if(!result) {
				wtpByOffice = new WordToPDF2();
				result = wtpByOffice.wordToPDF(wordFileName, PDFFileName);
			}
		} catch(Exception ex) {
			result = false;
			return result;
		}
		return result;
	}
}