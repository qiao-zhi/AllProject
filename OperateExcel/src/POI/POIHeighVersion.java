package POI;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class POIHeighVersion {
	public static void main(String[] args) {
		String[] title = {"id","name","sex"};
//		创建一个工作簿
		XSSFWorkbook workbook = new XSSFWorkbook();
//		创建一个工作表sheet
		Sheet sheet = workbook.createSheet();
//		创建第一行
		Row row = sheet.createRow(0);
//		创建一个单元格
		Cell cell = null;
//		创建表头
		for(int i=0;i<title.length;i++){
			cell=row.createCell(i);
			cell.setCellValue(title[i]);
		}
//		从第二行开始追加数据
		for(int i=1;i<=10;i++){
//			创建第i行
			Row nextRow = sheet.createRow(i);
//			参数代表第几列
			Cell cell2 = nextRow.createCell(0);
			cell2.setCellValue("a"+i);
			cell2 = nextRow.createCell(1);
			cell2.setCellValue("user"+i);
			cell2 = nextRow.createCell(2);
			cell2.setCellValue("男");
		}
//		创建一个文件
		File file = new File("E:/POI_TEST.xlsx");
		try {
			file.createNewFile();
//			打开文件流
			FileOutputStream outputStream = FileUtils.openOutputStream(file);
			workbook.write(outputStream);
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
