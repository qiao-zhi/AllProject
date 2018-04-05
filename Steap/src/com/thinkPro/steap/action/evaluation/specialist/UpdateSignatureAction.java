package com.thinkPro.steap.action.evaluation.specialist;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.fileupload.util.Streams;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.thinkPro.steap.common.CommonTools;
import com.thinkPro.steap.common.ValidateCheck;
import com.thinkPro.steap.db.service.specialist.SpecialistService;
/**
 * 修改专家签名
 * @author yachao
 *
 */
@SuppressWarnings("serial")
@Component
public class UpdateSignatureAction extends ActionSupport {
	Logger log = Logger.getLogger(UpdateSignatureAction.class);

	private String specialistId;
	private String oldSignatureIndex;
	private File signature;
	private String signatureFileName;
	private Map<String, Object> result;
	
	@Resource
	private SpecialistService specialistService;

	public String getSpecialistId() {
		return specialistId;
	}

	public void setSpecialistId(String specialistId) {
		this.specialistId = specialistId;
	}

	public String getOldSignatureIndex() {
		return oldSignatureIndex;
	}

	public void setOldSignatureIndex(String oldSignatureIndex) {
		this.oldSignatureIndex = oldSignatureIndex;
	}

	public File getSignature() {
		return signature;
	}

	public void setSignature(File signature) {
		this.signature = signature;
	}

	public String getSignatureFileName() {
		return signatureFileName;
	}

	public void setSignatureFileName(String signatureFileName) {
		this.signatureFileName = signatureFileName;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	@Override
	public String execute() throws Exception {
		result = new HashMap<String, Object>();
		try {
			String realPath = ServletActionContext.getServletContext().getRealPath("/signature");
			/* 如果不存在文件夹，创建防止签名图片的文件夹*/
			File signatureFold = new File(realPath);
			if(!signatureFold.exists()) {
				signatureFold.mkdirs();
			}
			
			if(ValidateCheck.isNotNull(oldSignatureIndex)) {
				deleteOldFile(realPath); // 删除旧签名图片
			}
			
			String newFileName = uploadFile(realPath);
			Map<String, Object> specialist_signature = new HashMap<String, Object>();
			specialist_signature.put("specialistId", specialistId);
			specialist_signature.put("signature", newFileName);
			
			int updateRows = specialistService.updateSpecialistSignature(specialist_signature);
			
			if(updateRows == 1) {
				newFileName = CommonTools.getSignatureFullPath(newFileName);
				result.put("oldSignatureIndex", newFileName);
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result.put("oldSignatureIndex", null);
			return SUCCESS;
		}
		return SUCCESS;
	}
	
	/*上传信息的专家签名到服务器指定文件夹下*/
	private String uploadFile(String realPath) throws Exception {
		String newFileName = null;
		try {
			InputStream streamIn = new FileInputStream(signature);
			newFileName = CommonTools.getNewFileName(signatureFileName);
			String fullFileName = realPath + "/" + newFileName;
			
			OutputStream streamOut = null;
			if(signature.exists()) {
				streamOut = new FileOutputStream(fullFileName);
				Streams.copy(streamIn, streamOut, true);
			}
			streamIn.close();
			streamOut.close();
			
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
		} 
		return newFileName;
	}
	
	/*删除旧的专家签名*/
	private void deleteOldFile(String realPath) throws Exception {
		String oldFileName = CommonTools.getOldSignatureName(oldSignatureIndex);
		String fullOldFileName = realPath + "/" + oldFileName;
		
		File oldFile = new File(fullOldFileName);
		if(oldFile.exists()) {
			oldFile.delete();
			log.info("Deleting old signature is ok!");
		}
	}
}
