package com.thinkPro.steap.action.host.revene;

import java.util.LinkedList;
import java.util.List;

public enum FileType {
	APPLYTEXT("300002", "科技项目验收申请书"), 
	PROMISETEXT("300003", "承诺书"), 
	TASKPLANTEXT("300004", "计划任务书"), 
	WORKSUMMARY("300005", "项目实施工作总结报告"), 
	TECHSUMMARY("300006", "项目实施技术总结报告"), 
	CONFIRMFILE("300007", "项目立项后相关证明材料"), 
	FINANCEFILE("300008", "科技项目验收财务资料一套");

	private String no;
	private String name;

	private FileType(String no, String name) {
		this.no = no;
		this.name = name;
	}
	
	public static List<String> getValues() {
		List<String> types = new LinkedList<String>();
		for (FileType type : FileType.values()) {
			types.add(type.getName());
		}
		return types;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
