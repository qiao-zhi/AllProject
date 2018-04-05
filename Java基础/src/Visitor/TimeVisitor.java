package Visitor;

public class TimeVisitor {
    //单例模式创建一个对象	
    private static TimeVisitor  t=new TimeVisitor();
	private TimeVisitor() {	
	}

	public static TimeVisitor getTimeVisitor(){
		return t;
	}
	
	
	
	//正式工上班时间
	int visitRegular(RegularEmployee e){
		/*****统计正式工时间****/
		String finally_1="人力资源部：该员工基本时间为40h，加班"+e.getAddTime()+"h,请假"+e.getMinusTime()+"h,最终工作时间"+e.getTime()+"小时";
		System.out.println(finally_1);
		int finallyTime=40+e.getAddTime()-e.getMinusTime();
		return finallyTime;
	}
	
	//临时工上班时间
	int visitTemp(TempEmployee e){
		int finallyTime=e.getBasicTime();
		String finally_1="人力资源部：该员工基本时间"+e.getBasicTime();
		System.out.println(finally_1);
		return finallyTime;
	}
	
	
}
