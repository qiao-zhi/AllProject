package Utils.GenerateNewFileName;

import java.util.UUID;

public class FileUtils {
	/**
		 * 获取文件的新名称
		 * @param fileName 文件名
		 * @return 文件新生成的名称
		 */
		public static String getNewFileName(String fileName) {
			StringBuffer newFileName = new StringBuffer();
			String extension = fileName.substring(fileName.lastIndexOf('.'));
			newFileName.append(UUID.randomUUID().toString());
			newFileName.append(extension);
			return newFileName.toString();
		}
		
		/**
		 * 用时间产生文件名
		 *@param fileName
		 *@return
		 */
		public static String getNewFileNameWithTimeStamp(String fileName) {
			StringBuffer newFileName = new StringBuffer();
			String extension = fileName.substring(fileName.lastIndexOf('.'));
			newFileName.append(System.currentTimeMillis());
			newFileName.append(extension);
			return newFileName.toString();
		}
}

