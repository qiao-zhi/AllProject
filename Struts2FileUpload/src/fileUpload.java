import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class fileUpload {

	private File[] imageUpload;  //名字与form表单的name名字一样
	private String[] imageUploadContentType;  //得到文件上传类型
	private String[] imageUploadFileName;  //得到文件名字
	
	public String execute(){
		
		//文件上传的路径
		String realPath = ServletActionContext.getServletContext().getRealPath("/fileUpload");
		File file = new File(realPath);
		if(!file.exists())file.mkdirs();
		try {
			
			for(int i=0;i<imageUpload.length;i++){
				FileUtils.copyFile(imageUpload[i], new File(file,imageUploadFileName[i]));
			System.out.println(realPath);
			System.out.println(this.getImageUploadContentType());
			System.out.println(this.imageUploadFileName);}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

	public File[] getImageUpload() {
		return imageUpload;
	}

	public void setImageUpload(File[] imageUpload) {
		this.imageUpload = imageUpload;
	}

	public String[] getImageUploadContentType() {
		return imageUploadContentType;
	}

	public void setImageUploadContentType(String[] imageUploadContentType) {
		this.imageUploadContentType = imageUploadContentType;
	}

	public String[] getImageUploadFileName() {
		return imageUploadFileName;
	}

	public void setImageUploadFileName(String[] imageUploadFileName) {
		this.imageUploadFileName = imageUploadFileName;
	}
	

	
}
