package cc.xuloo.betfair.model.internal;

import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.joda.time.DateTime;

import cc.xuloo.betfair.model.BetfairParser;
import cc.xuloo.betfair.model.IBetfairService;
import cc.xuloo.betfair.model.LoginResult;
import cc.xuloo.betfair.model.MarketData;
import cc.xuloo.ds.ThreadedProcessor;

import com.betfair.publicapi.types.exchange.v5.ArrayOfInt;
import com.betfair.publicapi.types.exchange.v5.GetAllMarketsErrorEnum;
import com.betfair.publicapi.types.exchange.v5.GetAllMarketsReq;
import com.betfair.publicapi.types.exchange.v5.GetAllMarketsResp;
import com.betfair.publicapi.types.exchange.v5.GetMarketErrorEnum;
import com.betfair.publicapi.types.exchange.v5.GetMarketPricesErrorEnum;
import com.betfair.publicapi.types.exchange.v5.GetMarketPricesReq;
import com.betfair.publicapi.types.exchange.v5.GetMarketPricesResp;
import com.betfair.publicapi.types.exchange.v5.GetMarketReq;
import com.betfair.publicapi.types.exchange.v5.GetMarketResp;
import com.betfair.publicapi.types.exchange.v5.Market;
import com.betfair.publicapi.types.exchange.v5.MarketPrices;
import com.betfair.publicapi.types.global.v3.BFEvent;
import com.betfair.publicapi.types.global.v3.EventType;
import com.betfair.publicapi.types.global.v3.GetEventTypesReq;
import com.betfair.publicapi.types.global.v3.GetEventTypesResp;
import com.betfair.publicapi.types.global.v3.GetEventsErrorEnum;
import com.betfair.publicapi.types.global.v3.GetEventsReq;
import com.betfair.publicapi.types.global.v3.GetEventsResp;
import com.betfair.publicapi.types.global.v3.LoginErrorEnum;
import com.betfair.publicapi.types.global.v3.LoginReq;
import com.betfair.publicapi.types.global.v3.LoginResp;
import com.betfair.publicapi.v3.bfglobalservice.BFGlobalService;
import com.betfair.publicapi.v3.bfglobalservice.BFGlobalService_Service;
import com.betfair.publicapi.v5.bfexchangeservice.BFExchangeService;
import com.betfair.publicapi.v5.bfexchangeservice.BFExchangeService_Service;

public class BlockingBetfairService extends ThreadedProcessor implements IBetfairService {

	private String sessionToken;
	
	private LoginResult loginResult;
	
	private BFGlobalService globalService;
	
	private BFExchangeService exchangeService;
	
	private boolean throttle;
	
	public BlockingBetfairService() {
		super(100, true);
	}
	
	private BFGlobalService getGlobalService() {
		if (globalService == null) {
			globalService = new BFGlobalService_Service().getBFGlobalService();
		}
		
		return globalService;
	}
	
	private com.betfair.publicapi.types.global.v3.APIRequestHeader getGlobalRequestHeader() {
		com.betfair.publicapi.types.global.v3.APIRequestHeader header = new com.betfair.publicapi.types.global.v3.APIRequestHeader();
		header.setSessionToken(sessionToken);
		
		return header;
	}
	
	private BFExchangeService getExchangeService() {
		if (exchangeService == null) {
			exchangeService = new BFExchangeService_Service().getBFExchangeService();
		}
		
		return exchangeService;
	}
	
	private com.betfair.publicapi.types.exchange.v5.APIRequestHeader getExchangeRequestHeader() {
		com.betfair.publicapi.types.exchange.v5.APIRequestHeader header = new com.betfair.publicapi.types.exchange.v5.APIRequestHeader();
		header.setSessionToken(sessionToken);
		
		return header;
	}
	
	@Override
	public LoginResult login(String username, String password, int productId, boolean throttle) {
		
		System.out.println("Logging in to betfair");
		
		if (loginResult == null) {
			
			this.throttle = throttle;
			
			LoginReq request = new LoginReq();
			
			request.setUsername(username);
			request.setPassword(password);
			request.setProductId(productId);
			request.setVendorSoftwareId(0);
			
			DelayableJob<LoginResult> job = new LoginJob(request, throttle);
			
			process(job);
			
			try {
				return job.getPromise().get();
			} catch (Exception e) {
				return new LoginResult(e.getMessage());
			}
		} else {
			return loginResult;
		}
	}
	
	public class LoginJob extends DelayableJob<LoginResult> {

		private LoginReq request;
		
		public LoginJob(LoginReq request, boolean throttle) {
			super(3000L, throttle);
			
			this.request = request;
		}
		
