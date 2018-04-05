package DRDCExcelTemplates.DCExcelPaper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Iterator;


import javax.swing.filechooser.FileSystemView;


import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class PrintExcel {
	public static void main(String[] args) {
		String data = "{'data':[{'名称':'2单元抽屉左侧板','部件编码':'8GCS.050.1159XD','柜体型号':'低电压配电柜','外购/自产':'自产','数量':'1','加工时间':'40','所属生产线':'钣金生产线（产线一)'},{'名称':'抽屉隔板','部件编码':'ctgb','柜体型号':'低电压配电柜','外购/自产':'自产','数量':'8','加工时间':'90','所属生产线':'钣金生产线（产线一)'},{'名称':'RC4-13二次动插件','部件编码':'RC4-13','柜体型号':'低电压配电柜','外购/自产':'外购','数量':'1','加工时间':'null','所属生产线':'钣金生产线（产线一)'}]}";
		print(data, "a");
		}

	public static void print(String data, String name) {
		System.out.println(data);
		JSONObject jsonObject = JSONObject.fromObject(data);
		// 将函数调用的结果返回给result
		// 保存路径要改！！！！
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File path = fsv.getHomeDirectory();
		String desktoppath = path.getPath();
		JSONObject result = Excel.createExcel(desktoppath + "\\" + name + ".xls", jsonObject);
		// 输出结果
		System.out.println(result);
	}
}

class Excel {
	@SuppressWarnings("unchecked")
	// 创建excel文件函数
	// src为待保存的文件路径,json为待保存的json数据
	public static JSONObject createExcel(String src, JSONObject json) {
		JSONObject result = new JSONObject(); // 用来反馈函数调用结果
		try {
			// 新建文件
			File file = new File(src);
			file.createNewFile();

			OutputStream outputStream = new FileOutputStream(file);// 创建工作薄
			WritableWorkbook writableWorkbook = Workbook.createWorkbook(outputStream);
			WritableSheet sheet = writableWorkbook.createSheet("First sheet", 0);// 创建新的一页

			JSONArray jsonArray = json.getJSONArray("data");// 得到data对应的JSONArray
			Label label; // 单元格对象
			int column = 0; // 列数计数

			// 将第一行信息加到页中。如：姓名、年龄、性别
			JSONObject first = jsonArray.getJSONObject(0);
			Iterator<String> iterator = first.keys(); // 得到第一项的key集合
			while (iterator.hasNext()) { // 遍历key集合
				String key = (String) iterator.next(); // 得到key
				label = new Label(column++, 0, key); // 第一个参数是单元格所在列,第二个参数是单元格所在行,第三个参数是值
				sheet.addCell(label); // 将单元格加到页
			}

			// 遍历jsonArray
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject item = jsonArray.getJSONObject(i); // 得到数组的每项
				iterator = item.keys(); // 得到key集合
				column = 0;// 从第0列开始放
				while (iterator.hasNext()) {
					String key = iterator.next(); // 得到key
					String value = item.getString(key); // 得到key对应的value
					label = new Label(column++, (i + 1), value); // 第一个参数是单元格所在列,第二个参数是单元格所在行,第三个参数是值
					sheet.addCell(label); // 将单元格加到页
				}
			}
			writableWorkbook.write(); // 加入到文件中
			writableWorkbook.close(); // 关闭文件，释放资源
		} catch (Exception e) {
			result.put("result", "failed"); // 将调用该函数的结果返回
			result.put("reason", e.getMessage()); // 将调用该函数失败的原因返回
			return result;
		}

		result.put("result", "successed");
		return result;
	}
}