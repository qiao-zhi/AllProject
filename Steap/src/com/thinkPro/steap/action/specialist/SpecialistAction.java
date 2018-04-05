package com.thinkPro.steap.action.specialist;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.bean.specialist.Specialist;
import com.thinkPro.steap.common.CommonTools;
import com.thinkPro.steap.common.PageConstants;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.specialist.SpecialistService;
import com.thinkPro.steap.db.service.sys.dic.DictionaryService;

@SuppressWarnings("serial")
@Component
public class SpecialistAction extends ActionSupport {

	private Specialist specialist; // 添加专家信息，从界面传回
	private List<String> domains;
	private Map<String, String> specialistCon; // 查询专家信息的条件，从界面传回
	private List<Specialist> specialistList; // 专家信息列表，显示到数据库
	private String specialistId; // 专家Id，添加成功时，返回界面，删除时，从界面传回
	private Map<String, String> spepassword; // 修改专家密码，从界面传回
	private int signatureCount; // 备份的专家签名图片数量
	private int pageCount;
	private boolean result;
	private Map<String, String> accountInfo; // 账户信息

	Logger logger = Logger.getLogger(SpecialistAction.class);

	@Resource
	private SpecialistService specialistService;
	@Resource
	private DictionaryService dictionaryService;
	
	public Specialist getSpecialist() {
		return specialist;
	}

	public void setSpecialist(Specialist specialist) {
		this.specialist = specialist;
	}

	public List<String> getDomains() {
		return domains;
	}

	public void setDomains(List<String> domains) {
		this.domains = domains;
	}

	public List<Specialist> getSpecialistList() {
		return specialistList;
	}

	public void setSpecialistList(List<Specialist> specialistList) {
		this.specialistList = specialistList;
	}

	public String getSpecialistId() {
		return specialistId;
	}

	public void setSpecialistId(String specialistId) {
		this.specialistId = specialistId;
	}

	public Map<String, String> getSpecialistCon() {
		return specialistCon;
	}

	public void setSpecialistCon(Map<String, String> specialistCon) {
		this.specialistCon = specialistCon;
	}

	public Map<String, String> getSpepassword() {
		return spepassword;
	}

	public void setSpepassword(Map<String, String> spepassword) {
		this.spepassword = spepassword;
	}

	public int getSignatureCount() {
		return signatureCount;
	}

