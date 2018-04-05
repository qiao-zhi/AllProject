package visitor2;

public class Teacher extends Candidate{
	private int numPaper;
	private int backGrade;
	
	public Teacher(int numPaper, int backGrade) {
		this.numPaper = numPaper;
		this.backGrade = backGrade;
	}
	
	//属性访问器与属性修改器
	public int getNumPaper() {
		return numPaper;
	}
	public void setNumPaper(int numPaper) {
		this.numPaper = numPaper;
	}
	public int getBackGrade() {
		return backGrade;
	}
	public void setBackGrade(int backGrade) {
		this.backGrade = backGrade;
	}
	
	//用于交换的方法
	@Override
	String accept(AwardVisitor av) {
		return	av.teacherVisitor(this);
	
	}
	
}