		@Override
		public LoginResult call() throws Exception {
			
			LoginResp response = getGlobalService().login(request);
			
			if (response.getErrorCode().equals(LoginErrorEnum.OK)) {
				
				sessionToken = response.getHeader().getSessionToken();
				
				return loginResult = new LoginResult();
			} else {
				return loginResult = new LoginResult(response.getErrorCode().toString());
			}
		}

		@Override
		public String toString() {
			return "LoginJob []";
		}
		
	}
	
	public boolean loggedIn() {
		return loginResult != null && loginResult.isSuccess();
	}

	@Override
	public List<MarketData> getAllMarkets(DateTime fromDate, DateTime toDate, int[] eventTypes) {
		
		if (loggedIn()) {
			
			GetAllMarketsReq request = new GetAllMarketsReq();
			request.setHeader(getExchangeRequestHeader());
			
			if (fromDate != null) {
				GregorianCalendar c = new GregorianCalendar();
				c.setTime(fromDate.toDate());
				try {
					request.setFromDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
				} catch (DatatypeConfigurationException e) {
					System.out.println("could not create a new XMLGregorianCalendar instance");
				}
			}
			
			if (toDate != null) {
				GregorianCalendar c = new GregorianCalendar();
				c.setTime(toDate.toDate());
				try {
					request.setToDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
				} catch (DatatypeConfigurationException e) {
					System.out.println("could not create a new XMLGregorianCalendar instance");
				}
			}
			
			if (eventTypes != null) {
				ArrayOfInt aoi = new ArrayOfInt();
				for (int i : eventTypes) aoi.getInt().add(i);
				request.setEventTypeIds(aoi);
			}
			
			DelayableJob<List<MarketData>> job = new AllMarketsJob(request, throttle);
			
			process(job);
			
			try {
				return job.getPromise().get();
			} catch (Exception e) {
				return Collections.emptyList();
			}
				
		} else {
			
			System.out.println("can't get all market data - can't log in");
			
			return Collections.emptyList();
		}
	}
	
	public class AllMarketsJob extends DelayableJob<List<MarketData>> {
		
		private GetAllMarketsReq request;
		
		public AllMarketsJob(GetAllMarketsReq request, boolean throttle) {
			super(1000L, throttle);
			
			this.request = request;
		}
		
		@Override 
		public List<MarketData> call() throws Exception {
			
//			System.out.println("getting all markets");
			
			GetAllMarketsResp response = getExchangeService().getAllMarkets(request);
			
			if (response.getErrorCode().equals(GetAllMarketsErrorEnum.OK)) {
				
//				System.out.println("Successfully retrieved all markets");
				
				if (!response.getHeader().getSessionToken().equals(sessionToken)) {
					sessionToken = response.getHeader().getSessionToken();
				}
				
				return BetfairParser.parseCompressedMarkets(response.getMarketData());
			} else {
				System.out.println("Problem loading market data '" + response.getErrorCode().toString() + "'");
				
				if (response.getHeader().getMinorErrorCode() != null) {
					System.out.println("minor error: " + response.getHeader().getMinorErrorCode().toString());
				} else {
					System.out.println("no minor error code");
				}
				
				return Collections.<MarketData>emptyList();
			}
		}

		@Override
		public String toString() {
			return "AllMarketsJob []";
		}
	}

	@Override
	public List<EventType> getAllEventTypes() {
		
		if (loggedIn()) {
			
			GetEventTypesReq request = new GetEventTypesReq();
			request.setHeader(getGlobalRequestHeader());
			
			DelayableJob<List<EventType>> job = new EventTypesJob(request, throttle);
			
			process(job);
			
			try {
				return job.getPromise().get();
			} catch (Exception e) {
				return Collections.emptyList();
			}
			
		} else {
			return Collections.emptyList();
		}
	}
	
	public class EventTypesJob extends DelayableJob<List<EventType>> {
		
		private GetEventTypesReq request;
		
		public EventTypesJob(GetEventTypesReq request, boolean throttle) {
			super(1000L, throttle);
			
			this.request = request;
		}
		
		@Override
		public List<EventType> call() throws Exception {
			
//			System.out.println("getting all event types");
			
			GetEventTypesResp response = getGlobalService().getAllEventTypes(request);
			
			if (response.getErrorCode().equals(GetEventsErrorEnum.OK)) {
				
//				System.out.println("all event types successfully retrieved");
				
				if (!response.getHeader().getSessionToken().equals(sessionToken)) {
					sessionToken = response.getHeader().getSessionToken();
				}
				
				return response.getEventTypeItems().getEventType();
			} else {
				System.out.println("Problem geting all events '" + response.getErrorCode().toString() + "'");
				
				return Collections.<EventType>emptyList();
			}
		}

