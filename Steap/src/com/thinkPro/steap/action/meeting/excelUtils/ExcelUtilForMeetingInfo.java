package com.thinkPro.steap.action.meeting.excelUtils;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.thinkPro.steap.bean.meeting.Meeting;

public class ExcelUtilForMeetingInfo {
	
	public static HSSFWorkbook exportExcel(String[] header, String sheetName, List<Meeting> meetingList) throws Exception {
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
		
		int size = meetingList.size();
		Meeting meeting;
		for(int i = 0; i < size; i++) {
			row = sheet.createRow(i + 1);
			meeting= meetingList.get(i);
			HSSFCell[] cell = new HSSFCell[header.length];
			
			for(int j = 0 ; j < header.length; j++) {
				cell[j] = row.createCell((short) j);
				cell[j].setEncoding(HSSFCell.ENCODING_UTF_16);
				cell[j].setCellStyle(style);
			}
			
			cell[0].setCellValue(meeting.getMeetingName() + "");
			cell[1].setCellValue(meeting.getMeetingPlace() + "");
			cell[2].setCellValue(meeting.getMeetingStatus() + "");
			cell[3].setCellValue(meeting.getMeetingTime()+ "");
			
			
		}
		return wb;
	}		
}
