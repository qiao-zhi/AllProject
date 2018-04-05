package Action.Excel2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.jdom.Attribute;
import org.jdom.Element;

import bean.Question;

public class GenerateExcelPaper {
	/**
	 * 将List<Question>导出到Excel
	 *@param list  数据
	 *@param fileName   导出文件名字
	 */
	public static void exportExcelPaper(List<Question> list,String fileName) {
		// 标题
		String[] title = { "题目", "类型", "A选项", "B选项", "C选项", "D选项", "答案", "解析" };
		// 创建一个工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 创建一个工作表sheet
		HSSFSheet sheet = workbook.createSheet();
		// 设置列宽
		setColumnWidth(sheet, 8);
		// 创建第一行
		HSSFRow row = sheet.createRow(0);
		// 创建一个单元格
		HSSFCell cell = null;
		// 创建表头
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			// 设置样式
			HSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 设置字体居中
			// 设置字体
			HSSFFont font = workbook.createFont();
			font.setFontName("宋体");
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 字体加粗
			// font.setFontHeight((short)12);
			font.setFontHeightInPoints((short) 13);
			cellStyle.setFont(font);
			cell.setCellStyle(cellStyle);

			cell.setCellValue(title[i]);
		}

		// 模拟数据
		/*List<Question> list = new ArrayList<>();
		list.add(new Question("你喜欢吃什么", "单选", "老司机", "方便吗", "辣条", "牛奶", "老司机", "我是老司机"));
		list.add(new Question("你喜欢吃什么", "单选", "老司机", "方便吗", "辣条", "牛奶", "老司机", "我是老司机"));
		list.add(new Question("你喜欢吃什么", "单选", "老司机", "方便吗", "辣条", "牛奶", "老司机", "我是老司机"));
		list.add(new Question("你喜欢吃什么", "单选", "老司机", "方便吗", "辣条", "牛奶", "老司机", "我是老司机"));
		list.add(new Question("你是人", "判断", "", "", "", "", "是", "我是老司机"));
		list.add(new Question("你是人", "判断", "", "", "", "", "是", "我是老司机"));*/
		System.out.println(list);
		// 从第二行开始追加数据
		for (int i = 1; i < (list.size() + 1); i++) {
			// 创建第i行
			HSSFRow nextRow = sheet.createRow(i);
			for (int j = 0; j < 8; j++) {
				Question eQuestion = list.get(i-1);
				HSSFCell cell2 = nextRow.createCell(j);
				if (j == 0) {
					cell2.setCellValue( eQuestion.getTimu());
				}
				if (j == 1) {
					cell2.setCellValue(eQuestion.getLeixing());
				}
				if (j == 2) {
					cell2.setCellValue(eQuestion.getAxuanxiang());
				}
				if (j == 3) {
					cell2.setCellValue(eQuestion.getBxuanxiang());
				}
				if (j == 4) {
					cell2.setCellValue(eQuestion.getCxuanxiang());
				}
				if (j == 5) {
					cell2.setCellValue(eQuestion.getDxuanxiang());
				}
				if (j == 6) {
					cell2.setCellValue(eQuestion.getDaan());
				}
				if (j == 7) {
					cell2.setCellValue(eQuestion.getJiexi());
				}
			}
		}

		// 创建一个文件"E:/1.xls"
		File file = new File(fileName);
		try {
			file.createNewFile();
			// 打开文件流
			FileOutputStream outputStream = FileUtils.openOutputStream(file);
			workbook.write(outputStream);
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 设置列宽()
	private static void setColumnWidth(HSSFSheet sheet, int colNum) {
		for (int i = 0; i < colNum; i++) {
			int v = 0;
			v = Math.round(Float.parseFloat("15.0") * 37F);
			v = Math.round(Float.parseFloat("20.0") * 267.5F);
			sheet.setColumnWidth(i, v);
		}
	}

}