		@Override
		public String toString() {
			return "EventTypesJob []";
		}
	}

	@Override
	public Market getMarket(int id) {
		
		if (loggedIn()) {
			
			final GetMarketReq request = new GetMarketReq();
			request.setHeader(getExchangeRequestHeader());
			
			request.setMarketId(id);
			
			DelayableJob<Market> job = new MarketJob(request, throttle);
			
			process(job);
			
			try {
				return job.getPromise().get();
			} catch (Exception e) {
				return null;
			}
		} else {
			return null;
		}
	}
	
	public class MarketJob extends DelayableJob<Market> {
		
		private GetMarketReq request;
		
		public MarketJob(GetMarketReq request, boolean throttle) {
			super(1000L, throttle);
			
			this.request = request;
		}
		
		@Override
		public Market call() throws Exception {
			
//			System.out.println("getting market");
			
			GetMarketResp response = getExchangeService().getMarket(request);
			
			if (response.getErrorCode().equals(GetMarketErrorEnum.OK)) {
				
//				System.out.println("market successfully retrieved");
				
				if (!response.getHeader().getSessionToken().equals(sessionToken)) {
					sessionToken = response.getHeader().getSessionToken();
				}
				
				return response.getMarket();
			} else {
				System.out.println("Problem getting market data '" + response.getErrorCode().toString() + "'");
				
				return null;
			}
		}

		@Override
		public String toString() {
			return "MarketJob []";
		}
	}

	@Override
	public List<BFEvent> getEvent(int parentId) {
		
		if (loggedIn()) {
			
			GetEventsReq request = new GetEventsReq();
			request.setHeader(getGlobalRequestHeader());
			
			request.setEventParentId(parentId);
			
			DelayableJob<List<BFEvent>> job = new EventJob(request, throttle);
			
			process(job);
			
			try {
				return job.getPromise().get();
			} catch (Exception e) {
				return Collections.emptyList();
			}
			
		} else {
			return Collections.emptyList();
		}
	}
	
	public class EventJob extends DelayableJob<List<BFEvent>> {
		
		private GetEventsReq request;
		
		public EventJob(GetEventsReq request, boolean throttle) {
			super(1000L, throttle);
			
			this.request = request;
		}
		
		@Override 
		public List<BFEvent> call() throws Exception {
			
//			System.out.println("getting event");
			
			GetEventsResp response = getGlobalService().getEvents(request);
			
			if (response.getErrorCode().equals(GetEventsErrorEnum.OK)) {
				
//				System.out.println("event successfully retrieved");
				
				if (!response.getHeader().getSessionToken().equals(sessionToken)) {
					sessionToken = response.getHeader().getSessionToken();
				}
				
				return response.getEventItems().getBFEvent();
			} else {
				System.out.println("Problem loading event data '" + response.getErrorCode().toString() + "'");
				
				return Collections.<BFEvent>emptyList();
			}
		}

		@Override
		public String toString() {
			return "EventJob []";
		}
	}

	@Override
	public MarketPrices getMarketPrices(int id) {
		
		if (loggedIn()) {
		
			final GetMarketPricesReq request = new GetMarketPricesReq();
			request.setHeader(getExchangeRequestHeader());
			
			request.setMarketId(id);
			
			DelayableJob<MarketPrices> job = new MarketPricesJob(request, throttle);
			
			process(job);
			
			try {
				return job.getPromise().get();
			} catch (Exception e) {
				return null;
			}
			
		} else {
			return null;
		}
	}
	
	public class MarketPricesJob extends DelayableJob<MarketPrices> {
		
		private GetMarketPricesReq request;
		
		public MarketPricesJob(GetMarketPricesReq request, boolean throttle) {
			super(3000L, throttle);
			
			this.request = request;
		}
		
		@Override
		public MarketPrices call() throws Exception {
			
//			System.out.println("getting market prices");
			
			GetMarketPricesResp response = getExchangeService().getMarketPrices(request);
			
			if (response.getErrorCode().equals(GetMarketPricesErrorEnum.OK)) {
				
//				System.out.println("market prices successfully retrieved");
				
				if (!response.getHeader().getSessionToken().equals(sessionToken)) {
					sessionToken = response.getHeader().getSessionToken();
				}
				
				return response.getMarketPrices();
			} else {
				System.out.println("Problem loading market prices '" + response.getErrorCode().toString() + "'");
				
				return null;
			}
		}

		@Override
		public String toString() {
			return "MarketPricesJob []";
		}
	}

}
