package com.thinkPro.steap.action.login;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component
public class ProduceVerify extends ActionSupport{
	private ByteArrayInputStream imageStream;
	
	public ByteArrayInputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(ByteArrayInputStream imageStream) {
		this.imageStream = imageStream;
	}

	@SuppressWarnings({ "static-access", "rawtypes", "unchecked" })
	@Override
	public String execute() throws Exception {
		/* 调用验证码的类 */
		VerifyCode verifyCode = new VerifyCode();
		BufferedImage image = verifyCode.getImage();
		
		/* 获取session和response */
		Map session = ActionContext.getContext().getSession();
		
		/* 将验证码图片，和字段传送到页面 */
		session.put("VCode", verifyCode.getText());
		imageStream = verifyCode.convertImageToStream(image);
		
		return SUCCESS;
	}
	
	

}
