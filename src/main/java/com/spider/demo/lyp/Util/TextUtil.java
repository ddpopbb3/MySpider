package com.spider.demo.lyp.Util;

public class TextUtil {

	public static boolean isEmpty(String url) {
		if (url == null || url.trim().length() == 0)
			return true;
		else
			return false;
	}

	/*让文件名符合windows的命名规范，去掉不合规范的字符*/
	public static String toWindowsName(String fileName) {
		fileName = fileName.trim();
		String wrongChar = "[/\\:*?<>|\"]\b";
		for (char c : fileName.toCharArray()) {
			for (char c2 : wrongChar.toCharArray()) {
				if (c == c2) {
					fileName=fileName.substring(0, fileName.indexOf(c))+fileName.substring(fileName.indexOf(c)+1);
				}
			}
		}
		return fileName;
	}
}
