package WW;

public class StudentTuitionModel {
	  private String studFirstName;
	   private String studLastName;
	   private String studSerialNum;
	   private String studTuitionNum;
	   private String studTuitionYear;
	   
	   
	public StudentTuitionModel(String studFirstName, String studLastName, String studSerialNum, String studTuitionNum,
			String studTuitionYear) {
		super();
		this.studFirstName = studFirstName;
		this.studLastName = studLastName;
		this.studSerialNum = studSerialNum;
		this.studTuitionNum = studTuitionNum;
		this.studTuitionYear = studTuitionYear;
	}
	public String getStudFirstName() {
		return studFirstName;
	}
	public void setStudFirstName(String studFirstName) {
		this.studFirstName = studFirstName;
	}
	public String getStudLastName() {
		return studLastName;
	}
	public void setStudLastName(String studLastName) {
		this.studLastName = studLastName;
	}
	public String getStudSerialNum() {
		return studSerialNum;
	}
	public void setStudSerialNum(String studSerialNum) {
		this.studSerialNum = studSerialNum;
	}
	public String getStudTuitionNum() {
		return studTuitionNum;
	}
	public void setStudTuitionNum(String studTuitionNum) {
		this.studTuitionNum = studTuitionNum;
	}
	public String getStudTuitionYear() {
		return studTuitionYear;
	}
	public void setStudTuitionYear(String studTuitionYear) {
		this.studTuitionYear = studTuitionYear;
	}
	  
}
