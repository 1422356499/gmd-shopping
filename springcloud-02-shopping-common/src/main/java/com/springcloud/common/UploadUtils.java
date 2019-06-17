package com.springcloud.common;

import java.util.Date;

/**
 * 文件上传的工具类
 * 
 * @author 吴榕兴
 *
 */
public class UploadUtils {

	/**
	 * 获得文件名称(毫秒数+四位随机数)
	 * 
	 * @return
	 */
	public static String getFileName() {
		String fileName = null;

		int num = (int) (Math.random() * 1000 + 1);

		String tempNum = "000" + num;
		tempNum.substring(tempNum.length() - 4);

		Date data = new Date();
		fileName = data.getTime() + tempNum;

		return fileName;
	}

	/**
	 * 返回文件的扩展名
	 * 
	 * @param fileName 文件名
	 * @return 成功返回文件扩展名,失败返回null
	 */
	public static String getExendedName(String fileName) {
		if (fileName == null || fileName.length() == 0) {
			return null;
		}

		int index = fileName.lastIndexOf(".");
		if (index == -1) {
			return null;
		}
		return fileName.substring(index);
	}
	
}
