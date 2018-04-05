package Visitor;

public class SalaryVisitor {

	int visitRegula(RegularEmployee e){//basic记录员工基本工资，然后根据时间计算工资
		int time=e.getTime();
		if(time>=40){
		 e.finallyIncome= e.getBasicIncome()+(time-40)*100;
		 }
		//小于40小时，判断是否减到0
		if(time<=40){
			if(e.getBasicIncome()-(40-time)*80>0){
			e.finallyIncome= e.getBasicIncome()-(40-time)*80;}
			else e.finallyIncome=0;
			}
		 String finally_income="财务部:基本工资"+e.getBasicIncome()+"元，最终工资："+e.finallyIncome+"元\n";
		 System.out.println(finally_income);
		return  e.finallyIncome;
	}
	
	int visitTemp(TempEmployee e){  //basic记录每小时工资，time记录时间
	 int  time=e.getTime();
	 e.finallyIncome=time*e.getIncomeEveryHour();
	 String finally_1="财务部:该临时工每小时"+e.getIncomeEveryHour()+"元。"+"总工资为"+e.finallyIncome+"元";
  	 System.out.println(finally_1);
		return time*e.getIncomeEveryHour();
	}
	
	
	
}
