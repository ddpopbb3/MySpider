package com.spider.demo.lyp.main;

import com.spider.demo.lyp.MyFirstSpider.CSDNblogCrawler;

public class Main {
	public static void main(String[] args) {
		String dir = "G:\\testforcrawl";
		// 下载热门博客前20页的内容
		for (int i = 1; i <= 20; i++) {
			try {
				new CSDNblogCrawler(i,dir).startCopy();
			} catch (InterruptedException e) {
			}
		}
	}
}
