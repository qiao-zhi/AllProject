package com.thinkPro.steap.action.receiveMeterial;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.project.ProjectQuery;
import com.thinkPro.steap.common.PageConstants;
import com.thinkPro.steap.db.service.project.ProjectService;
import com.thinkPro.steap.db.service.sys.dic.DictionaryService;

/**
 * @ClassName QuickQuery
 * @Description 新增页面，条件查询所有项目的信息
 * @author ding
 * @Date 2017年3月15日 下午9:05:21
 * @version 1.0.0
 */
@SuppressWarnings("serial")
public class QuickQuery extends ActionSupport {

	@Resource
	private ProjectService projectService;
	@Resource
	private DictionaryService dictionaryService;

	private List<Map<String, Object>> resultList;
	private ProjectQuery project;
	private int totalPage = 1;
	private String currentPages = "1";
	private List<Map<String, Object>> statusList;

	public List<Map<String, Object>> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<Map<String, Object>> statusList) {
		this.statusList = statusList;
	}

	public List<Map<String, Object>> getResultList() {
		return resultList;
	}

	public void setResultList(List<Map<String, Object>> resultList) {
		this.resultList = resultList;
	}

	public ProjectQuery getProject() {
		return project;
	}

	public void setProject(ProjectQuery project) {
		this.project = project;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String getCurrentPages() {
		return currentPages;
	}

	public void setCurrentPages(String currentPages) {
		this.currentPages = currentPages;
	}

	/**
	 * @Description: 条件查询所有项目
	 * @return
	 * @throws Exception
	 */
	public String searchAllProject(){
		
		if (currentPages.equals("")) {
			currentPages = "1";
		}
		
		project.setPageBegin(new PageConstants().getRecordNums(Integer.parseInt(currentPages)));
		project.setPageSize(new PageConstants().getPageSize());
		
		try {
			resultList = projectService.getAllProjectInfo(project);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Logger logger = Logger.getLogger(QuickQuery.class);
			logger.info(logger);
		}

		return SUCCESS;
	}

	/**
	 * @Description: 查询总共有几条数据
	 * @return String
	 */
	public String searchPageNum() {
		
		try {
			int recordNums = projectService.getAllProjectNum(project);
			this.totalPage = new PageConstants().getPages(recordNums);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Logger logger = Logger.getLogger(QuickQuery.class);
			logger.info(logger);
		}

		return SUCCESS;
	}
	
	/** 
	* @Description: 查询出所有的项目状态
	* @return String
	*/
	public String getAllStatus(){
		try {
			statusList = dictionaryService.getDicNameByUpDicId("100");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
}
