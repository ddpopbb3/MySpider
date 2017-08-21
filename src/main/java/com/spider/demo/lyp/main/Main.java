package com.spider.demo.lyp.main;

import com.spider.demo.lyp.MyFirstSpider.CSDNblogCrawler;

/**
 * 主程序入口，参数为下载地址
 * */
public class Main {
	public static void main(String[] args) {
		String dir = "E:\\CSDNblog\\";
	
		for (int i = 1; i <= 20; i++) {  // 下载热门博客前20页的内容
			try {
				new CSDNblogCrawler(i,dir).startCopy();
			} catch (InterruptedException e) {
			}
		}
	}
}
