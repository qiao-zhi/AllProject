package com.thinkPro.steap.action.receiveMeterial.execelUtils;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.thinkPro.steap.bean.project.ProjectAccept;
import com.thinkPro.steap.bean.project.ProjectCensor;
import com.thinkPro.steap.bean.project.ProjectCharge;
import com.thinkPro.steap.bean.project.ProjectReceive;

public class ExcelUtilForGetMaterial {

	
	public static HSSFWorkbook exportExcel(String[] header, String sheetName, List<ProjectAccept> result) throws Exception {
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
		
		int size = result.size();
		ProjectAccept projectAccept;
		for(int i = 0; i < size; i++) {
			row = sheet.createRow(i + 1);
			projectAccept= result.get(i);
			HSSFCell[] cell = new HSSFCell[header.length];
			
			for(int j = 0 ; j < header.length; j++) {
				cell[j] = row.createCell((short) j);
				cell[j].setEncoding(HSSFCell.ENCODING_UTF_16);
				cell[j].setCellStyle(style);
			}
			
			if (projectAccept.getProjectCharge() == null) {
				ProjectCharge projectCharge = new ProjectCharge();
				projectCharge.setDestributionDate("未确定负责部门");
				projectAccept.setProjectCharge(projectCharge);
			}
			if (projectAccept.getProjectReceive() == null) {
				ProjectReceive projectReceive = new ProjectReceive();
				projectReceive.setReceiveDate("未领取验收资料");
				projectAccept.setProjectReceive(projectReceive);
			}
			if (projectAccept.getProjectCensor() == null) {
				ProjectCensor projectCensor = new ProjectCensor();
				projectCensor.setCensorDate("未审查");
				projectAccept.setProjectCensor(projectCensor);
			}
			
			cell[0].setCellValue(projectAccept.getProjectName() + "");
			cell[1].setCellValue(projectAccept.getProjectId() + "");
			cell[2].setCellValue(projectAccept.getApplicant() + "");
			cell[3].setCellValue(projectAccept.getDomain() + "");
			cell[4].setCellValue(projectAccept.getProjectRecord().getRecordDate() + "");
			cell[5].setCellValue(projectAccept.getProjectCharge().getDestributionDate() + "");
			cell[6].setCellValue(projectAccept.getProjectReceive().getReceiveDate() + "");
			cell[7].setCellValue(projectAccept.getProjectCensor().getCensorDate() + "");
			
			
		}
		return wb;
	}		

}
