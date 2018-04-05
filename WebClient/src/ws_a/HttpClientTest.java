package ws_a;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.junit.Test;

public class HttpClientTest {

	@Test
	public void testGet() throws HttpException, Exception{
		HttpClient client = new HttpClient();
		GetMethod getMethod = new GetMethod("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo?mobileCode="+"13110410513"+
				"&userID="+"");
		//4.执行请求 ,结果码
		int code=client.executeMethod(getMethod);
		//5. 获取结果
		String result=getMethod.getResponseBodyAsString();
		System.out.println("get请求的结果："+result);
	}
	
	@Test
	public void post() throws Exception{
		HttpClient client=new HttpClient();
		PostMethod postMethod=new PostMethod("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo");
		//3.设置请求参数
		postMethod.setParameter("mobileCode", "13834786998");
		postMethod.setParameter("userID", "");
		//4.执行请求 ,结果码
		int code=client.executeMethod(postMethod);
		//5. 获取结果
		String result=postMethod.getResponseBodyAsString();
		System.out.println("Post请求的结果："+result);
	}
}
