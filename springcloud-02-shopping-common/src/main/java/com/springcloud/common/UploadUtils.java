package com.springcloud.common;

import java.util.Date;

/**
 * �ļ��ϴ��Ĺ�����
 * 
 * @author ������
 *
 */
public class UploadUtils {

	/**
	 * ����ļ�����(������+��λ�����)
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
	 * �����ļ�����չ��
	 * 
	 * @param fileName �ļ���
	 * @return �ɹ������ļ���չ��,ʧ�ܷ���null
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
