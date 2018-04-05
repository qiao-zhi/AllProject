package Visitor;


public class RegularEmployee extends employee{
	private int addTime;     //正式工加班时间
	private int minusTime;  //请假时间     
	private int basicIncome;   //正式工的基本工资

	
	
	public RegularEmployee() {
		super();
	}
	public RegularEmployee(int addTime, int minusTime, int basicIncome) {
		this.addTime = addTime;
		this.minusTime = minusTime;
		this.basicIncome = basicIncome;
	}
/***统计工资********/
	public int accept(SalaryVisitor v) {
		return v.visitRegula(this);
	}
	/*****统计时间*/
	public int accept(TimeVisitor v) {
		return v.visitRegular((this));
	}
	
	
	
public int getAddTime() {
		return addTime;
	}

	public int getMinusTime() {
		return minusTime;
	}

	public int getBasicIncome() {
		return basicIncome;
	}

	//获取这个对象的工作时间
	@Override
	public int getTime() {
		return 40+this.addTime-this.minusTime;
	}


}
