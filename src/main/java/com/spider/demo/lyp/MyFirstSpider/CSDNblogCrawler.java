package com.spider.demo.lyp.MyFirstSpider;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.StringUtils;

import com.spider.demo.lyp.ExractService.ExtractService;
import com.spider.demo.lyp.LinkTypeData.LinkTypeData;
import com.spider.demo.lyp.Rule.Rule;
import com.spider.demo.lyp.Thread.FileThread;

public class CSDNblogCrawler {

	private int page;
	private String downloaddir;

	public void setDownloaddir(String downloaddir) {
		this.downloaddir = downloaddir;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public CSDNblogCrawler(int page, String downloaddir) {
		this.setPage(page);
		if (StringUtils.endsWith(downloaddir, "\\")) {
			this.setDownloaddir(downloaddir + page + "\\");
		} else {
			this.setDownloaddir(downloaddir + "\\" + page + "\\");
		}
	}

	public void startCopy() throws InterruptedException {

		// 如果文件目录不存在就创建
		mkDir(new File(downloaddir));
		
		Rule rule = new Rule(new String[] {}, new String[] {}, "http://blog.csdn.net/?&page=" + page,
				"[data-mod=popu_254]", Rule.SELECTION, Rule.GET);
		List<LinkTypeData> linklist = doParse(rule);
		ExecutorService aExecutor = Executors.newFixedThreadPool(5);
		for (int i = 0; i < linklist.size(); i++) {
			FileThread fileThread = new FileThread(linklist.get(i), downloaddir);
			aExecutor.submit(fileThread);
		}
		aExecutor.shutdown();
		while (!aExecutor.isTerminated()) {
			Thread.sleep(1000);
		}
		System.out.println("第" + page + "页下载完毕");
	}

	public List<LinkTypeData> doParse(Rule rule) {
		ExtractService extractService = new ExtractService();
		List<LinkTypeData> list = new ArrayList<LinkTypeData>();
		list = extractService.extract(rule);
		int cout = 0;
		for (LinkTypeData li : list) {
			cout++;
			System.out.println(li.toString() + cout);
		}
		return list;
	}
	
	  public static void mkDir(File file) {  
	        if (file.getParentFile().exists()) {  
	            file.mkdir();  
	        } else {  
	            mkDir(file.getParentFile());  
	            file.mkdir();    
	        }  
	    } 
}
