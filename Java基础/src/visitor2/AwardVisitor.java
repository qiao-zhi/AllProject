package visitor2;
/*************
 * 访问者类，访问每一个类中，根据getter属性访问器判断是否满足奖励条件
 * **/
public class AwardVisitor {

		/*****访问学生的类*****/
	String studentVisitor(Student student){
		StringBuffer Award =new StringBuffer();
		if(student.getNumPaper()>=2){
			Award.append("发表论文数大于2，可以评选科研奖;");   //判断是否可以评选科研奖
		}
		if(student.getGrade()>=90){
			Award.append("成绩大于90,可以评选成绩优秀奖！");   //判断是否可以评选科研奖
		}
		return Award.toString();
	}
	
	
	/*****访问老师的类*****/
	String teacherVisitor(Teacher teacher){
		StringBuffer Award =new StringBuffer();
		if(teacher.getNumPaper()>=10){
			Award.append("论文超过10篇，可以评选科研奖;");   //判断是否可以评选科研奖
		}
		if(teacher.getBackGrade()>=90){
			Award.append("反馈成绩大于90，可以评选成绩优秀奖！");   //判断是否可以评选科研奖
		}
		return Award.toString();
	}
	
	
}
