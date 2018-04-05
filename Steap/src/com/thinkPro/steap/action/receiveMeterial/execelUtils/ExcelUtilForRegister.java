package com.thinkPro.steap.action.receiveMeterial.execelUtils;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.thinkPro.steap.bean.project.Project;

public class ExcelUtilForRegister {

	
	public static HSSFWorkbook exportExcel(String[] header, String sheetName, List<Project> projects) throws Exception {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet();
		wb.setSheetName(0, sheetName, HSSFWorkbook.ENCODING_UTF_16);
		
		HSSFRow row = sheet.createRow(0);
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		for(int i = 0; i < header.length; i++) {
			HSSFCell cell = row.createCell((short) i);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(header[i]);
			cell.setCellStyle(style);
		}
		
		int size = projects.size();
		Project project;
		for(int i = 0; i < size; i++) {
			row = sheet.createRow(i + 1);
			project = projects.get(i);
			HSSFCell[] cell = new HSSFCell[header.length];
			
			for(int j = 0 ; j < header.length; j++) {
				cell[j] = row.createCell((short) j);
				cell[j].setEncoding(HSSFCell.ENCODING_UTF_16);
				cell[j].setCellStyle(style);
			}
			
			cell[0].setCellValue(project.getProjectName() + "");
			cell[1].setCellValue(project.getProjectId() + "");
			cell[2].setCellValue(project.getApplicant() + "");
			cell[3].setCellValue(project.getDomain()+ "");
			cell[4].setCellValue(project.getApplicationDate() + "");
			cell[5].setCellValue(project.getContactPerson() + "");
			cell[6].setCellValue(project.getTelephone() + "");
			
		}
		return wb;
	}		

}
