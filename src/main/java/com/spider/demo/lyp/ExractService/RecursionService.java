package com.spider.demo.lyp.ExractService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.spider.demo.lyp.LinkTypeData.LinkTypeData;
import com.spider.demo.lyp.Rule.Rule;
import com.spider.demo.lyp.RuleException.RuleException;
import com.spider.demo.lyp.Util.TextUtil;

public class RecursionService {

	public List<LinkTypeData> extract(Rule rule) {
		
		//检查url
		validate(rule);
		
		List<LinkTypeData> list = new ArrayList<LinkTypeData>();
		
		
		try {
			//从rule中取值
			String url = rule.getUrl();
			String[] params = rule.getParams();
			String[] values = rule.getValues();
			String resultTagName = rule.getResultTagName();
			int resultType = rule.getRequestMoethod();
			int type = rule.getType();
			
			//解析url获得请求地址
			Connection connection  = (Connection) Jsoup.connect(url);
			
			//填表
			if(params != null){
				for(int i = 0 ; i <params.length;i++){
					connection.data(params[i],values[i]);
				}
			}
			
			Document document = null;
			
			//根据请求类型进行解析
			switch(resultType){
			case Rule.GET:
				document = connection.timeout(100000).get();
				break;
			case Rule.POST:
				document = connection.timeout(100000).post();
				break;
			}
			
			Elements results = new Elements();
			
			switch(type){
			case Rule.CLASS :
				results = document.getElementsByClass(resultTagName);
				break;
			case Rule.ID:
				Element elment = document.getElementById(resultTagName);
				results.add(elment);
				break;
			case Rule.SELECTION:
				results = document.select(resultTagName);
				break;
			default :
				if(TextUtil.isEmpty(resultTagName))
					results = document.getElementsByTag("body");
			}
			
			for(Element result:results){
				
				Elements links = result.getElementsByTag("a");
				if(links!=null)
				for(Element link :links){
					// 将href统一处理成小写
					String linkhref = link.attr("href");
					
					String linktext = link.text();
					
					//获取解析后的href和text
					LinkTypeData data = new LinkTypeData();
					data.setHref(linkhref);
					data.setText(linktext);
					list.add(data);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static void validate(Rule rule){
		String url = rule.getUrl();
		if(TextUtil.isEmpty(url)){
			throw new RuleException("url不能为空");
		}
		if(!url.startsWith("http://")){
			throw new RuleException("链接不正确");
		}
		if(rule.getParams()!=null&&rule.getValues()!=null){
			if(rule.getParams().length!=rule.getValues().length){
				throw new RuleException("参数个数不匹配！");
			}
		}
	}
}
