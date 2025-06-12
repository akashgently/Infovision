package com.Day2;

import java.util.Scanner;

interface FullDetails{
	public void show(String provider, String simType, String speed);
}

class Service{
	public void serviceInfo(String provider) {
		System.out.println("Provider: "+provider);
	}
}

class MobileService extends Service{
	public void mobileInfo(String simType) {
		System.out.println("SimType: "+simType);
	}
}

class infoService extends MobileService implements FullDetails{
	public void otherInfo(String speed) {
		System.out.println("Speed: "+speed);
	}

	@Override
	public void show(String provider, String simType, String speed) {
		System.out.println("Provider: "+provider+" SimType: "+simType+" Speed: "+speed); 
		
	}
}

public class InheritanceExample {
	public static void main(String[] args) {
//		SINGLE INHERITANCE
		MobileService mobile = new MobileService();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the provider: ");
		String provider = sc.nextLine();
		System.out.println("Enter the simType: ");
		String simType = sc.nextLine();
		System.out.println("Enter the speed of the service: ");
		String speed = sc.nextLine();
		mobile.serviceInfo(provider);
		mobile.mobileInfo(simType);
		
//		MULTILEVEL INHERITANCE
		infoService info = new infoService();
		info.serviceInfo(provider);
		info.mobileInfo(simType);
		info.otherInfo(speed);
		
//		MULTIPLE INHERITANCE		
		info.show(provider, simType, speed);
	}
}
