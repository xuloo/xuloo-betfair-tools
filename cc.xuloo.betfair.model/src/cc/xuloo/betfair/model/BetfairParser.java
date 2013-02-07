package cc.xuloo.betfair.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

public class BetfairParser {
	
	public static List<MarketData> parseCompressedMarkets(String marketData) {
		
		List<MarketData> entries = new ArrayList<MarketData>();
		
		if (!StringUtils.isEmpty(marketData)) {
			
			char[] currentSequence = new char[]{};
			int index = 0;
			char prevChar = ' ';
			char nextChar = marketData.charAt(index);
			
			while (index < marketData.length() - 1) {
				if (nextChar == ':') {
					if (prevChar != '\\' && currentSequence.length > 0) {
						entries.add(parseCompressedMarket(new String(currentSequence)));
						currentSequence = new char[]{};
					}	
				} else {
					currentSequence = Arrays.copyOf(currentSequence, currentSequence.length +1);
					currentSequence[currentSequence.length - 1] = nextChar;
				}
				
				prevChar = nextChar;
				index++;
				nextChar = marketData.charAt(index);
			}
		}
		
		System.out.println("There are " + entries.size() + " market data entries");
		
		return entries;
	}
	
	public static int[] parseEventHierarchy(String str) {
		String[] split = str.split("/");
		
		int[] ints = new int[split.length - 1];
		
		for (int i = 1;i < split.length; i++) {
			ints[i - 1] = Integer.parseInt(split[i]);
		}
		
		return ints; 
	}
	
	public static MarketData parseCompressedMarket(String marketData) {
		
		String[] records = marketData.split("~");
		
		MarketData market = new MarketData();
		
		market.marketId = Integer.parseInt(records[0]);
		market.marketName = records[1];
		market.marketType = records[2];
		market.marketStatus = records[3];
		market.eventDate = new DateTime(Long.parseLong(records[4]));
		market.menuPath = records[5];
		
		//System.out.println("event hierarchy -- " + records[6]);
		
		market.eventHierarchy = parseEventHierarchy(records[6]);
		market.betDelay = records[7];
		market.exchangeId = Integer.parseInt(records[8]);
		market.iso3CountryCode = records[9];
		market.lastRefresh = new DateTime(Long.parseLong(records[10]));
		market.numberOfRunners = Integer.parseInt(records[11]);
		market.numberOfWinners = Integer.parseInt(records[12]);
		market.totalAmountMatched = Double.parseDouble(records[13]);
		market.bspMarket = records[14] == "Y";
		market.turningInPlay = records[15] == "Y";
		
		return market;
	}
}
