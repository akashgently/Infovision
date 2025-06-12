package com.Day4;

public class DailyLimitException extends Exception {
	
	public DailyLimitException(){
		super();
	}
	
	public DailyLimitException(String msg){
		super(msg);
	}
	
}