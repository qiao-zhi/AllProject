package dto;

public class departmentDTO {
	private String department_id; 
	private String department_name;  
	private String department_num; 
	private String remark;
	private String superior_depar_num;    
	private String connect_way; 
public departmentDTO(){
	
}
	
	public departmentDTO(String str_0,String str_1,String str_2,String str_3,String str_4,String str_5){
		this.department_id=str_0;
		this.department_name=str_1;
		this.department_num=str_2;
		this.remark=str_3;
		this.superior_depar_num=str_4;
		this.connect_way=str_5;		
	}

	public String getdepartment_id() {
		return department_id;
	}

	public void setdepartment_id(String department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getDepartment_num() {
		return department_num;
	}

	public void setDepartment_num(String department_num) {
		this.department_num = department_num;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}



	public String getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}

	public String getSuperior_depar_num() {
		return superior_depar_num;
	}

	public void setSuperior_depar_num(String superior_depar_num) {
		this.superior_depar_num = superior_depar_num;
	}

	public String getConnect_way() {
		return connect_way;
	}

	public void setConnect_way(String connect_way) {
		this.connect_way = connect_way;
	}

	


}
