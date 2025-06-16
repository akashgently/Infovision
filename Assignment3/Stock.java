package com.Assignment3;

public class Stock {
	public String stockId;
	public String stockName;
	public int pricePerShare;
	public int availableShares;
	
	Stock(String stockId,String stockName,int pricePerShare,int availableShares){
		this.stockId = stockId;
		this.stockName = stockName;
		this.pricePerShare = pricePerShare;
		this.availableShares = availableShares;
	}
	
	public void addStock(int availableShares) {
		this.availableShares += availableShares;
	}
	
	 public synchronized void reduceStock(int quantity) throws InsufficientMarketSharesException {
	       if (quantity > availableShares) {
	           throw new InsufficientMarketSharesException("Not enough shares available in market.");
	       }
	       this.availableShares -= quantity;
	   }
	
	public String getStockId() {
		return stockId;
	}
	
	public String getStockName() {
		return stockName;
	}
	
	public int getPricePerShare() {
		return pricePerShare;
	}
	
	public int getAvailableShares() {
		return availableShares;
	}
}
