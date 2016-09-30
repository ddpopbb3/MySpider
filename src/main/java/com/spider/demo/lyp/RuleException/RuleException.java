package com.spider.demo.lyp.RuleException;

public class RuleException extends RuntimeException{
	
	public RuleException() {
		super();
	}
	
	public RuleException(String message) {
		super(message);
	}
	
	public RuleException(Throwable cause){
		super(cause);
	}
	
	public RuleException(String message,Throwable cause){
		super(message,cause);
	}
	
	
}
