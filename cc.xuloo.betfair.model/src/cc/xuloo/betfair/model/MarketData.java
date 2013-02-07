package cc.xuloo.betfair.model;

import org.joda.time.DateTime;

public class MarketData {

	public int marketId;
	public String marketName;
	public String marketType;
	public String marketStatus;
	public DateTime eventDate;
	public String menuPath;
	public int[] eventHierarchy;
	public String betDelay;
	public int exchangeId;
	public String iso3CountryCode;
	public DateTime lastRefresh;
	public int numberOfRunners;
	public int numberOfWinners;
	public double totalAmountMatched;
	public boolean bspMarket;
	public boolean turningInPlay;
}
