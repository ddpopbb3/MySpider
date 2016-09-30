package com.spider.demo.lyp.Util;

public class TextUtil {

	public static boolean isEmpty(String url) {
		if (url == null || url.trim().length() == 0)
			return true;
		else
			return false;
	}
}
