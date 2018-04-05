package com.thinkPro.steap.action.meeting;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.meeting.EnterpriseNotify;
import com.thinkPro.steap.bean.meeting.Meeting;
import com.thinkPro.steap.bean.specialist.Specialist;
import com.thinkPro.steap.db.service.meeting.MeetingService;
import com.thinkPro.steap.db.service.specialist.SpecialistService;
import com.thinkPro.steap.db.service.sys.dic.DictionaryService;

@SuppressWarnings("serial")
@Component
public class ConfirmSpecialist extends ActionSupport {

	private Meeting meeting;//会议
	private boolean status = false;//状态标志
	List<EnterpriseNotify> projectList;//企业通知
	private List<Specialist> showInitSpecialist;// 已存在的专家组名单
	private List<Specialist> enterSpecialist;// 所有的企业推荐专家
	List<String> domainList;//所有领域
	
	
	//查看单个项目的专家名单用到的
	private String myProjectId;//项目编号
	private List<Specialist> listSpecialist;//专家列表
	
	//从专家库中抽取专家
	private String name;// 专家名字
	private String domain;// 所属领域
	
	//保存专家组
	private String meetingID;//会议编号
	private String tempSource;//临时存储专家来源
	private String tempSpecialistId;//临时存储专家编号
	private List<String> sourceList = new ArrayList<String>();//专家来源列表
	private List<String> listSpecialistId = new ArrayList<String>();//专家编号列表
	
	//删除会议已经安排的专家
    private String  oneSpecialistId; 
    
    @Resource
    private MeetingService meetingService;
    @Resource
    private SpecialistService specialistService;
    @Resource
    private DictionaryService dictionaryService;
    
    
    //分页
    private int totalPage;
	private int currentPages;
	private int pageBegin=0;
	private int pageSize=8;
	private Map<String,Object> infoMap;
	
