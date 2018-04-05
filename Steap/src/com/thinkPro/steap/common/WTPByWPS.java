package com.thinkPro.steap.common;

import java.io.File;

import org.apache.log4j.Logger;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Variant;

/**
 * 通过WPS实现Word文档转换成PDF
 * @author yachao
 *
 */
public class WTPByWPS {
	public static final Logger logger = Logger.getLogger(WTPByWPS.class);
	
	public static Converter newConverter(String name) {
		if("wps".equals(name)) {
			return new Wps();
		}
		return null;
	}
	
	/**
	 * 通过WPS实现Word文档转换成PDF
	 * @param word 完全名称（路径+文件名）
	 * @param pdf 完全名称 （路径+文件名）
	 * @return
	 */
	public synchronized boolean convert(String word, String pdf) {
		return newConverter("wps").convert(word, pdf);
	}
	
	private abstract static interface Converter {
		public boolean convert(String word, String pdf);
	}
	
	private static class Wps implements Converter {

		@Override
		public synchronized boolean convert(String word, String pdf) {
			File wordFile = new File(word);
			File pdfFile = new File(pdf);
			boolean convertSuccessfully = false;
			
			ActiveXComponent wps = null;
			ActiveXComponent doc = null;
			
			try {
				logger.info("启动word...");
				
				long start = System.currentTimeMillis(); 
				
				wps = new ActiveXComponent("KWPS.Application");
				doc = wps.invokeGetComponent("Documents").
						invokeGetComponent("Open", new Variant(wordFile.getAbsolutePath()));
				
				logger.info("打开文档..." + word); 
				logger.info("转换文档到PDF..." + pdf);
	            
	            if (pdfFile.exists()) {     
	                pdfFile.delete();     
	            } 
				
	            try {
					doc.invoke("SaveAs", new Variant(pdfFile.getAbsolutePath()), new Variant(17));
	                convertSuccessfully = true;
	            } catch (Exception e) {
	                logger.warn("生成PDF失败");
	                e.printStackTrace();
	            }
				
	            long end = System.currentTimeMillis();     
                logger.info("转换完成..用时：" + (end - start) + "ms.");
			} finally {
                if (doc == null) {
                    logger.info("打开文件 " + wordFile.getAbsolutePath() + " 失败");
                } else {
                    try {
                        logger.info("释放文件 " + wordFile.getAbsolutePath());
                        doc.invoke("Close");
                        doc.safeRelease();
                    } catch (Exception e1) {
                        logger.info("释放文件 " + wordFile.getAbsolutePath() + " 失败");
                    }
                }

                if (wps == null) {
                    logger.info("加载 WPS控件失败");
                } else {
                    try {
                        logger.info("释放 WPS控件");
                        wps.invoke("Quit");
                        wps.safeRelease();
                    } catch (Exception e1) {
                        logger.info("释放 WPS 控件失败");
                    }
                }
            }
			return convertSuccessfully;
		}
	}
}
