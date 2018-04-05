package Visitor;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		while(true){
	  test();}

	}
  static void test(){
	  Scanner sc = new Scanner(System.in);
	  System.out.println("请选择要输入的员工类型：\n\t\t1、正式员工\n\t\t2、临时工\n\t\t3、退出系统");
	  int i = sc.nextInt();
      if(i==1){
    	  System.out.println("请输入员工基本工资(元)");
    	  int basicIncome = sc.nextInt();
    	  System.out.println("请输入员工加班时间(小时)");
    	  int add = sc.nextInt();
    	  System.out.println("请输入员工请假时间(小时)");
    	  int minus= sc.nextInt();
    	  RegularEmployee e=new RegularEmployee(add,minus,basicIncome);
    	  SalaryVisitor sv=new SalaryVisitor();
    	  TimeVisitor tv=TimeVisitor.getTimeVisitor();
    	  e.accept(tv);
    	  e.accept(sv);
    	  try {
			Thread.sleep(1000*5);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	  
      }
      if(i==2){
    	  System.out.println("请输入员工每小时工资(元)");
    	  int hourIncome = sc.nextInt();
    	  System.out.println("请输入员工工作时间(小时)");
    	  int time = sc.nextInt();
    	  TempEmployee te=new TempEmployee(hourIncome,time);
    	  SalaryVisitor sv=new SalaryVisitor();
    	  TimeVisitor tv=TimeVisitor.getTimeVisitor();
    	  te.accept(tv);
    	  te.accept(sv);
    	  
    	  try {
  			Thread.sleep(1000*5);   //停顿5s
  		} catch (InterruptedException e1) {
  			// TODO Auto-generated catch block
  			e1.printStackTrace();
  		}
    	 
      }
      if(i==3){
    	  System.exit(0);
      }
  }
}
