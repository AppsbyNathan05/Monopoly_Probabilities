package monopolyProbability;

public class Board {

	private Square[] board =new Square[40];
	
	private static final String[] squareNames = new String[] {
			"GO", "Mediterranean Avenue", "Community Chest One", "Baltic Avenue", "Income Tax", "Reading Railroad", "Oriental Avenue", "Chance One", 
			"Vermont Avenue", "Connecticut Avenue", "Jail", "St. Charles Place", "Electric Company", "States Avenue", "Virginia Avenue", 
			"Pennsylvania Railroad", "St. James Place", "Community Chest Two", "Tennessee Avenue", "New York Avenue", "Free Parking", 
			"Kentucky Avenue", "Chance Two", "Indiana Avenue", "Illinois Avenue", "B&O Railroad", "Atlantic Avenue", "Ventnor Avenue", 
			"Water Works", "Marvin Gardens", "Go To Jail", "Pacific Avenue", "North Carolina Avenue", "Community Chest Three", "Pennsylvania Avenue", 
			"Short Line", "Chance Three", "Park Place", "Luxury Tax", "Boardwalk"
	};
	
	public Board () {
		for (int index = 0; index < 40; index++) {
			board[index] = new Square(squareNames[index]);
		}	
		board[0].addToCurrentValue(100.0);
	}
	
	void addToCurrentValue (double currentValue, int square) {
		board[square].addToCurrentValue(currentValue);
	}
	
	void addToCurrentFirstDoubles (double currentFirstDoubles, int square) {
		board[square].addToCurrentFirstDoubles(currentFirstDoubles);
	}
	
	void addToCurrentSecondDoubles (double currentSecondDoubles, int square) {
		board[square].addToCurrentSecondDoubles(currentSecondDoubles);
	}
	
	void addToNextValue (double nextValue, int square) {
		board[square].addToNextValue(nextValue);
	}
	
	void addToNextFirstDoubles (double nextFirstDoubles, int square) {
		board[square].addToNextFirstDoubles(nextFirstDoubles);
	}
	
	void addToNextSecondDoubles (double nextSecondDoubles, int square) {
		board[square].addToNextSecondDoubles(nextSecondDoubles);
	}
	
	String getName (int square) {
		return board[square].getName();
	}
	
	double getCurrentValue (int square) {
		return board[square].getCurrentValue();
	}
	
	double getCurrentFirstDoubles (int square) {
		return board[square].getCurrentFirstDoubles();
	}
	
	double getCurrentSecondDoubles (int square) {
		return board[square].getCurrentSecondDoubles();
	}
	
	double getNextValue (int square) {
		return board[square].getNextValue();
	}
	
	double getNextFirstDoubles (int square) {
		return board[square].getNextFirstDoubles();
	}
	
	double getNextSecondDoubles (int square) {
		return board[square].getNextSecondDoubles();
	}
	
	double getOverallValue (int square) {
		return board[square].getOverallValue();
	}
	
	void resetValues () {
		for (int index = 0; index < 40; index++) {
			board[index].resetValues();
		}
	}
	
}
