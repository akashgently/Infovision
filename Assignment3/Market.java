package com.Assignment3;

public class Market extends Thread{
	   private Stock[] stocks = new Stock[10];
	   private int stockCount = 0;
	   public void addStock(Stock stock) throws InterruptedException {
	       if (stockCount < stocks.length) {
	           stocks[stockCount++] = stock;
	           System.out.println(stock.stockName +" Stock Added");
	           Thread.sleep(2000);
	       }
	   }
	   public synchronized Stock getStock(String stockId) throws StockNotFoundException {
	       for (int i = 0; i < stockCount; i++) {
	           if (stocks[i].getStockId().equals(stockId)) {
	               return stocks[i];
	           }
	       }
	       throw new StockNotFoundException("Stock with ID " + stockId + " not found.");
	   }

}
