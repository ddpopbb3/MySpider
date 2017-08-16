package com.spider.demo.lyp.MyFirstSpider;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

import com.spider.demo.lyp.ExractService.ExtractService;
import com.spider.demo.lyp.LinkTypeData.LinkTypeData;
import com.spider.demo.lyp.Rule.Rule;
import com.spider.demo.lyp.Thread.FileThread;

public class MyLowSpider2 {

	@Test
	public void fifthtest() throws InterruptedException {

		int page = 10;
		String url = "G:\\testforcrawl\\" + page + "\\";
		File file = new File(url);
		if (!file.exists() && !file.isDirectory()) {
			file.mkdir();
		}
		Rule rule = new Rule(new String[] {}, new String[] {}, "http://blog.csdn.net/?&page=" + page,
				"[data-mod=popu_254]", Rule.SELECTION, Rule.GET);
		List<LinkTypeData> linklist = doParse(rule);
		ExecutorService aExecutor = Executors.newFixedThreadPool(5);
		for (int i = 0; i < linklist.size(); i++) {
			FileThread fileThread = new FileThread(linklist.get(i), url);
			aExecutor.submit(fileThread);
			// fileThread.run();
		}
		aExecutor.shutdown();
		while (!aExecutor.isTerminated()) {
			Thread.sleep(1000);
		}
		System.out.println("所有的子线程都结束了！");
		// 第二种判断子线程都结束了的方案
		// for (int i = 0; i < linklist.size(); i++) {
		// fileThread fileThread = new fileThread(linklist.get(i),page);
		// aExecutor.submit(fileThread);
		// //fileThread.run();
		// }
		// while(fileThread.count < linklist.size()) {
		// try {
		// Thread.sleep(500);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
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
}
