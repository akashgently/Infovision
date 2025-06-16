package com.Assignment3;

public class Trader2 extends Trader{

	public Trader2(int traderId, String name, Market market) {
		super(traderId, name, market);
	}
	
	public void run() {
	       try {
	           buyStock("S1", 6);
	           sellStock("S1", 3);
	       } catch (Exception e) {
	           System.out.println( e.getMessage());
	       }
	   }

}
