package mail;


import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class SendMailTest {

	public static void main(String[] args) throws AddressException, MessagingException {
		//第一个是接受者，第二个是主体，第三个是内容
		MailUtils.sendMail("qiao_liqiang@126.com", "这是我发的第二封邮件","这是第二份封测试邮件");
	}
	
}
