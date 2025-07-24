package com.Assignment3;

public class Trader implements Trade, Runnable {
	   private int traderId;
	   private String name;
	   private PortfolioEntry[] portfolio = new PortfolioEntry[10];
	   private int portfolioSize = 0;
	   private Market market;
	   public Trader(int traderId, String name, Market market) {
	       this.traderId = traderId;
	       this.name = name;
	       this.market = market;
	   }
	   @Override
	   public void buyStock(String stockId, int quantity) throws StockNotFoundException, InsufficientMarketSharesException {
	       Stock stock = market.getStock(stockId);
	       stock.reduceStock(quantity);
	       boolean available = false;
	       for (int i = 0; i < portfolioSize; i++) {
	           if (portfolio[i].stockId.equals(stockId)) {
	               portfolio[i].quantity += quantity;
	               available = true;
	               break;
	           }
	       }
	       if (!available && portfolioSize < portfolio.length) {
	           portfolio[portfolioSize++] = new PortfolioEntry(stockId, quantity);
	       }
	       System.out.println(name + " bought " + quantity + " shares of " + stock.getStockName());
	   }
	   @Override
	   public void sellStock(String stockId, int quantity) throws StockNotFoundException, InsufficientSharesException {
	       Stock stock = market.getStock(stockId);
	       for (int i = 0; i < portfolioSize; i++) {
	           if (portfolio[i].stockId.equals(stockId)) {
	               if (portfolio[i].quantity < quantity) {
	                   throw new InsufficientSharesException("Not enough shares owned to sell");
	               }
	               portfolio[i].quantity -= quantity;
	               stock.addStock(quantity);
	               System.out.println(name + " sold " + quantity + " shares of " + stock.getStockName());
	               return;
	           }
	       }
	       throw new InsufficientSharesException("Stock not owned in portfolio");
	   }
	   public void printPortfolio() {
	       System.out.println("\nPortfolio of " + name + ":");
	       for (int i = 0; i < portfolioSize; i++) {
	           System.out.println("Stock ID: " + portfolio[i].stockId + ", Quantity: " + portfolio[i].quantity);
	       }
	   }
	@Override
	public void run() {
		
	}
	}
