package monopolyProbability;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Main {
	
	public static void main(String[] args) {
		
		double[] checkArray = new double[40];
		boolean finished = false;
		int century = 0;
		Board board = new Board();
		double currentValue = 0.0;
		double currentFirstDoubles = 0.0;
		double currentSecondDoubles = 0.0;
		double nextValue = 0.0;
		double nextFirstDoubles = 0.0;
		double nextSecondDoubles = 0.0;
		double nextGoToJail = 0.0;
		BufferedWriter writer = null;
		
		for (int index = 0; index < 40; index++) {
			checkArray[index] = 0.0;
		} // end for initialize
		
		//try
		try {
			File logFile = new File("Monopoly");
			System.out.println(logFile.getCanonicalPath());
			writer = new BufferedWriter(new FileWriter(logFile));
			
			do {	
				century = century + 1;

					for (int square = 0; square < 40; square++) {

						currentValue = 0.0;
						currentFirstDoubles = 0.0;
						currentSecondDoubles = 0.0;
						
						currentValue = board.getCurrentValue(square);
						currentFirstDoubles = board.getCurrentFirstDoubles(square);
						currentSecondDoubles = board.getCurrentSecondDoubles(square);
						
						for (int roll = 2; roll < 13; roll++) {
							
							nextValue = 0.0;
							nextFirstDoubles = 0.0;
							nextSecondDoubles = 0.0;
							nextGoToJail = 0.0;
							
							if (roll == 2 || roll == 12) {
								nextFirstDoubles = currentValue * 1.0/36.0;
								nextSecondDoubles = currentFirstDoubles * 1.0/36.0;
								nextGoToJail = currentSecondDoubles * 1.0/36.0;
							} else if (roll == 3 || roll == 4 || roll == 10 || roll == 11) {
								nextValue = currentValue * 2.0/36.0 + currentFirstDoubles * 2.0/36.0 + currentSecondDoubles * 2.0/36.0;
								if (roll == 4 || roll == 10) {
									nextFirstDoubles = currentValue * 1.0/36.0;
									nextSecondDoubles = currentFirstDoubles * 1.0/36.0;
									nextGoToJail = currentSecondDoubles * 1.0/36.0;
								} // end if check aDoublesRoll 4 10
							} else if (roll == 5 || roll == 6 || roll == 8 || roll == 9) {
								nextValue = currentValue * 4.0/36.0 + currentFirstDoubles * 4.0/36.0 + currentSecondDoubles * 4.0/36.0;
								if (roll == 6 || roll == 8) {
									nextFirstDoubles = currentValue * 1.0/36.0;
									nextSecondDoubles = currentFirstDoubles * 1.0/36.0;
									nextGoToJail = currentSecondDoubles * 1.0/36.0;
								} // end if check aDoublesRoll 6 8
							} else if (roll == 7) {
								nextValue = currentValue * 6.0/36.0 + currentFirstDoubles * 6.0/36.0 + currentSecondDoubles * 6.0/36.0;
							} else {
								System.out.println("ERROR 2");
							} // end if rolls
							
							// All the third doubles go to jail
							board.addToNextValue(nextGoToJail, 10);			
							
							if (board.getName((square + roll) % 40) == "Community Chest One" || 
									board.getName((square + roll) % 40) == "Community Chest Two" || 
									board.getName((square + roll) % 40) == "Community Chest Three") {
								
								// Community Chest 1, 2, and 3
								//------------------------------------------------------------------
								board.addToNextValue(nextValue * 14.0/16.0, (square + roll) % 40);
								board.addToNextFirstDoubles(nextFirstDoubles * 14.0/16.0, (square + roll) % 40);
								board.addToNextSecondDoubles(nextSecondDoubles * 14.0/16.0, (square + roll) % 40);
								
								// Advance to GO
								//------------------------------------------------------------------
								board.addToNextValue(nextValue * 1.0/16.0, 0);
								board.addToNextFirstDoubles(nextFirstDoubles * 1.0/16.0, 0);
								board.addToNextSecondDoubles(nextSecondDoubles * 1.0/16.0, 0);
								
								// Go To Jail
								//------------------------------------------------------------------
								board.addToNextValue(nextValue * 1.0/16.0, 10);
								board.addToNextFirstDoubles(nextFirstDoubles * 1.0/16.0, 10);
								board.addToNextSecondDoubles(nextSecondDoubles * 1.0/16.0, 10);
								
							} else if (board.getName((square + roll) % 40) == "Chance One" || 
									board.getName((square + roll) % 40) == "Chance Two" || 
									board.getName((square + roll) % 40) == "Chance Three") {
								
								// Chance 1, 2, and 3
								//------------------------------------------------------------------
								board.addToNextValue(nextValue * 6.0/15.0, (square + roll) % 40);
								board.addToNextFirstDoubles(nextFirstDoubles * 6.0/15.0, (square + roll) % 40);
								board.addToNextSecondDoubles(nextSecondDoubles * 6.0/15.0, (square + roll) % 40);
								
								// Illinois
								//------------------------------------------------------------------
								board.addToNextValue(nextValue * 1.0/15.0, 24);
								board.addToNextFirstDoubles(nextFirstDoubles * 1.0/15.0, 24);
								board.addToNextSecondDoubles(nextSecondDoubles * 1.0/15.0, 24);
								
								// St. Charles
								//------------------------------------------------------------------
								board.addToNextValue(nextValue * 1.0/15.0, 11);
								board.addToNextFirstDoubles(nextFirstDoubles * 1.0/15.0, 11);
								board.addToNextSecondDoubles(nextSecondDoubles * 1.0/15.0, 11);
								
								// Boardwalk
								//------------------------------------------------------------------
								board.addToNextValue(nextValue * 1.0/15.0, 39);
								board.addToNextFirstDoubles(nextFirstDoubles * 1.0/15.0, 39);
								board.addToNextSecondDoubles(nextSecondDoubles * 1.0/15.0, 39);
								
								if (board.getName((square + roll) % 40) == "Chance One" || 
										board.getName((square + roll) % 40) == "Chance Two") {
									
									// Advance to GO
									//------------------------------------------------------------------
									board.addToNextValue(nextValue * 1.0/15.0, 0);
									board.addToNextFirstDoubles(nextFirstDoubles * 1.0/15.0, 0);
									board.addToNextSecondDoubles(nextSecondDoubles * 1.0/15.0, 0);
									
									// Go To Jail
									//------------------------------------------------------------------
									board.addToNextValue(nextValue * 1.0/15.0, 10);
									board.addToNextFirstDoubles(nextFirstDoubles * 1.0/15.0, 10);
									board.addToNextSecondDoubles(nextSecondDoubles * 1.0/15.0, 10);
									
									// Reading
									//------------------------------------------------------------------
									board.addToNextValue(nextValue * 1.0/15.0, 5);
									board.addToNextFirstDoubles(nextFirstDoubles * 1.0/15.0, 5);
									board.addToNextSecondDoubles(nextSecondDoubles * 1.0/15.0, 5);
									
									if (board.getName((square + roll) % 40) == "Chance One") {
										
										// Income Tax
										//------------------------------------------------------------------
										board.addToNextValue(nextValue * 1.0/15.0, 4);
										board.addToNextFirstDoubles(nextFirstDoubles * 1.0/15.0, 4);
										board.addToNextSecondDoubles(nextSecondDoubles * 1.0/15.0, 4);
										
										// Electric Company
										//------------------------------------------------------------------
										board.addToNextValue(nextValue * 1.0/15.0, 12);
										board.addToNextFirstDoubles(nextFirstDoubles * 1.0/15.0, 12);
										board.addToNextSecondDoubles(nextSecondDoubles * 1.0/15.0, 12);
										
										// Pennsylvania
										//------------------------------------------------------------------
										board.addToNextValue(nextValue * 1.0/15.0, 15);
										board.addToNextFirstDoubles(nextFirstDoubles * 1.0/15.0, 15);
										board.addToNextSecondDoubles(nextSecondDoubles * 1.0/15.0, 15);
										
									} else if (board.getName((square + roll) % 40) == "Chance Two") {
										
										// New York
										//------------------------------------------------------------------
										board.addToNextValue(nextValue * 1.0/15.0, 19);
										board.addToNextFirstDoubles(nextFirstDoubles * 1.0/15.0, 19);
										board.addToNextSecondDoubles(nextSecondDoubles * 1.0/15.0, 19);
										
										// B & O
										//------------------------------------------------------------------
										board.addToNextValue(nextValue * 1.0/15.0, 25);
										board.addToNextFirstDoubles(nextFirstDoubles * 1.0/15.0, 25);
										board.addToNextSecondDoubles(nextSecondDoubles * 1.0/15.0, 25);
										
										// Water Works
										//------------------------------------------------------------------
										board.addToNextValue(nextValue * 1.0/15.0, 28);
										board.addToNextFirstDoubles(nextFirstDoubles * 1.0/15.0, 28);
										board.addToNextSecondDoubles(nextSecondDoubles * 1.0/15.0, 28);
										
									} else {
										System.out.println("ERROR 3");
									} // end if Chance 1 and 2
									
								} else if (board.getName((square + roll) % 40) == "Chance Three") {
									
									// Advance to GO
									//------------------------------------------------------------------
									board.addToNextValue(nextValue * 17.0/240.0, 0);
									board.addToNextFirstDoubles(nextFirstDoubles * 17.0/240.0, 0);
									board.addToNextSecondDoubles(nextSecondDoubles * 17.0/240.0, 0);
									
									// Go To Jail
									//------------------------------------------------------------------
									board.addToNextValue(nextValue * 17.0/240.0, 10);
									board.addToNextFirstDoubles(nextFirstDoubles * 17.0/240.0, 10);
									board.addToNextSecondDoubles(nextSecondDoubles * 17.0/240.0, 10);
									
									// Reading
									//------------------------------------------------------------------
									board.addToNextValue(nextValue * 32.0/240.0, 5);
									board.addToNextFirstDoubles(nextFirstDoubles * 32.0/240.0, 5);
									board.addToNextSecondDoubles(nextSecondDoubles * 32.0/240.0, 5);
									
									// Community Chest 3
									//------------------------------------------------------------------
									board.addToNextValue(nextValue * 14.0/240.0, 33);
									board.addToNextFirstDoubles(nextFirstDoubles * 14.0/240.0, 33);
									board.addToNextSecondDoubles(nextSecondDoubles * 14.0/240.0, 33);
									
									// Electric Company
									//------------------------------------------------------------------
									board.addToNextValue(nextValue * 16.0/240.0, 12);
									board.addToNextFirstDoubles(nextFirstDoubles * 16.0/240.0, 12);
									board.addToNextSecondDoubles(nextSecondDoubles * 16.0/240.0, 12);
									
								} else {
									System.out.println("ERROR 4");
								} // end if Chance
								
							} else if (board.getName((square + roll) % 40) == "Go To Jail") {
								
								//------------------------------------------------------------------
								board.addToNextValue(nextValue, 10);
								board.addToNextFirstDoubles(nextFirstDoubles, 10);
								board.addToNextSecondDoubles(nextSecondDoubles, 10);
								
							} else {
								
								//------------------------------------------------------------------
								board.addToNextValue(nextValue, (square + roll) % 40);
								board.addToNextFirstDoubles(nextFirstDoubles, (square + roll) % 40);
								board.addToNextSecondDoubles(nextSecondDoubles, (square + roll) % 40);
								
							} // end if check square
							
							
						} // end for 12 
					} // end for 40
					board.resetValues();

				System.out.println("Round " + century);
				writer.write("Round " + century + "\n");
				for (int index = 0; index < 40; index++) {
					System.out.println(board.getOverallValue(index) + " " + board.getName(index));
					writer.write(board.getOverallValue(index) + " " + board.getName(index) + "\n");
				} // end for display
			
				finished = false;
				for (int index = 0; index < 40; index++) {
					if (checkArray[index] != board.getOverallValue(index) - board.getOverallValue(index) % 0.001) {
						finished = true;
					} else {
						finished = false;
					} // end if
					checkArray[index] = board.getOverallValue(index) - board.getOverallValue(index) % 0.001;
				} // end for finished check
				
				if (century >= 100) {
					finished = false;
				}
				
			} while (finished);	
		
		} catch (Exception e) {	
			e.printStackTrace();
		} finally {
			try {
		
				//System.out.println(logFile.getCanonicalPath());
				writer.close();
		
			} catch (Exception e) {	
			} // end catch
		} // end finally
		
	} // end main
} // end class Main
