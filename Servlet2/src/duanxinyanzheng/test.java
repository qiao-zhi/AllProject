package duanxinyanzheng;

import java.util.HashMap;
import java.util.Map;

/**  
 * @Title: http://www.smschinese.cn/api.shtml
 * @date 2011-3-22
 * @version V1.2  
 */
public class test {
	
	//用户名
	private static String Uid = "qiao_liqiang";
	
	//接口安全秘钥
	private static String Key = "74999a2962630c52b6b4";
	
	//手机号码，多个号码如13800000000,13800000001,13800000002
	private static String smsMob = "18434391711";
	
	//短信内容
	private static String smsText = "你已被我公司解雇!【科技大学】";
	
	
	public static void main(String[] args) {
		
		HttpClientUtil client = HttpClientUtil.getInstance();
		
		//UTF发送
		int result = client.sendMsgUtf8(Uid, Key, smsText, smsMob);
		if(result>0){
			System.out.println("UTF8成功发送条数=="+result);
		}else{
			System.out.println(client.getErrorMsg(result));
		}
	}
}