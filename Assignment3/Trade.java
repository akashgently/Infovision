package com.Assignment3;

public interface Trade {
	void buyStock(String stockId, int quantity) throws StockNotFoundException, InsufficientMarketSharesException;
	
	void sellStock(String stockId, int quantity) throws StockNotFoundException,InsufficientSharesException;
}
