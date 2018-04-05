package dto;

public class majorDTO {
	private String major_id;
	private String major_name;
	
	
	/******¿Õ¹¹ÔìÆ÷********/
	public majorDTO() {
	
	}



	public majorDTO(String major_id, String major_name) {
		super();
		this.major_id = major_id;
		this.major_name = major_name;
	}



	public String getMajor_id() {
		return major_id;
	}



	public void setMajor_id(String major_id) {
		this.major_id = major_id;
	}



	public String getMajor_name() {
		return major_name;
	}



	public void setMajor_name(String major_name) {
		this.major_name = major_name;
	}
	
	
	
}
