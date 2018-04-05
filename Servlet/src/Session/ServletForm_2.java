package Session;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.misc.BASE64Encoder;

@WebServlet("/ServletForm_2")
public class ServletForm_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletForm_2() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TokenProcessor tp = TokenProcessor.getTp();
		String rand = tp.getToken();
		HttpSession session = request.getSession();
		session.setAttribute("rand", rand); // 用session将数据带过去
		request.getRequestDispatcher("/SecondForm.jsp").forward(request, response);
		;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

// 令牌处理器，产生一个随机数，单利模式，一个对象产生
class TokenProcessor {
	// 单利模式
	/***
	 * 1.构造方法私有 2.创建一个对象 3.公开一份方法暴露对象
	 */
	private TokenProcessor() {

	}

	private static TokenProcessor tp = new TokenProcessor();

	public static TokenProcessor getTp() {
		return tp;
	}

	public String getToken() {
		// token是系统当前时间毫秒数+随机数变为的字符串。长度不同
		String token = System.currentTimeMillis() + new Random().nextInt() + "";
		// 利用MD5摘要算法得到固定长度的字符串
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			// 根据MD5算法得到数据的指纹
			byte[] md5 = md.digest(token.getBytes());
			// BASE64编码，3BYTE变为4byte（每6位前面加2零）
			BASE64Encoder encoder = new BASE64Encoder();
			String ss = encoder.encode(md5);
			return ss;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}
