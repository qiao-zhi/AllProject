package dto;

public class employeeDTO {
	private String employee_id; 
	private String employee_name;  
	
	private String employee_sex; 
	
	private String employee_idcard;
	private String employeebirth;    
	private String department_id;         
	private String employee_job; 
	private String employee_post;  
	private String employee_address; 
	private String employee_photo;
	private String employee_phone_num;    
	
	
	/*******JavaBean必须有空构造器**/
	public employeeDTO() {
		
	}


	public employeeDTO(String str_0,String str_1,String str_2,String str_3,String str_4,String str_5,String str_6,String str_7,String str_8,String str_9,String str_10){
		this.employee_id=str_0;
		this.employee_name=str_1;
		this.employee_sex=str_2;
		this.employee_idcard=str_3;
		this.employeebirth=str_4;
		this.department_id=str_5;	
		this.employee_job=str_6;
		this.employee_post=str_7;
		this.employee_address=str_8;
		this.employee_photo=str_9;
		this.employee_phone_num=str_10;
	}


	public String getEmployee_id() {
		return employee_id;
	}


	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}


	public String getEmployee_name() {
		return employee_name;
	}


	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}


	public String getEmployee_sex() {
		return employee_sex;
	}


	public void setEmployee_sex(String employee_sex) {
		this.employee_sex = employee_sex;
	}


	public String getEmployee_idcard() {
		return employee_idcard;
	}


	public void setEmployee_idcard(String employee_idcard) {
		this.employee_idcard = employee_idcard;
	}


	public String getEmployeebirth() {
		return employeebirth;
	}


	public void setEmployeebirth(String employeebirth) {
		this.employeebirth = employeebirth;
	}


	public String getdepartment_id() {
		return department_id;
	}


	public void setdepartment_id(String department_id) {
		this.department_id = department_id;
	}


	public String getEmployee_job() {
		return employee_job;
	}


	public void setEmployee_job(String employee_job) {
		this.employee_job = employee_job;
	}


	public String getEmployee_post() {
		return employee_post;
	}


	public void setEmployee_post(String employee_post) {
		this.employee_post = employee_post;
	}


	public String getEmployee_address() {
		return employee_address;
	}


	public void setEmployee_address(String employee_address) {
		this.employee_address = employee_address;
	}


	public String getEmployee_photo() {
		return employee_photo;
	}


	public void setEmployee_photo(String employee_photo) {
		this.employee_photo = employee_photo;
	}


	public String getEmployee_phone_num() {
		return employee_phone_num;
	}


	public void setEmployee_phone_num(String employee_phone_num) {
		this.employee_phone_num = employee_phone_num;
	}


	
}
