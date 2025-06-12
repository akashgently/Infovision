package com.Day2;

import java.util.Scanner;

@FunctionalInterface
interface Machine{
	//Single abstract method
	public void showstatus();
	public default void working() {
		System.out.println("Working!");
	}
}
//method in interface that is  abstract till java 7
interface WashingMachine{
	public void start();
	public void pause();
	public void stop();
}
public class InterfaceExample implements  WashingMachine,Machine{
 
	@Override
	public void start() {
		System.out.println("Washing Machine Started!");
	}
 
	@Override
	public void pause() {
		System.out.println("Washing Machine Paused!");
	}
 
	@Override
	public void stop() {
		System.out.println("Washing Machine Stoped!");
	}

	@Override
	public void showstatus() {
		System.out.println("Washing Machine Working!");
		
	}
	
public static void main(String[] args) {
		InterfaceExample interface_object = new InterfaceExample();
		interface_object.working();
		interface_object.showstatus();
		System.out.println("Please type START");
		Scanner scan =new Scanner(System.in);
		String option = scan.nextLine();
		while(option.equalsIgnoreCase("start")) {
			System.out.println("Start-->1");
			System.out.println("Pause-->2");
			System.out.println("Stop-->3");
			System.out.println("Please select the number 1/2/3");
			int number =scan.nextInt();
			if(number==1) {
			interface_object.start();
			}else if(number==2) {
				interface_object.pause();
			}else if(number==3) {
				interface_object.stop();
				break;
		    }else {
		    	System.out.println("Invalid Input");
		    }
		}
		System.out.println("!");
		scan.close();
		
	}
 
}
