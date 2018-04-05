
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtil {
	
	/**
	 * ����ͨ��excel���
	 * @param header
	 * @param sheetName
	 * @param dataArray
	 * @return
	 * @throws Exception
	 */
	public static HSSFWorkbook exportExcel(String[] header, String sheetName, Object[][] dataArray) throws Exception {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet();
		wb.setSheetName(0, sheetName, HSSFWorkbook.ENCODING_UTF_16);
		
		/**
		 * ��ͷ��ʽ
		 */
		HSSFRow row = sheet.createRow(0);
		HSSFCellStyle headerStyle = wb.createCellStyle();
		HSSFFont headerFont = wb.createFont();
		headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		headerStyle.setFont(headerFont);
		
		for(int i = 0; i < header.length; i++) {
			HSSFCell cell = row.createCell((short) i);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(header[i]);
			cell.setCellStyle(headerStyle);
			sheet.setColumnWidth((short)i, (short) (header[i].getBytes().length * 2 * 256));
		}
		
		/**
		 * ���������ʽ
		 */
		HSSFCellStyle bodyStyle = wb.createCellStyle();
		bodyStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		int rows = dataArray.length;
		for(int i = 0; i < rows; i++) {
			row = sheet.createRow(i + 1);
			Object[] data = dataArray[i];
			HSSFCell[] cell = new HSSFCell[header.length];
			
			for(int j = 0 ; j < header.length; j++) {
				
				cell[j] = row.createCell((short) j);
				cell[j].setEncoding(HSSFCell.ENCODING_UTF_16);
				cell[j].setCellStyle(bodyStyle);
				
				cell[j].setCellValue(data[j] + "");
			}
		}
		return wb;
	}
	
	/**
	 * ����ͨ��excel���
	 * @param header ���ı�ͷ
	 * @param headerAlias �ֶα�ͷ
	 * @param sheetName �ļ���
	 * @param dataList List<Map<String, Object>>��ʽ�Ľ��
	 * @return
	 * @throws Exception
	 */
	public static HSSFWorkbook exportExcel(String[] header, String[] headerAlias, String sheetName, List<Map<String, Object>> dataList) throws Exception {
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
		
		Object[][] dataArray = List2Array.convert(headerAlias, dataList);
		int rows = dataArray.length;
		for(int i = 0; i < rows; i++) {
			row = sheet.createRow(i + 1);
			Object[] data = dataArray[i];
			HSSFCell[] cell = new HSSFCell[header.length];
			
			for(int j = 0 ; j < header.length; j++) {
				cell[j] = row.createCell((short) j);
				cell[j].setEncoding(HSSFCell.ENCODING_UTF_16);
				cell[j].setCellStyle(style);
				
				cell[j].setCellValue(data[j] + "");
			}
		}
		return wb;
	}
}
