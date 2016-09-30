package com.spider.demo.lyp.MyFirstSpider;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.spider.demo.lyp.ExractService.ExtractService;
import com.spider.demo.lyp.LinkTypeData.LinkTypeData;
import com.spider.demo.lyp.Rule.Rule;
import com.spider.demo.lyp.Util.FileTxt;

public class MyLowSpider {
	public String time = new String(System.currentTimeMillis()+"");
	/*@Test
	public void forthetest(){
		Rule rule = new Rule(new String[]{"name","password"},new String[]{"111","111"}, "http://localhost:8080/MyChapter/tologin.do", "tablebody1", Rule.CLASS, Rule.POST);
		
		ExtractService extractService=new ExtractService();
		List<LinkTypeData> list = new ArrayList<LinkTypeData>();
		list = extractService.extract(rule);
		for(LinkTypeData li:list){
			System.out.println(li.getText().toString());
		}
	}*/
	@Test
	public void forthetest2(){
		//Rule rule = new Rule(new String[]{},new String[]{},"http://www.chinanews.com/","ptv",Rule.CLASS,Rule.GET);
		//Rule rule = new Rule(new String[]{},new String[]{},"http://www.wh.sdu.edu.cn/index.do","xnxw",Rule.ID,Rule.GET);
		//Rule rule = new Rule(new String[]{},new String[]{},"http://www.ie.wh.sdu.edu.cn/","body_bg",Rule.CLASS,Rule.GET);
		//Rule rule = new Rule(new String[]{},new String[]{},"http://xsgzc.wh.sdu.edu.cn/read?id=5553","view_content",Rule.CLASS,Rule.GET);
		Rule rule = new Rule(new String[]{},new String[]{},"http://xsgzc.wh.sdu.edu.cn/list.action?class_id=7","list_table",Rule.CLASS,Rule.GET);
		
		ExtractService extractService=new ExtractService();
		List<LinkTypeData> list = new ArrayList<LinkTypeData>();
		list = extractService.extract(rule);
		FileTxt fileTxt = new FileTxt();
		
		
		File file = new File("G:\\FeigeDownload\\"+time+".txt");
		
		for(LinkTypeData li:list){
			fileTxt.FileWritterUtil(file,li.getText()+"\r\n");
			System.out.println("ok!");
		}
	}
	
}
  