package ss;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

public class DateConverter extends DefaultTypeConverter {

	//value表示要转的值，Class表示要转成的类型
	@Override
	public Object convertValue(Map<String, Object> context, Object value, Class toType) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		String []params=(String[])value;
		if(toType.equals(Date.class)){
			try {
//				System.out.println("111111111111");
			return	df.parse(params[0]);  //将字符串解析为日期类型
			} catch (ParseException e) {
				System.out.println("cccccccccc");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(toType==String.class){
			Date date = (Date)value;
			return 	df.format(date);//格式化日期格式
		}
		return null;
	}

	
}
