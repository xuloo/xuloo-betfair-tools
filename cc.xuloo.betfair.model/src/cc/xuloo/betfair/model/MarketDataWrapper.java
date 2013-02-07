package cc.xuloo.betfair.model;

public class MarketDataWrapper {

	private MarketData marketData;
	
	private boolean matched;
	
	public MarketDataWrapper(MarketData marketData) {
		this.marketData = marketData;
	}
	
	public MarketData getMarketData() {
		return marketData;
	}
	
	public boolean isMatched() {
		return matched;
	}
	
	public void setMatched(boolean matched) {
		this.matched = matched;
	}
}
