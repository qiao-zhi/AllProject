package visitor2;

public class Student extends Candidate {  
	private int numPaper;
	private int grade;
	
	public Student(int numPaper, int grade) {
		super();
		this.numPaper = numPaper;
		this.grade = grade;
	}
	
	
	//属性访问器与属性修改器
	public int getNumPaper() {
		return numPaper;
	}
	public void setNumPaper(int numPaper) {
		this.numPaper = numPaper;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	//用于交互的方法
	@Override
	String accept(AwardVisitor av) {
		return av.studentVisitor(this);
	}
	
	
}
