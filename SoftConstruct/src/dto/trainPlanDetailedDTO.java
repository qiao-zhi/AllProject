package dto;

public class trainPlanDetailedDTO {
	private String detailed_plan_id; 
	private String basic_plan_id;  
	private String major_id; 
	private String train_reason;
	private String train_content;    
	private String lesson_hour;         
	private String lesson_teacher;
	
	/*****¿Õ¹¹ÔìÆ÷********/
	public trainPlanDetailedDTO() {
	
	}
	
	
	public trainPlanDetailedDTO(String detailed_plan_id, String basic_plan_id, String major_id, String train_reason,
			String train_content, String lesson_hour, String lesson_teacher) {
		super();
		this.detailed_plan_id = detailed_plan_id;
		this.basic_plan_id = basic_plan_id;
		this.major_id = major_id;
		this.train_reason = train_reason;
		this.train_content = train_content;
		this.lesson_hour = lesson_hour;
		this.lesson_teacher = lesson_teacher;
	}
	public String getDetailed_plan_id() {
		return detailed_plan_id;
	}
	public void setDetailed_plan_id(String detailed_plan_id) {
		this.detailed_plan_id = detailed_plan_id;
	}
	public String getBasic_plan_id() {
		return basic_plan_id;
	}
	public void setBasic_plan_id(String basic_plan_id) {
		this.basic_plan_id = basic_plan_id;
	}
	public String getMajor_id() {
		return major_id;
	}
	public void setMajor_id(String major_id) {
		this.major_id = major_id;
	}
	public String getTrain_reason() {
		return train_reason;
	}
	public void setTrain_reason(String train_reason) {
		this.train_reason = train_reason;
	}
	public String getTrain_content() {
		return train_content;
	}
	public void setTrain_content(String train_content) {
		this.train_content = train_content;
	}
	public String getLesson_hour() {
		return lesson_hour;
	}
	public void setLesson_hour(String lesson_hour) {
		this.lesson_hour = lesson_hour;
	}
	public String getLesson_teacher() {
		return lesson_teacher;
	}
	public void setLesson_teacher(String lesson_teacher) {
		this.lesson_teacher = lesson_teacher;
	}
	
	
	
}
