package com.Day4;

public class ExceptionExample {
	public static void main(String[] args) throws Exception {
		int[] number =new int[5];
		String name = null;
		
		try{
			for(int i=0;i<6;i++) {
			System.out.println(number[i]);
		}
		}
		catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println(ex);
		}
		
		
		try{
			System.out.println(name.length());
		}
		catch(NullPointerException ex) {
			System.out.println(ex);
		}
		
		finally {
			System.out.println("Code works!");
		}
	}

}
