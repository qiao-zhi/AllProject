package com.thinkPro.steap.action.issue;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.thinkPro.steap.bean.project.IssueCertificate;
import com.thinkPro.steap.db.service.project.ProjectService;

@SuppressWarnings("serial")
@Component
public class EntryIssueCertificateAction extends ActionSupport implements ModelDriven<IssueCertificate> {
	Logger log = Logger.getLogger(EntryIssueCertificateAction.class);
	private IssueCertificate issueCertificate;
	
	@Resource
	private ProjectService projectService;
	
	public IssueCertificate getIssueCertificate() {
		return issueCertificate;
	}

	public void setIssueCertificate(IssueCertificate issueCertificate) {
		this.issueCertificate = issueCertificate;
	}

	@Override
	public String execute() throws Exception {
		try {
			if(issueCertificate != null) {
				
				projectService.insertIssueCertificate(issueCertificate);
				
				Map<String, Object> project_certificate = new HashMap<String, Object>();
				project_certificate.put("projectId", issueCertificate.getProjectId());
				project_certificate.put("certificate", true);
				projectService.updateProjectCertificate(project_certificate);
				
				project_certificate.put("projectStatus", "已发放证书");
				projectService.updateProjectCurrentStatus(project_certificate);
			}
		} catch(SQLException ex) {
			log.error(ex.getMessage(), ex);
		}
		return SUCCESS;
	}

	@Override
	public IssueCertificate getModel() {
		if(issueCertificate == null) {
			issueCertificate = new IssueCertificate();
		}
		return issueCertificate;
	}
}
