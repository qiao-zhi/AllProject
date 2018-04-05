package DRDCExcelTemplates;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import bean.Question;
import sun.awt.util.IdentityArrayList;

public class POIReadExcelTemplatesData {

	private static List<Question> list = new ArrayList<Question>();
	public static void main(String[] args) {
		File file = new File("e:/test.xls");
		try {
			// 获取一个工作簿
			FileInputStream openInputStream = FileUtils.openInputStream(file);
			HSSFWorkbook workbook = new HSSFWorkbook(openInputStream);
			// 获取一个工作表两种方式
			// HSSFSheet sheet = workbook.getSheet("sheet0");
			// 获取工作表的第二种方式
			// 获取第一个工作表,如果不为空读取数据
			HSSFSheet sheet = workbook.getSheet("sheet0");
			ReadSheet(sheet);
			// 获取第二个工作表,如果不为空读取数据
			HSSFSheet sheet1 = workbook.getSheet("sheet1");
			ReadSheet(sheet1);
			// 获取第三个工作表,如果不为空读取数据
			HSSFSheet sheet2 = workbook.getSheet("sheet2");
			ReadSheet(sheet2);
			for(int i =0;i<list.size();i++){
				System.out.println(list.get(i));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	
	private static void ReadSheet(HSSFSheet sheet) {
		if (sheet != null) {
			int firstRow = 0;
			// 获取sheet的最后一行
			int lastRow = sheet.getLastRowNum();
			Question question= new Question();
			for (int i = firstRow+2; i <= lastRow; i++) {
				HSSFRow row = sheet.getRow(i);
				int lastCol = row.getLastCellNum();
				System.out.println(lastCol);
//				判断是单选题还是多选题还是判断题
				if(lastCol==8){  //为单选或多选
					question.setTimu(row.getCell(0).getStringCellValue());
					question.setLeixing(row.getCell(1).getStringCellValue());
					question.setAxuanxiang(row.getCell(2).getStringCellValue());
					question.setBxuanxiang(row.getCell(3).getStringCellValue());
					question.setCxuanxiang(row.getCell(4).getStringCellValue());
					question.setDxuanxiang(row.getCell(5).getStringCellValue());
					question.setDaan(row.getCell(6).getStringCellValue());
					question.setJiexi(row.getCell(7).getStringCellValue());
					list.add(question);
					/*for (int j = 0; j < lastCol; j++) {
						HSSFCell cell = row.getCell(j);
						String value = cell.getStringCellValue();
						System.out.print(value + "  ");
					}*/
				}else{         //封装判断题
					question.setTimu(row.getCell(0).getStringCellValue());
					question.setLeixing(row.getCell(1).getStringCellValue());
					question.setDaan(row.getCell(2).getStringCellValue());
					question.setJiexi(row.getCell(3).getStringCellValue());
					list.add(question);
				}
				
			}
		}
	}
}
