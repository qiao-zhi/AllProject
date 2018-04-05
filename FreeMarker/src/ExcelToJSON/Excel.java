package ExcelToJSON;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.File;

public class Excel {
    public static void main(String[] args) {
        Sheet sheet;
        Workbook book;
        Cell cell1, cell2, cell3, cell4, cell5,cell6,cell7,cell8;
        JSONArray array = new JSONArray();
        try {
            //为要读取的excel文件名
            book = Workbook.getWorkbook(new File("F://a.xls"));

            //获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
            sheet = book.getSheet(0);

            for (int i = 2; i < sheet.getRows(); i++) {
                //获取每一行的单元格
                cell1 = sheet.getCell(0, i);//（列，行）
                cell2 = sheet.getCell(1, i);
                cell3 = sheet.getCell(2, i);
                cell4 = sheet.getCell(3, i);
                cell5 = sheet.getCell(4, i);
                cell6 = sheet.getCell(5, i);
                cell7 = sheet.getCell(6, i);
                cell8 = sheet.getCell(7, i);
                if ("".equals(cell1.getContents())) {//如果读取的数据为空
                    break;
                }
                JSONObject object = new JSONObject();
                object.put("timu",cell1.getContents());
                object.put("leixing",cell2.getContents());
                object.put("axuanxiang",cell3.getContents());
                object.put("bxuanxiang",cell4.getContents());
                object.put("cxuanxiang",cell5.getContents());
                object.put("dxuanxiang",cell6.getContents());
                object.put("daan",cell7.getContents());
                object.put("jiexi",cell8.getContents());
                array.add(object);
            }
            System.out.println(array.toString());
            book.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}