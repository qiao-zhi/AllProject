package com.thinkPro.steap.common;

import java.util.ResourceBundle;

public class CommonTools {
	private static ResourceBundle rs;
	
	/**
	 * 获取文件的新名称
	 * @param fileName 文件名
	 * @return 文件新生成的名称
	 */
	public static String getNewFileName(String fileName) {
		StringBuffer newFileName = new StringBuffer();
		String extension = fileName.substring(fileName.lastIndexOf('.'));
		newFileName.append(UUIDUtil.getUUID());
		newFileName.append(extension);
		return newFileName.toString();
	}
	
	/**
	 * 
	 * @param fileName
	 * @return
	 */
	
	public static String getSignatureFullPath(String fileName) {
		rs = ResourceBundle.getBundle("path");
		String realPath = rs.getString("signatureFile");
		return realPath + "/" +  fileName; 
	}
	
	public static String getOldSignatureName(String fileName) {
		fileName = fileName.substring(fileName.indexOf("/"));
		return fileName;
	}
	
	public static String getPromiseFileFullPath(String fileName) {
		rs = ResourceBundle.getBundle("path");
		String realPath = rs.getString("promiseFile");
		return realPath + "/" +  fileName; 
	}
	
	public static String getPromiseFileFullPath() {
		rs = ResourceBundle.getBundle("path");
		String realPath = rs.getString("promiseFile");
		return realPath;
	}
	
	public static String getSevenMaterial(String fileName) {
		rs = ResourceBundle.getBundle("path");
		String realPath = rs.getString("sevenMaterial");
		return realPath + "/" +  fileName; 
	}
	
	public static String getSevenMaterial() {
		rs = ResourceBundle.getBundle("path");
		String realPath = rs.getString("sevenMaterial");
		return realPath;
	}
	
	public static String getSevenMaterialPdf(String fileName) {
		rs = ResourceBundle.getBundle("path");
		String realPath = rs.getString("sevenMaterialPdf");
		return realPath + "/" +  fileName; 
	}
	
	public static String getSevenMaterialPdf() {
		rs = ResourceBundle.getBundle("path");
		String realPath = rs.getString("sevenMaterialPdf");
		return realPath;
	}
	
	public static String getinvestigatePictureFullPath(String fileName) {
		rs = ResourceBundle.getBundle("path");
		String realPath = rs.getString("investigatePicture");
		return realPath + "/" +  fileName; 
	}
	
	public static String getInvestigatePictureFullPath() {
		rs = ResourceBundle.getBundle("path");
		String realPath = rs.getString("investigatePicture");
		return realPath;
	}
	
	public static String getauditPictureFullPath(String fileName) {
		rs = ResourceBundle.getBundle("path");
		String realPath = rs.getString("auditPicture");
		return realPath + "/" +  fileName; 
	}
	
	public static String getAuditPictureFullPath() {
		rs = ResourceBundle.getBundle("path");
		String realPath = rs.getString("auditPicture");
		return realPath;
	}
	
	public static String getperfectMaterialFullPath(String fileName) {
		rs = ResourceBundle.getBundle("path");
		String realPath = rs.getString("perfectMaterial");
		return realPath + "/" +  fileName;
	}
	
	public static String getPerfectmaterialFullPath() {
		rs = ResourceBundle.getBundle("path");
		String realPath = rs.getString("perfectMaterial");
		return realPath;
	}
	
	public static String getsignatureBackupFile(String fileName) {
		rs = ResourceBundle.getBundle("path");
		String realPath = rs.getString("signatureBackupFile");
		return realPath + "/" +  fileName; 
	}
	
	public static String getSignatureBackupFile() {
		rs = ResourceBundle.getBundle("path");
		String realPath = rs.getString("signatureBackupFile");
		return realPath;
	}
	
	public static String getPerfectMaterialPDFPath(String fileName) {
		rs = ResourceBundle.getBundle("path");
		String realPath = rs.getString("perfectMaterialPDF");
		return realPath + "/" +  fileName; 
	}
	
	public static String getauditReprtFullPath(String fileName) {
		rs = ResourceBundle.getBundle("path");
		String realPath = rs.getString("auditReprt");
		return realPath + "/" +  fileName; 
	}
	
	public static String getPerfectMaterialPDFFullPath() {
		rs = ResourceBundle.getBundle("path");
		String realPath = rs.getString("perfectMaterialPDF");
		return realPath;
	}
	
	public static String getAuditReportWordAndPdf(String fileName) {
		rs = ResourceBundle.getBundle("path");
		String realPath = rs.getString("auditReportWordAndPdf");
		return realPath+ "/" +  fileName ; 
	}
	
	
	
}
