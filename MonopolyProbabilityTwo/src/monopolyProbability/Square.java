package monopolyProbability;

public class Square {

	private String name;
	private double currentValue = 0.0;
	private double currentFirstDoubles = 0.0;
	private double currentSecondDoubles = 0.0;
	private double nextValue = 0.0;
	private double nextFirstDoubles = 0.0;
	private double nextSecondDoubles = 0.0;
	
	public Square (String name) {
		this.name =name;
		currentValue = 0.0;
		currentFirstDoubles = 0.0;
		currentSecondDoubles = 0.0;
		nextValue = 0.0;
		nextFirstDoubles = 0.0;
		nextSecondDoubles = 0.0;
	}
	
	void addToCurrentValue (double currentValue) {
		this.currentValue = this.currentValue + currentValue;
	}
	
	void addToCurrentFirstDoubles (double currentFirstDoubles) {
		this.currentFirstDoubles = this.currentFirstDoubles + currentFirstDoubles;
	}
	
	void addToCurrentSecondDoubles (double currentSecondDoubles) {
		this.currentSecondDoubles = this.currentSecondDoubles + currentSecondDoubles;
	}
	
	void addToNextValue (double nextValue) {
		this.nextValue = this.nextValue + nextValue;
	}
	
	void addToNextFirstDoubles (double nextFirstDoubles) {
		this.nextFirstDoubles = this.nextFirstDoubles + nextFirstDoubles;
	}
	
	void addToNextSecondDoubles (double nextSecondDoubles) {
		this.nextSecondDoubles = this.nextSecondDoubles + nextSecondDoubles;
	}
	
	String getName () {
		return name;
	}
	
	double getCurrentValue () {
		return currentValue;
	}
	
	double getCurrentFirstDoubles () {
		return currentFirstDoubles;
	}
	
	double getCurrentSecondDoubles () {
		return currentSecondDoubles;
	}
	
	double getNextValue () {
		return nextValue;
	}
	
	double getNextFirstDoubles () {
		return nextFirstDoubles;
	}
	
	double getNextSecondDoubles () {
		return nextSecondDoubles;
	}
	
	double getOverallValue () {
		return currentValue + currentFirstDoubles + currentSecondDoubles;
	}
	
	void resetValues () {
		currentValue = nextValue;
		currentFirstDoubles = nextFirstDoubles;
		currentSecondDoubles = nextSecondDoubles;
		nextValue = 0.0;
		nextFirstDoubles = 0.0;
		nextSecondDoubles = 0.0;
	}
	
	
}
