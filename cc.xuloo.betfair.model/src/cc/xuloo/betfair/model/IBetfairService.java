package cc.xuloo.betfair.model;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.joda.time.DateTime;

import com.betfair.publicapi.types.exchange.v5.Market;
import com.betfair.publicapi.types.exchange.v5.MarketPrices;
import com.betfair.publicapi.types.global.v3.BFEvent;
import com.betfair.publicapi.types.global.v3.EventType;

public interface IBetfairService {

	LoginResult login(String username, String password, int id, boolean throttle);
	
	List<MarketData> getAllMarkets(DateTime fromDate, DateTime toDate, int[] eventTypes);
	
	List<EventType> getAllEventTypes();
	
	Market getMarket(int id);
	
	List<BFEvent> getEvent(int parentId);
	
	MarketPrices getMarketPrices(int id);
	
//	void setCredentials(String username, String password, int productId);
//	
//	boolean isThrottled();
	
	public static abstract class BetfairResponse<T> implements Iterable<T> {

		final T value;
		
        public abstract boolean wasSuccessful();
        
        public BetfairResponse(T value) {
            this.value = value;
        }

        public T get() {
            return value;
        }
        
        public Iterator<T> iterator() {
            return Collections.singletonList(value).iterator();
        }

        public static <T> Failed<T> Failed(T value) {
            return new Failed<T>(value);
        }

        public static <T> Succeeded<T> Succeeded(T value) {
            return new Succeeded<T>(value);
        }
    }

    public static class Failed<T> extends BetfairResponse<T> {

    	public Failed(T value) {
    		super(value);
    	}
    	
        @Override
        public boolean wasSuccessful() {
            return false;
        }

        @Override
        public String toString() {
            return "Failed";
        }
    }

    public static class Succeeded<T> extends BetfairResponse<T> {

        public Succeeded(T value) {
            super(value);
        }

        @Override
        public boolean wasSuccessful() {
            return true;
        }

        @Override
        public T get() {
            return value;
        }

        @Override
        public String toString() {
            return "Succeeded(" + value + ")";
        }
    }
}
