package cc.xuloo.betfair.model;

import java.util.List;

import org.joda.time.DateTime;

import com.betfair.publicapi.types.exchange.v5.Market;
import com.betfair.publicapi.types.global.v3.BFEvent;
import com.betfair.publicapi.types.global.v3.EventType;

public interface IBetfairService {

	boolean login(String username, String password, int id);
	
	List<MarketData> getAllMarkets(DateTime fromDate, DateTime toDate, int[] eventTypes);
	
	List<EventType> getAllEventTypes();
	
	Market getMarket(int id);
	
	List<BFEvent> getEvent(int parentId);
}
