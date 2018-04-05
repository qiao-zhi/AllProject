package Visitor;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestRegular {


	@Test
	public void test() {
		RegularEmployee e=new RegularEmployee();
  	  SalaryVisitor sv=new SalaryVisitor();
  	  TimeVisitor tv=TimeVisitor.getTimeVisitor();
  	  e.accept(tv);
	}

}
