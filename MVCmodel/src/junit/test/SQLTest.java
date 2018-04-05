package junit.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.web.utils.DBUtils;

public class SQLTest {

	@Test
	public void test() {
		
		DBUtils dbu=DBUtils.getDBUtils();
		dbu.getConnection();
	}

}
