package com.spider.demo.lyp.main;

import com.spider.demo.lyp.MyFirstSpider.CSDNblogCrawler;

public class Main {
	public static void main(String[] args) {
		String dir = "G:\\testforcrawl";
		for (int i = 19; i <= 19; i++) {
			try {
				new CSDNblogCrawler(i,dir).startCopy();
			} catch (InterruptedException e) {
			}
		}

	}
}
