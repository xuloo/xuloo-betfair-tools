package cc.xuloo.betfair.model.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.joda.time.DateTime;

import cc.xuloo.betfair.model.BetfairParser;
import cc.xuloo.betfair.model.IBetfairService;
import cc.xuloo.betfair.model.LoginResult;
import cc.xuloo.betfair.model.MarketData;
import cc.xuloo.ds.F.Either;
import cc.xuloo.ds.F.None;
import cc.xuloo.ds.F.Option;
import cc.xuloo.ds.F.Promise;
import cc.xuloo.ds.F.Some;
import cc.xuloo.ds.F.Tuple;

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

public class BetfairModel {

	private static final int MAXIMUM_LOGIN_RETRIES = 3;
	
	private String sessionToken;
	
	private boolean loggedIn;
	
	private BFGlobalService globalService;
	
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
	
	private BFExchangeService exchangeService;
	
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
	
	private String username;
	
	private String password;
	
	private int productId;
	
//	private boolean throttleApi;
//	
//	public boolean isThrottled() {
//		return throttleApi;
//	}
	
	private ExecutorService executor = Executors.newSingleThreadExecutor();
	
	private long lastRequestTime = System.currentTimeMillis();
	
	public void setCredentials(String username, String password, int productId) {
		this.username = username;
		this.password = password;
		this.productId = productId;
	}
	
