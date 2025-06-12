package com.Day2;

abstract class NetflixDisplay{
	public void display() {
		System.out.println("Displaying all the buttons!");
	}
	abstract public void showNetflix();
}
abstract class HotstarDisplay{
	public void display() {
		System.out.println("Displaying all the buttons!");
	}
	abstract public void displayJioHotstar();
}
 
class Abstract1 extends NetflixDisplay {
 
	@Override
	public void showNetflix() {
		System.out.println("redirecting to the intalled netflix app!");
	}
}

class Abstract2 extends HotstarDisplay {
	 
	@Override
	public void displayJioHotstar() {
		System.out.println("redirecting to the intalled jiohotstar app!");
	}
}
 
public class AbstractExample {
  public static void main(String[] args) {
	  Abstract1 tv1 = new Abstract1();
	  tv1.display();
	  tv1.showNetflix();
	  Abstract2 tv2 = new Abstract2();
	  tv2.display();
	  tv2.displayJioHotstar();
}
}
