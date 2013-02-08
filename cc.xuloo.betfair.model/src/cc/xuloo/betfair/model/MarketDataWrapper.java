package cc.xuloo.betfair.model;

public class MarketDataWrapper {

	private MarketData marketData;
	
	private boolean matched = false;
	
	private boolean canMatch = true;
	
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
	
	public void setBeMatched(boolean canMatch) {
		this.canMatch = canMatch;
	}
	
	public boolean canBeMatched() {
		return canMatch;
	}
}
