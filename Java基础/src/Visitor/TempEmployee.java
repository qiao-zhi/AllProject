package Visitor;

public class TempEmployee  extends employee{
    private int incomeEveryHour;
    private int basicTime;  //记录临时工基本工作时间
    
	public TempEmployee(int incomeEveryHour,int time) {
		this.incomeEveryHour = incomeEveryHour;
		this.basicTime=time;
	}

	public int accept(SalaryVisitor v) {
		return v.visitTemp(this);
	}
	public int accept(TimeVisitor v) {
		return v.visitTemp((this));
	}
	
	public int getTime() {
		return this.basicTime;
	}

	
	
	
	//初始化和获取属性数据
	public void setIncomeEveryHour(int incomeEveryHour) {
		this.incomeEveryHour = incomeEveryHour;
	}

	public void setBasicTime(int basicTime) {
		this.basicTime = basicTime;
	}

	public int getIncomeEveryHour() {
		return incomeEveryHour;
	}

	public int getBasicTime() {
		return basicTime;
	}

	
}
