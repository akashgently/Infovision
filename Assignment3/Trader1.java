package com.Assignment3;

public class Trader1 extends Trader{

	public Trader1(int traderId, String name, Market market) {
		super(traderId, name, market);
	}
	
	public void run() {
	       try {
	           buyStock("S1", 6);
	           sellStock("S1", 5);
	           buyStock("S2", 20);
	           buyStock("S2", 30);
	       } catch (Exception e) {
	           System.out.println( e.getMessage());
	       }
	   }

}