	//到选择项目界面
	public String toChooseSpecialistPage() {

		status = true;
		try {
			String meetingId = meeting.getMeetingId();
			// 项目信息
			ActionContext context = ActionContext.getContext();
			Map params = context.getSession();
			String userid = (String) params.get("userId");
			System.out.println(params+"userid"+userid);
			projectList = meetingService.getEnterpriseNotify(meetingId);

			// 得到所有项目编号
			List id = new ArrayList();
			for (int i = 0; i < projectList.size(); i++) {
				id.add(projectList.get(i).getProjectId());
			}

			//得到企业推荐专家
			enterSpecialist = new ArrayList<Specialist>();
			for (int i = 0; i < id.size(); i++) {

				try {

					String projectId = id.get(i).toString();
					List<Specialist> specList;
					specList = specialistService.getRecommendSpecialistList(projectId);
					 for (int j = 0; j < specList.size(); j++) {
						enterSpecialist.add(specList.get(j));

					 }
				} catch (SQLException e) {

					e.printStackTrace();
				}

			}

			// 初始化专家组名单到页面
			showInitSpecialist = specialistService.getSpecialistsByMeetingId(meetingId);

			
			//所属领域
			
			domainList=dictionaryService.getDomain("领域");
		//	System.out.println("领域"+domainList);
			
//			//初始化专家库专家
//			Map<String, Object> map = new HashMap<>();
//			map.put("name", null);
//			map.put("engageDomain", null);
//			listSpecialist=new SpecialistService().getSpecialistsByIf(map);
		
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return SUCCESS;

	}
	
	//查看企业推荐专家
	public String lookEnterSpecialist(){
		try {
			showInitSpecialist = specialistService.getSpecialistsByMeetingId(meeting.getMeetingId());
		 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return SUCCESS;
		
	}
	

	// 查看单个项目的专家名单
	public String lookSpecialist() {
		
		// 根据项目编号查询项目的专家
		try {
			System.out.println(myProjectId);
			listSpecialist = specialistService.getRecommendSpecialistList(myProjectId);
			System.out.println(listSpecialist);
		} catch (SQLException e) {

			e.printStackTrace();
		}		
		return SUCCESS;
	}

	

	// 从庄家库抽取名单	
	public String searchSpecialist() {
		
		Map<String, Object> map = new HashMap<>();
		if(domain.equals("")){
			domain=null;
		}
		if(name.equals("")){
			name=null;
		}
		map.put("name", name);
		map.put("engageDomain", domain);
		//map.put("pageBegin", pageBegin);
		map.put("pageSize", pageSize);
		
		if(currentPages==0){
			currentPages=1;
		}
		int temp=(currentPages-1)*pageSize;
		 if(temp==0){
				map.put("pageBegin", 0);
		 }else{
				map.put("pageBegin", temp);
		 }
		
		
		try {
			listSpecialist = specialistService.getSpecialistsByIf(map);
			int rowCount=specialistService.getSpecialistCount(map);
			if(rowCount%pageSize==0){
				 totalPage=rowCount/pageSize;
			}else{
				totalPage=rowCount/pageSize+1;
			}
			//currentPages=1;
			infoMap=new HashMap<>();
			infoMap.put("listSpecialist",listSpecialist);
			infoMap.put("totalPage",totalPage);
			infoMap.put("currentPages", currentPages);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return SUCCESS;
	}

	//查询分页
	public String searchSpecForPage(){
		Map<String, Object> map = new HashMap<>();
		map.put("name", null);
		map.put("engageDomain", null);
	
		map.put("pageSize", pageSize);
		
		int temp=(currentPages-1)*pageSize;
		 if(temp==0){
				map.put("pageBegin", 0);
		 }else{
				map.put("pageBegin", temp+1);
		 }
		 
		try {
			listSpecialist = specialistService.getSpecialistsByIf(map);
			int rowCount= specialistService.getSpecialistCount(map);
			if(rowCount%pageSize==0){
				 totalPage=rowCount/pageSize;
			}else{
				totalPage=rowCount/pageSize+1;
			}
			infoMap=new HashMap<>();
			infoMap.put("listSpecialist",listSpecialist);
			infoMap.put("totalPage",totalPage);
			infoMap.put("currentPages", currentPages);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	// 保存专家组	
	public String saveSpecialistRoster() {

		//将临时专家来源生成list
		String[] array1 = new String[1000];
		array1 = tempSource.toString().split(",");

		for (String a : array1) {

			sourceList.add(a);

		}

		//将临时专家编号生成list
		String[] array2 = new String[1000];
		array2 = tempSpecialistId.toString().split(",");

		for (String a : array2) {

			listSpecialistId.add(a);

		}
		List<String> specId = new ArrayList<String>();// 专家id
		List<Specialist> specList;// 专家列表

		// 得到已经存在的专家组名单
		try {
			specList = specialistService.getSpecialistsByMeetingId(meetingID);
			for (int i = 0; i < specList.size(); i++) {
				specId.add(specList.get(i).getSpecialistId());
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		

		// 判断专家是否已经存在于名单,如果存在，则不存入数据库
		Iterator<String> sListIterator = listSpecialistId.iterator();
		Iterator<String> sListIterator2 = sourceList.iterator();
		while (sListIterator.hasNext() && sListIterator2.hasNext()) {
			String str = sListIterator.next();
			String str2 = sListIterator2.next();
			for (int j = 0; j < specId.size(); j++) {
				if (str.equals(specId.get(j))) {
					sListIterator.remove();
					sListIterator2.remove();

				}

			}

		}

		
         //拼接专家信息
		List<Map<String, Object>> specInfoList = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < listSpecialistId.size(); i++) {

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("meetingId", meetingID);
			map.put("specialistId", listSpecialistId.get(i));
			map.put("source", sourceList.get(i));			
			specInfoList.add(map);

		}
		
		//将专家组信息放到数据库
		try {
			if(specInfoList.size()==0){
			    status = true;
				return SUCCESS; 
			}else{
				 int sucStatus = specialistService.insertArrangedSpecialist(specInfoList);

		         if (sucStatus > 0) {

			       status = true;

		         }
			}

			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return SUCCESS;

	}
	
	//删除会议已经安排的专家
   public String delSpecialist(){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("specialistId", oneSpecialistId);
		map.put("meetingId", meetingID);
		
	    try {
			int suc=specialistService.deleteArrangedSpecialist(map);
			if(suc>0){
				status=true;
			}else{
				status=false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	/*//删除企业推荐的专家
	public String deleteRecommendSpecialist(){
		
		
		try {
		int suc=new SpecialistService().deleteRecommendSpecialistById(oneSpecialistId);
		if(suc>0){
			status=true;
		}else{
			status=false;
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	//删除专家库中的专家
	 public String  deleteLibrarySpecialist(){
		 System.out.println("oneSpecialistId"+oneSpecialistId);
		 try {
				int suc=new SpecialistService().deleteLibrarySpecialistById(oneSpecialistId);
				if(suc>0){
					status=true;
				}else{
					status=false;
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		 return SUCCESS;
	 }*/
	 
	 
	 
	 
	 

	public Meeting getMeeting() {
		return meeting;
	}

	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}

	public List<Specialist> getListSpecialist() {
		return listSpecialist;
	}

	public void setListSpecialist(List<Specialist> listSpecialist) {
		this.listSpecialist = listSpecialist;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public List<EnterpriseNotify> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<EnterpriseNotify> projectList) {
		this.projectList = projectList;
	}

	public String getMyProjectId() {
		return myProjectId;
	}

	public void setMyProjectId(String myProjectId) {
		this.myProjectId = myProjectId;
	}

	public String getMeetingID() {
		return meetingID;
	}

	public void setMeetingID(String meetingID) {
		this.meetingID = meetingID;
	}

	public String getTempSource() {
		return tempSource;
	}

	public void setTempSource(String tempSource) {
		this.tempSource = tempSource;
	}

	public String getTempSpecialistId() {
		return tempSpecialistId;
	}

	public void setTempSpecialistId(String tempSpecialistId) {
		this.tempSpecialistId = tempSpecialistId;
	}

	public List<Specialist> getShowInitSpecialist() {
		return showInitSpecialist;
	}

	public void setShowInitSpecialist(List<Specialist> showInitSpecialist) {
		this.showInitSpecialist = showInitSpecialist;
	}

	public List<Specialist> getEnterSpecialist() {
		return enterSpecialist;
	}

	public void setEnterSpecialist(List<Specialist> enterSpecialist) {
		this.enterSpecialist = enterSpecialist;
	}

	public String getOneSpecialistId() {
		return oneSpecialistId;
	}

	public void setOneSpecialistId(String oneSpecialistId) {
		this.oneSpecialistId = oneSpecialistId;
	}

	public List<String> getDomainList() {
		return domainList;
	}

	public void setDomainList(List<String> domainList) {
		this.domainList = domainList;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPages() {
		return currentPages;
	}

	public void setCurrentPages(int currentPages) {
		this.currentPages = currentPages;
	}

	public Map<String, Object> getInfoMap() {
		return infoMap;
	}

	public void setInfoMap(Map<String, Object> infoMap) {
		this.infoMap = infoMap;
	}

	

}
