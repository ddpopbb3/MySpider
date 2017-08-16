package com.spider.demo.lyp.Util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
	public  void FileWritterUtil(File file,String content) {
		
		try {
			if(!file.exists())
				file.createNewFile();
				FileWriter fileWritter = new FileWriter(file.getPath(),true);
				fileWritter.write(content);
				fileWritter.write("\n");
				fileWritter.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