	public BetfairModel() {
		
	}
	
//	private void throttle() {
//		
//		if (throttleApi) {
//			
//			long curr = System.currentTimeMillis();
//			long delta = curr - lastRequestTime;
//			
//			if (delta < 1000) {
//				try {
//					Thread.currentThread().sleep(1000 - delta);
//				} catch (InterruptedException e) {
//					System.out.println("interrupted betfair model thread");
//				}
//			}
//			
//			lastRequestTime = System.currentTimeMillis();
//		}
//	}
	
//	public LoginResult login() {
//		
//		if (loggedIn) return new LoginResult();
//		
//		int currentTry = MAXIMUM_LOGIN_RETRIES;
//		
//		while (currentTry-- > 0) {
//			
//			System.out.println("logging in to betfair");
//			
//			final LoginReq request = new LoginReq();
//			
//			request.setUsername(username);
//			request.setPassword(password);
//			request.setProductId(productId);
//			request.setVendorSoftwareId(0);
//			
//			try {
//			
//				BetfairResponse<LoginResult> response = executor.submit(new BetfairRequest<LoginResult>(0) {
//	
//					@Override
//					public BetfairResponse<LoginResult> call() throws Exception {
//						
//						LoginResp response = getGlobalService().login(request);
//						
//						if (response.getErrorCode().equals(LoginErrorEnum.OK)) {
//							
//							System.out.println("login successful");
//							
//							sessionToken = response.getHeader().getSessionToken();
//							loggedIn = true;
//							
//							return Succeeded(new LoginResult());
//						} else {
//							return BetfairResponse.Failed(new LoginResult(response.getErrorCode().toString()));
//						}
//					}
//				}).get();
//			} catch (ExecutionException e) {
//				
//			} catch (InterruptedException e) {
//				
//			}
//			
//			
//		}
//		
//		return new LoginResult("Failed 3 times");
//	}
	
	
//	public LoginResult login(String username, String password, int id, boolean throttleApi) {
//		
//		//this.throttleApi = throttleApi;
//		
//		setCredentials(username, password, id);
//		
//		return login();
//	}
	
//	public List<MarketData> getAllMarkets(DateTime fromDate, DateTime toDate, int[] eventTypes) {
//		
//		if (login().isSuccess()) {
//			
//			//throttle();
//			
//			GetAllMarketsReq request = new GetAllMarketsReq();
//			request.setHeader(getExchangeRequestHeader());
//			
//			if (fromDate != null) {
//				GregorianCalendar c = new GregorianCalendar();
//				c.setTime(fromDate.toDate());
//				try {
//					request.setFromDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
//				} catch (DatatypeConfigurationException e) {
//					System.out.println("could not create a new XMLGregorianCalendar instance");
//				}
//			}
//			
//			if (toDate != null) {
//				GregorianCalendar c = new GregorianCalendar();
//				c.setTime(toDate.toDate());
//				try {
//					request.setToDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
//				} catch (DatatypeConfigurationException e) {
//					System.out.println("could not create a new XMLGregorianCalendar instance");
//				}
//			}
//			
//			if (eventTypes != null) {
//				ArrayOfInt aoi = new ArrayOfInt();
//				for (int i : eventTypes) aoi.getInt().add(i);
//				request.setEventTypeIds(aoi);
//			}
//			
//			GetAllMarketsResp response = getExchangeService().getAllMarkets(request);
//			
//			if (response.getErrorCode().equals(GetAllMarketsErrorEnum.OK)) {
//				if (!response.getHeader().getSessionToken().equals(sessionToken)) {
//					sessionToken = response.getHeader().getSessionToken();
//				}
//				
//				return BetfairParser.parseCompressedMarkets(response.getMarketData());
//			}
//			
//			System.out.println("Problem loading market data '" + response.getErrorCode().toString() + "'");
//			
//			return new ArrayList<MarketData>();
//				
//		} else {
//			
//			System.out.println("can't get all market data - can't log in");
//			
//			return new ArrayList<MarketData>();
//		}
//	}
	
//	public List<EventType> getAllEventTypes() {
//		
//		if (login().isSuccess()) {
//			
//			//throttle();
//			
//			GetEventTypesReq request = new GetEventTypesReq();
//			request.setHeader(getGlobalRequestHeader());
//			
//			GetEventTypesResp response = getGlobalService().getAllEventTypes(request);
//			
//			if (response.getErrorCode().equals(GetEventsErrorEnum.OK)) {
//				if (!response.getHeader().getSessionToken().equals(sessionToken)) {
//					sessionToken = response.getHeader().getSessionToken();
//				}
//				
//				return response.getEventTypeItems().getEventType();
//			}
//			
//			return new ArrayList<EventType>();
//			
//		} else {
//			return new ArrayList<EventType>();
//		}
//	}
	
//	public Market getMarket(int id) {
//		
//		if (login().isSuccess()) {
//			
//			//throttle();
//			
//			GetMarketReq request = new GetMarketReq();
//			request.setHeader(getExchangeRequestHeader());
//			
//			request.setMarketId(id);
//			
//			GetMarketResp response = getExchangeService().getMarket(request);
//			
//			if (response.getErrorCode().equals(GetMarketErrorEnum.OK)) {
//				if (!response.getHeader().getSessionToken().equals(sessionToken)) {
//					sessionToken = response.getHeader().getSessionToken();
//				}
//				
//				return response.getMarket();
//			}
//			
//			return null;
//		}
//		
//		return null;
//	}
	
//	public List<BFEvent> getEvent(int parentId) {
//		
//		if (login().isSuccess()) {
//			
//			//throttle();
//			
//			GetEventsReq request = new GetEventsReq();
//			request.setHeader(getGlobalRequestHeader());
//			
//			request.setEventParentId(parentId);
//			
//			GetEventsResp response = getGlobalService().getEvents(request);
//			
//			if (response.getErrorCode().equals(GetEventsErrorEnum.OK)) {
//				if (!response.getHeader().getSessionToken().equals(sessionToken)) {
//					sessionToken = response.getHeader().getSessionToken();
//				}
//				
//				return response.getEventItems().getBFEvent();
//			}
//			
//			return null;
//		}
//		
//		return null;
//	}
	
//	public MarketPrices getMarketPrices(int id) {
//		
//		if (login().isSuccess()) {
//			
//			//throttle();
//			
//			final GetMarketPricesReq request = new GetMarketPricesReq();
//			request.setHeader(getExchangeRequestHeader());
//			
//			request.setMarketId(id);
//			
//			Option<MarketPrices> response = execute(new BetfairTask<MarketPrices>(0) {
//
//				@Override
//				public Option<MarketPrices> call() throws Exception {
//					
//					GetMarketPricesResp response = getExchangeService().getMarketPrices(request);
//					
//					if (response.getErrorCode().equals(GetMarketPricesErrorEnum.OK)) {
//						if (!response.getHeader().getSessionToken().equals(sessionToken)) {
//							sessionToken = response.getHeader().getSessionToken();
//						}
//						
//						return Option.Some(response.getMarketPrices());
//					} else {
//						System.out.println("problem getting market prices - " + response.getErrorCode().toString());
//					}
//					return Option.None();
//				}
//			});
//			
//			
//			
//			return null;
//		} else {
//			return null;
//		}
//	}
	
	
}
