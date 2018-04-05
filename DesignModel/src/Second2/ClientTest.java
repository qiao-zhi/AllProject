package Second2;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Test;
public class ClientTest {
	@Test
	public void testCopy() {
		Client c = new Client();
		c.copy();
	}
}
