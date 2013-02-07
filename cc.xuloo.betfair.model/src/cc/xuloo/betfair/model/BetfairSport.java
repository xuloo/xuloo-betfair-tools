package cc.xuloo.betfair.model;

import java.util.ArrayList;
import java.util.List;

public class BetfairSport {
	
	private static List<BetfairSport> SPORTS;
	
	static {
		SPORTS = new ArrayList<BetfairSport>();
		
		SPORTS.add(new BetfairSport("Poker Room", 189929));
		SPORTS.add(new BetfairSport("Yahoo Racing", 2791893));
		SPORTS.add(new BetfairSport("Soccer", 1));
		SPORTS.add(new BetfairSport("Tennis", 2));
		SPORTS.add(new BetfairSport("Golf", 3));
		SPORTS.add(new BetfairSport("Cricket", 4));
		SPORTS.add(new BetfairSport("Rugby Union", 5));
		SPORTS.add(new BetfairSport("Boxing", 6));
		SPORTS.add(new BetfairSport("Horse Racing", 7));
		SPORTS.add(new BetfairSport("Motor Sport", 8));
		SPORTS.add(new BetfairSport("Soccer Euro 2000", 9));
		SPORTS.add(new BetfairSport("Special Bets", 10));
		SPORTS.add(new BetfairSport("Cycling", 11));
		SPORTS.add(new BetfairSport("Rowing", 12));
		SPORTS.add(new BetfairSport("Rugby League", 1477));
		SPORTS.add(new BetfairSport("Darts", 3503));
		SPORTS.add(new BetfairSport("Athletics", 3988));
		SPORTS.add(new BetfairSport("Greyhound Racing", 4339));
		SPORTS.add(new BetfairSport("Financial Bets", 6231));
		SPORTS.add(new BetfairSport("Snooker", 6422));
		SPORTS.add(new BetfairSport("American Football", 6423));
		SPORTS.add(new BetfairSport("Olympics - Sydney 2000", 7228));
		SPORTS.add(new BetfairSport("Baseball", 7511));
		SPORTS.add(new BetfairSport("Basketball", 7522));
		SPORTS.add(new BetfairSport("Hockey", 7523));
		SPORTS.add(new BetfairSport("Ice Hockey", 7524));
		SPORTS.add(new BetfairSport("Sumo Wrestling", 7525));
		SPORTS.add(new BetfairSport("Australian Rules", 61420));
		SPORTS.add(new BetfairSport("Gaelic Football", 66598));
		SPORTS.add(new BetfairSport("Hurling", 66599));
		SPORTS.add(new BetfairSport("Pool", 72382));
		SPORTS.add(new BetfairSport("Test Only", 104049));
		SPORTS.add(new BetfairSport("Chess", 136332));
		SPORTS.add(new BetfairSport("2002 Winter Olympics", 141540));
		SPORTS.add(new BetfairSport("Trotting", 256284));
		SPORTS.add(new BetfairSport("Commonwealth Games", 300000));
		SPORTS.add(new BetfairSport("Poker", 315220));
		SPORTS.add(new BetfairSport("Winter Sports", 451485));
		SPORTS.add(new BetfairSport("Handball", 468328));
		SPORTS.add(new BetfairSport("Volleyball", 998917));
		SPORTS.add(new BetfairSport("Politics", 2378961));
		SPORTS.add(new BetfairSport("Bridge", 982477));
		SPORTS.add(new BetfairSport("Exchange Poker", 1444073));
		SPORTS.add(new BetfairSport("International Rules", 678378));
		SPORTS.add(new BetfairSport("Table Tennis", 2593174));
		SPORTS.add(new BetfairSport("Floorball", 998920));
		SPORTS.add(new BetfairSport("Netball", 606611));
		SPORTS.add(new BetfairSport("Yachting", 998916));
		SPORTS.add(new BetfairSport("Swimming", 620576));
		SPORTS.add(new BetfairSport("Gaelic Games", 2152880));
		SPORTS.add(new BetfairSport("Internal Markets", 2264869));
		SPORTS.add(new BetfairSport("Olympics 2004", 1896798));
		SPORTS.add(new BetfairSport("Bowls", 998918));
		SPORTS.add(new BetfairSport("Bandy", 998919));
		SPORTS.add(new BetfairSport("Badminton", 627555));
		SPORTS.add(new BetfairSport("GAA Sports", 2030972));
		SPORTS.add(new BetfairSport("Backgammon", 1938544));
		SPORTS.add(new BetfairSport("Soccer - Euro 2004", 1564529));
		SPORTS.add(new BetfairSport("Exchange Roulette", 1444130));
		SPORTS.add(new BetfairSport("Exchange Blackjack", 1444076));
		SPORTS.add(new BetfairSport("Fishing", 3088925));
		SPORTS.add(new BetfairSport("Exchange Casino", 10271443));
		SPORTS.add(new BetfairSport("Tradefair Test", 16224213));
		SPORTS.add(new BetfairSport("Cross Sport Accumulators", 3145419));
		SPORTS.add(new BetfairSport("Featured Markets", 5545197));
		SPORTS.add(new BetfairSport("Ten Pin Bowling", 10390264));
		SPORTS.add(new BetfairSport("Exchange Card Racing", 1444115));
		SPORTS.add(new BetfairSport("Surfing", 4726642));
		SPORTS.add(new BetfairSport("Canoeing", 2872196));
		SPORTS.add(new BetfairSport("Equestrian", 18643353));
		SPORTS.add(new BetfairSport("Water Polo", 2901849));
		SPORTS.add(new BetfairSport("Fussball", 15826207));
		SPORTS.add(new BetfairSport("Exchange Omaha Hi", 1444099));
		SPORTS.add(new BetfairSport("Combat Sports", 4968929));
		SPORTS.add(new BetfairSport("Olympics 2008", 18051261));
		SPORTS.add(new BetfairSport("Roller Hockey", 3130721));
		SPORTS.add(new BetfairSport("Polo", 2977000));
		SPORTS.add(new BetfairSport("Harness Racing", 16872235));
		SPORTS.add(new BetfairSport("Pelota", 5412697));
		SPORTS.add(new BetfairSport("Horse Racing - Virtual", 26397698));
		SPORTS.add(new BetfairSport("Squash", 4609466));
		SPORTS.add(new BetfairSport("Futsal", 15826206));
		SPORTS.add(new BetfairSport("Beach Volleyball", 2872194));
		SPORTS.add(new BetfairSport("Exchange Hi Lo", 1444092));
		SPORTS.add(new BetfairSport("Exchange Baccarat", 1444085));
		SPORTS.add(new BetfairSport("Tradefair", 15242720));
		SPORTS.add(new BetfairSport("Casino", 1444120));
		SPORTS.add(new BetfairSport("Mixed Martial Arts", 26420387));
		SPORTS.add(new BetfairSport("Exchange Games", 5402258));
		SPORTS.add(new BetfairSport("Olympics 2012", 26686903));
		SPORTS.add(new BetfairSport("Paralympics 2012 ", 26886906));
		SPORTS.add(new BetfairSport("Exchange Bullseye Roulette", 1444150));
	}
	
	public static boolean has(String name) {
		for (BetfairSport sport : SPORTS) {
			if (sport.getName().toLowerCase().equals(name.toLowerCase())) return true;
		}
		
		return false;
	}
	
	public static BetfairSport forName(String name) {
		for (BetfairSport sport : SPORTS) {
			if (sport.getName().toLowerCase().equals(name.toLowerCase())) return sport;
		}
		
		return null;
	}

	private String name;
	
	private int id;
	
	public BetfairSport(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
	
	public boolean equals(BetfairSport other) {
		return name.equals(other.getName()) && id == other.getId();
	}
}
