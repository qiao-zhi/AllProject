package dto;

public class employeeTrain {
	private String department_id; 
	private String employeei_d;  
	private String plan_id; 
	private String grade;
	private String grade_status;
	
	/***¿Õ¹¹ÔìÆ÷**/
	public employeeTrain() {
		
	}

	public employeeTrain(String department_id, String employeei_d, String plan_id, String grade,
			String grade_status) {
		super();
		this.department_id = department_id;
		this.employeei_d = employeei_d;
		this.plan_id = plan_id;
		this.grade = grade;
		this.grade_status = grade_status;
	}

	public String getdepartment_id() {
		return department_id;
	}

	public void setdepartment_id(String department_id) {
		this.department_id = department_id;
	}

	public String getEmployeei_d() {
		return employeei_d;
	}

	public void setEmployeei_d(String employeei_d) {
		this.employeei_d = employeei_d;
	}

	public String getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(String plan_id) {
		this.plan_id = plan_id;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGrade_status() {
		return grade_status;
	}

	public void setGrade_status(String grade_status) {
		this.grade_status = grade_status;
	}             

	
	
	
	
}
