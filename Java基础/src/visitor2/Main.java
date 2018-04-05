package visitor2;

import java.util.Scanner;

import Visitor.RegularEmployee;
import Visitor.SalaryVisitor;

public class Main {

	public static void main(String[] args) {
		while(true){
		test();}
	}

	private static void test() {
		Scanner sc=new Scanner(System.in);
		System.out.println("请选择要判断的候选人类型：\n\t\t1、教师\n\t\t2、学生\n\t\t3、退出系统");
		int i = sc.nextInt();
		
		//判断教师
		if(i==1){
	    	  System.out.println("请输入教师的发表论文数");
	    	  int numPaper = sc.nextInt();
	    	  System.out.println("请输入教师的反馈成绩");
	    	  int backGrade = sc.nextInt();
	    	 Teacher teacher=new Teacher(numPaper, backGrade);
	    	 AwardVisitor av=new AwardVisitor();
	    	 System.out.println(teacher.accept(av));
	    	  try {
				Thread.sleep(1000*5);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	  
	      }
		
		
		
		//判断学生
		if(i==2){
	    	  System.out.println("请输入学生的发表论文数");
	    	  int numPaper = sc.nextInt();
	    	  System.out.println("请输入学生的成绩");
	    	  int backGrade = sc.nextInt();
	    	 Student student=new Student(numPaper, backGrade);
	    	 AwardVisitor av=new AwardVisitor();
	    	 System.out.println(student.accept(av));
	    	  try {
				Thread.sleep(1000*5);
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