	public void setSignatureCount(int signatureCount) {
		this.signatureCount = signatureCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public Map<String, String> getAccountInfo() {
		return accountInfo;
	}

	public void setAccountInfo(Map<String, String> accountInfo) {
		this.accountInfo = accountInfo;
	}

	public String getdomain() {
		try {
			String dictionaryOptionName = "领域";
			domains = dictionaryService.getDomain(dictionaryOptionName);
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		}
		return SUCCESS;
	}

	public String selectSpecAccountById() {
		try {
			if (ValidateCheck.isNotNull(specialistId)) {
				if (specialistService.selectSpecAccountById(specialistId)) {
					return SUCCESS;
				}
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		}
		return ERROR;
	}

	public String addAccountForSpec() {
		try {
			if (accountInfo.size() > 0) {
				Map<String, Object> account = new HashMap<String, Object>();
				account.put("specialistId", accountInfo.get("specialistId"));
				account.put("account", accountInfo.get("account"));
				account.put("password", accountInfo.get("password"));
				if (specialistService.addAccountForSpec(account)) {
					return SUCCESS;
				}
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		}
		return ERROR;
	}

	public String deleteAccountForSpec() {
		try {
			if (ValidateCheck.isNotNull(specialistId)) {
				if (specialistService.deleteAccountForSpec(specialistId)) {
					return SUCCESS;
				}
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		}
		return ERROR;
	}

	public String ShowSpecialist() {
		try {
			Object name = (Object) specialistCon.get("name");
			Object engageDomain = specialistCon.get("engageDomain");
			Object pageSize = new PageConstants().getPageSize();
			Object pageBegin = new PageConstants().getRecordNums(Integer.parseInt(specialistCon.get("currentPage")));
			if (name.equals("")) {
				specialistCon.put("name", null);
			} 
//			else if (ChineseUtil.isEnglish((String) name)) {
//				specialistCon.put("name", null);
//			}
			if (engageDomain.equals("请选择")) {
				specialistCon.put("engageDomain", null);
			}
			Map<String, Object> specialistC = new HashMap<String, Object>();
			specialistC.put("name", specialistCon.get("name"));
			specialistC.put("engageDomain", specialistCon.get("engageDomain"));
			specialistC.put("workUnit", specialistCon.get("workUnit"));
			specialistC.put("duty", specialistCon.get("duty"));
			specialistC.put("title", specialistCon.get("title"));
			
//			if (ChineseUtil.isEnglish((String) name) && name != null && !name.equals("")) {
//				specialistCon.put("name", null);
//				specialistC.put("pageSize", null);
//				specialistC.put("pageBegin", null);
//			} else {
				specialistC.put("pageSize", pageSize);
				specialistC.put("pageBegin", pageBegin);
//			}
			List<Specialist> tempList = new ArrayList<Specialist>();
			tempList = specialistService.getSpecialistsByIf(specialistC);
//			if (name != null && !name.equals("")) {
//				if (ChineseUtil.isEnglish((String) name)) {
//					String temp = (String) name;
//					temp = temp.replace(" ", "");
//					for (int i = 0; i < tempList.size(); i++) {
//						String tempName = tempList.get(i).getName().replace(" ", "");
//						if (!ChineseUtil.contains(tempName, temp)) {
//							tempList.remove(i);
//							i--;
//						}
//					}
//				}
//			}
			specialistList = tempList;
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		}
		return SUCCESS;
	}

	public String isLibrarySpecialist() {
		if (specialist != null) {
			try {
				if (specialistService.isLibrarySpecialist(specialist)) {
					return SUCCESS;
				}
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
			}
		}
		return ERROR;
	}

	public String addSpecialist() {
		if (specialist != null) {
			try {
				if (specialistService.insertLibrarySpecialist(specialist) > -1) {
					specialistId = specialist.getSpecialistId();
					return SUCCESS;
				}
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
			}
		}
		return ERROR;
	}

	public String updateSpecialist() {
		if (specialist != null) {
			try {
				if (specialistService.updateSpecialist(specialist) > 0) {
					return SUCCESS;
				}
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
			}
		}
		return ERROR;
	}

	public String deleteSpecialist() {
		if (specialistId != null) {
			try {
				if (specialistService.deleteLibrarySpecialistById(specialistId) > 0) {
					return SUCCESS;
				}
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
			}
		}
		return ERROR;
	}

	public String backupSignature() {

		String realPath = ServletActionContext.getServletContext().getRealPath("/signatureBackup");
		/* 如果不存在文件夹，创建防止签名图片的文件夹 */
		File signatureFold = new File(realPath);
		if (!signatureFold.exists()) {
			signatureFold.mkdirs();
		}

		String path = System.getProperty("user.dir").replace("\\", "/") + "/../webapps/Steap" + "/";
		String signatureFile = CommonTools.getSignatureFullPath("");
		String signatureBackupFile = CommonTools.getsignatureBackupFile("");
		File srcFile = new File(path + signatureFile);// 需要复制的文件的源路径
		File aimFile = new File(path + signatureBackupFile);// 复制后的文件的目标路径
		String aimPath = aimFile.getAbsolutePath();// 获得目标路径
		File[] str = srcFile.listFiles();
		if (str != null && !str.equals("")) {
			signatureCount = str.length;
			for (int i = 0; i < signatureCount; i++) {
				str[i].renameTo(new File(aimPath + "\\" + str[i].getName()));
			}
		}
		return SUCCESS;
	}

	public String isSetInitialPass() {
		String password = null;
		if (specialistId != null && !specialistId.equals("")) {
			try {
				password = specialistService.isSetInitailPass(specialistId);
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
			}
		}
		if (password != null && !password.equals("")) {
			result = true;
		} else {
			result = false;
		}
		return SUCCESS;
	}

	public String setPassword() {
		if (spepassword.size() > 0) {
			Map<String, Object> sepeciaPassWord = new HashMap<>();
			sepeciaPassWord.put("specialistId", spepassword.get("specialistId"));
			sepeciaPassWord.put("password", spepassword.get("password"));
			try {
				if (specialistService.updateLibrarySpecialistPassword(sepeciaPassWord) > 0) {
					return SUCCESS;
				}
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
			}
		}
		return ERROR;
	}

	public String searchPageCount() {
		try {
			Object name = (Object) specialistCon.get("name");
			Object engageDomain = specialistCon.get("engageDomain");
			if (name.equals("")) {
				specialistCon.put("name", null);
			}
//			else if (ChineseUtil.isEnglish((String) name)) {
//				specialistCon.put("name", null);
//			}
			if (engageDomain.equals("请选择")) {
				specialistCon.put("engageDomain", null);
			}

			Map<String, Object> specialistC = new HashMap<String, Object>();
			specialistC.put("name", specialistCon.get("name"));
			specialistC.put("engageDomain", specialistCon.get("engageDomain"));
			specialistC.put("initialPass", specialistCon.get("initialPass"));
			specialistC.put("workUnit", specialistCon.get("workUnit"));
			specialistC.put("duty", specialistCon.get("duty"));
			specialistC.put("title", specialistCon.get("title"));
			int specialistCount = specialistService.getSpecialistCount(specialistC);
			pageCount = new PageConstants().getPages(specialistCount);
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		}
		return SUCCESS;
	}
}
