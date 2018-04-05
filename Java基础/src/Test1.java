import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String s="qiaoliqiang123456";
MessageDigest md;
try {
	md = MessageDigest.getInstance("md5");
	byte []md5=md.digest(s.getBytes());
	System.out.println(new String(md5));
	
} catch (NoSuchAlgorithmException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	}

}
