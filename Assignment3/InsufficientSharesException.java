package com.Assignment3;

public class InsufficientSharesException extends Exception{
	
	public InsufficientSharesException() {
		super();
	}
	
	public InsufficientSharesException(String msg){
        super (msg);
    }

}
