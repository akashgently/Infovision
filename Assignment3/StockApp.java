package com.Assignment3;

public class StockApp {
	public static void main(String[] args) throws InterruptedException, StockNotFoundException {
	       Market market = new Market();
	       market.addStock(new Stock("S1", "Reliance", 2500, 9));
	       market.addStock(new Stock("S2", "TCS", 3500, 20));
//	       market.getStock("S3");
	       Trader trader1 = new Trader1(1, "Akash", market);
	       Trader trader2 = new Trader2(2, "Syed", market);
	       Thread t1 = new Thread(trader1);
	       Thread t2 = new Thread(trader2);
	       t1.start();
	       t1.join();
	       t2.start();
	       t2.join();
	       trader1.printPortfolio();
	       trader2.printPortfolio();
	   }

}
