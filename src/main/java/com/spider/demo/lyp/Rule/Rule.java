package com.spider.demo.lyp.Rule;

public class Rule {
	
	public Rule(String[] params, String[] values, String url, String resultTagName, int type, int requestMoethod) {
		super();
		this.params = params;
		this.values = values;
		this.url = url;
		this.resultTagName = resultTagName;
		this.type = type;
		this.requestMoethod = requestMoethod;
	}
	
	/** 参数列表*/
	private String[] params;
	
	/** 值列表*/
	private String[] values;
	/** 链接地址*/
	private String url;
	
	/** 选择器 包括ID/Class/Selection */
	private String resultTagName;	
	
	/** 请求的类型POST GET，默认是GET*/
	private int  type = ID;

    private int requestMoethod = GET ;   
    
    public final static int GET = 0 ;  
    public final static int POST = 1 ;  
      
  
    public final static int CLASS = 0;  
    public final static int ID = 1;  
    public final static int SELECTION = 2;  
    
    
    public String[] getParams() {
		return params;
	}
	public void setParams(String[] params) {
		this.params = params;
	}
	public String[] getValues() {
		return values;
	}
	public void setValues(String[] values) {
		this.values = values;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getResultTagName() {
		return resultTagName;
	}
	public void setResultTagName(String resultTagName) {
		this.resultTagName = resultTagName;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getRequestMoethod() {
		return requestMoethod;
	}
	public void setRequestMoethod(int requestMoethod) {
		this.requestMoethod = requestMoethod;
	}
}
