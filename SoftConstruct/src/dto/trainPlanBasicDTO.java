package dto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import util.DataBaseConnection;

public class trainPlanBasicDTO {
//	private static  Object[][] ss_1 ;
	private String plan_Id; 
	private String plan_name;  
	private String start_time; 
	private String end_time;
	private String build_Time;    
	private String train_Plan_Type;         
	private String startYear;
	private String finish_Status;
	private String train_people_num;
	private String train_major;
	
	/******¿ÕµÄ¹¹ÔìÆ÷***/
	public trainPlanBasicDTO() {
		
	}
	
	
	public trainPlanBasicDTO(String plan_Id, String plan_name, String start_time, String end_time, String build_Time,
			String train_Plan_Type, String startYear, String finish_Status,String s1,String s2) {
		this.plan_Id = plan_Id;
		this.plan_name = plan_name;
		this.start_time = start_time;
		this.end_time = end_time;
		this.build_Time = build_Time;
		this.train_Plan_Type = train_Plan_Type;
		this.startYear = startYear;
		this.finish_Status = finish_Status;
		this.train_people_num=s1;
		this.train_major=s2;
	}
	public String getPlan_Id() {
		return plan_Id;
	}
	public void setPlan_Id(String plan_Id) {
		this.plan_Id = plan_Id;
	}
	public String getPlan_name() {
		return plan_name;
	}
	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getBuild_Time() {
		return build_Time;
	}
	public void setBuild_Time(String build_Time) {
		this.build_Time = build_Time;
	}
	public String getTrain_Plan_Type() {
		return train_Plan_Type;
	}
	public void setTrain_Plan_Type(String train_Plan_Type) {
		this.train_Plan_Type = train_Plan_Type;
	}
	public String getStartYear() {
		return startYear;
	}
	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}
	public String getFinish_Status() {
		return finish_Status;
	}
	public void setFinish_Status(String finish_Status) {
		this.finish_Status = finish_Status;
	}


	public String getTrain_people_num() {
		return train_people_num;
	}


	public void setTrain_people_num(String train_people_num) {
		this.train_people_num = train_people_num;
	}


	public String getTrain_major() {
		return train_major;
	}


	public void setTrain_major(String train_major) {
		this.train_major = train_major;
	}
	
	
	
	@SuppressWarnings("null")
	public static void  query(){
		DataBaseConnection data=new DataBaseConnection();
		Connection con=data.getconnection();
	
		QueryRunner qr = new QueryRunner();
		String sql="Select * from train_plan_basic;";
		try {
List<trainPlanBasicDTO> train = new ArrayList<trainPlanBasicDTO>();
train=qr.query(con, sql, new BeanListHandler<trainPlanBasicDTO>(trainPlanBasicDTO.class));
int num=train.size(),xuhao=0;
Object [][]ss_1=new Object[num][10];
for(trainPlanBasicDTO in:train ){
		System.out.println(in.getBuild_Time());	
		}
for(int i=0;i<num;i++){
	for(int j=0;j<10;j++)
	{if(j==0){ss_1[i][j]=(xuhao++);}
	if(j==1){ss_1[i][j]=train.get(i).getPlan_name();}
	if(j==2){ss_1[i][j]=train.get(i).getStart_time();}
	if(j==3){ss_1[i][j]=train.get(i).getEnd_time();}
	if(j==4){ss_1[i][j]=train.get(i).getStartYear();}
	if(j==5){ss_1[i][j]=train.get(i).getTrain_Plan_Type();}
	if(j==6){ss_1[i][j]=train.get(i).getStart_time();}
	if(j==7){ss_1[i][j]=train.get(i).getFinish_Status();}
	if(j==8){ss_1[i][j]=train.get(i).getTrain_people_num();}
	if(j==9){ss_1[i][j]=train.get(i).getTrain_major();}
	
	}
	System.out.println(ss_1[i][0]);
	
}	

	
		System.out.println(ss_1[5][5]);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		
		
		
	}

	public static void main(String s[]){
		trainPlanBasicDTO.query();
	}
	
	
}
