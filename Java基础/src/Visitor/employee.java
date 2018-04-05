package Visitor;

public abstract class employee {
	protected int finallyIncome;  //最终工资是两个子类都有的

	abstract public int getTime();
	abstract public int accept(SalaryVisitor v);
	
	
}
